package com.example.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    private static final String TAG = "ImageActivity";
    public static final String ARG_IMAGE_BOUNDS = "arg_image_bounds";
    private ImageView imageView;
    private Rect start;
    private Rect end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        start = getIntent().getParcelableExtra(ARG_IMAGE_BOUNDS);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                Rect target = new Rect();
                target.left = imageView.getLeft();
                target.top = imageView.getTop();
                target.bottom = target.top + height;
                target.right = target.left + width;
                startAnimation(imageView, start, target);
                end = target;
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    private void startAnimation(View target, Rect start, Rect end) {
        float ratioWidth = start.width() * 1.0f / end.width();
        float ratioHeight = start.height() * 1.0f / end.height();
        float ratio = Math.max(ratioHeight, ratioWidth);

        target.setPivotX(1.0f * start.centerX() / end.width());
        target.setPivotY(1.0f * start.centerY() / end.height());
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, ratio, 1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, ratio, 1.0f);
        PropertyValuesHolder translateX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, start.left, end.left);
        PropertyValuesHolder translateY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, start.top, end.top);
        ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(target, scaleX, scaleY);
        ObjectAnimator translateAnimator = ObjectAnimator.ofPropertyValuesHolder(target, translateX, translateY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleAnimator).with(translateAnimator);
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    @Override
    public void finish() {
        playExitAnimator();
    }

    private void playExitAnimator() {
        float ratioWidth = start.width() * 1.0f / end.width();
        float ratioHeight = start.height() * 1.0f / end.height();
        float ratio = Math.max(ratioHeight, ratioWidth);

        imageView.setPivotX(1.0f * start.centerX() / end.width());
        imageView.setPivotY(1.0f * start.centerY() / end.height());

        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X,  1.0f, ratio);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f, ratio);
        PropertyValuesHolder translateX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, end.left, start.left);
        PropertyValuesHolder translateY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, end.top, start.top);
        ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, scaleX, scaleY);
        ObjectAnimator translateAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, translateX, translateY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleAnimator).with(translateAnimator);
        animatorSet.setDuration(300);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ImageActivity.super.finish();
                ImageActivity.super.overridePendingTransition(0, 0);
            }
        });
    }
}
