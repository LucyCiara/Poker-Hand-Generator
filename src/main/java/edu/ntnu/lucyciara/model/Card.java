package edu.ntnu.lucyciara.model;

import edu.ntnu.lucyciara.util.ParameterCheck;

public class Card {
  private String suit;
  private String symbol;

  public Card(String suit, String symbol) {
    ParameterCheck.stringValidation(suit, "suit");
    ParameterCheck.stringValidation(symbol, "symbol");
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
    int[] value;
    try {
      value = new int[] { Integer.parseInt(this.symbol) };
      if (value[0] > 10 || value[0] < 2) {
        value = new int[] {0};
      }
    } catch (Exception e) {
      if (symbol.equals("J")) {
        value = new int[] { 11 };
      } else if (symbol.equals("Q")) {
        value = new int[] { 12 };
      } else if (symbol.equals("K")) {
        value = new int[] { 13 };
      } else if (symbol.equals("A")) {
        value = new int[] { 1, 14 };
      } else {
        value = new int[] { 0 };
      }
    }
    return value;
  }
}
