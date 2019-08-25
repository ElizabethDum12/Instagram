package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        //Set applicationID, and sever based on the values in the Heroku settings.
        //clientKey is not needed unless explicity congigured
        //any network interceptors must be added with the Configuration builfer given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("gloria-instagram")
                .clientKey("gloria-instagram-codepath")
                .server("http://gloria-instagram.herokuapp.com/parse").build());
        }
}
