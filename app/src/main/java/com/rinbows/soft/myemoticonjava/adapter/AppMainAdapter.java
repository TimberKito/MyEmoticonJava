package com.rinbows.soft.myemoticonjava.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class AppMainAdapter extends FragmentPagerAdapter {
    private final List<Fragment> viewPagerData;
    private final FragmentManager fragmentManager;

    public AppMainAdapter(List<Fragment> viewPagerData, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.viewPagerData = viewPagerData;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return viewPagerData.get(position);
    }

    @Override
    public int getCount() {
        return viewPagerData.size();
    }
}
