package com.ekoneimar.chatapplicationspring2017.evenbus;

import com.squareup.otto.Bus;

import org.androidannotations.annotations.EBean;

/**
 * Created by SNinkovic_ns on 13.5.2017.
 */



    @EBean(scope = EBean.Scope.Singleton)
    public class OttoBus extends Bus {

    }

