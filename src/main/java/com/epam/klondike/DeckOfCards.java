package com.epam.klondike;

import com.epam.klondike.card.Card;
import com.epam.klondike.card.Color;
import com.epam.klondike.card.Symbol;

import java.util.*;

public class DeckOfCards {

  private Deque<Card> deck;
  private Piles piles;

  public DeckOfCards(Deque<Card> deck, Piles piles) {
    this.deck = deck;
    this.piles = piles;
  }

  public DeckOfCards(Piles piles) {
    this.deck = new ArrayDeque<>();
    for (int i = 0; i < 13; i++) {
      Symbol symbol = Symbol.values()[i];

      for (int j = 0; j < 4; j++) {
        Card card = new Card(Color.values()[j], symbol, false);
        this.deck.add(card);
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DeckOfCards that = (DeckOfCards) o;

    return !(deck != null ? !deck.equals(that.deck) : that.deck != null) &&
        !(piles != null ? !piles.equals(that.piles) : that.piles != null);

  }

  @Override
  public int hashCode() {
    int result = deck != null ? deck.hashCode() : 0;
    result = 31 * result + (piles != null ? piles.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DeckOfCards{" +
        "deck=" + deck +
        ", piles=" + piles +
        '}';
  }

  public Deque<Card> shuffle() {
    List<Card> deckAsList = new LinkedList<>(deck);
    Collections.shuffle(deckAsList);
    return new ArrayDeque<>(deckAsList);
  }

  public void initialDeal() {
    piles = new Piles();
    for (int i = 0; i < piles.getNumberOfPiles(); i++) {
      Pile pile = piles.getPile(i);
      Card card = deck.getFirst();
      pile.add(card);
      deck.removeFirst();
    }
  }

}
