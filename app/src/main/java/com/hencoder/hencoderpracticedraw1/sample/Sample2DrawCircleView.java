package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Dp2PxUtil;

public class Sample2DrawCircleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample2DrawCircleView(Context context) {
        super(context);
    }

    public Sample2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        paint.setColor(Color.BLACK);
        canvas.drawCircle(300F, 200F, 200F, paint);

        paint.setStrokeWidth(5F);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(800F, 200F, 200F, paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300F, 700F, 200F, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Dp2PxUtil.dip2px(getContext(), 20F));
        canvas.drawCircle(800F, 700F, 200F, paint);
    }
}
