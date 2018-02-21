package ca.effenti.gameofcards.ui.main;

import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferences;
import ca.effenti.gameofcards.webservices.DeckOfCardsService;
import ca.effenti.gameofcards.webservices.dto.CreateDeckBody;
import ca.effenti.gameofcards.webservices.dto.DeckResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private DeckOfCardsService deckService;
    private AppSharedPreferences sharedPreferences;

    private String deckId;

    public MainPresenterImpl(MainView mainView, DeckOfCardsService deckOfCardsService, AppSharedPreferences appSharedPreferences){
        this.view = mainView;
        this.deckService = deckOfCardsService;
        this.sharedPreferences = appSharedPreferences;

        // Try to restore deck id from shared preferences
        this.setDeckId(this.sharedPreferences.getDeckId());
        if(this.deckId == null){
            this.initializeDeck();
        }
    }

    private void setDeckId(String deckId) {
        this.deckId = deckId;
        // Persist the new value
        this.sharedPreferences.setDeckId(deckId);
        // Tell the view to enable or disable button
        this.view.enableDrawButton(this.deckId != null);
    }

    private void initializeDeck() {
        // Do an asynchronous call to get a new deck
        this.deckService.createDeck(new CreateDeckBody(1)).enqueue(new Callback<DeckResponse>() {
            @Override
            public void onResponse(Call<DeckResponse> call, Response<DeckResponse> response) {
                setDeckId(response.body().getDeckId());
            }

            @Override
            public void onFailure(Call<DeckResponse> call, Throwable t) {}
        });
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
