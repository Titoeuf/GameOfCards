package ca.effenti.gameofcards.webservices.deckofcards;


public class DeckResponse {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private int remaining;

    public boolean isSuccess() {
        return success;
    }

    public String getDeckId() {
        return deck_id;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }
}
