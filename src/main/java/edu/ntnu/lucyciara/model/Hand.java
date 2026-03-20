package edu.ntnu.lucyciara.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
  private List<Card> cards;

  // private static final String[] ROYAL_CARDS = new String[] {
  // "A", "10", "J", "Q", "K"
  // };

  public Hand() {
    this(new ArrayList<Card>());
  }

  public Hand(List<Card> cards) {
    this.cards = cards;
  }

  public List<Card> getCards() {
    return this.cards;
  }

  public void addCard(Card card) {
    this.cards.add(card);
  }

  // private List<String> getSymbols() {
  // List<String> symbols = new ArrayList<String>();
  // for (Card card : this.cards) {
  // symbols.add(card.getSymbol());
  // }
  // return symbols;
  // }

  public boolean checkFlush() {
    String suit = this.cards.getFirst().getSuit();
    return this.cards.stream().allMatch(c -> c.getSuit().equals(suit));
  }

  // public boolean checkRoyalFlush() {
  // if (this.checkFlush() &&
  // this.getSymbols().containsAll(Arrays.asList(ROYAL_CARDS))) {
  // return true;
  // } else {
  // return false;
  // }
  // }

  public int sum() {
    int sum = 0;
    for (Card card : this.cards) {
      sum += card.getValue()[0];
    }
    return sum;
  }

  public boolean checkHasCard(String suit, String symbol) {
    for (Card card : this.cards) {
      if (card.getSuit().equals(suit) && card.getSymbol().equals(symbol)) {
        return true;
      }
    }
    return false;
  }

  public List<Card> countSuit(String suit) {
    List<Card> cards = new ArrayList<Card>();
    for (Card card : this.cards) {
      if (card.getSuit().equals(suit)) {
        cards.add(card);
      }
    }
    return cards;
  }
}
