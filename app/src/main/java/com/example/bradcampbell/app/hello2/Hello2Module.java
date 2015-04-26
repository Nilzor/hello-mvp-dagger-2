package com.example.bradcampbell.app.hello2;

import dagger.Module;
import dagger.Provides;

@Module
public class Hello2Module {
    @Provides @Hello2Scope public Hello2Presenter providePresenter() {
        return new Hello2Presenter();
    }
}
