package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonInfoAdapter extends ArrayAdapter<PersonInfo> {
    private int resourceId;
    public PersonInfoAdapter(Context context, int textViewResourceId, List<PersonInfo> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PersonInfo personInfo = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView infoImage = (ImageView) view.findViewById(R.id.item_image);
        TextView infoName = (TextView) view.findViewById(R.id.name);

        infoImage.setImageResource(personInfo.getImageId());
        infoName.setText(personInfo.getName());
        if(!personInfo.getDetail().equals("")) {
            TextView detail = (TextView) view.findViewById(R.id.detail);
            detail.setText(personInfo.getDetail());
        }
        if(personInfo.getName().equals("")){
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height=0;
//        params.width =100;
            view.setLayoutParams(params);
        }

        return view;
    }
}
