package com.ROCKY_IMAGEBrowser;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.ROCKY_IMAGEBrowser.Constants;

public class LazyScrollView extends ScrollView {

    private static final String tag = "LazyScrollView";
    OnTouchListener onTouchListener = new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    if (view != null && onScrollListener != null) {
                        handler.sendMessageDelayed(handler.obtainMessage(
                                Constants.HANDLER_WHAT), Constants.MESSAGE_DELAY);
                    }
                    break;

                default:
                    break;
            }
            return false;
        }

    };
    private Handler handler;
    private View view;
    private OnScrollListener onScrollListener;

    public LazyScrollView(Context context) {
        super(context);

    }

    public LazyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public LazyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        onScrollListener.onAutoScroll(l, t, oldl, oldt);
    }

    private void init() {

        this.setOnTouchListener(onTouchListener);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        if (view.getMeasuredHeight() - 20 <= getScrollY()
                                + getHeight()) {
                            if (onScrollListener != null) {
                                onScrollListener.onBottom();
                            }

                        } else if (getScrollY() == 0) {
                            if (onScrollListener != null) {
                                onScrollListener.onTop();
                            }
                        } else {
                            if (onScrollListener != null) {
                                onScrollListener.onScroll();
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        };

    }

    /**
     * 获得参考的View，主要是为了获得它的MeasuredHeight，然后和滚动条的ScrollY+getHeight作比较。
     */
    public void getView() {
        this.view = getChildAt(0);
        if (view != null) {
            init();
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    /**
     * 定义接口
     *
     * @author admin
     */
    public interface OnScrollListener {
        void onBottom();

        void onTop();

        void onScroll();

        void onAutoScroll(int l, int t, int oldl, int oldt);
    }
}