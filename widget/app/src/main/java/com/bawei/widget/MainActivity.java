package com.bawei.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    SwipeImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView = findViewById(R.id.iv);
        Glide.with(this).load(R.drawable.boss).into(myImageView);
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


    }
}
