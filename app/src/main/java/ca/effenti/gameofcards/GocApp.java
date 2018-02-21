package ca.effenti.gameofcards;

import android.app.Application;
import android.content.Context;

import ca.effenti.gameofcards.models.AppDatabaseFactory;
import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferencesFactory;


public class GocApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Context appContext = getApplicationContext();
        AppSharedPreferencesFactory.initialize(appContext);
        AppDatabaseFactory.initialize(appContext);
    }
}
