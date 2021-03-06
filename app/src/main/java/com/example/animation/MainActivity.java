package com.example.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button animation;
    private Button customAnimation;
    private Button animator;
    private Button multiProperty;
    private Button transition;
    private Button manual;
    private Button vector;
    private Button font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = (Button) findViewById(R.id.animation);
        animation.setOnClickListener(this);
        customAnimation = (Button) findViewById(R.id.customAnimation);
        customAnimation.setOnClickListener(this);
        animator = (Button) findViewById(R.id.animator);
        animator.setOnClickListener(this);
        multiProperty = (Button) findViewById(R.id.multiProperty);
        multiProperty.setOnClickListener(this);
        transition = (Button) findViewById(R.id.transitionAnimator);
        transition.setOnClickListener(this);
        manual = (Button) findViewById(R.id.manual);
        manual.setOnClickListener(this);
        vector = (Button) findViewById(R.id.vector);
        vector.setOnClickListener(this);
        font = (Button) findViewById(R.id.font);
        font.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == animation) {
            Intent intent = new Intent(this, AnimationActivity.class);
            startActivity(intent);
        } else if (v == customAnimation) {
            Intent intent = new Intent(this, CustomAnimationActivity.class);
            startActivity(intent);
        } else if (v == animator) {
            Intent intent = new Intent(this, AnimatorActivity.class);
            startActivity(intent);
        } else if (v == multiProperty) {
            Intent intent = new Intent(this, MultiPropertyActivity.class);
            startActivity(intent);
        } else if (v == transition) {
            Intent intent = new Intent(this, TransitionActivity.class);
            startActivity(intent);
        } else if (v == manual) {
            Intent intent = new Intent(this, AlbumActivity.class);
            startActivity(intent);
        } else if (v == vector) {
            Intent intent = new Intent(this, VectorActivity.class);
            startActivity(intent);
        } else if (v == font) {
            Intent intent = new Intent(this, FontActivity.class);
            startActivity(intent);
        }
    }
}
