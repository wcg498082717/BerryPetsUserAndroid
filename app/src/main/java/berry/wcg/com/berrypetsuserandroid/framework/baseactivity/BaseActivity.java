package berry.wcg.com.berrypetsuserandroid.framework.baseactivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;


/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class BaseActivity extends AppCompatActivity {
    private String tag="BaseActivity";
    protected BaseActivity instance;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
            instance=BaseActivity.this;
        }
        this.getDelegate().getSupportActionBar().hide();
    }
    @Override
    protected void onStart() {
//        BroadcastReceiver receiver=new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Log.i(tag, "class:"+"wcg:"+"received");
//            }
//        };
//        IntentFilter filter=new IntentFilter();
//        filter.addAction(ACTION_TOKENEND);
//        registerReceiver(receiver,filter);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= 21) {
//                getWindow().setStatusBarColor(getResources().getColor(R.color.colorOrange));
//            }
//        }
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        OkHttpUtil.cancleRequestByContextAndTag(getIntance());
    }
    //真正沉浸式
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//
//        }
//        if(hasFocus && Build.VERSION.SDK_INT >= 21){
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);// SDK21
//        }
//    }

    @Override
    protected void onDestroy() {
        OkHttpUtil.cancleRequestByContextAndTag(getIntance());
        super.onDestroy();
    }
    public BaseActivity getIntance(){
        return instance;
    }
    public String getTag(){
        return getClass().getName();
    }
}
