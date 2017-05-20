package com.ekoneimar.chatapplicationspring2017.View;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ekoneimar.chatapplicationspring2017.model.Message;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by SNinkovic_ns on 20.5.2017.
 */
@EViewGroup
public class BaseMessageItemView extends LinearLayout {

    @ViewById
    TextView messageTime;

    @ViewById
    TextView messageUser;

    @ViewById
    TextView messageText;

    @ViewById
    SimpleDraweeView userPhoto;


    public BaseMessageItemView(Context context) {
        super(context);
    }


    public BaseMessageItemView bind (Message message){
        messageText.setText(message.getText());
        messageTime.setText(DateFormat.format("HH:mm dd MMM", message.getTimestamp()));
        messageUser.setText(message.getUser().getUsername());
        userPhoto.setImageURI(message.getUser().getPhotoUrl());



        return this;
    }
}
