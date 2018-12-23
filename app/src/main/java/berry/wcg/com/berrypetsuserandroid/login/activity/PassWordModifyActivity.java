package berry.wcg.com.berrypetsuserandroid.login.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.baseactivity.BaseActivity;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.login.persenter.ModifyPersenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassWordModifyActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_verfycode)
    EditText etVerfycode;
    @BindView(R.id.tx_getverfycode)
    TextView txGetverfycode;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_password2)
    EditText etPassword2;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    private ModifyPersenter persenter;
    int time = 60;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                try {
                    txGetverfycode.setText("(" + time + ")" + "S后重新发送");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } else if (msg.what == 2) {
                txGetverfycode.setSelected(false);
                txGetverfycode.setEnabled(true);
                time = 60;
                txGetverfycode.setText("获取验证码");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_modify);
        ButterKnife.bind(this);
        persenter=new ModifyPersenter(PassWordModifyActivity.this);
    }

    private void starttime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (time > 0) {
                    try {
                        handler.sendEmptyMessage(1);
                        time--;
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // code_btn.setText("获取验证码");
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    @OnClick({R.id.tx_getverfycode, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tx_getverfycode:
                if(etPhone.getText().length()>10){
                    if(txGetverfycode.getText().equals("获取验证码")){
                        starttime();
                        persenter.getverfycode(etPhone.getText().toString());
                    }
                }else{
                    T.showShort("请输入手机号");
                }
                break;
            case R.id.btn_submit:
                if (etPassword.getText().toString() != null && etPassword2.getText() != null) {
                    if (etPassword.getText().toString().equals(etPassword2.getText().toString())) {
                        if(etPassword.getText().toString().length()>=6){
                            if(persenter.checkVeifyCode(etVerfycode.getText().toString())){
                                persenter.modifyPassWord(etPhone.getText().toString(),etPassword.getText().toString(),etVerfycode.getText().toString());
                            }else{
                                T.showShort( "验证码错误");
                            }
                        }else{
                            T.showShort( "请确认密码长度");
                        }
                    }else{
                        T.showShort( "请确认两次密码是否相同");
                    }
                } else {
                    T.showShort( "请确认两次密码是否非空");
                }
                break;
        }
    }


}
