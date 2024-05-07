package com.rinbows.soft.myemoticonjava.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;

import com.rinbows.soft.myemoticonjava.App;
import com.rinbows.soft.myemoticonjava.R;
import com.rinbows.soft.myemoticonjava.databinding.SettingFragmentBinding;

public class SettingFragment extends BaseFragment implements View.OnClickListener {
    private SettingFragmentBinding binding;

    @Override
    protected View getSubclassContentView() {
        binding = SettingFragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();
        initAppVersion();
        initButton();
    }

    private void initAppVersion() {
        binding.appVersionSetting.setText(getAppVersion());
    }

    private String getAppVersion() {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageInfo = App.appContext.getPackageManager()
                        .getPackageInfo(App.appContext.getPackageName(), PackageManager.PackageInfoFlags.of(0));
            } else {
                packageInfo = App.appContext.getPackageManager()
                        .getPackageInfo(App.appContext.getPackageName(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
        return "Version:" + packageInfo.versionName;
    }

    private void initButton() {
        binding.layoutRatingSetting.setOnClickListener(this);
        binding.layoutShareSetting.setOnClickListener(this);
        binding.layoutWhatsappSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.layoutShareSetting) {
            startSharePage();
        } else if (v == binding.layoutRatingSetting) {
            startRatingPage();
        } else if (v == binding.layoutWhatsappSetting) {
            startDownloadPage();
        }
    }

    private void startDownloadPage() {
        String url = getString(R.string.whatsApp_link);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void startRatingPage() {
        String url = getString(R.string.link) + App.appContext.getPackageName();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void startSharePage() {
        String url = getString(R.string.link) + App.appContext.getPackageName();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(intent);
    }
}
