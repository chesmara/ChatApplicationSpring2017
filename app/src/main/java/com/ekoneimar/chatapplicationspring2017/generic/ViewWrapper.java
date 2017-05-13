package com.ekoneimar.chatapplicationspring2017.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by SNinkovic_ns on 13.5.2017.
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}