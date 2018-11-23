package com.qfxl.marquee.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qfxl.marquee.R;
import com.qfxl.marqueeview.BaseMarqueeAdapter;

import java.util.List;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/22
 *     desc   : 第二行MarqueeView适配器
 *     version: 1.0
 * </pre>
 */
public class SecondAdapter extends BaseMarqueeAdapter {
    private List<Pair<String, String>> mPairs;

    public SecondAdapter(List<Pair<String, String>> pairs) {
        mPairs = pairs;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_second_marquee, null);
        TextView first = itemView.findViewById(R.id.tv_first);
        TextView second = itemView.findViewById(R.id.tv_second);
        first.setText(mPairs.get(position).first);
        second.setText(mPairs.get(position).second);
        return itemView;
    }

    @Override
    public int getCount() {
        return mPairs.size();
    }
}
