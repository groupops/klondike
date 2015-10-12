package com.epam.klondike;

import com.epam.klondike.card.Card;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Pile {

  private final Stack<Card> pile;

  public Pile() {
    pile = new Stack<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pile pile1 = (Pile) o;

    return !(pile != null ? !pile.equals(pile1.pile) : pile1.pile != null);

  }

  @Override
  public int hashCode() {
    return pile != null ? pile.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Pile{" +
        "pile=" + pile +
        '}';
  }

  public void putOneCard(Card card) {
    pile.add(card);
  }

  public void putManyCards(Stack<Card> cards){
    pile.addAll(cards);
  }

  public Card getOneCard(){
    return pile.pop();
  }

  public Stack<Card> getManyCards(int numberOfCards){
    Stack<Card> cards = new Stack<>();
    for(int i = 0; i < numberOfCards; i++){
      Card card = pile.pop();
      cards.add(card);
    }
    return cards;
  }

  public List<Card> getAllCards() {
    return pile.stream().collect(Collectors.toList());
  }

  public void printCards() {
    pile.forEach(System.out::println);
  }

}
