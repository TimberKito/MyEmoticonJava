package com.rinbows.soft.myemoticonjava.activity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.rinbows.soft.myemoticonjava.adapter.AppMainAdapter;
import com.rinbows.soft.myemoticonjava.databinding.AppActivityBinding;
import com.rinbows.soft.myemoticonjava.fragment.HomeFragment;
import com.rinbows.soft.myemoticonjava.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class AppActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private AppActivityBinding binding;
    private List<Fragment> vpFragments = new ArrayList<>();

    @Override
    View getSubclassContentView() {
        binding = AppActivityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();
        initButton();
        initViewPager();
    }

    private void initViewPager() {
        vpFragments.add(new HomeFragment());
        vpFragments.add(new SettingFragment());
        ViewPager viewPager = binding.appViewpager;
        viewPager.setAdapter(new AppMainAdapter(vpFragments, getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(0);
        setPagerSelect(0);
    }

    private void setPagerSelect(int i) {
        switch (i) {
            case 0:
                binding.appHomeTab.setSelected(true);
                binding.appSettingTab.setSelected(false);
                binding.appViewpager.setCurrentItem(0);
                break;
            case 1:
                binding.appHomeTab.setSelected(false);
                binding.appSettingTab.setSelected(true);
                binding.appViewpager.setCurrentItem(1);
                break;
        }
    }

    private void initButton() {
        binding.appHomeTab.setOnClickListener(this);
        binding.appSettingTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.appHomeTab) {
            setPagerSelect(0);
        } else if (v == binding.appSettingTab) {
            setPagerSelect(1);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setPagerSelect(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
