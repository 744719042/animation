package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout mContainer;
    private Button changeBounds;
    private Button changeSize;
    private Button fade;
    private Button slide;
    private Button explode;
    private boolean isScene2 = false;
    private boolean isGone = false;

    private Scene scene1;
    private Scene scene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        mContainer = (FrameLayout) findViewById(R.id.container);
        changeBounds = (Button) findViewById(R.id.changeBound);
        changeBounds.setOnClickListener(this);
        changeSize = (Button) findViewById(R.id.changeSize);
        changeSize.setOnClickListener(this);
        fade = (Button) findViewById(R.id.fade);
        fade.setOnClickListener(this);
        slide = (Button) findViewById(R.id.slide);
        slide.setOnClickListener(this);
        explode = (Button) findViewById(R.id.explode);
        explode.setOnClickListener(this);
        scene1 = Scene.getSceneForLayout(mContainer, R.layout.scene_layout_one, this);
        scene2 = Scene.getSceneForLayout(mContainer, R.layout.scene_layout_two, this);
    }

    @Override
    public void onClick(View v) {
        if (v == changeBounds) {
            ChangeBounds changeBounds = new ChangeBounds();
            if (isScene2) {
                TransitionManager.go(scene1, changeBounds);
            } else {
                TransitionManager.go(scene2, changeBounds);
            }

            isScene2 = !isScene2;
        } else if (v == changeSize) {
            View view1 = findViewById(R.id.first);
            View view2 = findViewById(R.id.second);
            View view3 = findViewById(R.id.third);
            View view4 = findViewById(R.id.forth);

            TransitionManager.beginDelayedTransition(mContainer);
            view1.getLayoutParams().width *= 2;
            view1.getLayoutParams().height *= 2;
            view1.requestLayout();

            view2.getLayoutParams().width /= 2;
            view2.getLayoutParams().height /= 2;
            view2.requestLayout();

            view3.setX(view3.getX() + 100);
            view4.setX(view4.getX() - 100);
        } else if (v == fade) {
            TransitionManager.beginDelayedTransition(mContainer, new Fade());
            processViews();
        } else if (v == slide) {
            TransitionManager.beginDelayedTransition(mContainer, new Slide());
            processViews();
        } else if (v == explode) {
            TransitionManager.beginDelayedTransition(mContainer, new Explode());
            processViews();
        }
    }

    private void processViews() {
        View view1 = findViewById(R.id.first);
        View view2 = findViewById(R.id.second);
        View view3 = findViewById(R.id.third);
        View view4 = findViewById(R.id.forth);
        if (!isGone) {
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
            view4.setVisibility(View.GONE);
        } else {
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
            view3.setVisibility(View.VISIBLE);
            view4.setVisibility(View.VISIBLE);
        }
        isGone = !isGone;
    }
}
