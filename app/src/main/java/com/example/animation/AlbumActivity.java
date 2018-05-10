package com.example.animation;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AlbumActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, ImageActivity.class);
                int width = imageView.getWidth();
                int height = imageView.getHeight();

                Rect target = new Rect();
                target.left = imageView.getLeft();
                target.top = imageView.getTop();
                target.bottom = target.top + height;
                target.right = target.left + width;

                intent.putExtra(ImageActivity.ARG_IMAGE_BOUNDS, target);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, ImageActivity.class);
                int width = imageView2.getWidth();
                int height = imageView2.getHeight();

                Rect target = new Rect();
                target.left = imageView2.getLeft();
                target.top = imageView2.getTop();
                target.bottom = target.top + height;
                target.right = target.left + width;

                intent.putExtra(ImageActivity.ARG_IMAGE_BOUNDS, target);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        imageView3 = (ImageView) findViewById(R.id.image3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, ImageActivity.class);
                int width = imageView3.getWidth();
                int height = imageView3.getHeight();

                Rect target = new Rect();
                target.left = imageView3.getLeft();
                target.top = imageView3.getTop();
                target.bottom = target.top + height;
                target.right = target.left + width;

                intent.putExtra(ImageActivity.ARG_IMAGE_BOUNDS, target);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}
