package berry.wcg.com.berrypetsuserandroid.login.persenter;

import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import berry.wcg.com.berrypetsuserandroid.framework.AppConfig;
import berry.wcg.com.berrypetsuserandroid.framework.utils.jsonutil.JsonUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.login.activity.RegistActivity;
import berry.wcg.com.berrypetsuserandroid.login.bean.RegistBean;
import berry.wcg.com.berrypetsuserandroid.login.bean.VerifyBean;
import okhttp3.Call;

import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_REGISTSUCCESS;

public class RegisterPersenter  {
    private RegistActivity activity;
    private VerifyBean verifyBean=null;
    private RegistBean registBean=null;

    public RegisterPersenter(RegistActivity activity) {
        this.activity = activity;
    }

    public void getverfycode(String phonenum) {
        Map map = new HashMap();
        map.put("phone", phonenum);
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.url_getcode, map, false, new OkHttpUtil.WcgCallBack() {
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
                    verifyBean=JsonUtil.getEntityByJsonString(response,VerifyBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * @param phonenum
     * @param password
     * @param verifycode 验证码
     */
    public void regist(final String phonenum, final String password, String verifycode) {
        Map map = new HashMap();
        map.put("phone", phonenum);
        map.put("passWord", password);
        map.put("verifycode", verifycode);
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.url_regist, map, false, new OkHttpUtil.WcgCallBack() {
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
                    registBean=JsonUtil.getEntityByJsonString(response,RegistBean.class);
                    if(registBean.getData().equals("注册成功")){
                        Intent result=new Intent();
                        result.putExtra("phone",phonenum);
                        result.putExtra("password",password);
                        activity.setResult(ACTION_REGISTSUCCESS,result);
                        activity.finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Boolean checkVeifyCode(String verifyCode){
        if(verifyBean!=null){
            return verifyBean.getCode()==0&&verifyBean.getData().getVerifycode()==Integer.parseInt(verifyCode);
        }else{
            return false;
        }
    }
}
