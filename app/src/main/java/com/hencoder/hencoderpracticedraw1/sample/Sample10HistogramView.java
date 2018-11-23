package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample10HistogramView extends View {
    //dither 防抖动, antialias 抗锯齿
    private Paint mPaint = new Paint(Paint.DITHER_FLAG | Paint.ANTI_ALIAS_FLAG);
    private String[] mTexts = new String[]{
            "Froyo",
            "GB",
            "ICS",
            "JB",
            "KitKat",
            "L",
            "M",
    };
    private float[] mValue = new float[]{
            1.0f / 40,
            1.0f / 20,
            1.0f / 20,
            4.0f / 10,
            4.0f / 5,
            6.0f / 7,
            1.0f / 3,
    };

    public Sample10HistogramView(Context context) {
        super(context);
    }

    public Sample10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
//        setBackgroundColor(Color.parseColor("#506E7"));
        final int histogramCount = 7;
        float spacing = 15;
        float histogramW = (getWidth() / 8 * 6 - (histogramCount + 1) * spacing) / histogramCount;

        drawCoordinateAxis(canvas);
        drawXText(canvas, spacing, histogramW, histogramCount);
        drawHistogram(canvas, spacing, histogramW, histogramCount);

        drawTitleText(canvas);
    }

    /**
     * 绘制标题
     *
     * @param canvas 画布
     */
    private void drawTitleText(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(48);
        String title = "直方图";
        canvas.drawText(title, getWidth() / 2 - mPaint.measureText(title) / 2,
                30 + Math.abs(mPaint.getFontMetrics().ascent), mPaint);
    }

    /**
     * 绘制柱状图
     *
     * @param canvas         画布
     * @param spacing        柱状图间距
     * @param histogramW     柱状图宽度
     * @param histogramCount 柱状图个数
     */
    private void drawHistogram(Canvas canvas, float spacing, float histogramW, float histogramCount) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#72B916"));
        for (int i = 0; i < histogramCount; i++) {
            canvas.drawRect(
                    getWidth() / 8 + (i + 1) * (spacing + histogramW) - histogramW,
                    getHeight() / 8 * 7 - getHeight() / 8 * 6 * mValue[i],
                    getWidth() / 8 + (i + 1) * (spacing + histogramW),
                    getHeight() / 8 * 7,
                    mPaint);
        }
    }

    /**
     * 绘制 X 轴上的文字
     *
     * @param canvas         画布
     * @param spacing        柱状图间距
     * @param histogramW     柱状图宽度
     * @param histogramCount 柱状图个数
     */
    private void drawXText(Canvas canvas, float spacing, float histogramW, float histogramCount) {
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(18);
        for (int i = 0; i < histogramCount; i++) {
            float textWidth = mPaint.measureText(mTexts[i]);
            canvas.drawText(mTexts[i],
                    getWidth() / 8 + (i + 1) * (spacing + histogramW) - histogramW / 2 - textWidth / 2,
                    getHeight() / 8 * 7 + Math.abs(mPaint.getFontMetrics().ascent), mPaint);
        }
    }

    /**
     * 绘制坐标轴
     *
     * @param canvas 画布
     */
    private void drawCoordinateAxis(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(10F);
        canvas.drawLines(new float[]{
                getWidth() / 8, getHeight() / 8,
                getWidth() / 8, getHeight() / 8 * 7,
                getWidth() / 8, getHeight() / 8 * 7,
                getWidth() / 8 * 7, getHeight() / 8 * 7,
        }, mPaint);

    }
}
