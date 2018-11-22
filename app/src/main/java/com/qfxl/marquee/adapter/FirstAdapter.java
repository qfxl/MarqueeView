package com.qfxl.marquee.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qfxl.marqueeview.BaseMarqueeAdapter;

import java.util.List;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/22
 *     desc   : 第一行MarqueeView适配器
 *     version: 1.0
 * </pre>
 */
public class FirstAdapter extends BaseMarqueeAdapter {
    private List<String> mList;

    public FirstAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        TextView defaultView = new TextView(context);
        defaultView.setText(mList.get(position));
        defaultView.setTextColor(Color.parseColor("#666666"));
        defaultView.setGravity(Gravity.CENTER);
        return defaultView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
