package com.example.bradcampbell.app;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides @Singleton public Bus provideBus() {
        return new Bus();
    }
}
