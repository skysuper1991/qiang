package cn.qiang.utils;

import android.content.Context;


public class CommonUtils {
    private static final String TAG = "CommonUtils";
    private static String token = "2d047115-055e-4f00-9d3a-5143c1a460e2";
    /**
     * @param context
     * @param access_token
     */
    public static void setAccessToken(Context context, String access_token) {
        SharedPreferencesUtils.setParam(context, "access_token", access_token);


    }


    /**
     * @return
     */
    public static String getAccessToken(Context context) {
        String assessToken = SharedPreferencesUtils.getParam(context, "access_token", token).toString();
        return assessToken;
//        return token;
    }

    /**
     * @return
     */
    public static String getPhone(Context context) {
        return SharedPreferencesUtils.getParam(context, "access_phone", "").toString();
    }

    /**
     * @param context
     * @param access_token
     */
    public static void sethpone(Context context, String access_token) {
        SharedPreferencesUtils.setParam(context, "access_phone", access_token);
    }

}
