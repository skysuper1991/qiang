package cn.qiang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qiang.R;

public class ListMsgAdapter extends BaseAdapter{
    private static final String TAG = "ListBeanAdapter";

    private List<String> dataBeans;
    private Context context;

    public ListMsgAdapter(Context context) {
        dataBeans = new ArrayList<>();
        this.context = context;
    }

    public void setDataBeans(String dataBeans) {
        this.dataBeans.add(dataBeans);
    }


    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvTips.setText(dataBeans.get(i));
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.tv_tips)
        TextView tvTips;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
