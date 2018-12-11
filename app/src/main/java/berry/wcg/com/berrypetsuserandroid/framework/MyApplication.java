package berry.wcg.com.berrypetsuserandroid.framework;

import android.app.Application;
import android.content.Context;
import org.xutils.x;

import berry.wcg.com.berrypetsuserandroid.framework.utils.cache.ACache;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;

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
    }

    public static Application getInstance() {
        return instance;
    }
}
