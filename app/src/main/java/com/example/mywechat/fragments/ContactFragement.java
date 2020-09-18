package com.example.mywechat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywechat.R;

import com.example.mywechat.adapers.ContactAdapter;

import com.example.mywechat.view.DividerItemDecoration;
import com.example.mywechat.view.LetterView;


public class ContactFragement extends Fragment {
    private RecyclerView contactList;
    private String[] contactNames;
    private ListView headerlist;
    private LinearLayoutManager layoutManager;
    private LetterView letterView;
    private ContactAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.contact_layout,container,false);
        contactNames = new String[] {"Forest","Tracy","订阅号","广化篮球群","百宝","必胜客","尘昔","CVN社区","涛","张三丰", "郭靖", "黄蓉", "黄老邪", "赵敏",
                "123", "天山童姥", "任我行", "于万亭"};
        contactList = (RecyclerView) view.findViewById(R.id.contact_list);
        letterView = (LetterView) view.findViewById(R.id.letter_view);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ContactAdapter(getActivity(), contactNames);


        contactList.setLayoutManager(layoutManager);
        contactList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        contactList.setAdapter(adapter);

        letterView.setCharacterListener(new LetterView.CharacterClickListener() {
            @Override
            public void clickCharacter(String character) {
                layoutManager.scrollToPositionWithOffset(adapter.getScrollPosition(character), 0);
            }

            @Override
            public void clickArrow() {
                layoutManager.scrollToPositionWithOffset(0, 0);
            }
        });
    return view;

    }
}
