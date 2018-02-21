package ca.effenti.gameofcards.models.card;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CardDao {
    @Query("SELECT * FROM card")
    List<Card> getAll();

    @Query("SELECT * FROM card ORDER BY uid DESC LIMIT 1")
    LiveData<Card> observeLast();

    @Insert
    void insertAll(List<Card> cards);

    @Insert
    void insert(Card card);

    @Delete
    void delete(Card card);
}