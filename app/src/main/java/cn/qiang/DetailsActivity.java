package cn.qiang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiang.adapter.OrderListAdapter;
import cn.qiang.bean.OrderBean;
import cn.qiang.utils.CommonUtils;
import cn.qiang.utils.HttpUtils;

public class DetailsActivity extends Activity {
    private static final String TAG = "DetailsActivity";
    @BindView(R.id.lv_list)
    ListView lvList;
    @BindView(R.id.bt_save)
    TextView btSave;
    private String type = "4";
    private String url = "http://www.6688.name/api.php/order/orderinfo";

    private OrderBean orderBean;
    private OrderListAdapter orderListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        orderListAdapter = new OrderListAdapter(DetailsActivity.this);
        lvList.setAdapter(orderListAdapter);
        init();

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        Map<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("type", type);
        map.put("token", CommonUtils.getAccessToken(DetailsActivity.this));
        HttpUtils.postHttp(map, url, new HttpUtils.HttpCallBack() {
            @Override
            public void successHttp(JSONObject jsonObject, int id) {
                if (jsonObject.optInt("code") == 1) {
                    Gson gson = new Gson();
                    orderBean = gson.fromJson(String.valueOf(jsonObject), OrderBean.class);
                    if (orderBean != null && orderBean.getData() != null)
                        orderListAdapter.setDataBeans(orderBean.getData());
                    if (orderListAdapter.getCount() == 0)
                        Toast.makeText(DetailsActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
                    orderListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void errorHttp(String msg) {

            }
        });
    }


    @OnClick({R.id.rb_1, R.id.rb_2, R.id.rb_3, R.id.rb_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_1:
                type = "4";
                break;
            case R.id.rb_2:
                type = "1";
                break;
            case R.id.rb_3:
                type = "2";
                break;
            case R.id.rb_4:
                type = "3";
                break;
        }
        init();
    }
}
