package com.rinbows.soft.myemoticonjava.fragment;

import android.view.View;

import com.rinbows.soft.myemoticonjava.data.Identifier;
import com.rinbows.soft.myemoticonjava.databinding.HomeFragmentViewpagerBinding;

public class HomeVPFragment extends BaseFragment {
    private HomeFragmentViewpagerBinding binding;
    private Identifier identifier;

    public HomeVPFragment(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    protected View getSubclassContentView() {
        binding = HomeFragmentViewpagerBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    void initView() {
        super.initView();

    }
}
