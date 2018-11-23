package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample8DrawArcView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF mRectF = new RectF(200,100,800,500);

    public Sample8DrawArcView(Context context) {
        super(context);
    }

    public Sample8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mRectF,-130,110,true,mPaint);// 从-130开始，跨度110
        canvas.drawArc(mRectF,20,120,false,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mRectF,180,40,false,mPaint);

    }
}