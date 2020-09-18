package com.example.mywechat.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mywechat.R;
import com.example.mywechat.listener.IEditTextChangeListener;
import com.example.mywechat.utils.WorksSizeCheckUtil;
/*
 * @author liujiaqi
 * @Date 2020/9/18
 * */
public class LoginActivity extends AppCompatActivity {
    private SharedPreferences logincookie=null;
    private String user_username = "root";
    private String user_password = "abc123";

    public SharedPreferences getLogincookie() {
        return logincookie;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //隐藏自带标题
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//全屏显示
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//因为背景为浅色所以将状态栏字体设置为黑色
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        inputFocus();//监听EditView变色
        if (!auto_Login()){//SharedPreferences中没找到
            check();//登录验证
        }
        buttonChangeColor();
        //启动注册页面
        findViewById(R.id.login_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean auto_Login(){//判断SharedPreferences中是否含有"username","password"，有返回true
        logincookie = getSharedPreferences("logincookie", MODE_PRIVATE);
        String getusername = logincookie.getString("username",null);
        String getpassword = logincookie.getString("password",null);
        if (getpassword!=null&&getusername!=null){
            if (getpassword.equals(user_password)&&getusername.equals(user_username)){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            }else{
                Toast.makeText(LoginActivity.this,"账号已过期请重新登录！",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return false;
    }
    public void check(){
        //仿登录功能
        Button button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EditText in_username=(EditText)findViewById(R.id.username);
                 EditText in_passwd=(EditText)findViewById(R.id.passwd);
                 String   name=in_username.getText().toString();
                 String password=in_passwd.getText().toString();
                if("root".equals(name)&&"abc123".equals(password)){
                    final SharedPreferences.Editor editor = logincookie.edit();
                    editor.putString("username",name);//写入SharedPreferences中
                    editor.putString("password",password);
                    editor.commit();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void inputFocus(){
        final EditText username=(EditText)findViewById(R.id.username);
        final EditText passwd=(EditText)findViewById(R.id.passwd);
        //悬停dvier变色
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                    ImageView imageView=(ImageView)findViewById(R.id.login_diver1);
                    imageView.setBackgroundResource(R.color.input_dvier_focus);
                } else {
                    // 此处为失去焦点时的处理内容
                    ImageView imageView=(ImageView)findViewById(R.id.login_diver1);
                    imageView.setBackgroundResource(R.color.input_dvier);
                }
            }
        });
        passwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                    ImageView imageView=(ImageView)findViewById(R.id.login_diver2);
                    imageView.setBackgroundResource(R.color.input_dvier_focus);
                } else {
                    // 此处为失去焦点时的处理内容
                    ImageView imageView=(ImageView)findViewById(R.id.login_diver2);
                    imageView.setBackgroundResource(R.color.input_dvier);
                }
            }
        });
    }
    public void buttonChangeColor(){
        final EditText username=(EditText)findViewById(R.id.username);
        final EditText passwd=(EditText)findViewById(R.id.passwd);
        final Button button=(Button)findViewById(R.id.login);
        //创建工具类对象 把要改变颜色的Button先传过去
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(button);
        textChangeListener.addAllEditText(username,passwd);//把所有要监听的EditText都添加进去
        ////接口回调 在这里拿到boolean变量 根据isHasContent的值决定 Button应该设置什么颜色
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if(isHasContent){
                    button.setBackgroundResource(R.drawable.login_button_focus);
                    button.setTextColor(getResources().getColor(R.color.loginButtonTextFouse));
                }else{
                    button.setBackgroundResource(R.drawable.login_button_shape);
                    button.setTextColor(getResources().getColor(R.color.loginButtonText));
                }
            }
        });
    }
}


