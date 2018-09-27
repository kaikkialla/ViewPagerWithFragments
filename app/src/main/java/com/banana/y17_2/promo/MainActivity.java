package com.banana.y17_2.promo;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    TextView My_Account_Button;
    ImageView Filters_Button;
    Button Discover_More_Buton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.View_Pager);
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        final CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        My_Account_Button = findViewById(R.id.My_Account_Button);
        Filters_Button = findViewById(R.id.Filters_Button);
        Discover_More_Buton = findViewById(R.id.Discover_More_Button);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (viewPager.getCurrentItem() == 6) {
                    viewPager.setCurrentItem(0);
                }
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


       /*
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout, new Fragment2(), null).commit();
        }
        */
    }
}
