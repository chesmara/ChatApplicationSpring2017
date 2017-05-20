package com.ekoneimar.chatapplicationspring2017;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.androidannotations.annotations.EApplication;

/**
 * Created by SNinkovic_ns on 20.5.2017.
 */
@EApplication
public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
