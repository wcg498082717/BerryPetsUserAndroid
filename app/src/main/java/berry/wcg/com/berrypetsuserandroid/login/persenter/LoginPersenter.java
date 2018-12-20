package berry.wcg.com.berrypetsuserandroid.login.persenter;

import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import berry.wcg.com.berrypetsuserandroid.framework.AppConfig;
import berry.wcg.com.berrypetsuserandroid.framework.MyApplication;
import berry.wcg.com.berrypetsuserandroid.framework.utils.jsonutil.JsonUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.login.activity.LoginActivity;
import berry.wcg.com.berrypetsuserandroid.login.bean.LoginBean;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import okhttp3.Call;

public class LoginPersenter {
    private LoginActivity activity;
    private LoginBean loginBean=null;
    public LoginPersenter(LoginActivity activity) {
        this.activity = activity;
    }

    public void login(String phonenum, String password) {
        Map map = new HashMap();
        map.put("phone", phonenum);
        map.put("passWord", password);
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.url_login, map, false, new OkHttpUtil.WcgCallBack() {
            @Override
            public void onCancle(Call call, IOException e) {
            }
            @Override
            public void onFailure(Call call, IOException e) {
                T.showShort("网络异常");
            }
            @Override
            public void onSuccess(String response) {
                try {
                    loginBean=JsonUtil.getEntityByJsonString(response,LoginBean.class);
                    //登录成功,进入主页面
                    if(loginBean.getCode()==0){
                        MyApplication.aCache.put("token",loginBean.getData().getToken());
                        Intent i= new Intent(activity,MainActivity.class);
                        activity.startActivity(i);
                        activity.finish();
                    }else{
                    //登录失败
                    T.showShort(loginBean.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
