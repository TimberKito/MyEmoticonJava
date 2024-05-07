package com.rinbows.soft.myemoticonjava.fragment;

import static com.rinbows.soft.myemoticonjava.tools.DataTools.parseJsonFile;

import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rinbows.soft.myemoticonjava.App;
import com.rinbows.soft.myemoticonjava.data.Identifier;
import com.rinbows.soft.myemoticonjava.databinding.HomeFragmentBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private HomeFragmentBinding binding;
    private List<Identifier> identifierList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected View getSubclassContentView() {
        binding = HomeFragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();
        initTabLayout();
        initHomeViewPager();
    }

    private void initHomeViewPager() {
        binding.viewpagerHome.setOffscreenPageLimit(4);
        binding.viewpagerHome.setAdapter(new FragmentPagerAdapter(requireActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return identifierList.get(position).getIdentifierName();
            }
        });
        binding.tabLayoutHome.setupWithViewPager(binding.viewpagerHome);
    }

    private void initTabLayout() {
        try {
            identifierList.addAll(getIdentifierList());
        } catch (IOException e) {
            Toast.makeText(App.appContext, "Loading files failed!", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < identifierList.size(); i++) {
            binding.tabLayoutHome.addTab(binding.tabLayoutHome.newTab().setText(identifierList.get(i).getIdentifierName()));
            fragmentList.add(new HomeVPFragment(identifierList.get(i)));
        }
    }

    public static List<Identifier> getIdentifierList() throws IOException {
        return parseJsonFile(App.appContext.getAssets().open("data.json"));
    }
}
