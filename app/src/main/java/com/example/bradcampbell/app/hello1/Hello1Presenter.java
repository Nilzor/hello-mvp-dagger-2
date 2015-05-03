package com.example.bradcampbell.app.hello1;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.bradcampbell.library.BasePresenter;
import com.example.bradcampbell.library.PresenterBundle;

class Hello1Presenter extends BasePresenter<Hello1LinearLayout> {
    private static final String VIEWMODEL_KEY = "hello1ViewModel";
    private Hello1ViewModel viewModel;

    public void buttonPressed() {
        view.goToNextScreen();
    }

    // Todo: make this reusable base method. view.update(viewModel) is a recurring pattern.
    @Override public void bindView(Hello1LinearLayout view) {
        super.bindView(view);
        viewModel.updateSerial();
        viewModel.updateText();
        view.update(viewModel);
    }

    @Override public void onCreate(@Nullable PresenterBundle bundle) {
        viewModel = new Hello1ViewModel();
        if (bundle != null) {
            viewModel = (Hello1ViewModel) bundle.getSerializable(VIEWMODEL_KEY);
            viewModel.updateText();
        }
    }

    @Override public void onSaveInstanceState(@NonNull PresenterBundle bundle) {
        bundle.putSerializable(VIEWMODEL_KEY, viewModel);
    }
}