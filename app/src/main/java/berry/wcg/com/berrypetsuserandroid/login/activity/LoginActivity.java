package berry.wcg.com.berrypetsuserandroid.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.utils.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_MODIFYPASSWORD;
import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_MODIFYPASSWORDSUCCESS;
import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_REGIST;
import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_REGISTSUCCESS;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.aty_login_et_phone)
    EditText atyLoginEtPhone;
    @BindView(R.id.aty_login_et_password)
    EditText atyLoginEtPassword;
    @BindView(R.id.aty_login_btn_login)
    Button atyLoginBtnLogin;
    @BindView(R.id.aty_login_tx_forgetpassword)
    TextView atyLoginTxForgetpassword;
    @BindView(R.id.aty_login_tx_regist)
    TextView atyLoginTxRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.aty_login_btn_login, R.id.aty_login_tx_forgetpassword, R.id.aty_login_tx_regist})
    public void onViewClicked(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.aty_login_btn_login:

                break;
            case R.id.aty_login_tx_forgetpassword:
                 i = new Intent(LoginActivity.this,PassWordModifyActivity.class);
                startActivityForResult(i,ACTION_MODIFYPASSWORD);
                break;
            case R.id.aty_login_tx_regist:
                 i = new Intent(LoginActivity.this,RegistActivity.class);
                startActivityForResult(i,ACTION_REGIST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==ACTION_REGISTSUCCESS||resultCode==ACTION_MODIFYPASSWORDSUCCESS){
            atyLoginEtPhone.setText(data.getStringExtra("phone"));
            atyLoginEtPassword.setText(data.getStringExtra("password"));
        }

    }
}
