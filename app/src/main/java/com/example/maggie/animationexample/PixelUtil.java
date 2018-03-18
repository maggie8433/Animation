package com.example.maggie.animationexample;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by MAGGIE on 2018/3/13.
 */
public class PixelUtil {

    public static float getDensity(Context context) {
        if(context == null) {
            return 0;
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }

    public static float convertDpToPixel(float dp, Context context) {
        float px = dp * getDensity(context);
        return px;
    }

    public static float convertPixelToDp(float px, Context context) {
        float dp = px / getDensity(context);
        return dp;
    }

    public static void setFrame(View v, float x, float y, float w, float h) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) (w), (int) (h));
        params.setMargins((int) x, (int) y, 0, 0);
        v.setLayoutParams(params);
    }

    public static void setLinearLayout(View v, float w, float h) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (w), (int) (h));
        v.setLayoutParams(params);
    }

    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        if (activity != null) {
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        }
        return metrics;
    }

}
