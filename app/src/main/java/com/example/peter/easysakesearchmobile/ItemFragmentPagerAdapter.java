package com.example.peter.easysakesearchmobile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by peter on 2017/08/31.
 */

public class ItemFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final String SAKE_BRAND = "銘柄";
    private static final String SAKE_MAKER = "酒造";
    private static final String[] ITEMS = {SAKE_BRAND, SAKE_MAKER};

    public ItemFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ITEMS[position];
    }
}
