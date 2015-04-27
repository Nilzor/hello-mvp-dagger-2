package com.example.bradcampbell.library;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ComponentCacheDelegate {
    private static final String NEXT_ID_KEY = "next-presenter-id";

    private NonConfigurationInstance nonConfigurationInstance;

    public void onCreate(Bundle savedInstanceState, Object nonConfigurationInstance) {
        if (nonConfigurationInstance == null) {
            long seed = 0;
            if (savedInstanceState != null) {
                seed = savedInstanceState.getLong(NEXT_ID_KEY);
            }
            this.nonConfigurationInstance = new NonConfigurationInstance(seed);
        } else {
            this.nonConfigurationInstance = (NonConfigurationInstance)nonConfigurationInstance;
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putLong(NEXT_ID_KEY, nonConfigurationInstance.nextId.get());
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return nonConfigurationInstance;
    }

    public long generateId() {
        return nonConfigurationInstance.nextId.getAndIncrement();
    }

    @SuppressWarnings("unchecked")
    public final <C> C getComponent(long index) {
        return (C) nonConfigurationInstance.components.get(index);
    }

    public void setComponent(long index, Object component) {
        nonConfigurationInstance.components.put(index, component);
    }

    private static class NonConfigurationInstance {
        private Map<Long, Object> components;
        private AtomicLong nextId;
        public NonConfigurationInstance(long seed) {
            components = new HashMap<>();
            nextId = new AtomicLong(seed);
        }
    }
}
