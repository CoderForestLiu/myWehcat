package com.example.mywechat.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.mywechat.view.NestedListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.mywechat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
    private String[] name={"昔尘","百宝"};
    private  NestedListView infolist;
    private int[] headimg={R.mipmap.xi,R.mipmap.bai};
    private int[] feedback = {R.mipmap.feed,R.mipmap.feed};
    private int[] image={R.mipmap.ak2,R.mipmap.weather};
    private String[] text={"沉迷代码套娃，差点玩到死机","朝霞不出门，晚霞行千里"};
    private String[] time={"5小时前","6小时前"};
    private SimpleAdapter simpleAdapter;
    private ArrayList<Map<String,Object>> arrayList;
    private Context context = null;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        infolist = findViewById(R.id.friend_list);
        setSupportActionBar(toolbar);

            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                //因为背景为浅色，设置通知栏字体颜色为深色

                decorView.setSystemUiVisibility(option);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
            //返回按钮
            ImageView imageButton=(ImageView) findViewById(R.id.white_back);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            //内容适配器
            arrayList=new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            HashMap<String,Object> map=new HashMap<>();
            map.put("mingzi",name[i]);
            map.put("touxiang",headimg[i]);
            map.put("wenzi",text[i]);
            map.put("tupian",image[i]);
            map.put("shijian",time[i]);
            map.put("feedback",feedback[i]);
            arrayList.add(map);
        }
        simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.updatelist,
                new String[]{"mingzi","touxiang","wenzi","tupian","shijian","feedback"},
                new int[]{R.id.circle_name,R.id.circle_headimg,R.id.circle_text,R.id.circle_img,R.id.circle_time,R.id.feed}
        );
            infolist.setAdapter(simpleAdapter);
            setListViewHeightBasedOnChildren(infolist,view,simpleAdapter);
        }
    /**
     * 动态设置ListView的高度
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView,View view,SimpleAdapter adapter) {
        if(listView == null) return;
        if (adapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
