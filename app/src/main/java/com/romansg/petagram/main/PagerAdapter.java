package com.romansg.petagram.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Este adaptador provee fragmentos y titulos a un ViewPager
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private String[] tabTitles;

    public PagerAdapter(FragmentManager fm, Fragment[] fragments, String[] tabTitles) {
        super(fm);

        this.fragments = fragments;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
