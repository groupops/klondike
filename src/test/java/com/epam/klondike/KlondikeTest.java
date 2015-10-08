package com.epam.klondike;

import com.epam.klondike.card.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class KlondikeTest {

  Piles piles;
  DeckOfCards deck;
  Deque<Card> shuffledCards;
  DeckOfCards shuffledDeck;

  @Before
  public void setUp(){
    piles = new Piles();
    deck = new DeckOfCards(piles);
    shuffledCards = deck.shuffle();
    shuffledDeck = new DeckOfCards(shuffledCards, piles);
  }

  @Test
  public void shouldShuffleCards() {
    assertNotEquals(deck, shuffledDeck);
  }

  @Test
  public void shouldPlaceAllCardsInSevenPiles() {
    shuffledDeck.initialDeal();

    System.out.println(piles.toString());
    assertNotNull(piles.getPile(0));
    assertNotNull(piles.getPile(1));
    assertNotNull(piles.getPile(2));
    assertNotNull(piles.getPile(3));
    assertNotNull(piles.getPile(4));
    assertNotNull(piles.getPile(5));
    assertNotNull(piles.getPile(6));
  }

  @Test
  public void shouldPlaceExactNumberOfCardsInSevenPiles() {
    shuffledDeck.initialDeal();

    assertNotNull(piles.getPile(0));
    assertNotNull(piles.getPile(1));
    assertNotNull(piles.getPile(2));
    assertNotNull(piles.getPile(3));
    assertNotNull(piles.getPile(4));
    assertNotNull(piles.getPile(5));
    assertNotNull(piles.getPile(6));
  }

  @Test
  public void shouldSetTopCardOfEachPlaceFaceUp() {

  }

  @Test
  public void shouldMoveTopCardToOtherPileIfAllowed() {

  }

  @Test
  public void shouldMoveTwoTopCardsToOtherPileIfAllowed() {

  }

}
