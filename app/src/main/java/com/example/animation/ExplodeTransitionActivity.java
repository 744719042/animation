package com.example.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;

import com.example.animation.transition.ImageTransition;

public class ExplodeTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        findViewById(R.id.first).setTag(0f);
        getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.enter_explode_transition));
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.exit_explode_transition));
        getWindow().setSharedElementEnterTransition(new ImageTransition().addTarget(R.id.first));
    }
}
