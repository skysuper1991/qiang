package cn.qiang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qiang.R;
import cn.qiang.bean.OrderBean;

public class OrderListAdapter extends BaseAdapter {
    private static final String TAG = "ListBeanAdapter";

    private List<OrderBean.DataBean> dataBeans;
    private Context context;


    public OrderListAdapter(Context context) {
        dataBeans = new ArrayList<>();
        this.context = context;
    }

    public void setDataBeans(List<OrderBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    public void clearDataBeans() {
        this.dataBeans.clear();
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public OrderBean.DataBean getItem(int i) {
        return dataBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_order, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvName.setText(dataBeans.get(i).getName());
        viewHolder.tvPrice.setText("总金额:" + dataBeans.get(i).getPrice() + "           利率:" + dataBeans.get(i).getShouyi() + "%");
        double lilv = (dataBeans.get(i).getPrice() * (dataBeans.get(i).getShouyi() * 0.01));
        DecimalFormat df = new DecimalFormat("#.00");

        String endtime = dataBeans.get(i).getEnttime();
        String str = "";
        if (endtime != null && endtime.length() > 10)
            str = "    结束时间:" + endtime.substring(0, endtime.length() - 9);
        viewHolder.tvLirun.setText("利润:" + df.format(lilv) + str);

        return view;
    }


    static class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_lirun)
        TextView tvLirun;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

