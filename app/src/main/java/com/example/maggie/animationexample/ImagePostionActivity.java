package com.example.maggie.animationexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by MAGGIE on 2018/3/7.
 */
public class ImagePostionActivity extends Activity {

    private ImageView dragon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagepostion);

        dragon = (ImageView) findViewById(R.id.dragon);


//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // RelativeLayout. though you can use xml RelativeLayout here too by `findViewById()`
        RelativeLayout relativeLayout = new RelativeLayout(this);
// ImageView
//        ImageView imageView = new ImageView(this);

// Setting layout params to our RelativeLayout
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(175, 175);

// Setting position of our ImageView
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;

// Finally Adding the imageView to RelativeLayout and its position

        dragon.setLayoutParams(layoutParams);

    }
}
