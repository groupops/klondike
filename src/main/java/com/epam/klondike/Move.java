package com.epam.klondike;

import com.epam.klondike.card.Card;

import java.util.Stack;

public class Move {

  public void moveCards(Pile fromPile, Pile toPile, int numberOfCards) {
    Checker.isMoveAllowed(fromPile, toPile, numberOfCards);
    Stack<Card> cards = fromPile.getManyCards(numberOfCards);
    toPile.putManyCards(cards);
  }

}
