package com.banana.y17_2.promo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(final int i) {


        switch (i){
            case 0:
                return new Fragment2();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment2();
            case 3:
                return new Fragment2();
            case 4:
                return new Fragment2();
            case 5:
                return new Fragment2();
            default:
                //Toast.makeText(context, "Oops, Something went wrong", Toast.LENGTH_SHORT).show();
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
