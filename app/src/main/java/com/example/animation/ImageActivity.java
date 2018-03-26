package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);
        setContentView(R.layout.activity_image);
    }
}
