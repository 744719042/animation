package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.animation.transition.ImageTransition;

public class SlideTransiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        findViewById(R.id.first).setTag(0f);
        getWindow().setSharedElementEnterTransition(new ImageTransition().addTarget(R.id.first));
    }
}
