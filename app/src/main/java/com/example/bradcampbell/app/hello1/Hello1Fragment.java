package com.example.bradcampbell.app.hello1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bradcampbell.app.R;
import com.example.bradcampbell.library.PresenterFragment;

import static com.example.bradcampbell.app.App.getAppComponent;

public class Hello1Fragment extends PresenterFragment<Hello1Component, Hello1Presenter> {
    @Override protected Hello1Component onCreateNonConfigurationComponent() {
        return DaggerHello1Component.builder()
                .appComponent(getAppComponent(getActivity()))
                .build();
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return getComponent()
                .inject((Hello1LinearLayout)
                        inflater.inflate(R.layout.fragment_hello1, container, false));
    }
}
