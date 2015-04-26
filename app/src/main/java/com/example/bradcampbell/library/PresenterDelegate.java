package com.example.bradcampbell.library;

import android.os.Bundle;
import android.view.View;

import static com.example.bradcampbell.library.PresenterBundleUtils.getPresenterBundle;
import static com.example.bradcampbell.library.PresenterBundleUtils.setPresenterBundle;

public class PresenterDelegate<P extends Presenter> {
    private boolean isDestroyedBySystem;
    private P presenter;

    public void onCreate(P presenter, Bundle savedInstanceState) {
        this.presenter = presenter;
        PresenterBundle bundle = getPresenterBundle(savedInstanceState);
        presenter.onCreate(bundle);
    }

    @SuppressWarnings("unchecked")
    public void onViewCreated(View view) {
        try {
            presenter.bindView(view);
        } catch (ClassCastException e) {
            throw new RuntimeException("The view provided does not implement the view interface " +
                    "expected by " + presenter.getClass().getSimpleName() + ".", e);
        }
    }

    public void onResume() {
        isDestroyedBySystem = false;
    }

    public void onSaveInstanceState(Bundle outState) {
        isDestroyedBySystem = true;
        PresenterBundle bundle = new PresenterBundle();
        presenter.onSaveInstanceState(bundle);
        setPresenterBundle(outState, bundle);
    }

    public void onDestroyView() {
        presenter.unbindView();
    }

    public void onDestroy() {
        if (!isDestroyedBySystem) {
            // User is exiting this view, remove presenter from the cache
            presenter.onDestroy();
        }
    }
}
