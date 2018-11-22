package com.qfxl.marquee.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qfxl.marquee.AdvEntity;
import com.qfxl.marquee.R;
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
public class ThirdAdapter extends BaseMarqueeAdapter {
    private List<AdvEntity> mList;

    public ThirdAdapter(List<AdvEntity> list) {
        mList = list;
    }

    @Override
    public View getView(int position, Context context, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_third_marquee, null);
        ViewHolder holder = new ViewHolder(itemView);
        holder.adContentTv.setText(mList.get(position).getContent());
        holder.adPromotionalTv.setText(mList.get(position).getPromotionalPrice());
        holder.adPriceTv.setText(mList.get(position).getPrice());
        return itemView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    class ViewHolder {
        public TextView adContentTv;
        public TextView adPriceTv;
        public TextView adPromotionalTv;

        public ViewHolder(View itemView) {
            adContentTv = itemView.findViewById(R.id.tv_ad_content);
            adPriceTv = itemView.findViewById(R.id.tv_ad_price);
            adPromotionalTv = itemView.findViewById(R.id.tv_ad_promotional_price);
            adContentTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            adPriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
