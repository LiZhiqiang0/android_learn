package com.example.myapplication2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

public class MainActivity extends AppCompatActivity {

    private List<PersonInfo> personInfoList = new ArrayList<>();
    private String[] name = {"1", "2", "3", "4", "5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置状态栏和导航栏颜色为透明
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);

            //设置导航栏颜色为透明
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            //设置通知栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
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