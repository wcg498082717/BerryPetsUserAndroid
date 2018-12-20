package berry.wcg.com.berrypetsuserandroid.main.persenter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.adapter.Fragment_MainPage_VpAdapter;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage;

public class FragmentMainPagePersenter {
    private Fragment_MainPage fragment;
    private MainActivity activity;
    private ViewPager vp;
    private TabLayout tb_lay;
    private Fragment_MainPage_VpAdapter vpadapter;
    private ArrayList<String> tabtitles;
    private ArrayList<View> views = new ArrayList<>();

    public FragmentMainPagePersenter(MainActivity activity,Fragment_MainPage fragment) {
        this.fragment = fragment;
        this.activity = activity;
        tb_lay=fragment.getFragMainpageTblayout();
        vp=fragment.getFragMainpageVp();
        tabtitles=new ArrayList<String>(Arrays.asList(activity.getString(R.string.orderbyall),activity.getString(R.string.orderbysell),
                activity.getString(R.string.orderbyscore),activity.getString(R.string.orderbydistance)));
    }

    public void initview() {
        //初始化tablayout
        for (int i = 0; i < tabtitles.size(); i++) {
            tb_lay.addTab(tb_lay.newTab().setText(tabtitles.get(i)));
        }

        vpadapter = new Fragment_MainPage_VpAdapter(views, tabtitles);
        vp.setAdapter(vpadapter);

    }
}
