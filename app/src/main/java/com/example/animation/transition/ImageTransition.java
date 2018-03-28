package com.example.animation.transition;

import android.animation.Animator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/3/27.
 */

public class ImageTransition extends Transition {
    @Override
    public void captureStartValues(TransitionValues transitionValues) {

    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {

    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
