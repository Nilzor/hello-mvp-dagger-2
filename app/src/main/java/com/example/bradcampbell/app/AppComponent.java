package com.example.bradcampbell.app;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = AppModule.class
)
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
    Bus getBus();
}
