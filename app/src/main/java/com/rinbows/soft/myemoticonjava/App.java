package com.rinbows.soft.myemoticonjava;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static Context appContext;

    static {
        appContext = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
}
