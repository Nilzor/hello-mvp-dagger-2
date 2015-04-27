package com.example.bradcampbell.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ComponentCacheActivity extends AppCompatActivity implements ComponentCache {
    private ComponentCacheDelegate delegate = new ComponentCacheDelegate();

    @Override public void onCreate(Bundle savedInstanceState) {
        delegate.onCreate(savedInstanceState, getLastCustomNonConfigurationInstance());
        super.onCreate(savedInstanceState);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        delegate.onSaveInstanceState(outState);
    }

    @Override public Object onRetainCustomNonConfigurationInstance() {
        return delegate.onRetainCustomNonConfigurationInstance();
    }

    @Override public long generateId() {
        return delegate.generateId();
    }

    @Override public final <C> C getComponent(long index) {
        return delegate.getComponent(index);
    }

    @Override public void setComponent(long index, Object component) {
        delegate.setComponent(index, component);
    }
}
