package ca.effenti.gameofcards.webservices;

import ca.effenti.gameofcards.webservices.deckofcards.CardsResponse;
import ca.effenti.gameofcards.webservices.deckofcards.CreateDeckBody;
import ca.effenti.gameofcards.webservices.deckofcards.DeckResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeckOfCardsService {
    @POST("deck/new/shuffle")
    Call<DeckResponse> createDeck(@Body CreateDeckBody body);

    @GET("deck/new/shuffle")
    Call<DeckResponse> getNewDeck(@Query("deck_count") int count);

    @GET("deck/{deck_id}/shuffle")
    Call<DeckResponse> shuffleDeck(@Path("deck_id") String deckId);

    @GET("deck/{deck_id}")
    Call<DeckResponse> getDeck(@Path("deck_id") String deckId);

    @GET("deck/{deck_id}/draw")
    Call<CardsResponse> drawCards(@Path("deck_id") String deckId, @Query("count") int count);
}
