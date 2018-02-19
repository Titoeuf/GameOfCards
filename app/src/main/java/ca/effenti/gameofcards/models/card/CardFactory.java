package ca.effenti.gameofcards.models.card;


import java.util.ArrayList;
import java.util.List;

import ca.effenti.gameofcards.webservices.deckofcards.CardsResponse;

public class CardFactory {
    public static List<Card> fromCardsResponse(CardsResponse cardsResponse){
        ArrayList<Card> cards = new ArrayList<>();
        for (CardsResponse.Card cardResponse : cardsResponse.getCards()) {
            cards.add(new Card(
                    cardResponse.getImage(),
                    cardResponse.getValue(),
                    cardResponse.getSuit(),
                    cardResponse.getCode()
            ));
        }
        return cards;
    }
}
