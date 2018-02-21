package ca.effenti.gameofcards.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.effenti.gameofcards.R;
import ca.effenti.gameofcards.models.AppDatabaseFactory;
import ca.effenti.gameofcards.models.card.CardDao;
import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferences;
import ca.effenti.gameofcards.models.sharedpref.AppSharedPreferencesFactory;
import ca.effenti.gameofcards.webservices.DeckOfCardsService;
import ca.effenti.gameofcards.webservices.DeckOfCardsServiceFactory;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter presenter;

    @BindView(R.id.btn_draw)
    Button drawButton;
    @BindView(R.id.img_card)
    ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DeckOfCardsService deckService = DeckOfCardsServiceFactory.getService();
        AppSharedPreferences sharedPreferences = AppSharedPreferencesFactory.getSharedPreferences();
        CardDao cardDao = AppDatabaseFactory.getDatabase().cardDao();
        this.presenter = new MainPresenterImpl(
                this,
                deckService,
                sharedPreferences,
                cardDao,
                this
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    @Override
    protected void onPause() {
        this.presenter.onPause();
        super.onPause();
    }

    @Override
    public void enableDrawButton(boolean enabled) {
        this.drawButton.setEnabled(enabled);
    }

    @Override
    public void showCardImage(String imageUrl) {
        Picasso.with(this).load(imageUrl).into(this.cardImage);
    }

    @OnClick(R.id.btn_draw)
    void onDrawButtonClick() {
        this.presenter.drawACard();
    }
}
