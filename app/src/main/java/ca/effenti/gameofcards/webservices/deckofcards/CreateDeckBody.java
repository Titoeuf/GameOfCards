package ca.effenti.gameofcards.webservices.deckofcards;


public class CreateDeckBody {
    private int deck_count;

    public CreateDeckBody(){
        this(1);
    }

    public CreateDeckBody(int deckCount) {
        this.deck_count = deckCount;
    }
}
