package com.example.bradcampbell.app.hello2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bradcampbell.app.R;
import com.example.bradcampbell.library.PresenterControllerFragment;

import static com.example.bradcampbell.app.App.getAppComponent;

public class Hello2Fragment extends PresenterControllerFragment<Hello2Component, Hello2Presenter> {
    @Override protected Hello2Component onCreateNonConfigurationComponent() {
        return DaggerHello2Component.builder()
                .appComponent(getAppComponent(getActivity()))
                .build();
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return getComponent()
                .inject((Hello2LinearLayout)
                        inflater.inflate(R.layout.fragment_hello2, container, false));
    }
}
