package com.ekoneimar.chatapplicationspring2017.model;

import java.io.Serializable;

/**
 * Created by SNinkovic_ns on 20.5.2017.
 */

public class User extends  BaseModel implements Serializable {

    private String username;

    private String photoUrl;


    public User(String id, String username, String photoUrl) {
        super(id);
        this.username = username;
        this.photoUrl = photoUrl;
    }

    public User(){}

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId().equals(user.getId());
    }


}
