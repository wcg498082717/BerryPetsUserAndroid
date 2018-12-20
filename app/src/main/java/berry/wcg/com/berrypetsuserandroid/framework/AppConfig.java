package berry.wcg.com.berrypetsuserandroid.framework;

public  class AppConfig {
    public static String RELEASE_URL="https://www.berrypets.com/";
    public static String TEST_URL="https://www.berrypets.com/testApi";
    public static String LOCAL_URL="http://192.168.1.117:8080";
    public static String USE_URL;
    public static int RUN_MOD=2;//1为正式环境2为测试环境3为本机
    public static final int ACTION_PHOTO_CROP = 1;
    public static final int ACTION_REGIST=2;
    public static final int ACTION_REGISTSUCCESS=3;
    public static final int ACTION_MODIFYPASSWORD=4;
    public static final int ACTION_MODIFYPASSWORDSUCCESS=5;

    static {
        if(RUN_MOD==1){
            USE_URL=RELEASE_URL;
        }else if(RUN_MOD==2){
            USE_URL=TEST_URL;
        }else{
            USE_URL=LOCAL_URL;
        }
    }

    public static final String Url_CheckVersion=USE_URL+"/user/AndroidCheckVersion";
    public static final String url_getcode=USE_URL+"/user/getverifycode";
    public static final String url_regist=USE_URL+"/user/withoutlogin/registuser";
    public static final String url_modifyPassword=USE_URL+"/user/withoutlogin/modifyPassWord";
    public static final String url_login=USE_URL+"/user/withoutlogin/applogin";
    public static final String url_main=USE_URL+"/user/withnologin/indexv2";
}
