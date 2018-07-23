package com.example.animation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class AlbumActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mPictures;
    private RecyclerView mAlbums;
    private FrameLayout mAlbumLayout;
    private LinearLayout mAlbumTitle;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        mInflater = LayoutInflater.from(this);
        mPictures = (RecyclerView) findViewById(R.id.recycle_view);
        mAlbums = (RecyclerView) findViewById(R.id.album_recycler_view);
        mAlbumLayout = (FrameLayout) findViewById(R.id.album_layout);
        mAlbumTitle = (LinearLayout) mInflater.inflate(R.layout.custom_album_title, null);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(mAlbumTitle, new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        mAlbumTitle.setOnClickListener(this);

        queryAlbums();
    }

    private void queryAlbums() {

    }

    @Override
    public void onClick(View v) {
        if (v == mAlbumTitle) {
            TranslateAnimation animation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.show_album);
            mAlbumLayout.setVisibility(View.VISIBLE);
            mAlbumLayout.startAnimation(animation);
        }
    }
}
