package com.example.yang.my2ndapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris.black on 6/11/15.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private Map<Integer, Fragment> mPageReferenceMap = new HashMap<>();

    private static final String[] TITLES = new String[] {
            "进度",
            "步数",
            "速度",

    };

    public static final int NUM_TITLES = TITLES.length;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_TITLES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            PageFragment1 myFragment1 = PageFragment1.create(position + 1);
            mPageReferenceMap.put(position, myFragment1);
            return myFragment1;
        }else if(position == 1){
            PageFragment2 myFragment2 = PageFragment2.create(position + 1);
            mPageReferenceMap.put(position, myFragment2);
            return myFragment2;
        }else{
            PageFragment3 myFragment3 = PageFragment3.create(position + 1);
            mPageReferenceMap.put(position, myFragment3);
            return myFragment3;
        }

    }

    public void destroy() {
        mPageReferenceMap.clear();
    }

    public Fragment getFragment(int key) {
        //Log.d(TAG, "GET: " + key);
        return mPageReferenceMap.get(key);
    }
}
