package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;

public class FadeTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.exit_fade_transition));
        getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.enter_fade_transition));
        setContentView(R.layout.activity_fade_transition);
    }
}
