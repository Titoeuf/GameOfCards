package ca.effenti.gameofcards.models;


import android.content.Context;
import android.content.SharedPreferences;

import ca.effenti.gameofcards.GocApp;

public class AppSharedPreferences {
    private static SharedPreferences getPreferences(){
        return GocApp.getAppContext().getSharedPreferences("com.neurodesign.racavoxpop.RCSharedPreferences", Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor(){
        return AppSharedPreferences.getPreferences().edit();
    }

    public static String getDeckId(){
        return AppSharedPreferences.getPreferences().getString("deck_id", null);
    }

    public static void setDeckId(String deckId){
        SharedPreferences.Editor edit = AppSharedPreferences.getEditor();
        edit.putString("deck_id", deckId);
        edit.apply();
    }
}
