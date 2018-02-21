package ca.effenti.gameofcards.ui.main;

import android.util.Log;

import ca.effenti.gameofcards.webservices.DeckOfCardsService;
import ca.effenti.gameofcards.webservices.dto.CreateDeckBody;
import ca.effenti.gameofcards.webservices.dto.DeckResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {
    private static final String LOG_TAG = "MainPresenterImpl";

    private MainView view;
    private DeckOfCardsService deckService;

    public MainPresenterImpl(MainView mainView, DeckOfCardsService deckOfCardsService){
        this.view = mainView;
        this.deckService = deckOfCardsService;

        this.deckService.createDeck(new CreateDeckBody()).enqueue(new Callback<DeckResponse>() {
            @Override
            public void onResponse(Call<DeckResponse> call, Response<DeckResponse> response) {
                Log.d(LOG_TAG, "Create Deck Success");
            }

            @Override
            public void onFailure(Call<DeckResponse> call, Throwable t) {
                Log.d(LOG_TAG, "Create Deck Failure");
            }
        });
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
