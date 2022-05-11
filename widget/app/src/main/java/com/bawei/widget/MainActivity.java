package com.bawei.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.widget2.SwipeImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    SwipeImageView myImageView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView = findViewById(R.id.iv);
        imageView = findViewById(R.id.iv2);
        imageView.setImageResource(R.drawable.boss);
        Glide.with(this).load(R.drawable.boss).into(myImageView);
       // myImageView.setImageResource(R.drawable.boss);
        myImageView.setOnSwipeLister(new SwipeImageView.SwipeLister() {
            @Override
            public void onLeft() {
                Toast.makeText(MainActivity.this, "111", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRight() {
                Toast.makeText(MainActivity.this, "222", Toast.LENGTH_SHORT).show();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix = new Matrix();
                matrix.postTranslate(100, 100);
//切记修改控件缩放模式为 MATRIX
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                imageView.setImageMatrix(matrix);
            }
        });

    }
}
