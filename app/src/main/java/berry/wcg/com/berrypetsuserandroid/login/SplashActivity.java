package berry.wcg.com.berrypetsuserandroid.login;

import android.Manifest;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.util.HashMap;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import okhttp3.Call;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        }
        setContentView(R.layout.activity_splash);
        SplashActivityPermissionsDispatcher.CheckLocalStorageWithPermissionCheck(SplashActivity.this);
        this.getDelegate().getSupportActionBar().hide();

    }

    private void checkVersion() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("latitude","104.666666");
        parames.put("longitude","30.5444444");
        parames.put("distance","500000");
        OkHttpUtil.doPost(SplashActivity.this, "https://www.berrypets.com/user/withnologin/index", parames, false, new OkHttpUtil.WcgCallBack() {
            @Override
            public void onCancle(Call call, IOException e) {
                Log.i("splashactivity","netcancle");
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("splashactivity","netonFailure");
            }

            @Override
            public void onSuccess(String response) {
                Log.i("splashactivity","netonSuccess"+response);
            }
        });
    }


    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void CheckLocalStorage() {
        //检测更新
        checkVersion();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
