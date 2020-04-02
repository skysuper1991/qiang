package cn.qiang.utils;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by Administrator on 2018/6/28 0028.
 */

public class HttpUtils {

    private static String TAG = "HttpUtils";

    private static String urlName(String url) {
        return "." + url.substring(url.lastIndexOf("/") + 1, url.length());
    }

    /**
     * get请求
     *
     * @param params
     * @param url
     * @param httpCallBack
     */
    public static void getHttp(final String url, Map<String, String> params, final HttpCallBack httpCallBack) {
        if (url == null || url.length() == 0) {
            Log.w(TAG + urlName(url), "get:url不能为空");
            return;
        }
        String strParam = params.toString().replaceAll(" ", "");
        Log.w(TAG + urlName(url), url + "?" + strParam.replaceAll(",", "&").substring(1, strParam.length() - 1));
        OkHttpUtils.get().params(params).url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG + urlName(url), "onError" + e.getMessage());
                httpCallBack.errorHttp(e.getMessage());
            }
            @Override
            public void onResponse(String response, int id) {
                try {
                    Log.i(TAG, "onResponse: " + response);
                    JSONObject object = new JSONObject(response);
                    Log.i(TAG + urlName(url), response);
                    httpCallBack.successHttp(object, id);
                } catch (JSONException e) {
                    Log.e(TAG + urlName(url), "onError:" + e.getMessage());
                }
            }
        });
    }

    /**
     * post请求
     *
     * @param params
     * @param url
     * @param httpCallBack
     */
    public static void postHttp(Map<String, String> params, final String url, final HttpCallBack httpCallBack) {
        if (url == null || url.length() == 0) {
            Log.w(TAG + urlName(url), "get:url不能为空");
            return;
        }
//        Toast.makeText(MyApplication.getContext(), "成功", Toast.LENGTH_SHORT).show();
        if (params != null) {
//            String sessionId = CommonUtils.getSession(MyApplication.getContext());
//            params.put("sid", sessionId);
            Log.i(TAG, params.toString());
        }

        String strParam = params.toString().replaceAll(" ", "");
        Log.w(TAG + urlName(url), url + "?" + strParam.replaceAll(",", "&").substring(1, strParam.length() - 1));
        OkHttpUtils.post()
                .params(params).url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG + urlName(url), "onError" + e.getMessage());
                        httpCallBack.errorHttp(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.i(TAG + urlName(url), response);
                            JSONObject object = new JSONObject(response);
                            httpCallBack.successHttp(object,id);
                        } catch (JSONException e) {
                            Log.e(TAG + urlName(url), "onError:" + e.getMessage());
                        }
                    }
                });
    }

    /**
     * 上传图片
     *
     * @param file
     * @param callBack
     */
    public static void uploadImage(Map<String, String> params, String url, File file, final HttpCallBack callBack) {
        if (url == null && url.length() == 0) {
            return;
        }
        if (!file.exists()) {
            return;
        }
//        String sessionId = CommonUtils.getSession(MyApplication.getContext());
        OkHttpUtils.post().params(params).addFile("image", file.getName(), file).url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i(TAG, "onError: " + e.getMessage());
                callBack.errorHttp(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    Log.i(TAG, "onResponse: " + response);
                    JSONObject json = new JSONObject(response);
                    callBack.successHttp(json, id);
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        });
    }

    /**
     * http 请求回调
     */
    public interface HttpCallBack {
        void successHttp(JSONObject jsonObject, int id);

        void errorHttp(String msg);
    }

    /**
     * http 请求回调
     */
    public interface HttpCallBackError {
        void successHttp(JSONObject jsonObject, int id);

        void errorHttp(String msg);
    }

}
