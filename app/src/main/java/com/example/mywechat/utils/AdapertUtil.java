package com.example.mywechat.utils;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapertUtil {


   public static void addlistView(List<Map<String,Object>> list, ListView listView, int[] pics, String[] username,
                                  String[] content,String[] time,Context context, int resource,int picid,int userid,int contentid,
                                  int timeid){
       list=new ArrayList<>();
       for (int i =0;i<pics.length;i++){
           Map<String,Object> map = new HashMap<>();
           map.put("userhead",pics[i]);
           map.put("username",username[i]);
           map.put("content",content[i]);
           map.put("time",time[i]);
           list.add(map);
       }
       listView.setAdapter(new SimpleAdapter(context,list,resource,new String[]{"userhead","username","content","time"}
       ,new int[]{picid,userid,contentid,timeid}));
   }

    public static void contactlistView(List<Map<String,Object>> list, ListView listView, int[] pics, String[] words,Context context, int resource,int picid,int wordid){
        list=new ArrayList<>();
        for (int i =0;i<pics.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("userhead",pics[i]);
            map.put("content",words[i]);
            list.add(map);
        }
        listView.setAdapter(new SimpleAdapter(context,list,resource,new String[]{"userhead","content"}
                ,new int[]{picid,wordid}));
    }
}
