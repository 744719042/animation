package com.example.animation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

public class FontView extends View {
    private static final String TAG = "FontView";
    private int colorTop = Color.RED;
    private int colorAsc = Color.BLUE;
    private int colorBaseLine = Color.GREEN;
    private int colorDesc = Color.MAGENTA;
    private int colorBottom = Color.BLACK;

    private Paint mPaint;
    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(dp2sp(30));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), dp2sp(100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        Log.d(TAG, "fontMetricsInt.leading = " + fontMetricsInt.leading);
        Log.d(TAG, "fontMetricsInt.top = " + fontMetricsInt.top);
        Log.d(TAG, "fontMetricsInt.ascent = " + fontMetricsInt.ascent);
        Log.d(TAG, "fontMetricsInt.descent = " + fontMetricsInt.descent);
        Log.d(TAG, "fontMetricsInt.bottom = " + fontMetricsInt.bottom);
        Log.d(TAG, "fontMetricsInt = " + fontMetricsInt);

        int baseX = 0, baseY = dp2sp(80);
        mPaint.setColor(colorBaseLine);
        canvas.drawLine(baseX, baseY, 1000, baseY, mPaint);
        mPaint.setColor(Color.CYAN);
        canvas.drawText("Good Morning to YOU", baseX, baseY, mPaint);
        mPaint.setColor(colorTop);
        canvas.drawLine(baseX,baseY + fontMetricsInt.top, 1000, baseY + fontMetricsInt.top, mPaint);
        mPaint.setColor(colorAsc);
        canvas.drawLine(baseX, baseY + fontMetricsInt.ascent, 1000, baseY + fontMetricsInt.ascent, mPaint);
        mPaint.setColor(colorDesc);
        canvas.drawLine(baseX, baseY + fontMetricsInt.descent, 1000, baseY + fontMetricsInt.descent, mPaint);
        mPaint.setColor(colorBottom);
        canvas.drawLine(baseX, baseY + fontMetricsInt.bottom, 1000, baseY + fontMetricsInt.bottom, mPaint);

        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
    }

    public int dp2sp(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
