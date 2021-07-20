package com.example.myapplication2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonInfoRecyclerViewAdapter extends RecyclerView.Adapter<PersonInfoRecyclerViewAdapter.ViewHolder>{

    private List<PersonInfo> personInfoList;
    private View view;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView infoImage;
        TextView textRight, textLeft;
        public ViewHolder(View view){
            super(view);
            infoImage = (ImageView) view.findViewById(R.id.item_image);
            textLeft = (TextView) view.findViewById(R.id.name);
            textRight = (TextView) view.findViewById(R.id.detail);
        }
    }

    public PersonInfoRecyclerViewAdapter(List<PersonInfo> personInfoList){
        this.personInfoList = personInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personinfo_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonInfoRecyclerViewAdapter.ViewHolder holder, int position) {
        PersonInfo personInfo = personInfoList.get(position);
        holder.infoImage.setImageResource(personInfo.getImageId());
        holder.textLeft.setText(personInfo.getName());
        holder.textRight.setText(personInfo.getDetail());
        if(personInfo.getName().equals("")){
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height=10;
//        params.width =100;
            view.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return personInfoList.size();
    }
}
