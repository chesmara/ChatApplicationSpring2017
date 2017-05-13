package com.ekoneimar.chatapplicationspring2017.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ekoneimar.chatapplicationspring2017.R;
import com.ekoneimar.chatapplicationspring2017.dao.MessageDao;
import com.ekoneimar.chatapplicationspring2017.model.Conversation;
import com.ekoneimar.chatapplicationspring2017.model.Message;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_create_message)
public class CreateMessageFragment extends Fragment {


    public CreateMessageFragment() {
    }


    @Bean
    MessageDao messageDao;

    @ViewById
    EditText messageText;

    public void initFor(Conversation conversation) {
        messageDao.initFor(conversation);
    }

        @Click
        void sendMessage(){

            final String text = messageText.getText().toString();
            if (text.isEmpty()) {
                return;
            }

            final Message message = new Message(text);
            messageDao.write(message);
            messageText.setText("");
        }

}

