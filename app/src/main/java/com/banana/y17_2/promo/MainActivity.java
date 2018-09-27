package com.banana.y17_2.promo;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    TextView My_Account_Button;
    ImageView Filters_Button;
    Button Discover_More_Button;
    Timer swipeTimer;

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.View_Pager);
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        final CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        My_Account_Button = findViewById(R.id.My_Account_Button);
        Filters_Button = findViewById(R.id.Filters_Button);
        Discover_More_Button = findViewById(R.id.Discover_More_Button);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        swipeImage();

        findViewById(R.id.Root_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeTimer.cancel();
            }
        });

       /*
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout, new Fragment2(), null).commit();
        }
        */


    }

    public void swipeImage() {
        if (swipeTimer != null) {
            swipeTimer.cancel();
        }
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                int i = viewPager.getCurrentItem() + 1;
                if (i > 4) {
                    i = 0;
                }
                viewPager.setCurrentItem(i, true);
                Log.e("ViewNumber", String.valueOf(viewPager.getCurrentItem()));
            }
        };
        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]

                view.setRotation(360 * position);




            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}



//[-1;1]

//Modify the default slide transition to shrink the page as well
                /* float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                */