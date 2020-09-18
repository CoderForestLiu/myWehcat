package com.example.mywechat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.example.mywechat.R;
import com.example.mywechat.activity.UpdateActivity;
import com.example.mywechat.activity.Video_Activity;
import com.example.mywechat.adapers.ExploreAdapter;

import java.util.ArrayList;
import java.util.List;

import domain.Explore;

public class ExploreFragment extends Fragment {
   private View view;
   private List<Explore> exploreList1 = new ArrayList<>();
   private List<Explore> exploreList2 = new ArrayList<>();
   private List<Explore> exploreList3 = new ArrayList<>();
   private List<Explore> exploreList4 = new ArrayList<>();
   private List<Explore> exploreList5 = new ArrayList<>();
   private List<Explore> exploreList6 = new ArrayList<>();
   private List<Explore> exploreList7 = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.explore_layout, container, false);
        //适配第一个listView
        ExploreAdapter adapter1 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList1);
        ListView listView1 = (ListView) view.findViewById(R.id.discover_listview1);
        listView1.setAdapter(adapter1);
        //适配listView_video
        ExploreAdapter adapter_video = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList2);
        ListView listView_video = (ListView) view.findViewById(R.id.discover_listview_video);
        listView_video.setAdapter(adapter_video);
        //适配第二个listView
        ExploreAdapter adapter2 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList3);
        ListView listView2 = (ListView) view.findViewById(R.id.discover_listview2);
        listView2.setAdapter(adapter2);
        //适配第三个listView
        ExploreAdapter adapter3 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList4);
        ListView listView3 = (ListView) view.findViewById(R.id.discover_listview3);
        listView3.setAdapter(adapter3);
        //适配第四个listView
        ExploreAdapter adapter4 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList5);
        ListView listView4 = (ListView) view.findViewById(R.id.discover_listview4);
        listView4.setAdapter(adapter4);
        //适配第五个listView
        ExploreAdapter adapter5 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList6);
        ListView listView5 = (ListView) view.findViewById(R.id.discover_listview5);
        listView5.setAdapter(adapter5);
        //适配第六个listView
        ExploreAdapter adapter6 = new ExploreAdapter(view.getContext(), R.layout.explore_listview, exploreList7);
        ListView listView6 = (ListView) view.findViewById(R.id.discover_listview6);
        listView6.setAdapter(adapter6);

        //为第一个ListView添加点击事件
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(view.getContext(), UpdateActivity.class);//启动朋友圈
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });
        listView_video.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(view.getContext(), Video_Activity.class);//启动视频号
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }
  //初始化参数
    private void init() {
         Explore explore1=new Explore(R.mipmap.afe,"朋友圈",R.mipmap.next);
        exploreList1.add(explore1);
        Explore explore2 = new Explore(R.mipmap.video,"视频号",R.mipmap.next);
        exploreList2.add(explore2);
         Explore explore3=new Explore(R.mipmap.afg,"扫一扫",R.mipmap.next);
        exploreList3.add(explore3);
        Explore explore4=new Explore(R.mipmap.afh,"摇一摇",R.mipmap.next);
        exploreList3.add(explore4);
        Explore explore5=new Explore(R.mipmap.look,"看一看",R.mipmap.next);
        exploreList4.add(explore5);
        Explore explore6=new Explore(R.mipmap.search,"搜一搜",R.mipmap.next);
        exploreList4.add(explore6);
        Explore explore7=new Explore(R.mipmap.nearperson,"附近的人",R.mipmap.next);
        exploreList5.add(explore7);

        Explore explore8=new Explore(R.mipmap.axw,"购物",R.mipmap.next);
        exploreList6.add(explore8);
        Explore explore9=new Explore(R.mipmap.ak6,"游戏",R.mipmap.next);
        exploreList6.add(explore9);
        Explore explore10=new Explore(R.mipmap.program,"小程序",R.mipmap.next);
        exploreList7.add(explore10);

    }

    //加载参数
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

}