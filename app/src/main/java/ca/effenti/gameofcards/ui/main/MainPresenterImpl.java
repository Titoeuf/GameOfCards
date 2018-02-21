package ca.effenti.gameofcards.ui.main;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;

    public MainPresenterImpl(MainView mainView){
        this.view = mainView;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
