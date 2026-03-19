package edu.ntnu.lucyciara.model;

public class Card {
  private String suit;
  private String symbol;

  public Card(String suit, String symbol) {
    this.suit = suit;
    this.symbol = symbol;
  }

  public String getSuit() {
    return this.suit;
  }

  public String getSymbol() {
    return this.symbol;
  }

  public int[] getValue() {
    try {
      return new int[] { Integer.parseInt(this.symbol) };
    } catch (Exception e) {
      if (symbol.equals("J")) {
        return new int[] { 11 };
      } else if (symbol.equals("Q")) {
        return new int[] { 12 };
      } else if (symbol.equals("K")) {
        return new int[] { 13 };
      } else if (symbol.equals("A")) {
        return new int[] { 1, 14 };
      } else {
        return new int[] { 0 };
      }
    }
  }
}
