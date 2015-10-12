package com.epam.klondike;

import com.epam.klondike.card.Card;

import java.util.Stack;

public class Checker {

  public static boolean isMoveAllowed(Pile fromPile, Pile toPile,
                                      int numberOfCards) {
    Stack<Card> cards = fromPile.getManyCards(numberOfCards);
    return isCardsInOrder(cards);
  }

  public static boolean isCardsInOrder(Stack<Card> cards) {
    return true;
  }

}
