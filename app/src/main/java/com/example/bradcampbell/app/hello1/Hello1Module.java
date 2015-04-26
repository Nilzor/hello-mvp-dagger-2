package com.example.bradcampbell.app.hello1;

import dagger.Module;
import dagger.Provides;

@Module
public class Hello1Module {
    @Provides @Hello1Scope public Hello1Presenter providePresenter() {
        return new Hello1Presenter();
    }
}
