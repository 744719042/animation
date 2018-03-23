package com.example.animation;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MultiPropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image;
    private Button button;
    private Button multi;
    private Button keyFrame;
    private Button changeColor;
    private Button changePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_property);

        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);
        multi = (Button) findViewById(R.id.multiProperty);
        multi.setOnClickListener(this);
        keyFrame = (Button) findViewById(R.id.keyFrame);
        keyFrame.setOnClickListener(this);
        changeColor = (Button) findViewById(R.id.changeColor);
        changeColor.setOnClickListener(this);
        changePosition = (Button) findViewById(R.id.changePosition);
        changePosition.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Toast.makeText(getApplicationContext(), "点击我", Toast.LENGTH_SHORT).show();
        } else if (v == multi) {
            PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat("translationX", 0, 200);
            PropertyValuesHolder translationY = PropertyValuesHolder.ofFloat("translationY", 0, 200);
            PropertyValuesHolder rotationX = PropertyValuesHolder.ofFloat("rotationX", 0, 360);
            PropertyValuesHolder rotationY = PropertyValuesHolder.ofFloat("rotationY", 0, 360);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(button, translationX, translationY, rotationX, rotationY);

            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.start();
        } else if (v == keyFrame) {
            Keyframe keyframe = Keyframe.ofFloat(0f, 0f);
            Keyframe keyframe1 = Keyframe.ofFloat(0.1f, -60f);
            Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 60f);
            Keyframe keyframe3 = Keyframe.ofFloat(0.3f, -60f);
            Keyframe keyframe4 = Keyframe.ofFloat(0.4f, 60f);
            Keyframe keyframe5 = Keyframe.ofFloat(0.5f, -60f);
            Keyframe keyframe6 = Keyframe.ofFloat(0.6f, 60f);
            Keyframe keyframe7 = Keyframe.ofFloat(0.7f, -60f);
            Keyframe keyframe8 = Keyframe.ofFloat(0.8f, 60f);
            Keyframe keyframe9 = Keyframe.ofFloat(0.9f, -60f);
            Keyframe keyframe10 = Keyframe.ofFloat(1.0f, 0f);

            PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotationX",
                    keyframe, keyframe1, keyframe2, keyframe3, keyframe4,
                    keyframe5, keyframe6, keyframe7, keyframe8, keyframe9, keyframe10);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(image, propertyValuesHolder);
            animator.setDuration(5000);
            animator.start();
        } else if (v == changeColor) {
            ObjectAnimator animator = ObjectAnimator.ofInt(button, "backgroundColor", Color.LTGRAY, Color.CYAN);
            animator.setEvaluator(new ArgbEvaluator());
            animator.start();
        } else if (v == changePosition) {
            ObjectAnimator animator = ObjectAnimator.ofObject(image, new PositionProperty(Position.class, "position"), new PositionEvaluator(),
                    new Position(100, 100), new Position(500, 200), new Position(300, 500));
            animator.setDuration(3000);
            animator.start();
        }
    }

    private static class PositionEvaluator implements TypeEvaluator<Position> {
        @Override
        public Position evaluate(float fraction, Position startValue, Position endValue) {
            float x = (endValue.x - startValue.x) * fraction + startValue.x;
            float y = (endValue.y - startValue.y) * fraction + startValue.y;
            return new Position(x, y);
        }
    }

    private static class PositionProperty extends Property<View, Position> {

        public PositionProperty(Class<Position> type, String name) {
            super(type, name);
        }

        @Override
        public Position get(View view) {
            return new Position(view.getX(), view.getY());
        }

        @Override
        public void set(View view, Position value) {
            view.setX(value.x);
            view.setY(value.y);
        }
    }

    private static class Position {
        public float x;
        public float y;

        public Position(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
