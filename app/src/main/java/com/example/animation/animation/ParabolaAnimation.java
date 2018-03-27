package com.example.animation.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2018/3/27.
 */

public class ParabolaAnimation extends Animation {
    private static final String TAG = "ParabolaAnimation";
    private float mToPosX;
    private float mToPosY;
    private float mToPosXValue;
    private float mToPosYValue;
    private int mPosType;

    private float mParamA;

    public ParabolaAnimation(float toPosX, float toPosY, int posType) {
        mToPosXValue = toPosX;
        mToPosYValue = toPosY;

        mPosType = posType;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        if (mPosType == Animation.RELATIVE_TO_PARENT) {
            mToPosX = mToPosXValue * parentWidth;
            mToPosY = mToPosYValue * parentHeight;
        }

        mParamA = (mToPosY) / (mToPosX * mToPosX);
        Log.d(TAG, "initialize: mToPosX = " + mToPosX + ", mToPosY = " + mToPosY + ", mParamA = " + mParamA);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float posX = mToPosX * interpolatedTime;
        float posY = mParamA * posX * posX;
        Log.d(TAG, "posX = " + posX + ", posY = " + posY);
        t.getMatrix().setTranslate(posX, posY);
    }
}
