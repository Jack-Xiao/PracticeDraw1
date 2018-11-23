package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Dp2PxUtil;

public class Sample4DrawPointView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample4DrawPointView(Context context) {
        super(context);
    }

    public Sample4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(Dp2PxUtil.dip2px(getContext(), 20));
        canvas.drawPoint(200, 200, mPaint);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(400, 200, mPaint);
    }
}
