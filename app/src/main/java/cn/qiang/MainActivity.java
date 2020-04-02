package cn.qiang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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
import cn.qiang.adapter.ListBeanAdapter;
import cn.qiang.bean.listbean;
import cn.qiang.utils.CommonUtils;
import cn.qiang.utils.HttpUtils;
import cn.qiang.utils.SharedPreferencesUtils;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.et_token)
    EditText etToken;
    @BindView(R.id.et_time)
    EditText etTime;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.lv_list)
    ListView lvList;
    private String url = "http://www.6688.name/api.php/index/index";
    private String getPhone = "http://www.6688.name/api.php/center/index";
    private ListBeanAdapter adapter;
    private listbean listbean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate: " + CommonUtils.getAccessToken(MainActivity.this));
        etToken.setText(CommonUtils.getAccessToken(MainActivity.this));
        adapter = new ListBeanAdapter(this);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(this);
        getPhone();
        getindex();
        getMillis();
    }


    public void setMillis() {
        SharedPreferencesUtils.setParam(MainActivity.this, "millis", etTime.getText().toString().trim());
    }

    /**
     * get_base_token
     */
    public String getMillis() {
        String millis = SharedPreferencesUtils.getParam(MainActivity.this, "millis", "10").toString();
        Log.i(TAG, "getMillis: " + millis);
        if (millis.length() > 0)
            etTime.setText(millis);
        else
            millis = 500 + "";
        return millis;
    }

    private void getindex() {
        Map<String, String> map = new HashMap<>();
        map.put("token", CommonUtils.getAccessToken(MainActivity.this));
        HttpUtils.postHttp(map, url, new HttpUtils.HttpCallBack() {
            @Override
            public void successHttp(JSONObject jsonObject, int id) {
                if (jsonObject.optInt("code") == 1) {
                    Gson gson = new Gson();
                    listbean = gson.fromJson(String.valueOf(jsonObject), listbean.class);
                    adapter.setDataBeans(listbean.getData());
                }
                adapter.notifyDataSetChanged();
                Log.i(TAG, "successHttp: " + jsonObject);
                Toast.makeText(MainActivity.this, "" + jsonObject.optString("     msg"), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void errorHttp(String msg) {
                Toast.makeText(MainActivity.this, "输入的token不正确", Toast.LENGTH_SHORT).show();
                adapter.clearDataBeans();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getPhone() {
        Map<String, String> map = new HashMap<>();
        map.put("token", CommonUtils.getAccessToken(MainActivity.this));
        HttpUtils.postHttp(map, getPhone, new HttpUtils.HttpCallBack() {
            @Override
            public void successHttp(JSONObject jsonObject, int id) {
                if (jsonObject.optInt("code") == 1) {
                    tvPhone.setText(jsonObject.optJSONObject("data").optString("mobile"));
                    CommonUtils.sethpone(MainActivity.this, tvPhone.getText().toString());
                } else {
                    tvPhone.setText("上一次电话" + CommonUtils.getPhone(MainActivity.this));
                }
            }

            @Override
            public void errorHttp(String msg) {
                adapter.clearDataBeans();
                adapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        setMillis();
    }


    @OnClick({R.id.btn_save, R.id.btn_mismm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                CommonUtils.setAccessToken(MainActivity.this, etToken.getText().toString());
                getindex();
                getPhone();
                break;
            case R.id.btn_mismm:
                setMillis();
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("changci_id", adapter.getItem(i).getChangci());
        startActivity(intent);
    }
}

