package ca.effenti.gameofcards.models.sharedpref;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class AppSharedPreferencesImpl implements AppSharedPreferences {
    private Context context;

    AppSharedPreferencesImpl(@NonNull Context context){
        this.context = context;
    }
    private SharedPreferences getPreferences(){
        return this.context.getSharedPreferences("com.neurodesign.racavoxpop.RCSharedPreferences", Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor(){
        return this.getPreferences().edit();
    }

    @Override
    public String getDeckId(){
        return this.getPreferences().getString("deck_id", null);
    }

    @Override
    public void setDeckId(String deckId){
        SharedPreferences.Editor edit = this.getEditor();
        edit.putString("deck_id", deckId);
        edit.apply();
    }
}
