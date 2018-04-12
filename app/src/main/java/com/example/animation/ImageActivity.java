package com.example.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    private static final String TAG = "ImageActivity";
    public static final String ARG_IMAGE_BOUNDS = "arg_image_bounds";
    private ImageView imageView;
    private Rect startBounds;
    private Rect endBounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        startBounds = getIntent().getParcelableExtra(ARG_IMAGE_BOUNDS);
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
                startAnimation(imageView, startBounds, target);
                endBounds = target;
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    private void startAnimation(View target, Rect start, Rect end) {
        ViewWrapper view = new ViewWrapper(target);
        PropertyValuesHolder width = PropertyValuesHolder.ofInt("width", start.width(), end.width());
        PropertyValuesHolder height = PropertyValuesHolder.ofInt("height", start.height(), end.height());
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, width, height);
        animator.setDuration(300);
        animator.start();
    }

    private static class ViewWrapper {
        private View view;

        public ViewWrapper(View view) {
            this.view = view;
        }

        public void setWidth(int width) {
            Log.d(TAG, "width = " + width);
            view.getLayoutParams().width = width;
            view.requestLayout();
        }

        public int getWidth() {
            return view.getWidth();
        }

        public void setHeight(int height) {
            Log.d(TAG, "height = " + height);

            view.getLayoutParams().height = height;
            view.requestLayout();
        }

        public int getHeight() {
            return view.getHeight();
        }
    }

    @Override
    public void finish() {
        playExitAnimator();
    }

    private void playExitAnimator() {
        ViewWrapper view = new ViewWrapper(imageView);
        PropertyValuesHolder width = PropertyValuesHolder.ofInt("width", endBounds.width(), startBounds.width());
        PropertyValuesHolder height = PropertyValuesHolder.ofInt("height", endBounds.height(), startBounds.height());
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, width, height);
        animator.setDuration(300);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ImageActivity.super.finish();
                ImageActivity.super.overridePendingTransition(0, 0);
            }
        });
        animator.start();
    }
}
