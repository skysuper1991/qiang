package cn.qiang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qiang.R;
import cn.qiang.bean.listbean;
import cn.qiang.utils.CommonUtils;
import cn.qiang.utils.HttpUtils;
import cn.qiang.utils.SharedPreferencesUtils;

public class ListBeanAdapter extends BaseAdapter implements View.OnClickListener {
    private static final String TAG = "ListBeanAdapter";

    private List<listbean.DataBean> dataBeans;
    private Context context;
    private boolean flag = true;
    private String qianggou = "http://www.6688.name/api.php/index/qianggou";

    private String booking = "http://www.6688.name/api.php/index/booking";
    private long millis = 0;
    private String phone;

    public ListBeanAdapter(Context context) {
        dataBeans = new ArrayList<>();
        this.context = context;
        phone = CommonUtils.getPhone(context);
    }

    public void setDataBeans(List<listbean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        this.isqiang = true;
    }

    public void clearDataBeans() {
        this.dataBeans.clear();
    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public listbean.DataBean getItem(int i) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_city, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String cishi = "";
        if (isqiang) {
            viewHolder.tvName.setText(dataBeans.get(i).getName());
            viewHolder.tvPrice.setText("价格:" + dataBeans.get(i).getPricemin() + "--" + dataBeans.get(i).getPricemax());
            viewHolder.tvTime.setText("时间:" + dataBeans.get(i).getTimemin() + "");
            viewHolder.tvTaiYang.setText("太阳:" + dataBeans.get(i).getTaozi() + "");

            long time = System.currentTimeMillis() / 1000;
            Log.i(TAG, "getView: " + time + "=====" + dataBeans.get(i).getMin_time());
            long timex = dataBeans.get(i).getMin_time() - time;
            Log.i(TAG, "getView: " + timex + ",i=" + i);
            Log.i(TAG, i + "getView: " + (timex > 0));
            Log.i(TAG, i + "getView: " + (timex < 600));
            Log.i(TAG, i + "getView: " + (timex > 0 && timex < 600));
            if (timex >0 && timex < 30 * 60) {
                viewHolder.btnSave.setBackgroundColor(Color.parseColor("#FF4081"));  //红色
                view.setBackgroundColor(Color.parseColor("#3F51B5"));
                viewHolder.tvTime.setTextColor(Color.parseColor("#ffffff"));
            } else {
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                viewHolder.btnSave.setBackgroundColor(Color.parseColor("#3F51B5"));
            }

            viewHolder.btnSave.setOnClickListener(this);
            viewHolder.btnSave.setTag(i);
            viewHolder.btnCanle.setOnClickListener(this);
            viewHolder.btnCanle.setTag(i);
            viewHolder.btnYuding.setOnClickListener(this);
            viewHolder.btnYuding.setTag(i);
        } else {
            if (dataBeans.get(i).getCounts() != 0) {
                cishi = "\n\n" + "正在抢购" + dataBeans.get(i).getName() + ",点击次数：" + dataBeans.get(i).getCounts();
            }
        }
        viewHolder.tvTips.setText("收益:" + dataBeans.get(i).getShouyi() + "               周期:" + dataBeans.get(i).getZouqi() + cishi);
        return view;
    }


    private void setTimer() {
        flag = true;
        Log.i(TAG, "setTimer: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(millis); //休眠一秒
                        mHanler.sendEmptyMessage(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void stopTimer() {
        flag = false;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHanler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //去执行定时操作逻辑
            Log.i(TAG, "handleMessage: " + millis);
//            dataBeans.get(position).setCounts((dataBeans.get(position).getCounts()) + 1);
//            notifyDataSetChanged();
            qianggou();
        }
    };

    private String tips = "";
    private int position;

    private void qianggou() {
        String token = CommonUtils.getAccessToken(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("changci", "" + dataBeans.get(position).getChangci());
        HttpUtils.postHttp(map, qianggou, new HttpUtils.HttpCallBack() {
            @Override
            public void successHttp(JSONObject jsonObject, int id) {
                String msg = jsonObject.optString("msg");
                if (!msg.equals(tips)) {
                    tips = msg;
                    Toast.makeText(context, msg + "_" + phone, Toast.LENGTH_SHORT).show();
                }
                dataBeans.get(position).setCounts((dataBeans.get(position).getCounts()) + 1);
                notifyDataSetChanged();
                dataBeans.get(position).setStips(msg);
                Log.i(TAG, "successHttp: " + jsonObject.toString());
            }

            @Override
            public void errorHttp(String msg) {

            }
        });
    }

    private void booking() {
        String token = CommonUtils.getAccessToken(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("changci", dataBeans.get(position).getChangci() + "");
        HttpUtils.postHttp(map, booking, new HttpUtils.HttpCallBack() {
            @Override
            public void successHttp(JSONObject jsonObject, int id) {
                String msg = jsonObject.optString("msg");
                if (!msg.equals(tips)) {
                    tips = msg;
                    Toast.makeText(context, msg + "_" + dataBeans.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
                dataBeans.get(position).setStips(msg);
                Log.i(TAG, "successHttp: " + jsonObject.toString());
            }

            @Override
            public void errorHttp(String msg) {

            }
        });
    }

    private boolean isqiang;

    @Override
    public void onClick(View view) {
        this.millis = Integer.parseInt(SharedPreferencesUtils.getParam(context, "millis", "10").toString());
        tips = "";
        position = (int) view.getTag();
        switch (view.getId()) {
            case R.id.btn_yuding:
                booking();

                break;
            case R.id.btn_save:
                isqiang = false;
                setTimer();
                setTimer();
                setTimer();
                setTimer();
                setTimer();
                flag = true;
                break;
            case R.id.btn_canle:
                stopTimer();
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_taiyang)
        TextView tvTaiYang;
        @BindView(R.id.tv_tips)
        TextView tvTips;
        @BindView(R.id.btn_yuding)
        Button btnYuding;
        @BindView(R.id.btn_save)
        Button btnSave;
        @BindView(R.id.btn_canle)
        Button btnCanle;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

