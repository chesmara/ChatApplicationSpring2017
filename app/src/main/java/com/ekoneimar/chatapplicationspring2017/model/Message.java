package com.ekoneimar.chatapplicationspring2017.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SNinkovic_ns on 13.5.2017.
 */

public class Message extends  BaseModel implements Serializable{

    private String text;

    private Date timestamp;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
        this.timestamp = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
