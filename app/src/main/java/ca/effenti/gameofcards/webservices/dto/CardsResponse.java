package ca.effenti.gameofcards.webservices.dto;

import java.util.List;

public class CardsResponse {
    private boolean success;
    private List<Card> cards;
    private String deck_id;
    private int remaining;

    public boolean isSuccess() {
        return success;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getDeckId() {
        return deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public class Card {
        private String image;
        private String value;
        private String suit;
        private String code;

        public String getImage() {
            return image;
        }

        public String getValue() {
            return value;
        }

        public String getSuit() {
            return suit;
        }

        public String getCode() {
            return code;
        }
    }
}
