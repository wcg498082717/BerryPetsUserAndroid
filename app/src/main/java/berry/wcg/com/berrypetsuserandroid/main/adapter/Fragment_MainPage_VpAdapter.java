package berry.wcg.com.berrypetsuserandroid.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;

public class Fragment_MainPage_VpAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private MainActivity activity;

    public Fragment_MainPage_VpAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment_MainPage_VpAdapter( ArrayList<Fragment> fragments, MainActivity activity,FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
