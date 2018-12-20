package berry.wcg.com.berrypetsuserandroid.login.persenter;

import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import berry.wcg.com.berrypetsuserandroid.framework.AppConfig;
import berry.wcg.com.berrypetsuserandroid.framework.utils.jsonutil.JsonUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.login.activity.PassWordModifyActivity;
import berry.wcg.com.berrypetsuserandroid.login.bean.ModifyBean;
import berry.wcg.com.berrypetsuserandroid.login.bean.VerifyBean;
import okhttp3.Call;

import static berry.wcg.com.berrypetsuserandroid.framework.AppConfig.ACTION_MODIFYPASSWORDSUCCESS;

public class ModifyPersenter {
    private PassWordModifyActivity activity;
    private ModifyBean modifyBean=null;
    private VerifyBean verifyBean=null;
    public ModifyPersenter(PassWordModifyActivity activity) {
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
    public void modifyPassWord(final String phonenum, final String password, String verifycode) {
        Map map = new HashMap();
        map.put("phone", phonenum);
        map.put("passWord", password);
        map.put("verifycode", verifycode);
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.url_modifyPassword, map, false, new OkHttpUtil.WcgCallBack() {
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
                    modifyBean=JsonUtil.getEntityByJsonString(response,ModifyBean.class);
                    if(modifyBean.getCode()==0){
                        Intent result=new Intent();
                        result.putExtra("phone",phonenum);
                        result.putExtra("password",password);
                        activity.setResult(ACTION_MODIFYPASSWORDSUCCESS,result);
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
