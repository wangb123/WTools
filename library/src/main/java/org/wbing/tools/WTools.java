package org.wbing.tools;

import android.content.Context;

/**
 * @author wangbing
 * @date 2018/8/28
 */
public class WTools {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
