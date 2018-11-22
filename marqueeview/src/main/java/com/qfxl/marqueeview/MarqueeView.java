package com.qfxl.marqueeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

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
     * item点击监听
     */
    private OnItemClickListener mOnItemClickListener;
    /**
     * 默认的滚动方向
     */
    private Direction mDirection;

    private final Direction[] directions = {
            Direction.LEFT_TO_RIGHT,
            Direction.TOP_TO_BOTTOM,
            Direction.RIGHT_TO_LEFT,
            Direction.BOTTOM_TO_TOP
    };

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MarqueeView);
        Animation in = getInAnimation();
        Animation out = getOutAnimation();
        if (in == null || out == null) {
            int directionIndex = a.getInt(R.styleable.MarqueeView_mv_direction, 0);
            mDirection = directions[directionIndex];
            switch (mDirection) {
                default:
                case LEFT_TO_RIGHT:
                    in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_left_in);
                    out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_right_out);
                    break;
                case TOP_TO_BOTTOM:
                    in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_top_in);
                    out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bottom_out);
                    break;
                case RIGHT_TO_LEFT:
                    in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_right_in);
                    out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_left_out);
                    break;
                case BOTTOM_TO_TOP:
                    in = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bottom_in);
                    out = AnimationUtils.loadAnimation(getContext(), R.anim.anim_top_out);
                    break;
            }
        }
        a.recycle();
        setInAnimation(in);
        setOutAnimation(out);
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
        int adapterCount = mAdapter.getCount();
        for (int i = 0; i < adapterCount; i++) {
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

    public enum Direction {
        /**
         * left -> right
         */
        LEFT_TO_RIGHT(0),
        /**
         * top -> bottom
         */
        TOP_TO_BOTTOM(1),
        /**
         * right -> left
         */
        RIGHT_TO_LEFT(2),
        /**
         * bottom -> top
         */
        BOTTOM_TO_TOP(3);

        Direction(int i) {

        }
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
