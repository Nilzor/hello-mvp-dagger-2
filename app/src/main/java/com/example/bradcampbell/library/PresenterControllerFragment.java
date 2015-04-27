package com.example.bradcampbell.library;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class PresenterControllerFragment<C extends HasPresenter<P>, P extends Presenter>
        extends ComponentControllerFragment<C> {
    private PresenterControllerDelegate<P> presenterDelegate = new PresenterControllerDelegate<>();

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterDelegate.onCreate(getComponent().getPresenter(), savedInstanceState);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterDelegate.onViewCreated(view);
    }

    @Override public void onResume() {
        super.onResume();
        presenterDelegate.onResume();
    }

    @Override public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenterDelegate.onSaveInstanceState(outState);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        presenterDelegate.onDestroyView();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        presenterDelegate.onDestroy();
    }
}
