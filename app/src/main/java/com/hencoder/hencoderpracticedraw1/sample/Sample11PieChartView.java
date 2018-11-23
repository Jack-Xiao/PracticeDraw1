package com.hencoder.hencoderpracticedraw1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Sample11PieChartView extends View {
    private final float[] mPercents = new float[]{
            0.01f,
            0.03f,
            0.02f,
            0.16f,
            0.28f,
            0.34f,
            0.16f,
    };

    private String[] mTexts = new String[]{
            "Froyo",
            "Gingerbread",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
    };

    private String[] mColors = new String[]{
            "#FFFFFF",
            "#9926AD",
            "#9E9E9E",
            "#009688",
            "#2196F3",
            "#F44336",
            "#FFC107",
    };

    // 每个扇形 中心点偏差
    private float[][] mOffsets = new float[][]{
            new float[]{0, 0},
            new float[]{0, 1},
            new float[]{0, 2},
            new float[]{0, 2},
            new float[]{-2, 2},
            new float[]{-8, -16},
            new float[]{1, -1},

    };

    // 每个扇形 起始角度 + 扫过角度
    private float[][] mAngles = calculateAngle();

    private float[][] mLineStart = new float[mPercents.length][2];

    private Random mRandom = new Random();
    private Path mPath = new Path();
    private RectF mRectF = new RectF();
    private Paint mPaint = new Paint(Paint.DITHER_FLAG | Paint.ANTI_ALIAS_FLAG);

    public Sample11PieChartView(Context context) {
        super(context);
    }

    public Sample11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float centerX = getWidth() / 2 - 100;
        float centerY = getHeight() / 2;

        float radius = 240;
        int arcCount = mPercents.length;

        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < arcCount; i++) {
            mRectF.set(centerX - radius + mOffsets[i][0],
                    centerY - radius + mOffsets[i][1],
                    centerX + radius + mOffsets[i][0],
                    centerY + radius + mOffsets[i][1]);

            mLineStart[i][0] = (float) (mRectF.centerX() +
                    radius * Math.cos(transform(mAngles[i][0] + mAngles[i][1] / 2)));
            mLineStart[i][1] = (float) (mRectF.centerY() -
                    radius * Math.sin(transform(mAngles[i][0] + mAngles[i][1] / 2)));
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(18);
            drawLine(canvas, i, centerY);

            mPaint.setColor(Color.parseColor(mColors[i]));
            // 2 度的间隙
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(mRectF, mAngles[i][0], mAngles[i][1] - 2, true, mPaint);
        }
    }

    private void drawLine(Canvas canvas, int index, float centerY) {
        int[] scale = getScale(index);
        mPath.reset();
        mPath.moveTo(mLineStart[index][0], mLineStart[index][1]);

        float[] offset = new float[2];

        if (index == 0 && Math.abs(mLineStart[0][1] - centerY) < 20) {
            mPath.rLineTo(100, 0);
            offset[0] = 100;
            offset[1] = 0;
        } else if (index != 0
                && Math.abs(mLineStart[index - 1][1] - mLineStart[index][1]) < 40
                && Math.abs(mLineStart[index - 1][0] - mLineStart[index][0]) < 40) {
            mPath.rLineTo(45 * scale[0], 0);
            mPath.rLineTo(10 * scale[0], 10 * scale[1]);
            mPath.rLineTo(45 * scale[0], 0);
            offset[0] = 100 * scale[0];
            offset[1] = 10 * scale[1];
        } else {
            mPath.rLineTo(30 * scale[0], 20 * scale[1]);
            mPath.rLineTo(100 * scale[0], 0);
            offset[0] = 130 * scale[0];
            offset[1] = 20 * scale[1];
        }

        float textWidth = scale[0] == 1 ? 20 : -mPaint.measureText(mTexts[index]) - 20;
        canvas.drawText(mTexts[index],
                mLineStart[index][0] + offset[0] + textWidth,
                mLineStart[index][1] + offset[1], mPaint);
        canvas.drawPath(mPath, mPaint);
    }

    // 象限符号
    private int[] getScale(int index) {
        float centerX = getWidth() / 2 - 100;
        float centerY = getHeight() / 2;


        float x = mLineStart[index][0];
        float y = mLineStart[index][1];

        if (x > centerX && y < centerY) {
            return new int[]{1, -1};
        } else if (x > centerX && y > centerY) {
            return new int[]{1, 1};
        } else if (x < centerX && y < centerY) {
            return new int[]{-1, -1};
        } else {
            return new int[]{-1, 1};
        }
    }

    private float transform(float angle) {
        return (float) ((360 - angle) / 360 * Math.PI * 2);
    }

    private float[][] calculateAngle() {

        int count = mPercents.length;
        float[][] angles = new float[count][2];

        float startAngle = 0;
        float totalAngle = 360;

        for (int i = 0; i < count; i++) {
            angles[i][0] = startAngle;
            angles[i][1] = totalAngle * mPercents[i];
            startAngle += angles[i][1];
        }

        return angles;
    }
}
