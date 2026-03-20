package edu.ntnu.lucyciara.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class for a whole deck of cards, with a method for drawing a hand and for getting the entire deck.
 */
public class DeckOfCards {
  private static final String[] SUITS = new String[] { "Hearts", "Diamonds", "Spades", "Clovers" };
  private static final String[] SYMBOLS = new String[] {
      "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
  };

  private List<Card> deck;
  private List<Card> drawPile;
  private Random random;

  public DeckOfCards() {
    this.deck = new ArrayList<Card>();
    for (String suit : SUITS) {
      for (String symbol : SYMBOLS) {
        this.deck.add(new Card(suit, symbol));
      }
    }
    this.drawPile = new ArrayList<Card>(this.deck);
    this.random = new Random();
  }

  private Card draw() {
    int index = this.random.nextInt(this.drawPile.size());
    Card card = this.drawPile.get(index);
    this.drawPile.remove(index);
    return card;
  }

  // private Card drawSuit(String suit) {
  // List<Card> suitCards = this.drawPile.stream().filter(card ->
  // card.getSuit().equals(suit)).toList();
  // int index = this.random.nextInt(suitCards.size());
  // Card card = suitCards.get(index);
  // this.drawPile.remove(card);
  // return card;
  // }

  public Hand dealHand(int n) {
    if (n > deck.size()) {
      throw new IllegalArgumentException("n can't be more than the size of the deck");
    } else if (n < 1) {
      throw new IllegalArgumentException("n can't be less than 1");
    }
    Hand hand = new Hand();
    for (int i = 0; i < n; i++) {
      hand.addCard(this.draw());
    }
    this.drawPile = new ArrayList<Card>(this.deck);
    return hand;
  }

  // public Hand dealSuitHand(int n, String suit) {
  // Hand hand = new Hand();
  // for (int i = 0; i < n; i++) {
  // hand.addCard(this.drawSuit(suit));
  // }
  // this.drawPile = new ArrayList<Card>(this.deck);
  // return hand;
  // }

  public List<Card> getCards() {
    return this.deck;
  }
}
