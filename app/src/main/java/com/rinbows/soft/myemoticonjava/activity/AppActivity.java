package com.rinbows.soft.myemoticonjava.activity;

import android.view.View;

import com.rinbows.soft.myemoticonjava.App;
import com.rinbows.soft.myemoticonjava.databinding.AppActivityBinding;

public class AppActivity extends BaseActivity {
    private AppActivityBinding binding;

    @Override
    View getSubclassContentView() {
        binding = AppActivityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();
    }
}
