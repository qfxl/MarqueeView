package com.qfxl.marqueeview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * <pre>
 *     author : qfxl
 *     e-mail : xuyonghong0822@gmail.com
 *     time   : 2018/11/21
 *     desc   : 跑马灯效果
 *     version: 1.0
 * </pre>
 */
public class MarqueeView extends ViewFlipper {
    private final String TAG = MarqueeView.class.getSimpleName();
    /**
     * 适配器
     */
    private BaseMarqueeAdapter mAdapter;

    /**
     * Item点击监听
     */
    private OnItemClickListener mOnItemClickListener;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bottom_in);
        Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_top_out);
        setInAnimation(in);
        setOutAnimation(out);
    }

    /**
     * 直接设置文本
     *
     * @param texts
     */
    public void setTexts(List<String> texts) {

    }

    /**
     * 设置适配器
     *
     * @param adapter
     */
    public void setAdapter(BaseMarqueeAdapter adapter) {
        if (adapter != null) {
            mAdapter = adapter;
            generateView();
        } else {
            throw new IllegalArgumentException("MarqueeView Adapter is null");
        }
    }

    /**
     * 获取Adapter
     *
     * @return
     */
    public BaseMarqueeAdapter getAdapter() {
        return mAdapter;
    }

    /**
     * 设置Item点击监听
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
        if (mAdapter != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final int position = i;
                View childView = getChildAt(position);
                childView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(position, v);
                        }
                    }
                });
            }
        }
    }

    /**
     * 生成View
     */
    private void generateView() {
        removeAllViews();
        int childCount = mAdapter.getCount();
        for (int i = 0; i < childCount; i++) {
            final int position = i;
            View childView = mAdapter.getView(position, getContext(), this);
            childView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position, v);
                    }
                }
            });
            addView(childView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
    }

    public void start() {
        startFlipping();
    }

    public void stop() {
        stopFlipping();
    }

    public interface OnItemClickListener {
        /**
         * item click监听
         *
         * @param position
         * @param view
         */
        void onItemClick(int position, View view);
    }
}
