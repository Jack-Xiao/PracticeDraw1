package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Dp2PxUtil;

public class Sample6DrawLineView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample6DrawLineView(Context context) {
        super(context);
    }

    public Sample6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        mPaint.setStrokeWidth(Dp2PxUtil.dip2px(getContext(),5));
        canvas.drawLine(100,100,400,400,mPaint);
    }
}
