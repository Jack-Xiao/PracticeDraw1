package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample7DrawRoundRectView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF mRectF = new RectF(300,100,800,500);

    public Sample7DrawRoundRectView(Context context) {
        super(context);
    }

    public Sample7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(mRectF,50,50,mPaint);
    }
}
