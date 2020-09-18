package com.example.mywechat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mywechat.R;
import com.example.mywechat.adapers.ExploreAdapter;
import com.example.mywechat.adapers.SettingAdaper;

import java.util.ArrayList;
import java.util.List;

import domain.Explore;
import domain.Setting;
/*
* @author liujiaqi
* @Date 2020/9/18
* */
public class SettingActivity extends AppCompatActivity {
    private List<Setting> setingList1 = new ArrayList<>();
    private List<Setting> setingList2 = new ArrayList<>();
    private List<Setting> setingList3 = new ArrayList<>();
    private List<Setting> setingList4 = new ArrayList<>();
    private List<Setting> setingList5 = new ArrayList<>();
    private List<Setting> setingList6 = new ArrayList<>();
    private SharedPreferences sp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        init();
        //适配第一个listView
        SettingAdaper adapter1 = new SettingAdaper(this, R.layout.setting_listview, setingList1);
        ListView listView1 = (ListView)findViewById(R.id.discover_listview1);
        listView1.setAdapter(adapter1);
        //适配第二个listView
        SettingAdaper adapter2 = new SettingAdaper(this, R.layout.setting_listview, setingList2);
        ListView listView2 = (ListView) findViewById(R.id.discover_listview2);
        listView2.setAdapter(adapter2);
        //适配第三个listView
        SettingAdaper adapter3 = new SettingAdaper(this, R.layout.setting_listview, setingList3);
        ListView listView3 = (ListView) findViewById(R.id.discover_listview3);
        listView3.setAdapter(adapter3);
        //适配第四个listView
        SettingAdaper adapter4 = new SettingAdaper(this, R.layout.setting_listview, setingList4);
        ListView listView4 = (ListView) findViewById(R.id.discover_listview4);
        listView4.setAdapter(adapter4);
        //适配第五个listView
        SettingAdaper adapter5 = new SettingAdaper(this, R.layout.setting_listview, setingList5);
        ListView listView5 = (ListView) findViewById(R.id.discover_listview5);
        listView5.setAdapter(adapter5);

        //适配第五个listView
        SettingAdaper adapter6 = new SettingAdaper(this, R.layout.setting_listview, setingList6);
        ListView listView6 = (ListView) findViewById(R.id.discover_listview6);
        listView6.setAdapter(adapter6);

        listView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LoginActivity loginActivity = new LoginActivity();
                sp = getSharedPreferences("logincookie",MODE_PRIVATE);
                final SharedPreferences.Editor editor = sp.edit();
                 if (editor!=null){
                     editor.remove("username");
                     editor.remove("password");
                     editor.commit();
                     Toast.makeText(SettingActivity.this,"账号已注销！",Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
                     startActivity(intent);
                 }

            }
        });

    }
    public void init(){
            Setting setting1=new Setting("账号与安全",R.mipmap.next);
            setingList1.add(setting1);

            Setting setting2=new Setting("新消息通知",R.mipmap.next);
            Setting setting3=new Setting("隐私",R.mipmap.next);
            Setting setting4=new Setting("通用",R.mipmap.next);
            setingList2.add(setting2);
            setingList2.add(setting3);
            setingList2.add(setting4);

            Setting setting5=new Setting("帮助与反馈",R.mipmap.next);
            Setting setting6=new Setting("关于微信",R.mipmap.next);
            setingList3.add(setting5);
            setingList3.add(setting6);

            Setting setting7=new Setting("插件",R.mipmap.next);
            setingList4.add(setting7);

            Setting setting8=new Setting("切换账号",R.mipmap.next);
            setingList5.add(setting8);

            Setting setting9=new Setting("退出登录",0);
            setingList6.add(setting9);



    }
}
