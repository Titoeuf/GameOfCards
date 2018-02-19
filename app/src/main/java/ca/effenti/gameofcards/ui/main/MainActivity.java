package ca.effenti.gameofcards.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ca.effenti.gameofcards.R;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    private MainPresenter presenter;

    private Button drawButton;
    private ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawButton = findViewById(R.id.btn_draw);
        this.drawButton.setOnClickListener(this);
        this.cardImage = findViewById(R.id.img_card);

        this.presenter = new MainPresenterImpl(this, this);
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

    @Override
    public void onClick(View v) {
        if(v == this.drawButton){
            this.presenter.drawACard();
        }
    }
}
