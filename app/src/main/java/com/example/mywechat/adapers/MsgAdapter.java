package com.example.mywechat.adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mywechat.R;

import java.util.List;

import domain.Msg;

public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourceId;

    public MsgAdapter(Context context, int textViewresourceId, List<Msg> objects) {
        super(context, textViewresourceId, objects);
        resourceId = textViewresourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Msg msg = getItem(position);
       View view;
       ViewHolder viewHolder;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_Layout);
            viewHolder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if(msg.getType()== Msg.RECEIVED){//判断消息类型
            //如果是收到的消息，则显示左边消息布局，将右边消息布局隐藏
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }else if(msg.getType()== Msg.SENT){
            //如果是发出去的消息，显示右边布局的消息布局，将左边的消息布局隐藏
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}
