package com.qfxl.marqueeview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/22
 *     desc   : MarqueeView 适配器
 *     version: 1.0
 * </pre>
 */
public interface Adapter {
    /**
     * 获取MarqueeView ItemView
     *
     * @param position position
     * @param context  context
     * @param parent   parent
     * @return MarqueeView itemView
     */
    View getView(int position, Context context, ViewGroup parent);

    /**
     * 获取MarqueeView数量
     *
     * @return MarqueeView count
     */
    int getCount();
}
