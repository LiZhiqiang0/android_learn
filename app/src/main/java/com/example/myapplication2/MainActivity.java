package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

public class MainActivity extends AppCompatActivity {

    private List<PersonInfo> personInfoList = new ArrayList<>();
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);
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
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }



//        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
//        LayoutInflater layoutInflater = getLayoutInflater();
//        View view1 = layoutInflater.inflate(R.layout.teacher1,null);
//        View view2 = layoutInflater.inflate(R.layout.teacher2, null);
//        viewList = new ArrayList<>();
//        viewList.add(view1);
//        viewList.add(view2);
//
//        OnlineSolutionAdapter onlineSolutionAdapter = new OnlineSolutionAdapter(viewList);
//        viewPager.setAdapter(onlineSolutionAdapter);



//        initPersonInfos();
//        PersonInfoAdapter adapter = new PersonInfoAdapter(MainActivity.this, R.layout.personinfo_item, personInfoList);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
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
}