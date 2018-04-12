package com.example.animation;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.ImageView;

public class VectorActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);
        imageView = (ImageView) findViewById(R.id.image);
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) imageView.getDrawable();
        drawable.start();

        imageView2 = (ImageView) findViewById(R.id.image2);
        AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) imageView2.getDrawable();
        drawable2.start();

        imageView3 = (ImageView) findViewById(R.id.image3);
        AnimatedVectorDrawable drawable3 = (AnimatedVectorDrawable) imageView3.getDrawable();
        drawable3.start();

        imageView4 = (ImageView) findViewById(R.id.image4);
        AnimatedVectorDrawable drawable4 = (AnimatedVectorDrawable) imageView4.getDrawable();
        drawable4.start();

        imageView5 = (ImageView) findViewById(R.id.image5);
        AnimatedVectorDrawable drawable5 = (AnimatedVectorDrawable) imageView5.getDrawable();
        drawable5.start();
    }
}
