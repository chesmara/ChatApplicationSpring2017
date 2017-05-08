package com.ekoneimar.chatapplicationspring2017.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ekoneimar.chatapplicationspring2017.View.ConversationItemView;
import com.ekoneimar.chatapplicationspring2017.View.ConversationItemView_;
import com.ekoneimar.chatapplicationspring2017.dao.ConversationDao;
import com.ekoneimar.chatapplicationspring2017.model.Conversation;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SNinkovic_ns on 7.5.2017.
 */
@EBean
public class ConversationAdapter extends BaseAdapter {


    private List<Conversation> conversations=new ArrayList<>();

    @RootContext
    Context context;

    @Bean
    ConversationDao conversationDao;

    @AfterInject
    void init(){
        setConversations(conversationDao.getConversations());
    }




    @Override
    public int getCount() {
        return conversations.size();
    }

    @Override
    public Object getItem(int position) {
        return conversations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ConversationItemView conversationItemView;
        if (convertView == null) {
            conversationItemView = ConversationItemView_.build(context);
        } else {
            conversationItemView = (ConversationItemView) convertView;
        }

        conversationItemView.bind(conversations.get(position));

        return conversationItemView;
    }

    private void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
        notifyDataSetChanged();
    }
}
