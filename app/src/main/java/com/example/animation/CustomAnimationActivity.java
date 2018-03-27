package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.animation.animation.ParabolaAnimation;
import com.example.animation.animation.RotateXAnimation;
import com.example.animation.animation.RotateYAnimation;

public class CustomAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private ImageView ball;
    private Button button;
    private Button rotateY;
    private Button rotateX;
    private Button parabola;
    private RotateYAnimation rotateYAnimation;
    private RotateXAnimation rotateXAnimation;
    private ParabolaAnimation parabolaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation);
        image = (ImageView) findViewById(R.id.image);
        ball = (ImageView) findViewById(R.id.ball);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        rotateY = (Button) findViewById(R.id.rotateY);
        rotateY.setOnClickListener(this);
        rotateX = (Button) findViewById(R.id.rotateX);
        rotateX.setOnClickListener(this);
        parabola = (Button) findViewById(R.id.parabola);
        parabola.setOnClickListener(this);

        rotateYAnimation = new RotateYAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateYAnimation.setDuration(2000);

        rotateXAnimation = new RotateXAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateXAnimation.setDuration(2000);

        parabolaAnimation = new ParabolaAnimation(0.5f, 0.8f, Animation.RELATIVE_TO_PARENT);
        parabolaAnimation.setDuration(2000);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Toast.makeText(getApplicationContext(), "点击我", Toast.LENGTH_SHORT).show();
        } else if (v == rotateY) {
            image.startAnimation(rotateYAnimation);
            button.startAnimation(rotateYAnimation);
        } else if (v == rotateX) {
            image.startAnimation(rotateXAnimation);
            button.startAnimation(rotateXAnimation);
        } else if (v == parabola) {
            ball.startAnimation(parabolaAnimation);
        }
    }
}
