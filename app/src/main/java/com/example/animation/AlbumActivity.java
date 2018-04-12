package com.example.animation;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AlbumActivity extends AppCompatActivity {
    private ImageView imageView;

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
    }
}
