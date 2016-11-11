package com.demo.zidiying;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by yuexingwu on 2016/11/9.
 */

/**
 * 1.怎么让元素动起来，需要什么
 * 2.让元素动起来的元素放在哪
 * 3.逻辑怎么影响绘制
 * 4.怎么让元素看起来流畅
 */

public class LogicView extends View {
    private Paint paint = new Paint();
    private float rx = 0;
    private MyThread myThread;
    private RectF rectF = new RectF(0,30,100,160);
    private float sweepAngle = 0;
    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void drawSub(Canvas canvas){
        paint.setTextSize(30);
        canvas.drawText("LogicView",rx,30,paint);
        canvas.drawArc(rectF,0,sweepAngle,true,paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        if (myThread ==null){
            myThread = new MyThread();
            myThread.start();
        }else {
            drawSub(canvas);
        }
    }
    class MyThread extends Thread{
        Random random = new Random();
        @Override
        public void run() {
            while (true) {
                rx = rx + 5;

                if (rx>getWidth()){
                    rx=0-paint.measureText("LogicView");
                }

                sweepAngle ++;
                if (sweepAngle==360){
                    sweepAngle=0;
                }

                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                paint.setARGB(255,r,g,b);


                postInvalidate();//在线程中更新绘制方法
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }
}
