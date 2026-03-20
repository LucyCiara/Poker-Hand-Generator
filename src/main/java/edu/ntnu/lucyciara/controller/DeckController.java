package edu.ntnu.lucyciara.controller;

import java.util.List;

import edu.ntnu.lucyciara.model.Card;
import edu.ntnu.lucyciara.model.DeckOfCards;
import edu.ntnu.lucyciara.model.Hand;
import edu.ntnu.lucyciara.view.MainPage;

/**
 * A class for communicating between the model classes and the MainPage's UI, with a methods for button actions.
 */
public class DeckController {
    private MainPage mainPage;
    private DeckOfCards deck;
    private Hand hand;
    
    public DeckController(MainPage mainPage, DeckOfCards deck) {
        this.mainPage = mainPage;
        this.deck = deck;
    }

    public void drawHand() {
        String handStrings = "";
        this.hand = deck.dealHand(5);
        for (Card card : hand.getCards()) {
            String suitString = new String(new char[] {card.getSuit().toCharArray()[0]});
            String symbolString = card.getSymbol();
            handStrings += suitString + symbolString + " ";
        }
        this.mainPage.setCards(handStrings);
    }

    public void checkHand() {
        String sumString = Integer.toString( this.hand.sum() );
        this.mainPage.setSum(sumString);

        List<Card> heartCards = this.hand.countSuit("Hearts");
        String heartString = "";
        for (Card card : heartCards) {
            String suitString = "H";
            String symbolString = card.getSymbol();
            heartString += suitString + symbolString + " ";
        }
        if (heartString.isBlank()) {
            heartString = "None";
        }
        this.mainPage.setHearts(heartString);
    
        if (this.hand.checkFlush()) {
            this.mainPage.setFlush("Yes");
        } else {
            this.mainPage.setFlush("No");
        }

        if (this.hand.checkHasCard("Spades", "Q")) {
            this.mainPage.setQueenOfSpades("Yes");
        } else {
            this.mainPage.setQueenOfSpades("No");
        }
    }
}
