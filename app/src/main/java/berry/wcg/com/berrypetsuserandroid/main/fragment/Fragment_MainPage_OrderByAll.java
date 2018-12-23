package berry.wcg.com.berrypetsuserandroid.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.persenter.FragmentMainPageOrderByAllPersenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_MainPage_OrderByAll extends Fragment {
    @BindView(R.id.frag_mainpage_orderbyall_rv)
    RecyclerView fragMainpageOrderbyallRv;
    @BindView(R.id.frag_mainpage_orderbyall_swrefresh)
    SwipeRefreshLayout fragMainpageOrderbyallSwrefresh;
    Unbinder unbinder;
    private FragmentMainPageOrderByAllPersenter persenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainpage_orderbyall, null);
        unbinder = ButterKnife.bind(this, v);
        persenter = new FragmentMainPageOrderByAllPersenter(Fragment_MainPage_OrderByAll.this, (MainActivity) getActivity());
        persenter.initview();
        persenter.initnet(1);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public RecyclerView getFragMainpageOrderbyallRv() {
        return fragMainpageOrderbyallRv;
    }

    public SwipeRefreshLayout getFragMainpageOrderbyallSwrefresh() {
        return fragMainpageOrderbyallSwrefresh;
    }
}
