package com.example.testproject;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this).applicationId("cjones-parse-server")
                .clientKey("Grayson2015")
                .server("https://parse-server-example-cjones.herokuapp.com/parse")
                .build());

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
