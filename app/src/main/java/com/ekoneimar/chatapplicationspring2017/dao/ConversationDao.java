package com.ekoneimar.chatapplicationspring2017.dao;

import com.ekoneimar.chatapplicationspring2017.evenbus.OttoBus;
import com.ekoneimar.chatapplicationspring2017.evenbus.event.ConverstationsUpdatedEvent;
import com.ekoneimar.chatapplicationspring2017.model.Conversation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SNinkovic_ns on 7.5.2017.
 */
@EBean(scope = EBean.Scope.Singleton)
public class ConversationDao  {

    public static final String CONVERSATION_TAG = "conversations";

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private List<Conversation> conversations = new ArrayList<>();

    private Map<String, Conversation> conversationMap = new HashMap<>();

    @Bean
    OttoBus bus;


    @AfterInject
    void init(){
        database.getReference(CONVERSATION_TAG).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conversationMap = dataSnapshot.getValue(
                        new GenericTypeIndicator<Map<String, Conversation>>() {} );
                publish();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void write ( Conversation conversation){
        final DatabaseReference databaseReference=
                database.getReference(CONVERSATION_TAG).push();
        conversation.setId(databaseReference.getKey());
        databaseReference.setValue(conversation);
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    private void publish(){
        conversations.clear();
        if (conversationMap != null){
            conversations.addAll(conversationMap.values());
        }
        bus.post(new ConverstationsUpdatedEvent());
    }
}
