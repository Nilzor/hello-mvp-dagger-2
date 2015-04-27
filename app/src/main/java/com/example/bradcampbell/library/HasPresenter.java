package com.example.bradcampbell.library;

public interface HasPresenter<P extends Presenter> {
    P getPresenter();
}
