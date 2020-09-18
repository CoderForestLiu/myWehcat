package com.example.mywechat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.mywechat.R;
import com.example.mywechat.view.NestedListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Video_Activity extends AppCompatActivity {
    private int[] mp4 = {0,0,0};
    private String[] username = {"user1","user2","user3"};
    private int[] userhead = {R.mipmap.mypic,R.mipmap.shuai,R.mipmap.jedi};
    private int[] videomore = {R.mipmap.more,R.mipmap.more,R.mipmap.more};
    private String[] title = {"迪士尼励志短片《小鸭子》，超萌治愈","迪士尼励志短片《小鸭子》，超萌治愈","迪士尼励志短片《小鸭子》，超萌治愈"};
    private int[] comment = {R.mipmap.videolike,R.mipmap.videolike,R.mipmap.videolike};

    private ArrayList<HashMap<String,Object>> arrayList = new ArrayList<>();
    private NestedListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        NestedListView videolist = findViewById(R.id.viediolist);
        ImageView back = findViewById(R.id.back_video);
        for(int i=0;i<username.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("username",username[i]);
            map.put("userhead",userhead[i]);
            map.put("title",title[i]);
            map.put("mp4",mp4[i]);
            map.put("videomore",videomore[i]);
            map.put("videocomment",comment[i]);
            arrayList.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(Video_Activity.this,arrayList,R.layout.videolist,
                new String[]{"username","userhead","title","mp4","videomore","videocomment"},
                new int[]{R.id.username,R.id.userhead,R.id.video_title,R.id.videoimg,R.id.videomore,R.id.comment});
        videolist.setAdapter(simpleAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
