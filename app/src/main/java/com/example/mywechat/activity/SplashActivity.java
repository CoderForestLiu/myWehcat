package com.example.mywechat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mywechat.R;

public class SplashActivity extends AppCompatActivity {
Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转至登陆界面
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        },3000);//延迟三秒
    }
}
