package ca.effenti.gameofcards.models;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseFactory {
    private AppDatabaseFactory() {}

    private static AppDatabase database;

    public static void initialize(Context context) {
        if(database==null){
            database = Room.databaseBuilder(context, AppDatabase.class, "goc-db").build();
        }
    }

    public static AppDatabase getDatabase() {
        if(database == null){
            throw new RuntimeException("AppDatabaseFactory must be initialized with application context before getting an instance");
        }
        return database;
    }
}
