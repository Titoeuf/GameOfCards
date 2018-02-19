package ca.effenti.gameofcards.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ca.effenti.gameofcards.models.card.Card;
import ca.effenti.gameofcards.models.card.CardDao;

@Database(entities = {Card.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDao cardDao();
}

