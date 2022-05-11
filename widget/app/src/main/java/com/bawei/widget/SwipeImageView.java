package com.bawei.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;


public class SwipeImageView extends AppCompatImageView {
    private float ix,iy;
    private SwipeLister swipeLister;
    private Matrix matrix = new Matrix();
    public void setOnSwipeLister(SwipeLister swipeLister) {
        this.swipeLister = swipeLister;
    }

    public SwipeImageView(Context context) {
        super(context);

    }

    public SwipeImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private float sx,sy;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        if(action == MotionEvent.ACTION_DOWN){
            sx= x;
            sy = y;
        }else if(action == MotionEvent.ACTION_MOVE){
           ix= x-sx;
           if(ix <=-100){//左滑动
               swipeLister.onLeft();
           }else if(ix>=100){//右滑动
               swipeLister.onRight();
           }

        }else if(action == MotionEvent.ACTION_UP){
            ix = x-sx;
        }

        Matrix matrix = new Matrix();
        matrix.postTranslate(ix, iy);
//切记修改控件缩放模式为 MATRIX
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(matrix);


        return true;
    }


   public interface  SwipeLister{
        void onLeft();
        void onRight();
    }
}
