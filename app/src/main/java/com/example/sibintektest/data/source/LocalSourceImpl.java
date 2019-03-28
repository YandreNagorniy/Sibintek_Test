package com.example.sibintektest.data.source;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.ref.WeakReference;

public class LocalSourceImpl implements LocalSource {
    private static final String LOCAL_DATA = "local_data";
    private static final String DATABASE_FULL = "database_full";
    private SharedPreferences preferences;

    public LocalSourceImpl(WeakReference<Context> context) {
        preferences = context.get().getApplicationContext()
                .getSharedPreferences(LOCAL_DATA, Context.MODE_PRIVATE);
    }

    @Override
    public Boolean getLocalData() {
        return preferences.getBoolean(DATABASE_FULL, false);
    }

    @Override
    public void setLocalData(Boolean isLocal) {
        preferences.edit().putBoolean(DATABASE_FULL, isLocal).apply();
    }
}
