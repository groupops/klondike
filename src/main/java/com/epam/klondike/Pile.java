package com.epam.klondike;

import com.epam.klondike.card.Card;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pile {

  private Deque<Card> pile;

  public Pile(){
    pile = new ArrayDeque<>();
  }

  public void add(Card card){
    pile.add(card);
  }

  public Card take(){
    Card card = pile.getFirst();
    pile.removeFirst();
    return card;
  }

}
