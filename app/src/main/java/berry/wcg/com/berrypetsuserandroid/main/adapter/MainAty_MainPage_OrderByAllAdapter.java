package berry.wcg.com.berrypetsuserandroid.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.main.activity.MainActivity;
import berry.wcg.com.berrypetsuserandroid.main.bean.MainOrderByBean;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAty_MainPage_OrderByAllAdapter extends RecyclerView.Adapter<MainAty_MainPage_OrderByAllAdapter.ViewHolder> {
    private MainActivity activity;
    private MainOrderByBean.DataBean bean;

    public MainAty_MainPage_OrderByAllAdapter(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_orderby_shop, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txShopname.setText(bean.getShopinfo().get(position).getName());
        holder.txSendprice.setText("￥"+bean.getShopinfo().get(position).getSendstprice()+"起送");
    }

    @Override
    public int getItemCount() {
        return bean.getShopinfo().size();
    }

    public MainOrderByBean.DataBean getBean() {
        return bean;
    }

    public void setBean(MainOrderByBean.DataBean bean) {
        this.bean = bean;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tx_shopname)
        TextView txShopname;
        @BindView(R.id.tx_sendprice)
        TextView txSendprice;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 底部加载更多
     */
    class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcv_load_more)
        ProgressBar rcvLoadMore;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
