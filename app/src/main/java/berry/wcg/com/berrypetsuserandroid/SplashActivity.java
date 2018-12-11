package berry.wcg.com.berrypetsuserandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
