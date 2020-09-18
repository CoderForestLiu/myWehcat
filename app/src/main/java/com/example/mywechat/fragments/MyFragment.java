package com.example.mywechat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mywechat.R;
import com.example.mywechat.activity.SettingActivity;
import com.example.mywechat.adapers.MyAdaper;

import java.util.ArrayList;
import java.util.List;

import domain.Myself;

public class MyFragment extends Fragment {
    private View view;
    private List<Myself> myList1 = new ArrayList<>();
    private List<Myself> myList2 = new ArrayList<>();
    private List<Myself> myList3 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_activity,container,false);
        MyAdaper adapter1 = new MyAdaper(view.getContext(), R.layout.my_listview,myList1);
        ListView listView1 = (ListView) view.findViewById(R.id.my_listview1);
        listView1.setAdapter(adapter1);

        MyAdaper adapter2 = new MyAdaper(view.getContext(), R.layout.my_listview,myList2);
        ListView listView2 = (ListView) view.findViewById(R.id.my_listview2);
        listView2.setAdapter(adapter2);

        MyAdaper adapter3 = new MyAdaper(view.getContext(), R.layout.my_listview,myList3);
        ListView listView3 = (ListView) view.findViewById(R.id.my_listview3);
        listView3.setAdapter(adapter3);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init() {
        Myself myself1 = new Myself(R.mipmap.mypay,"支付",R.mipmap.next);
        myList1.add(myself1);
        Myself myself2 = new Myself(R.mipmap.akc,"收藏",R.mipmap.next);
        myList2.add(myself2);
        Myself myself3 = new Myself(R.mipmap.ak_,"相册",R.mipmap.next);
        myList2.add(myself3);
        Myself myself4 = new Myself(R.mipmap.akb,"卡包",R.mipmap.next);
        myList2.add(myself4);
        Myself myself5 = new Myself(R.mipmap.ak2,"表情",R.mipmap.next);
        myList2.add(myself5);
        Myself myself6 = new Myself(R.mipmap.akd,"设置",R.mipmap.next);
        myList3.add(myself6);


    }

    //加载参数
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }
}
