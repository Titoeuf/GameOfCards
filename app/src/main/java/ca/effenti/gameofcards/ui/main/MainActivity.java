package ca.effenti.gameofcards.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import ca.effenti.gameofcards.R;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter presenter;

    private Button drawButton;
    private ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawButton = findViewById(R.id.btn_draw);
        this.cardImage = findViewById(R.id.img_card);

        this.presenter = new MainPresenterImpl(this);
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
}
