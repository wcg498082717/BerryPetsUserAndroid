package berry.wcg.com.berrypetsuserandroid.main.persenter;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.HashMap;

import berry.wcg.com.berrypetsuserandroid.framework.AppConfig;
import berry.wcg.com.berrypetsuserandroid.framework.MyApplication;
import berry.wcg.com.berrypetsuserandroid.framework.utils.jsonutil.JsonUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;
import berry.wcg.com.berrypetsuserandroid.framework.utils.toast.T;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.adapter.MainAty_MainPage_OrderByAllAdapter;
import berry.wcg.com.berrypetsuserandroid.main.bean.MainOrderByBean;
import berry.wcg.com.berrypetsuserandroid.main.fragment.Fragment_MainPage_OrderByAll;
import okhttp3.Call;

public class FragmentMainPageOrderByAllPersenter {
    private Fragment_MainPage_OrderByAll fragment;
    private MainActivity activity;
    private int pagenum = 1;
    private int pagesize = 5;
    private RecyclerView rv;
    private SwipeRefreshLayout swrefresh;
    private MainOrderByBean bean;
    private MainAty_MainPage_OrderByAllAdapter adapter;

    public FragmentMainPageOrderByAllPersenter(Fragment_MainPage_OrderByAll fragment, MainActivity activity) {
        this.fragment = fragment;
        this.activity = activity;
        rv = fragment.getFragMainpageOrderbyallRv();
        swrefresh = fragment.getFragMainpageOrderbyallSwrefresh();
        adapter = new MainAty_MainPage_OrderByAllAdapter(activity);
    }

    public void initview() {
        rv.setLayoutManager(new LinearLayoutManager(activity));
        swrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pagenum = 1;
                initnet(pagenum);
            }
        });
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = layoutManager.getItemCount();
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();

//                if (!loading && totalItemCount < (lastVisibleItem + Constant.VISIBLE_THRESHOLD)) {
//                    new ArticleTask(mActivity).execute(mAdapter.getBottomArticleId());
//                    loading = true;
//                }
            }
        });
    }

    public void initnet(int page) {
        if (pagenum == page && pagenum == 1) {
            getpageinfo(pagenum);
        }
    }

    public void getpageinfo(int page) {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", MyApplication.aCache.getAsString("token"));
//        map.put("latitude",LocationUtils.getLngAndLat(activity).getLatitude());
//        map.put("longitude",LocationUtils.getLngAndLat(activity).getLongitude());
        map.put("latitude", "30.565656");
        map.put("longitude", "104.565656");
        map.put("pagenum", String.valueOf(pagenum));
        map.put("pagesize", String.valueOf(pagesize));
        map.put("distance", "50000");
        map.put("ordertype", "01");
        OkHttpUtil.doPost(activity.getIntance(), AppConfig.url_main, map, false, new OkHttpUtil.WcgCallBack() {
            @Override
            public void onCancle(Call call, IOException e) {
                if (swrefresh.isRefreshing()) {
                    swrefresh.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                if (swrefresh.isRefreshing()) {
                    swrefresh.setRefreshing(false);
                }
                T.showShort("网络异常");
            }

            @Override
            public void onSuccess(String response) {
                if (swrefresh.isRefreshing()) {
                    swrefresh.setRefreshing(false);
                }
                try {
                    bean = JsonUtil.getEntityByJsonString(response, MainOrderByBean.class);
                    if (pagenum == 1) {
                        adapter.setBean(bean.getData());
                        rv.setAdapter(adapter);
                    } else {
                        adapter.getBean().getShopinfo().addAll(bean.getData().getShopinfo());
                        adapter.getBean().setIslastpage(bean.getData().isIslastpage());
                    }
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
