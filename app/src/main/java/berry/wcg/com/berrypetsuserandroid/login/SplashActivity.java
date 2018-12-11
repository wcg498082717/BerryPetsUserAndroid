package berry.wcg.com.berrypetsuserandroid.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import berry.wcg.com.berrypetsuserandroid.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //检测更新
        checkVersion();
    }

    private void checkVersion() {
//        OkHttpUtil.doPost();
    }

}
