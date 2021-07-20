package com.example.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private Context context;

    public HomeFragment(){}
    private List<PersonInfo> personInfoList = new ArrayList<>();

    public HomeFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ViewPager viewPagerOnline = (ViewPager)view.findViewById(R.id.viewpager_Online);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = View.inflate(getContext(), R.layout.teacher1,null);
        View view2 = View.inflate(getContext(), R.layout.teacher2, null);
        List<View> viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        OnlineSolutionAdapter onlineSolutionAdapter = new OnlineSolutionAdapter(viewList);
        viewPagerOnline.setAdapter(onlineSolutionAdapter);
        List<String> titles = new ArrayList<>();
        List<PageFragment> fragments = new ArrayList<>();
        initTabData(titles, fragments);
        initTabView(view, titles, fragments);
        return view;
    }

    private void initPersonInfos(){
        PersonInfo pro = new PersonInfo("Pro Learner Missions", R.drawable.pro, "30% Achieved");
        personInfoList.add(pro);
        PersonInfo questions = new PersonInfo("Questions You Asked", R.drawable.group, "");
        personInfoList.add(questions);
        PersonInfo bookmarks = new PersonInfo("Bookmarks", R.drawable.bookmark, "");
        personInfoList.add(bookmarks);
        PersonInfo history = new PersonInfo("Recently Viewed", R.drawable.history, "");
        personInfoList.add(history);
        PersonInfo share = new PersonInfo("Share with Friends", R.drawable.share, "");
        personInfoList.add(share);
        PersonInfo settings = new PersonInfo("Settings", R.drawable.settings, "");
        personInfoList.add(settings);
        PersonInfo rect = new PersonInfo("", R.drawable.rectangle, "");
        personInfoList.add(rect);
        PersonInfo tutor = new PersonInfo("SnapSolve Tutor", R.drawable.tutor, "");
        personInfoList.add(tutor);
    }

    private void initTabData(List<String> titles, List<PageFragment> fragments){
        titles.add("Maths");
        titles.add("Physics");
        titles.add("Chemistry");
        titles.add("Biology");
        titles.add("Science");
        fragments.add(new PageFragment(getContext()));
        fragments.add(new PageFragment(getContext()));
        fragments.add(new PageFragment(getContext()));
        fragments.add(new PageFragment(getContext()));
        fragments.add(new PageFragment(getContext()));
    }

    private void initTabView(View view, List<String> titles, List<PageFragment> fragments){
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(new PageFragmentPagerAdapter(getActivity().getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }

}

