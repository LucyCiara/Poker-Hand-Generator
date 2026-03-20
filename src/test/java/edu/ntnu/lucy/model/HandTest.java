package edu.ntnu.lucy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ntnu.lucyciara.model.Card;
import edu.ntnu.lucyciara.model.Hand;

public class HandTest {
    private static final String[] SUITS = new String[] {"Hearts", "Clovers", "Spades", "Diamonds"};
    
    private static final String[] TEST_SYMBOLS = new String[] {"A", "10", "3", "K", "2"};
    private static final String[] TEST_SUITS = new String[] {SUITS[0], SUITS[1], SUITS[2], SUITS[0], SUITS[3]};
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    private List<Card> cards;
   
    private Card flushCard1;
    private Card flushCard2;
    private Card flushCard3;
    private Card flushCard4;
    private Card flushCard5;   

    private List<Card> flushCards;

    @BeforeEach
    void init () {
        this.cards = new ArrayList<Card>();
        card1 = new Card(TEST_SUITS[0], TEST_SYMBOLS[0]);
        card2 = new Card(TEST_SUITS[1], TEST_SYMBOLS[1]);
        card3 = new Card(TEST_SUITS[2], TEST_SYMBOLS[2]);
        card4 = new Card(TEST_SUITS[3], TEST_SYMBOLS[3]);
        card5 = new Card(TEST_SUITS[4], TEST_SYMBOLS[4]);
        this.cards.add(card1);
        this.cards.add(card2);
        this.cards.add(card3);
        this.cards.add(card4);
        this.cards.add(card5);

        this.flushCards = new ArrayList<Card>();
        flushCard1 = new Card(TEST_SUITS[0], TEST_SYMBOLS[0]);
        flushCard2 = new Card(TEST_SUITS[0], TEST_SYMBOLS[1]);
        flushCard3 = new Card(TEST_SUITS[0], TEST_SYMBOLS[2]);
        flushCard4 = new Card(TEST_SUITS[0], TEST_SYMBOLS[3]);
        flushCard5 = new Card(TEST_SUITS[0], TEST_SYMBOLS[4]);
        this.flushCards.add(flushCard1);
        this.flushCards.add(flushCard2);
        this.flushCards.add(flushCard3);
        this.flushCards.add(flushCard4);
        this.flushCards.add(flushCard5);



    }


    @Test
    public void nullCardsInConstructorThrowsExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hand(null));
        assertEquals("cards can't be null", exception.getMessage());
    } 

    @Test
    public void getCardsGetsCards() {
        Hand hand = new Hand(this.cards);
        assertEquals(this.cards, hand.getCards());
    }

    @Test
    public void addNullCardThrowsExpectedException() {
        Hand hand = new Hand();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> hand.addCard(null));
        assertEquals("card can't be null", exception.getMessage());
    }

    @Test
    public void addCardAddsOnlyCard() {
        Hand hand = new Hand();
        assertEquals(0, hand.getCards().size());
        hand.addCard(card1);
        assertEquals(1, hand.getCards().size());
        assertEquals(card1, hand.getCards().getFirst());
    }

    @Test
    public void flushIsOnlyTrueOnFlush() {
        Hand hand = new Hand(this.cards);
        Hand flushHand = new Hand(this.flushCards);
        assertFalse(hand.checkFlush());
        assertTrue(flushHand.checkFlush());
    }

    @Test
    public void sumIsSum() {
        Hand hand = new Hand();
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card4);
        int expectedSum = card1.getValue()[0] + card2.getValue()[0] + card4.getValue()[0];
        assertEquals(expectedSum, hand.sum());
    }

    @Test
    public void checkHasCardHasOnlyCards() {
        Hand hand = new Hand(cards);
        for (Card card : cards) {
            assertTrue(hand.checkHasCard(card.getSuit(), card.getSymbol()));
        }

        String wrongSymbol = "6";
        assertFalse(Arrays.asList(this.cards).contains((Object) wrongSymbol));
        Card notInHandCard = new Card(TEST_SUITS[0], wrongSymbol);
        assertFalse(hand.checkHasCard(notInHandCard.getSuit(), notInHandCard.getSymbol()));
    }

    @Test
    public void countSuitCountsNumberOfCardsInSuit() {
        Hand hand = new Hand(cards);
        for (String suit : SUITS) {
            List<String> expectedCount = Arrays.stream(TEST_SUITS).filter(s -> s.equals(suit)).toList();
            assertEquals(expectedCount.size(), hand.countSuit(suit).size());
        }
    }
}
