package com.example.bradcampbell.app.hello1;

import com.example.bradcampbell.app.AppComponent;
import com.example.bradcampbell.library.InjectsPresenter;

import dagger.Component;

@Component(
        modules = Hello1Module.class,
        dependencies = AppComponent.class
)
@Hello1Scope
public interface Hello1Component extends InjectsPresenter<Hello1Presenter> {
    Hello1LinearLayout inject(Hello1LinearLayout view);
}
