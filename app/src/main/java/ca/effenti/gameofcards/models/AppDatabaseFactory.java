package ca.effenti.gameofcards.models;


import android.arch.persistence.room.Room;

import ca.effenti.gameofcards.GocApp;

public class AppDatabaseFactory {
    private AppDatabaseFactory() {}

    private static AppDatabase database;

    public static AppDatabase getDatabase() {
        if(database == null){
            database = Room.databaseBuilder(GocApp.getAppContext(), AppDatabase.class, "goc-db").build();
        }
        return database;
    }
}
