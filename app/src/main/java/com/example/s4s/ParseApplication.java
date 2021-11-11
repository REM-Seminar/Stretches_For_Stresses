package com.example.s4s;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Stretches.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("6yStRlIMnKcMmwlEArd5ZconsX3vcKV0XS8ZZIpB")
                .clientKey("OOoDI9Rc78pNzOHtTGP6ULyKN2yDe4IsylmurELa")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
