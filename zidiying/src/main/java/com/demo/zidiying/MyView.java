package com.demo.zidiying;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuexingwu on 2016/11/9.
 */

/**
 * 1.创建
 * 2.加入绘制元素，通过view提供的ondraw方法
 */

public class MyView extends View {
    private Bitmap bitmap;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }

    public MyView(Context context){
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(0xffff0000);
        canvas.drawText("this is onDraw",0,30,paint);
        canvas.drawLine(0,60,200,60,paint);
//        canvas.drawRect(0,90,200,80,paint);

        Rect rect =new Rect(0,90,200,80);
//        canvas.drawRect(rect,paint);
//
        RectF rectF = new RectF(0,90,200,80);
//        canvas.drawRect(rectF,paint);

        //绘制圆形矩形
        canvas.drawRoundRect(rectF,10,10,paint);

        paint.setStyle(Paint.Style.STROKE);
        //绘制圆形
        canvas.drawCircle(100,250,100,paint);

        canvas.drawBitmap(bitmap,0,400,paint);




    }
}

