package berry.wcg.com.berrypetsuserandroid.framework;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

import java.io.IOException;
import java.util.HashMap;

import berry.wcg.com.berrypetsuserandroid.framework.utils.cache.ACache;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyApplication extends Application {
    private static Context context;
    private String tag="application";
    public static int screenW, screenH;
    private static Application instance;
    public static ACache aCache;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context=getApplicationContext();
        T.init(this);
        aCache = ACache.get(this);//初始化Acache
        //对xUtils进行初始化
        x.Ext.init(this);
        //是否是开发、调试模式
//        x.Ext.setDebug(BuildConfig.DEBUG);//是否输出debug日志，开启debug会影响性能
        checkversion();
    }

    private void checkversion() {
        HashMap map = new HashMap();
        OkHttpUtil.doPost("", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public static Application getInstance() {
        return instance;
    }
}
