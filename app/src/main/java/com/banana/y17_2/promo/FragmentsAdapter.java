package com.banana.y17_2.promo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentsAdapter extends FragmentStatePagerAdapter {

    public FragmentsAdapter(FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int i){
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new NikitaFragment();
            default:
        }
        return null;
    }

    public int getCount() {
        return 6;
    }
}
