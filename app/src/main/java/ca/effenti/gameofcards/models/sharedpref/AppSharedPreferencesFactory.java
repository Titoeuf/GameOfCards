package ca.effenti.gameofcards.models.sharedpref;


import android.content.Context;

public class AppSharedPreferencesFactory {
    private static AppSharedPreferences sharedPreferences;

    public static void initialize(Context context) {
        if(sharedPreferences==null){
            sharedPreferences = new AppSharedPreferencesImpl(context);
        }
    }

    public static AppSharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            throw new RuntimeException("AppSharedPreferences must be initialized with application context before getting an instance");
        }
        return sharedPreferences;
    }
}
