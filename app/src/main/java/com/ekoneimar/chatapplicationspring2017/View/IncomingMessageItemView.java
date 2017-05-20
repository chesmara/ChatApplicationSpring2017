package com.ekoneimar.chatapplicationspring2017.View;

import android.content.Context;

import com.ekoneimar.chatapplicationspring2017.R;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by SNinkovic_ns on 20.5.2017.
 */
@EViewGroup(R.layout.item_view_message_incoming)
public class IncomingMessageItemView extends BaseMessageItemView {

    public IncomingMessageItemView(Context context) {
        super(context);
    }
}
