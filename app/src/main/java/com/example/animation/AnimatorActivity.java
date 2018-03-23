package com.example.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image;
    private TextView textView;
    private Button button;
    private Button alpha;
    private Button translate;
    private Button scale;
    private Button rotate;
    private Button rotateY;
    private Button rotateX;
    private Button width;
    private Button value;

    private Animator alphaAnimation;
    private Animator rotateAnimation;
    private Animator translateAnimation;
    private Animator scaleAnimation;
    private Animator rotateXAnimation;
    private Animator rotateYAnimation;
    private ValueAnimator valueAnimation;
    private Animator widthAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        image = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.amount);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        alpha = (Button) findViewById(R.id.alpha);
        alpha.setOnClickListener(this);
        translate = (Button) findViewById(R.id.translate);
        translate.setOnClickListener(this);
        scale = (Button) findViewById(R.id.scale);
        scale.setOnClickListener(this);
        rotate = (Button) findViewById(R.id.rotate);
        rotate.setOnClickListener(this);
        rotateX = (Button) findViewById(R.id.rotateX);
        rotateX.setOnClickListener(this);
        rotateY = (Button) findViewById(R.id.rotateY);
        rotateY.setOnClickListener(this);
        value = (Button) findViewById(R.id.value);
        value.setOnClickListener(this);
        width = (Button) findViewById(R.id.width);
        width.setOnClickListener(this);

        alphaAnimation = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        rotateAnimation = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        rotateXAnimation = AnimatorInflater.loadAnimator(this, R.animator.rotate_x);
        rotateYAnimation = AnimatorInflater.loadAnimator(this, R.animator.rotate_y);
        translateAnimation = AnimatorInflater.loadAnimator(this, R.animator.translate);
        scaleAnimation = AnimatorInflater.loadAnimator(this, R.animator.scale);
        valueAnimation = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value);
        widthAnimation = AnimatorInflater.loadAnimator(this, R.animator.width);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Toast.makeText(getApplicationContext(), "点击我", Toast.LENGTH_SHORT).show();
        } else if (v == alpha) {
            alphaAnimation.setTarget(image);
            alphaAnimation.start();
        } else if (v == translate) {
            translateAnimation.setTarget(button);
            translateAnimation.start();
        } else if (v == scale) {
            scaleAnimation.setTarget(image);
            scaleAnimation.start();
        } else if (v == rotate) {
            rotateAnimation.setTarget(image);
            rotateAnimation.start();
        } else if (v == rotateX) {
            rotateXAnimation.setTarget(image);
            rotateXAnimation.start();
        } else if (v == rotateY) {
            rotateYAnimation.setTarget(image);
            rotateYAnimation.start();
        } else if (v == value) {
            valueAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    textView.setText(String.valueOf(animation.getAnimatedValue()));
                }
            });
            valueAnimation.start();
        } else if (v == width) {
            widthAnimation.setTarget(new ViewWrapper(button));
            widthAnimation.start();
        }
    }

    private static class ViewWrapper {
        private View view;
        public ViewWrapper(View view) {
            this.view = view;
        }

        public void setWidth(int width) {
            view.getLayoutParams().width = width;
            view.requestLayout();
        }

        public int getWidth() {
            return view.getLayoutParams().width;
        }
    }
}
