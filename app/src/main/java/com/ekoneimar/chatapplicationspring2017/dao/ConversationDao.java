package com.ekoneimar.chatapplicationspring2017.dao;

import com.ekoneimar.chatapplicationspring2017.model.Conversation;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SNinkovic_ns on 7.5.2017.
 */
@EBean
public class ConversationDao  {

    private List<Conversation> conversations=new ArrayList<>();


    @AfterInject
    void init(){
        for (int i=0; i<10; i++){
            conversations.add(new Conversation(null,"Fun chat" +i));
        }
    }

    public List<Conversation> getConversations() {
        return conversations;
    }
}
