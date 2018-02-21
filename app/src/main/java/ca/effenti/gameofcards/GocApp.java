package ca.effenti.gameofcards;

import android.app.Application;

import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferencesFactory;


public class GocApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppSharedPreferencesFactory.initialize(getApplicationContext());
    }
}
