package com.qfxl.marquee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qfxl.marquee.R;
import com.qfxl.marquee.entity.TaoBaoEntity;
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
public class TaoBaoAdapter extends BaseMarqueeAdapter {
    private List<TaoBaoEntity> mList;

    public TaoBaoAdapter(List<TaoBaoEntity> list) {
        mList = list;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_taobao_marquee, null);
        ViewHolder holder = new ViewHolder(itemView);
        holder.tvTitle.setText(mList.get(position).getTitle());
        holder.tvContent.setText(mList.get(position).getContent());
        return itemView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvContent;

        ViewHolder(View itemView) {
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
