package com.example.mywechat.adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mywechat.R;

import java.util.List;

import domain.Explore;

public class ExploreAdapter extends ArrayAdapter<Explore> {
    private int resourceID;
    public ExploreAdapter(Context context, int textViewResourceID, List<Explore> objects){
        super(context,textViewResourceID,objects);
        resourceID=textViewResourceID;
    }
    @Override
    //绑定组件，根据传进来的Arraylist<Explore>逐个设置值
    public View getView(int position, View convertView, ViewGroup parent) {
        Explore explore=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.discover_img);
        ImageView arrow=(ImageView)view.findViewById(R.id.discover_arrow);
        TextView textView1=(TextView)view.findViewById(R.id.discover_text);
        imageView1.setImageResource(explore.getImg());
        arrow.setImageResource(explore.getArrow());
        textView1.setText(explore.getText());
        return view;
    }
}
