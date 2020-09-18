package com.example.mywechat.adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mywechat.R;

import java.util.List;

import domain.Explore;
import domain.Setting;

public class SettingAdaper extends ArrayAdapter<Setting> {
    private int resourceID;
    public SettingAdaper(Context context, int textViewResourceID, List<Setting> objects){
        super(context,textViewResourceID,objects);
        resourceID=textViewResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Setting setting =getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView1=(ImageView)view.findViewById(R.id.discover_img);
        ImageView arrow=(ImageView)view.findViewById(R.id.discover_arrow);
        TextView textView1=(TextView)view.findViewById(R.id.discover_text);
        arrow.setImageResource(setting.getArrow());
        textView1.setText(setting.getText());
        return view;
    }
}
