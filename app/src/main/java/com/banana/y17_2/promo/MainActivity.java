package com.banana.y17_2.promo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        final Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Discover_More_Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Image Slider", Toast.LENGTH_SHORT).show();
            }
        });


       /*
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Frame_Layout, new Fragment2(), null).commit();
        }
        */
    }
}
