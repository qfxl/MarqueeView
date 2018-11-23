package com.qfxl.marquee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qfxl.marquee.R;
import com.qfxl.marquee.entity.AdvEntity;
import com.qfxl.marqueeview.BaseMarqueeAdapter;

import java.util.List;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MyAdapter extends BaseMarqueeAdapter {
    private List<AdvEntity> mList;

    public MyAdapter(List<AdvEntity> list) {
        mList = list;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_marquee, null);
        ViewHolder holder = new ViewHolder(itemView);
        holder.tv_title.setText(mList.get(position).getTitle());
        holder.tv_content.setText(mList.get(position).getContent());
        return itemView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    class ViewHolder {
        public TextView tv_title;
        public TextView tv_content;

        public ViewHolder(View itemView) {
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
