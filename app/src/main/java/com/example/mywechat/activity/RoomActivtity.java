package com.example.mywechat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mywechat.R;
import com.example.mywechat.adapers.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

import domain.Msg;

public class RoomActivtity extends AppCompatActivity {
    EditText editText ;
    private  String[] content ;
    private MsgAdapter adapter;
    private  ListView msglistview;
    private List<Msg> msgList = new ArrayList<Msg>();
    private Toolbar toolbar;
    private TextView textView;
    private ImageView btn_back;
    private String first_page_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        initMsg();
        adapter = new MsgAdapter(RoomActivtity.this, R.layout.roomlist_layout, msgList);
        textView = findViewById(R.id.username);
        msglistview= findViewById(R.id.listview);
        editText = findViewById(R.id.editText);
        editText.setOnKeyListener(onKey);
        msglistview.setAdapter(adapter);
        msglistview.setDivider(null);
        btn_back=findViewById(R.id.back);
        final Intent intent = getIntent();
        textView.setText(intent.getStringExtra("username"));
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("mytalk",first_page_content);
                setResult(0x02,intent);//带返回值的activity
                finish();
            }
        });


    }

    View.OnKeyListener onKey = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            if (keyCode == KeyEvent.KEYCODE_ENTER) {//按下回车键发送
                //这里写发送信息的方法
                String content = editText.getText().toString();

                if(!"".equals(content)){
                    Msg msg = new Msg(content, Msg.SENT);
                    first_page_content = msg.getContent();
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();//有新消息时，刷新ListView中的显示
                    msglistview.setSelection(msgList.size());//将ListView定位到最后一行

                    editText.setText("");//清空输入框的内容
                    editText.clearFocus();
                }

            }
            return true;
        }
    };
    private void initMsg() {//初始化消息
        Msg msg1 = new Msg("I miss you!",Msg.RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("I miss you,too!",Msg.SENT);
        msgList.add(msg2);

        Msg msg3 = new Msg("I will come back soon!",Msg.RECEIVED);
        msgList.add(msg3);

    }
}


