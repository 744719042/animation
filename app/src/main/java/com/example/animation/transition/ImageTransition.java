package com.example.animation.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/3/27.
 */

public class ImageTransition extends Transition {
    private static final String PROPNAME_POSITION_X = "image:position:x";
    private static final String PROPNAME_POSITION_Y = "image:position:y";
    private static final String PROPNAME_RADIUS = "image:radius";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_POSITION_X, transitionValues.view.getLeft());
        transitionValues.values.put(PROPNAME_POSITION_Y, transitionValues.view.getTop());
        transitionValues.values.put(PROPNAME_RADIUS, 200f);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_POSITION_X, transitionValues.view.getLeft());
        transitionValues.values.put(PROPNAME_POSITION_Y, transitionValues.view.getTop());
        transitionValues.values.put(PROPNAME_RADIUS, 0f);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, final TransitionValues endValues) {
        int startLeft = (int) startValues.values.get(PROPNAME_POSITION_X);
        int startTop = (int) startValues.values.get(PROPNAME_POSITION_Y);
        int endLeft = (int) endValues.values.get(PROPNAME_POSITION_X);
        int endTop = (int) endValues.values.get(PROPNAME_POSITION_Y);
        float startRadius = (float) startValues.values.get(PROPNAME_RADIUS);
        float endRadius = (float) endValues.values.get(PROPNAME_RADIUS);

        float radius = startRadius;
        if (startLeft > endLeft) {
            startRadius = endRadius;
            endRadius = radius;
        }

        PropertyValuesHolder propertyValuesHolderX = PropertyValuesHolder.ofFloat("x", startLeft, endLeft);
        PropertyValuesHolder propertyValuesHolderY = PropertyValuesHolder.ofFloat("y", startTop, endTop);
        ObjectAnimator positionAnimator = ObjectAnimator.ofPropertyValuesHolder(endValues.view, propertyValuesHolderX, propertyValuesHolderY);
        ValueAnimator shapeAnimator = ValueAnimator.ofFloat(startRadius, endRadius);
        shapeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                GradientDrawable gradientDrawable = (GradientDrawable) endValues.view.getBackground();
                gradientDrawable.setCornerRadius((Float) animation.getAnimatedValue());
                endValues.view.setBackground(gradientDrawable);
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(600);
        animatorSet.play(positionAnimator).with(shapeAnimator);
        return animatorSet;
    }
}
