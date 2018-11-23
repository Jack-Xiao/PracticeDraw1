package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample3DrawRectView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public Sample3DrawRectView(Context context) {
        super(context);
    }

    public Sample3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        mPaint.setColor(Color.BLACK);
        //width height point 中心点

        int widthPoint = getWidth() / 2;
        int heightPoint = getHeight() / 2;
        int start = widthPoint - 200;
        int top = heightPoint - 200;

        int right = widthPoint + 200;
        int bottom = heightPoint + 200;

        canvas.drawRect(start, top, right, bottom, mPaint);
    }
}
