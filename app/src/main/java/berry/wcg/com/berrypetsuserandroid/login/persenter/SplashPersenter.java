package berry.wcg.com.berrypetsuserandroid.login.persenter;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import java.io.IOException;
import java.util.HashMap;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.AppConfig;
import berry.wcg.com.berrypetsuserandroid.framework.utils.applicationutils.ApplicationUtils;
import berry.wcg.com.berrypetsuserandroid.framework.baseactivity.BaseActivity;
import berry.wcg.com.berrypetsuserandroid.framework.utils.jsonutil.JsonUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.login.activity.LoginActivity;
import berry.wcg.com.berrypetsuserandroid.login.activity.SplashActivity;
import berry.wcg.com.berrypetsuserandroid.login.bean.CheckVersionBean;
import berry.wcg.com.berrypetsuserandroid.login.dialog.UpdateDialog;
import okhttp3.Call;

public class SplashPersenter {

    private SplashActivity activity;
    private UpdateDialog updateDialog;
    private CheckVersionBean checkBean;
    private TimeCount timeCount;

    public SplashPersenter(BaseActivity activity) {
        this.activity = (SplashActivity) activity;
    }

    /**
     * 显示更新对话框
     */
    public void showUpdateDialog() {
        updateDialog = new UpdateDialog(activity);
        updateDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        updateDialog.setContentView(R.layout.dialog_update);
        Window dialogWindow = updateDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        updateDialog.findViewById(R.id.tx_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDialog.cancel();
                //取消更新，开始倒计时
                SplashPersenter.this.startTime();
            }
        });
        updateDialog.findViewById(R.id.tx_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDialog.cancel();
                String url = checkBean.getData().getPackageurl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                activity.startActivity(i);
            }
        });
//        dialogWindow.setBackgroundDrawable(null);
        updateDialog.show();
    }

    /**
     * 检测是否有新版本
     */
    public void checkVersion(){
        Log.i(activity.getTag(), "checkversion");
        HashMap<String, String> parames = new HashMap<>();
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.Url_CheckVersion, parames, false, new OkHttpUtil.WcgCallBack() {
            @Override
            public void onCancle(Call call, IOException e) {
                Log.i(activity.getTag(), "netcancle" + e.toString());
            }
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(activity.getTag(), "netonFailure" + e.toString());
            }
            @Override
            public void onSuccess(String response) {
                    Log.i(activity.getTag(), "netonSuccess" +response );
                try {
                    checkBean = JsonUtil.getEntityByJsonString(response, CheckVersionBean.class);
                    activity.getTxTime().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            enterLogin();
                        }
                    });
                    if (ApplicationUtils.getLocalVersionName(activity.getIntance()).equals(checkBean.getData().getVersion())) {
                        //不用更新，直接开始倒计时
                        startTime();
                    } else {
                    showUpdateDialog();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void startTime() {
        timeCount = new TimeCount(3000, 1000);// 构造CountDownTimer对象
        timeCount.start();
    }

    /**
     * 实现倒计时类
     *
     * @author Administrator
     */
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval); // 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if(activity.getTxTime()!=null){
                activity.getTxTime().setText("跳过"+"("+String.valueOf((millisUntilFinished / 1000))+")s");
            }
        }

        @Override
        public void onFinish() {
            enterLogin();
        }
    }

    public void enterLogin(){
        Intent i =  new Intent(activity, LoginActivity.class);
        activity.startActivity(i);
        activity.finish();
    }
}
