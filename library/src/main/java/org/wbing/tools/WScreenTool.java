package org.wbing.tools;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;

import java.lang.reflect.Field;


/**
 * 获取屏幕,分辨率相关
 *
 * @author 6a209
 * <p/>
 * 2011-12-14 下午10:28:41
 */
public class WScreenTool {

    private WScreenTool() {
    }

    public static int getScreenWidth() {
        return WTools.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public static int dip2px(int dip) {
        return dip2px((float) dip);
    }

    public static int dip2px(float dip) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dip, WTools.getContext().getResources().getDisplayMetrics()
        );
    }

    public static int px2dip(int px) {
        float density = getDensity(WTools.getContext());
        return Math.round(px / density);
    }

    public static int getScreenDensityDpi() {
        return WTools.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static float getXdpi() {
        return WTools.getContext().getResources().getDisplayMetrics().xdpi;
    }

    public static float getYdpi() {
        return WTools.getContext().getResources().getDisplayMetrics().ydpi;
    }

    public static float getDensity() {
        return WTools.getContext().getResources().getDisplayMetrics().density;
    }

    public static float getDensity(Context ctx) {
        return ctx.getResources().getDisplayMetrics().density;
    }

    /**
     * ５40 的分辨率上是85 （
     *
     * @return
     */
    public static int getScal() {
        return (int) (getScreenWidth() * 100 / 480);
    }

    /**
     * 宽全屏, 根据当前分辨率　动态获取高度
     * height 在８００*４８０情况下　的高度
     *
     * @return
     */
    public static int get480Height(int height480) {
        int width = getScreenWidth();
        return (height480 * width / 480);
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = WTools.getContext().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sbar;
    }

    public static int getScreenHeight() {
        return WTools.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * Get boundary of view which current page shows in.
     *
     * @param activity
     * @return index 0: width index 1:height
     */
    public static int[] getContentBoundary(Activity activity) {
        int[] boundary = new int[2];
        if (activity == null) {
            return boundary;
        }

        View contentView = activity.findViewById(android.R.id.content);
        boundary[0] = contentView.getMeasuredWidth();
        boundary[1] = contentView.getMeasuredHeight();

        return boundary;
    }
}