package com.example.mywechat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mywechat.R;
import com.example.mywechat.activity.RoomActivtity;
import com.example.mywechat.utils.AdapertUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ChatFragment extends Fragment {
    private SearchView searchView;
    private List<Map<String,Object>> list;
    private ListView listView;
    private int currentpos=0;
    private  int[] pics = new int[]{R.mipmap.mypic,R.mipmap.ma,R.mipmap.booking,R.mipmap.basketball,R.mipmap.bai,R.mipmap.pizza,R.mipmap.xi,R.mipmap.cvn,R.mipmap.tao};
    private String[] username = new String[]{"Forest","Tracy","订阅号","广化篮球群","百宝","必胜客","尘昔","CVN社区","涛"};
    private String[] content=new String[]{"hello","Long time no see!","hi","Long time no see!","hi","Long time no see!","hi","Long time no see!","hi"};
    private  String[] time = new String[]{new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
            new SimpleDateFormat("yyyy-MM-dd").format(new Date())
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_layout,container,false);
        listView = view.findViewById(R.id.listview1);
        AdapertUtil.addlistView(list,listView,pics,username,content,time,getActivity(),R.layout.chatlist_layout,
                R.id.imageView2,R.id.textView,R.id.textView2,R.id.textView4);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(username[position]!=null){
                    Intent intent = new Intent(getActivity(), RoomActivtity.class);
                    intent.putExtra("username",username[position]);
                    currentpos=position;
                    startActivityForResult(intent,0x01);
                }

            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(0x01, 0x02, data);
        String result = data.getStringExtra("mytalk");
        content[currentpos]=result;
        AdapertUtil.addlistView(list,listView,pics,username,content,time,getActivity(),R.layout.chatlist_layout,
                R.id.imageView2,R.id.textView,R.id.textView2,R.id.textView4);

    }

}
