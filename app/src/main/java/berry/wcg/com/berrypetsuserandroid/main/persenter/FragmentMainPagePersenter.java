package berry.wcg.com.berrypetsuserandroid.main.persenter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.adapter.Fragment_MainPage_VpAdapter;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage_OrderByAll;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage_OrderByDistance;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage_OrderByScore;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage_OrderBySell;

public class FragmentMainPagePersenter {
    private Fragment_MainPage fragment;
    private MainActivity activity;
    private ViewPager vp;
    private TabLayout tb_lay;
    private ArrayList<String> tabtitles;
//    private ArrayList<View> views = new ArrayList<>();
//    private Fragment_MainPage_VpAdapter2 vpadapter2;
    private Fragment_MainPage_VpAdapter vpadapter;
    private ArrayList<Fragment> tabfragments = new ArrayList<>();

//    private ArrayList<Integer> tabres = new ArrayList<Integer>(Arrays.asList(R.layout.view_mainpage_orderbyall,R.layout.view_mainpage_orderbysell,
//            R.layout.view_mainpage_orderbyscore,R.layout.view_mainpage_orderbydistance));

    public FragmentMainPagePersenter(MainActivity activity,Fragment_MainPage fragment) {
        this.fragment = fragment;
        this.activity = activity;
        tb_lay=fragment.getFragMainpageTblayout();
        vp=fragment.getFragMainpageVp();

    }

    public void initview() {
        tabtitles=new ArrayList<String>(Arrays.asList(activity.getString(R.string.orderbyall),activity.getString(R.string.orderbysell),
                activity.getString(R.string.orderbyscore),activity.getString(R.string.orderbydistance)));
//        //初始化tablayout
//        for (int i = 0; i < tabtitles.size(); i++) {
//            tb_lay.addTab(tb_lay.newTab().setText(tabtitles.get(i)));
//        }
        //采用pageradapter
//        for (int i = 0; i < tabtitles.size(); i++) {
//            View v = LayoutInflater.from(activity).inflate(tabres.get(i),null);
//            views.add(v);
//        }
//        vpadapter = new Fragment_MainPage_VpAdapter2(views, tabtitles);
//        vp.setAdapter(vpadapter2);
        //采用fragmentpageadapter
        Fragment_MainPage_OrderByAll frag1=new Fragment_MainPage_OrderByAll();
        Fragment_MainPage_OrderBySell frag2=new Fragment_MainPage_OrderBySell();
        Fragment_MainPage_OrderByScore frag3=new Fragment_MainPage_OrderByScore();
        Fragment_MainPage_OrderByDistance frag4=new Fragment_MainPage_OrderByDistance();
        tabfragments.add(frag1);
        tabfragments.add(frag2);
        tabfragments.add(frag3);
        tabfragments.add(frag4);
        vpadapter=new Fragment_MainPage_VpAdapter(tabfragments,activity,fragment.getChildFragmentManager());
        vp.setAdapter(vpadapter);
        //会调用removealltabs（使用fragmentpageradapter的viewpager会不显示tablayout，使用pageradapter的viewpager则会显示）
        tb_lay.setupWithViewPager(vp);
        for (int i=0;i<tb_lay.getTabCount();i++) {
            tb_lay.getTabAt(i).setText(tabtitles.get(i));
        }
    }
}
