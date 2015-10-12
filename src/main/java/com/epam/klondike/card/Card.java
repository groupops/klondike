package com.epam.klondike.card;

public class Card {

  private final Color COLOR;
  private final Symbol SYMBOL;
  private boolean isFaceUp;

  public Card(Color color, Symbol symbol, boolean isFaceUp) {
    this.COLOR = color;
    this.SYMBOL = symbol;
    this.isFaceUp = isFaceUp;
  }

  public Color getColor() {
    return COLOR;
  }

  public Symbol getSymbol() {
    return SYMBOL;
  }

  public boolean isFaceUp() {
    return isFaceUp;
  }

  public void setFaceUp(boolean isFaceUp) {
    this.isFaceUp = isFaceUp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Card card = (Card) o;

    return COLOR == card.COLOR && SYMBOL == card.SYMBOL;

  }

  @Override
  public int hashCode() {
    int result = COLOR != null ? COLOR.hashCode() : 0;
    result = 31 * result + (SYMBOL != null ? SYMBOL.hashCode() : 0);
    result = 31 * result + (isFaceUp ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Card{" +
        "COLOR=" + COLOR +
        ", SYMBOL=" + SYMBOL +
        '}';
  }
}
