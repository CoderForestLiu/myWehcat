package com.example.mywechat.adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mywechat.R;

import java.util.List;

import domain.Myself;

public class MyAdaper extends ArrayAdapter<Myself> {
    private int resourceID;

    public MyAdaper(@NonNull Context context, int textViewResourceId, List<Myself> objects) {
        super(context, textViewResourceId, objects);
        this.resourceID = textViewResourceId;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Myself myself = getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.my_img);
        ImageView arrow=(ImageView)view.findViewById(R.id.my_arrow);
        TextView textView1=(TextView)view.findViewById(R.id.my_text);
        imageView1.setImageResource(myself.getImg());
        arrow.setImageResource(myself.getArrow());
        textView1.setText(myself.getText());
        return view;

    }

}
