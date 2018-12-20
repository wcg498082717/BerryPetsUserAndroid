package berry.wcg.com.berrypetsuserandroid.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.persenter.FragmentMainPagePersenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_MainPage extends Fragment {
    @BindView(R.id.frag_mainpage_tblayout)
    TabLayout fragMainpageTblayout;
    @BindView(R.id.frag_mainpage_vp)
    ViewPager fragMainpageVp;
    Unbinder unbinder;
    private FragmentMainPagePersenter persenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainpage, null);
        unbinder = ButterKnife.bind(this, view);
        persenter=new FragmentMainPagePersenter((MainActivity) getActivity(),Fragment_MainPage.this);
        persenter.initview();
        return view;
    }

    public TabLayout getFragMainpageTblayout() {
        return fragMainpageTblayout;
    }

    public ViewPager getFragMainpageVp() {
        return fragMainpageVp;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
