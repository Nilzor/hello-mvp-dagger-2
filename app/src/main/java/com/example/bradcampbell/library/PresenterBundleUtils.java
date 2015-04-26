package com.example.bradcampbell.library;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class PresenterBundleUtils {
    private static final String TAG = PresenterBundleUtils.class.getSimpleName();
    private static final String MAP_KEY = PresenterBundle.class.getName();

    private PresenterBundleUtils() {
        // No instances
    }

    @SuppressWarnings("unchecked") // Handled internally
    public static PresenterBundle getPresenterBundle(Bundle savedInstanceState) {
        HashMap<String, Object> map = null;
        if (savedInstanceState != null) {
            try {
                map = (HashMap<String, Object>) savedInstanceState
                        .getSerializable(MAP_KEY);
            } catch (ClassCastException e) {
                Log.e(TAG, "", e);
            }
        }
        PresenterBundle result = null;
        if (map != null) {
            result = new PresenterBundle();
            result.setMap(map);
        }
        return result;
    }

    public static void setPresenterBundle(Bundle outState, PresenterBundle presenterBundle) {
        outState.putSerializable(MAP_KEY, presenterBundle.getMap());
    }
}
