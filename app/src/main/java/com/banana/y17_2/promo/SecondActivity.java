package com.banana.y17_2.promo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

/*
        final Transition fade;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fade = new Fade();
            fade.excludeTarget(android.R.id.statusBarBackground, false);
            fade.excludeTarget(android.R.id.navigationBarBackground, false);
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
        }
        */
    }
}
