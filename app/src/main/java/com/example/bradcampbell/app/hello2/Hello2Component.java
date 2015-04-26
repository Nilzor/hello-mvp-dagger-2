package com.example.bradcampbell.app.hello2;

import com.example.bradcampbell.app.AppComponent;
import com.example.bradcampbell.library.InjectsPresenter;

import dagger.Component;

@Component(
        modules = Hello2Module.class,
        dependencies = AppComponent.class
)
@Hello2Scope
public interface Hello2Component extends InjectsPresenter<Hello2Presenter> {
    Hello2LinearLayout inject(Hello2LinearLayout view);
}
