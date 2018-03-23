package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image;
    private Button button;
    private Button alpha;
    private Button translate;
    private Button scale;
    private Button rotate;
    private AlphaAnimation alphaAnimation;
    private RotateAnimation rotateAnimation;
    private TranslateAnimation translateAnimation;
    private ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        image = (ImageView) findViewById(R.id.image);
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

        alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.alpha);
        rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate);
        translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translate);
        scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.scale);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Toast.makeText(getApplicationContext(), "点击我", Toast.LENGTH_SHORT).show();
        } else if (v == alpha) {
            image.startAnimation(alphaAnimation);
            button.startAnimation(alphaAnimation);
        } else if (v == translate) {
            image.startAnimation(translateAnimation);
            button.startAnimation(translateAnimation);
        } else if (v == scale) {
            image.startAnimation(scaleAnimation);
            button.startAnimation(scaleAnimation);
        } else if (v == rotate) {
            image.startAnimation(rotateAnimation);
            button.startAnimation(rotateAnimation);
        }
    }
}
