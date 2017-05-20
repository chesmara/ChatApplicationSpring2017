package com.ekoneimar.chatapplicationspring2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.ekoneimar.chatapplicationspring2017.R;
import com.ekoneimar.chatapplicationspring2017.adapter.ConversationAdapter;
import com.ekoneimar.chatapplicationspring2017.dao.UserDao;
import com.ekoneimar.chatapplicationspring2017.evenbus.OttoBus;
import com.ekoneimar.chatapplicationspring2017.evenbus.event.UsersLoadedEvent;
import com.ekoneimar.chatapplicationspring2017.model.Conversation;
import com.ekoneimar.chatapplicationspring2017.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity {


    private static final int LOGIN_REQUEST_CODE=42;

    @ViewById
    ListView listView;

    @Bean
    ConversationAdapter conversationAdapter;



@Bean
UserDao userDao;


    @AfterViews
    void init() {
        if(FirebaseAuth.getInstance().getCurrentUser() == null){
                LoginActivity_.intent(this).startForResult(LOGIN_REQUEST_CODE);
            } else {
                userDao.init();
            }

            listView.setAdapter(conversationAdapter);
    }


    @OnActivityResult(value= LOGIN_REQUEST_CODE)
    void liginSucceeded(int resultCode){
        if(resultCode != RESULT_OK){
            return;
        }
        userDao.init();
    }


    @Subscribe
    public void usersLoaded(UsersLoadedEvent event){

        final FirebaseUser firebaseUser= FirebaseAuth
                .getInstance().getCurrentUser();

        if (userDao.userExists(firebaseUser.getUid())){
            userDao.setCurrentUser(userDao.getUserById(firebaseUser.getUid()));
        }else {
            final User user = new User(firebaseUser.getUid(),firebaseUser.getDisplayName(),
                    firebaseUser.getPhotoUrl().toString());
            userDao.write(user);
           userDao.setCurrentUser(user);

        }

    }


    @ItemClick
    void listViewItemClicked(Conversation conversation) {

        ConversationActivity_
                .intent(this)
                .conversation(conversation)
                .start();
    }




    @Click
    void fab(){
        CreateConversationActivity_.intent(this).start();
    }


}