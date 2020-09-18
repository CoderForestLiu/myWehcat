package com.example.mywechat.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.mywechat.R;
import com.example.mywechat.fragments.ChatFragment;
import com.example.mywechat.fragments.ContactFragement;
import com.example.mywechat.fragments.ExploreFragment;
import com.example.mywechat.fragments.MyFragment;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar mBottomNavigationBar;
    private TextBadgeItem textBadgeItem,textBadgeItem2;
    private ShapeBadgeItem shapeBadgeItem;
    private TextView title;
    private Button button_menu;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }
    private void initView() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        textBadgeItem = new TextBadgeItem();
        textBadgeItem2 = new TextBadgeItem();

        //显示信息提示数字
        textBadgeItem.setBorderWidth(4)
                .setBackgroundColorResource(R.color.red)
                .setAnimationDuration(200)
                .setText("3")
                .setHideOnSelect(false);

        //显示信息提示数字
        textBadgeItem2.setBorderWidth(7)
                .setTextColorResource(R.color.red)
                .setBackgroundColorResource(R.color.red)
                .setAnimationDuration(200)
                .setText("1")
                .setHideOnSelect(false);

    }

    /**
     * 配置控件
     */
    private void setView() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setActiveColor(R.color.colorPrimary);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.tab_weixin_pressed, "消息")
                .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.tab_weixin_normal))
                .setBadgeItem(textBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.tab_address_pressed, "通讯录")
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.tab_address_normal)))
                .addItem(new BottomNavigationItem(R.mipmap.tab_find_frd_pressed, "发现")
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.tab_find_frd_normal))
                        .setBadgeItem(textBadgeItem2))//设置小红点
                .addItem(new BottomNavigationItem(R.mipmap.tab_settings_pressed, "我的")
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.tab_settings_normal)))

                .setFirstSelectedPosition(0)//设置第一个菜单为选中状态
                .initialise();//必须调用该方法，才会生效
        title = findViewById(R.id.bar_title);
        button_menu = findViewById(R.id.btn_menu);


        //设置第一个要显示的Fragment
        replace(new ChatFragment());
        //BottomNavigationBar选项卡，选择事件
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
              slideFuntion(position);

            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中

            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中

                slideFuntion(position);
            }
        });
    }

    /**
     * 切换Fragment
     *
     * @param fragment Fragment
     */
    private void replace(Fragment fragment) {//切换Fragment
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameContent, fragment);
        transaction.commit();
    }

    /**
     * 启动Activity
     *
     *
     */
    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }
    public void Onmenu(View v,int resource){
        View popupwindow_menu=getLayoutInflater().inflate(resource,null,false);
        pop=new PopupWindow(popupwindow_menu, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);
        pop.showAsDropDown(findViewById(R.id.btn_menu),0,0);
    }
    public void slideFuntion(int position){
        switch (position) {
            case 0:
                replace(new ChatFragment());
                title.setText("微信");
                button_menu.setBackgroundResource(R.mipmap.add);
                LinearLayout.LayoutParams lp1 = (LinearLayout.LayoutParams) title.getLayoutParams();//动态设置margin值
                lp1.setMargins(445,0,0,0);
                button_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Onmenu(v,R.layout.menu);//加载右上角菜单
                    }
                });
                break;
            case 1:
                replace(new ContactFragement());
                title.setText("通讯录");
                button_menu.setBackgroundResource(R.mipmap.add);
                LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams) title.getLayoutParams();
                lp2.setMargins(440,0,0,0);
                button_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"addfriends",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 2:
                replace(new ExploreFragment());
                title.setText("发现");
                LinearLayout.LayoutParams lp3 = (LinearLayout.LayoutParams) title.getLayoutParams();
                lp3.setMargins(450,0,0,0);
                button_menu.setBackgroundResource(0);
                break;
            case 3:
                replace(new MyFragment());
                title.setText("");
                LinearLayout.LayoutParams lp4 = (LinearLayout.LayoutParams) title.getLayoutParams();
                lp4.setMargins(550,0,0,0);
                button_menu.setBackgroundResource(R.mipmap.camera);
                break;
            default:
                break;
        }
    }
}

