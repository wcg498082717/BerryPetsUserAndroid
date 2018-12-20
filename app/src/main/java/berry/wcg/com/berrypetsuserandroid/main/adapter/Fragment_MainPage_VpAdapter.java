package berry.wcg.com.berrypetsuserandroid.main.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Fragment_MainPage_VpAdapter extends PagerAdapter {
    //    这个是viewpager的填充视图
    private List<View> views;
    //    这个是table导航条里面的内容填充
    private List<String> tabtitles;

    public Fragment_MainPage_VpAdapter(List<View> views, List<String> tabtitles) {
        this.views = views;
        this.tabtitles = tabtitles;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    //    这个是和tablelayout相关的
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
}
