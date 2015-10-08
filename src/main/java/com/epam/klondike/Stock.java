package com.epam.klondike;

import com.epam.klondike.card.Card;

import java.util.Deque;

public class Stock {

  private Deque<Card> stock;

  public Deque<Card> getStock() {
    return stock;
  }

  public void setStock(Deque<Card> stock) {
    this.stock = stock;
  }

  public Card getCard(){
    return stock.getFirst();
  }

}
