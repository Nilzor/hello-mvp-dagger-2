package com.example.bradcampbell.library;

public interface InjectsPresenter<P extends Presenter> {
    P getPresenter();
}
