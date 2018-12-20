package berry.wcg.com.berrypetsuserandroid.main.persenter;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.MyApplication;
import berry.wcg.com.berrypetsuserandroid.framework.utils.locationutils.LocationUtils;
import berry.wcg.com.berrypetsuserandroid.login.bean.LoginBean;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.bean.Tab;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_Mine;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_Order;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_OrderCar;

public class MainPersenter {
    private MainActivity activity;
    private LoginBean loginBean=null;
    private LayoutInflater mInflater=null;
    private List<Tab> mTabs = new ArrayList<>();
    private FragmentTabHost atyMainTabhost;
    private FrameLayout atyMainTabcontent;
    private FrameLayout tabhost;



    public MainPersenter(MainActivity activity) {
        this.activity = activity;
        mInflater=LayoutInflater.from(activity);
        atyMainTabcontent=activity.getTabContent();
        atyMainTabhost=activity.getMainTabHost();
        tabhost=activity.getTabHost();
    }

    //控件初始化
    public void viewinit() {
        activity.getMainTabHost().setup(activity,activity.getSupportFragmentManager(), R.id.aty_main_tabcontent);
        Tab tab_MainPage = new Tab(R.string.mainpage,R.drawable.ic_launcher_background,Fragment_MainPage.class) ;
        Tab tab_order = new Tab(R.string.order,R.drawable.ic_launcher_background,Fragment_Order.class) ;
        Tab tab_ordercar = new Tab(R.string.ordercar,R.drawable.ic_launcher_background,Fragment_OrderCar.class) ;
        Tab tab_mine = new Tab(R.string.mine,R.drawable.ic_launcher_background,Fragment_Mine.class) ;
        mTabs.add(tab_MainPage);
        mTabs.add(tab_order);
        mTabs.add(tab_ordercar);
        mTabs.add(tab_mine);

        for (int i = 0 ; i < mTabs.size() ;i++ ){
            View view = mInflater.inflate(R.layout.view_tabhost,null) ;
            ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
            TextView tex = (TextView) view.findViewById(R.id.txt_indicator);
            img.setImageResource(mTabs.get(i).getIcon());
            tex.setText(mTabs.get(i).getTitle());
            atyMainTabhost.addTab(atyMainTabhost.newTabSpec(activity.getString(mTabs.get(i).getTitle())).setIndicator(view), mTabs.get(i).getFragment(), null);
        }
        atyMainTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        atyMainTabhost.setCurrentTab(0);
    }

    //网络初始化
    public void netinit() {
        LocationUtils.getLngAndLat(activity);
        HashMap<String,String> map = new HashMap<>();
        map.put("token",MyApplication.aCache.getAsString("token"));
        map.put("latitude",MyApplication.aCache.getAsString("token"));
        map.put("longitude",MyApplication.aCache.getAsString("token"));
        map.put("pagenum",MyApplication.aCache.getAsString("token"));
        map.put("pagesize",MyApplication.aCache.getAsString("token"));
        map.put("ordertype",MyApplication.aCache.getAsString("token"));

//        OkHttpUtil.doPost(activity.getIntance(),AppConfig.url_main);
    }
}
