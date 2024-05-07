package com.rinbows.soft.myemoticonjava.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getSubclassContentView());
        initView();
    }

    void initView() {

    }

    abstract View getSubclassContentView();
}
