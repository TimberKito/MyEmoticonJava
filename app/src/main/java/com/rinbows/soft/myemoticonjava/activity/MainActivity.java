package com.rinbows.soft.myemoticonjava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rinbows.soft.myemoticonjava.R;
import com.rinbows.soft.myemoticonjava.databinding.MainActivityBinding;

public class MainActivity extends BaseActivity {
    private MainActivityBinding binding;
    private final long LOADING_TIME = 2000;

    @Override
    View getSubclassContentView() {
        binding = MainActivityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();
        new CountDownTimer(LOADING_TIME, LOADING_TIME) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                jumpActivity();
                finish();
            }
        }.start();
    }

    private void jumpActivity() {
        Intent intent = new Intent(this, AppActivity.class);
        startActivity(intent);
    }
}