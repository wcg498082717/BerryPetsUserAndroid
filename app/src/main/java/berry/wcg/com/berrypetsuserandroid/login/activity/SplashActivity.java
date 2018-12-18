package berry.wcg.com.berrypetsuserandroid.login.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.utils.base.BaseActivity;
import berry.wcg.com.berrypetsuserandroid.login.persenter.SplashPersenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;


@RuntimePermissions
public class SplashActivity extends BaseActivity {

    @BindView(R.id.tx_time)
    TextView txTime;
    private SplashPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        persenter = new SplashPersenter(SplashActivity.this);
        //开始检测权限
        SplashActivityPermissionsDispatcher.LocalStoreGrantedWithPermissionCheck(SplashActivity.this);

    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void LocalStoreGranted() {
        //权限获取成功
        Log.i(getTag(), "checkpermissionok");
        persenter.checkVersion();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void LocalStoreDenied() {
        //权限获取失败
        Log.i(getTag(), "checkpermissionnone");
    }

    @OnNeverAskAgain({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void LocalStoreNeverAsk() {
        //权限获取失败
        Log.i(getTag(), "LocalStorageNeverAsk");
    }

    public TextView getTxTime() {
        return txTime;
    }
}
