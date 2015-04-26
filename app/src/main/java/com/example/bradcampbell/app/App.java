package com.example.bradcampbell.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private AppComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent(Context context) {
        return ((App)context.getApplicationContext()).component;
    }
}
