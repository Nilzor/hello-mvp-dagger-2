package com.example.bradcampbell.library;

public interface ComponentCache {
    long generateId();
    <C> C getComponent(long index);
    <C> void setComponent(long index, C component);
}
