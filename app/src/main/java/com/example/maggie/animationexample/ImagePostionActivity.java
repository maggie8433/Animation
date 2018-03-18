package com.example.maggie.animationexample;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by MAGGIE on 2018/3/7.
 */
public class ImagePostionActivity extends Activity implements View.OnClickListener {

    private ImageView dragon, image;
    private Button Right;
    private Button Left;
    private float movex;
    private float width;
    private RelativeLayout relativeLayout;
    private ImageView owl;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagepostion);


        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener((SensorEventListener) this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);


        DisplayMetrics metrics = new DisplayMetrics();
        ImagePostionActivity.this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int width= metrics.widthPixels;
        float viewW = 50, viewH = 50;
        float w = metrics.widthPixels, h = viewH / viewW * w;

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);



        dragon = (ImageView) findViewById(R.id.dragon);
        owl = (ImageView)findViewById(R.id.owl);

        ImageView owl = new ImageView(ImagePostionActivity.this);
        owl.setImageResource(R.drawable.owl);
        PixelUtil.setFrame(owl, 0, 0, 50, 50);
        owl.setScaleType(ImageView.ScaleType.FIT_XY);
        owl.setBackgroundColor(Color.TRANSPARENT);
        relativeLayout.addView(owl);

//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // RelativeLayout. though you can use xml RelativeLayout here too by `findViewById()`
        RelativeLayout relativeLayout = new RelativeLayout(this);
// ImageView
//        ImageView imageView = new ImageView(this);

// Setting layout params to our RelativeLayout
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(175, 175);

// Setting position of our ImageView
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;

// Finally Adding the imageView to RelativeLayout and its position

        dragon.setLayoutParams(layoutParams);


        float x = layoutParams.leftMargin;

        Right = (Button) findViewById(R.id.Right);
        Left = (Button) findViewById(R.id.Left);

        Right.setOnClickListener(this);
        Left.setOnClickListener(this);


//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        width = size.x;

        Log.e("width", String.valueOf(width));

        movex = 200;


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Right:


                dragon.setX(dragon.getX() + movex);
                owl.setX(owl.getX() + movex);
                Log.e("dragon", String.valueOf(dragon.getX()));
                Log.e("owl", String.valueOf(owl.getX()));

                break;


            case R.id.Left:

                if (dragon.getX() > 0 || owl.getX() > 0) {
                    dragon.setX(dragon.getX() - movex);
                    owl.setX(owl.getX() - movex);
                    Log.e("dragon", String.valueOf(dragon.getX()));
                    Log.e("owl", String.valueOf(owl.getX()));
                } else
                    dragon.setX(0f);
                    owl.setX(0f);

                break;

        }
    }

//    @Override
//    public void onSensorChanged(SensorEvent sensorEvent) {
//
//        Sensor mySensor = sensorEvent.sensor;
//        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//
//            float x = sensorEvent.values[0];
//            float y = sensorEvent.values[1];
//            long curTime = System.currentTimeMillis();
//            if ((curTime - lastUpdate) > 500) {
//                long diffTime = (curTime - lastUpdate);
//                lastUpdate = curTime;
//                if (Round(x, 4) > 3.0000) {
////                    Log.e("cathy", "Left shake detected " + Round(x, 4));
////                    clawX -= 150;
////                    if (clawX <= sx * 0 - sx * 0.05f) //空氣牆
////                        clawX = sx * 0 - sx * 0.05f;
////                    Log.e("cathy", "clawX: " + clawX);
//
////                    //爪子動畫
////                    ClawAnimation = claw.animate().x(clawX).y(clawY).setDuration(800);
////
////                    //爪子中心點動畫
////                    ClawAnimation = clawdot.animate().x(clawX+150).y(claw.getBottom()/2).setDuration(800);
////                    clawdot.setVisibility(View.VISIBLE);
//                } else if (Round(x, 4) < -3.0000) {
////                    Log.e("cathy", "Right shake detected " + Round(x, 4));
////                    clawX += 150;
////                    if (clawX >= sx - sx * 0.3f) //空氣牆
////                        clawX = sx - sx * 0.3f;
////                    Log.e("cathy", "clawX: " + clawX);
//
////                    //爪子動畫
////                    ClawAnimation = claw.animate().x(clawX).y(clawY).setDuration(800);
////
////                    //爪子中心點動畫
////                    ClawAnimation = clawdot.animate().x(clawX+150).y(claw.getBottom()/2).setDuration(800);
////                    clawdot.setVisibility(View.VISIBLE);
//
//                }
//
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//
//    protected void onPause() {
//    }
//
//    public static float Round(float Rval, int Rpl) {
//        float p = (float) Math.pow(10, Rpl);
//        Rval = Rval * p;
//        float tmp = Math.round(Rval);
//        return (float) tmp / p;
//    }

//    public void onDraw(Canvas canvas) {
//
//        Bitmap imgtable = BitmapFactory.decodeResource(getResources(), R.drawable.shape);
//
//        float centreX = (canvas.getWidth()  - imgtable.getWidth()) /2;
//
//        float centreY = (canvas.getHeight() - imgtable.getHeight()) /2;
//        canvas.drawColor(Color.TRANSPARENT);
//        canvas.drawBitmap(imgtable, centreX, centreY, null);
//
//    }
}
