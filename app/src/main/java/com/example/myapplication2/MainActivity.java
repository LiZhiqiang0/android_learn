package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

public class MainActivity extends AppCompatActivity {

    private List<PersonInfo> personInfoList = new ArrayList<>();
    private List<View> viewList;
    private List<String> titles = new ArrayList<>();
    private List<PageFragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //设置状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            设置通知栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        MeFragment meFragment = new MeFragment();
        fragmentTransaction.replace(R.id.frame_layout, homeFragment);
        fragmentTransaction.commit();
        ConstraintLayout layoutHome = (ConstraintLayout) findViewById(R.id.layout1);
        ConstraintLayout layoutMe = (ConstraintLayout) findViewById(R.id.layout3);
        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickHome(homeFragment);
            }
        });
        layoutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMe(meFragment);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }



//        initTabData();
//        initTabView();

//        initPersonInfos();
//        PersonInfoAdapter adapter = new PersonInfoAdapter(MainActivity.this, R.layout.personinfo_item, personInfoList);
//        ListView listView = (ListView) findViewById(R.id.list_aa);
//        listView.setAdapter(adapter);
//        initPersonInfos();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        PersonInfoRecyclerViewAdapter adapter = new PersonInfoRecyclerViewAdapter(personInfoList);
//        recyclerView.setAdapter(adapter);
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

    private void onClickMe(MeFragment meFragment){
        TextView textHome = (TextView) findViewById(R.id.text_home);
        textHome.setTextColor(getResources().getColor(R.color.gray));
        TextView textMe = (TextView) findViewById(R.id.text_me);
        textMe.setTextColor(getResources().getColor(R.color.light_black));

        ImageView imageHome = (ImageView) findViewById(R.id.image_home);
        imageHome.setImageResource(R.drawable.firstpage);
        ImageView imageMe = (ImageView) findViewById(R.id.image_me);
        imageMe.setImageResource(R.drawable.me2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, meFragment);
        fragmentTransaction.commit();
    }

    private void onClickHome(HomeFragment homeFragment){
        TextView textHome = (TextView) findViewById(R.id.text_home);
        textHome.setTextColor(getResources().getColor(R.color.light_black));
        TextView textMe = (TextView) findViewById(R.id.text_me);
        textMe.setTextColor(getResources().getColor(R.color.gray));
        ImageView imageHome = (ImageView) findViewById(R.id.image_home);
        imageHome.setImageResource(R.drawable.firstpage2);
        ImageView imageMe = (ImageView) findViewById(R.id.image_me);
        imageMe.setImageResource(R.drawable.learn);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, homeFragment);
        fragmentTransaction.commit();
    }




}