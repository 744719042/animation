package com.example.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;

public class Translate2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.enter_explode_transition));
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.exit_explode_transition));

    }
}
