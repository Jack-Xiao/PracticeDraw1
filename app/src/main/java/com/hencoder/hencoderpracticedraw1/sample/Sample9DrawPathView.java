package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample9DrawPathView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path mPath = new Path();
    {
        mPath.addArc(new RectF(200, 200, 400, 400), -225, 225); // 半径 100 的扇形 225度，从-225开始
        mPath.arcTo(new RectF(400, 200, 600, 400), -180, 225, false); // false 不留下移笔痕迹
        mPath.lineTo(400, 542); // 从原点画直线到坐标400,542
    }

    public Sample9DrawPathView(Context context) {
        super(context);
    }

    public Sample9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        //        练习内容：使用 canvas.drawPath() 方法画心形	//        练习内容：使用 canvas.drawPath() 方法画心形
        canvas.drawPath(mPath,mPaint);
    }
}
