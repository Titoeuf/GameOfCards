package ca.effenti.gameofcards.ui.main;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.List;

import ca.effenti.gameofcards.models.card.Card;
import ca.effenti.gameofcards.models.card.CardDao;
import ca.effenti.gameofcards.models.card.CardFactory;
import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferences;
import ca.effenti.gameofcards.webservices.DeckOfCardsService;
import ca.effenti.gameofcards.webservices.dto.CardsResponse;
import ca.effenti.gameofcards.webservices.dto.CreateDeckBody;
import ca.effenti.gameofcards.webservices.dto.DeckResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter, Observer<Card> {
    private MainView view;
    private DeckOfCardsService deckService;
    private AppSharedPreferences sharedPreferences;
    private CardDao cardDao;
    private LifecycleOwner lifecycleOwner;

    private String deckId;

    public MainPresenterImpl(
            MainView mainView,
            DeckOfCardsService deckOfCardsService,
            AppSharedPreferences appSharedPreferences,
            CardDao cardDao,
            LifecycleOwner lifecycleOwner
    ){
        this.view = mainView;
        this.deckService = deckOfCardsService;
        this.sharedPreferences = appSharedPreferences;
        this.cardDao = cardDao;
        this.lifecycleOwner = lifecycleOwner;

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
        // Reevaluate the state of our button
        this.view.enableDrawButton(this.deckId != null);

        // Connect to our database
        this.cardDao.observeLast().observe(lifecycleOwner, this);
    }

    @Override
    public void onPause() {
        this.cardDao.observeLast().removeObserver(this);
    }

    @Override
    public void drawACard() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<CardsResponse> response = deckService.drawCards(deckId, 1).execute();
                    // Save the cards
                    List<Card> cardList = CardFactory.fromCardsResponse(response.body());
                    cardDao.insert(cardList.get(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onChanged(@Nullable Card card) {
        if (card != null) {
            this.view.showCardImage(card.getImage());
        }
    }
}
