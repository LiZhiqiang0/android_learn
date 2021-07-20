package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PageFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<PageFragment> fragments;
    private List<String> titles;
    public PageFragmentPagerAdapter(FragmentManager fm, List<PageFragment> fragments, List<String> titles){
        super(fm);
        this.fragments=fragments;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
