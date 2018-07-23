package com.example.animation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

public class CustomTextView extends AppCompatTextView {
    private Paint mInnerPaint;
    private Paint mOuterPaint;
    private float mProgress;
    private int colorDefault = Color.BLACK;
    private int colorNew = Color.RED;

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextSize(20);
        mInnerPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setDither(true);
        mInnerPaint.setTextSize(dp2sp(20));
        mInnerPaint.setColor(colorDefault);
        mOuterPaint = new Paint();
        mOuterPaint.setAntiAlias(true);
        mOuterPaint.setDither(true);
        mOuterPaint.setTextSize(dp2sp(20));
        mOuterPaint.setColor(colorNew);
        mProgress = 0.5f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = mOuterPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        int baseLine = getHeight() / 2 + dy;
        canvas.save();
        canvas.clipRect(0, 0, mProgress * getWidth(), getHeight());
        canvas.drawText(getText().toString(), getPaddingLeft(), baseLine, mInnerPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(mProgress * getWidth(), 0, getWidth(), getHeight());
        canvas.drawText(getText().toString(), getPaddingLeft(), baseLine, mOuterPaint);
        canvas.restore();
    }

    public int dp2sp(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidate();
    }
}
