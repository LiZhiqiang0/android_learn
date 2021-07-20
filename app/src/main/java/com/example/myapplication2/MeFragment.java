package com.example.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment {
    private Context context;
    public MeFragment(){}

    public MeFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ListView listView =view.findViewById(R.id.list_aa);
//        PersonInfoAdapter adapter = new PersonInfoAdapter(getActivity().getBaseContext(), R.layout.personinfo_item, personInfoList);
//        listView.setAdapter(adapter);
        View view =inflater.inflate(R.layout.me_fragment,container,false);
        List<PersonInfo> personInfoList = new ArrayList<>();
        initPersonInfos(personInfoList);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.reycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        PersonInfoRecyclerViewAdapter adapter = new PersonInfoRecyclerViewAdapter(personInfoList);
        recyclerView.setAdapter(adapter);
        return view;

    }

    private void initPersonInfos(List<PersonInfo> personInfoList){
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
