package berry.wcg.com.berrypetsuserandroid.main.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.baseactivity.BaseActivity;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.main.persenter.MainPersenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity {

    @BindView(R.id.aty_main_tabcontent)
    FrameLayout atyMainTabcontent;
    @BindView(android.R.id.tabhost)
    FrameLayout tabhost;
    @BindView(R.id.aty_main_tabhost)
    FragmentTabHost atyMainTabhost;

    private MainPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        persenter=new MainPersenter(MainActivity.this);
        persenter.viewinit();
        MainActivityPermissionsDispatcher.checkLocationOkWithPermissionCheck(MainActivity.this);
    }

    public FragmentTabHost getMainTabHost(){
        return atyMainTabhost;
    }
    public FrameLayout getTabHost(){
        return tabhost;
    }
    public FrameLayout getTabContent(){
        return atyMainTabcontent;
    }

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void checkLocationOk() {
        //权限检测成功
        persenter.netinit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void checkLocationNone() {
        //没有获取权限
        T.showShort("没有获取到地图权限，无法使用进一步功能，请设置");
    }

    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    void checkLocationNeverAsk() {
        //不再询问权限
    }
}
