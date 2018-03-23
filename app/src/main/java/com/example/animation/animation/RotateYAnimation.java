package com.example.animation.animation;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2018/3/22.
 */

public class RotateYAnimation extends Animation {

    private Camera mCamera;
    private float mFromDegrees;
    private float mToDegrees;
    private int mPivotXType;
    private int mPivotYType;
    private float mPivotXValue;
    private float mPivotYValue;

    private float mPivotX;
    private float mPivotY;

    public RotateYAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
                           int pivotYType, float pivotYValue) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;

        mPivotXValue = pivotXValue;
        mPivotXType = pivotXType;
        mPivotYValue = pivotYValue;
        mPivotYType = pivotYType;

        mCamera = new Camera();
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        switch (mPivotXType) {
            case Animation.ABSOLUTE:
                mPivotX = mPivotXValue;
                break;
            case Animation.RELATIVE_TO_PARENT:
                mPivotX = mPivotXValue * parentWidth;
                break;
            case Animation.RELATIVE_TO_SELF:
                mPivotX = mPivotXValue * width;
                break;
        }

        switch (mPivotYType) {
            case Animation.ABSOLUTE:
                mPivotY = mPivotYValue;
                break;
            case Animation.RELATIVE_TO_PARENT:
                mPivotY = mPivotYValue * parentHeight;
                break;
            case Animation.RELATIVE_TO_SELF:
                mPivotY = mPivotYValue * height;
                break;
        }
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        float scale = getScaleFactor();

        mCamera.save();
        if (mPivotX == 0.0f && mPivotY == 0.0f) {
            mCamera.rotateY(degrees);
            mCamera.getMatrix(t.getMatrix());
        } else {
            mCamera.translate(mPivotX * scale, mPivotY * scale, 0);
            mCamera.rotateY(degrees);
            mCamera.translate(-mPivotX * scale, -mPivotY * scale, 0);
            mCamera.getMatrix(t.getMatrix());
        }
        mCamera.restore();
    }
}
