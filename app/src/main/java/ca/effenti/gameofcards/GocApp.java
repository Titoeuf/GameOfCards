package ca.effenti.gameofcards;

import android.app.Application;
import android.content.Context;


public class GocApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        GocApp.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return GocApp.context;
    }
}
