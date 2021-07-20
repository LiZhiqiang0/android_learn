package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        //状态栏透明&改变字体颜色
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_home);
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