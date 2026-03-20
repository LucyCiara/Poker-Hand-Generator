package edu.ntnu.lucy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ntnu.lucyciara.model.Card;
import edu.ntnu.lucyciara.model.DeckOfCards;
import edu.ntnu.lucyciara.model.Hand;

public class DeckOfCardsTest {
    private static final String[] SUITS = new String[] { "Hearts", "Diamonds", "Spades", "Clovers" };
    private static final String[] SYMBOLS = new String[] {
        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    @Test
    public void dealMoreCardsThanDeckSizeThrowsExpectedException() {
        DeckOfCards deck = new DeckOfCards();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> deck.dealHand(deck.getCards().size() + 1));
        assertEquals("n can't be more than the size of the deck", exception.getMessage());
    }

    @Test
    public void dealLessThanOneCardThrowsExpectedException() {
        DeckOfCards deck = new DeckOfCards();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
        assertEquals("n can't be less than 1", exception.getMessage());
    }

    @Test
    public void dealHandDealsExpectedNumberOfCards() {
        DeckOfCards deck = new DeckOfCards();
        int cardsToDeal = 4;
        assertEquals(cardsToDeal, deck.dealHand(cardsToDeal).getCards().size());
    }

    @Test
    public void dealingEntireHandCreatesNoDuplicates() {
        DeckOfCards deck = new DeckOfCards();
        Hand deckHand = deck.dealHand(deck.getCards().size());
        for (String suit : SUITS) {
            for (String symbol : SYMBOLS) {
                assertEquals(1, deckHand.getCards().stream().filter(c -> c.getSuit().equals(suit) && c.getSymbol().equals(symbol)).toList().size());
            }
        }
    }
}
