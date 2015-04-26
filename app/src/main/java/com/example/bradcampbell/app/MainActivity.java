package com.example.bradcampbell.app;

import android.os.Bundle;

import com.example.bradcampbell.app.events.NavigateToHello2Event;
import com.example.bradcampbell.app.hello1.Hello1Fragment;
import com.example.bradcampbell.app.hello2.Hello2Fragment;
import com.example.bradcampbell.library.ComponentActivity;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import static com.example.bradcampbell.app.App.getAppComponent;

public class MainActivity extends ComponentActivity {
    @Inject Bus bus;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent(this).inject(this);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root, new Hello1Fragment())
                    .commit();
        }
    }

    @Override protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Subscribe public void onNavigateToHello2Event(NavigateToHello2Event event) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.root, new Hello2Fragment())
                .commit();
    }
}
