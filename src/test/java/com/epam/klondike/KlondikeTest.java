package com.epam.klondike;

import com.epam.klondike.card.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.Deque;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class KlondikeTest {

  Piles piles;
  DeckOfCards deck;
  Deque<Card> shuffledCards;
  DeckOfCards shuffledDeck;

  @Before
  public void setUp() {
    piles = new Piles();
    deck = new DeckOfCards(piles);
    shuffledCards = deck.getShuffledDeck();
    shuffledDeck = new DeckOfCards(shuffledCards, piles);
  }

  @Test
  public void shouldShuffleCards() {
    assertThat(shuffledDeck, is(not(equalTo(deck))));
  }

  @Test
  public void shouldPlaceAllCardsInSevenPiles() {
    shuffledDeck.initialDeal();

    assertThat(shuffledDeck.getPile(0), is(notNullValue()));
    assertThat(shuffledDeck.getPile(1), is(notNullValue()));
    assertThat(shuffledDeck.getPile(2), is(notNullValue()));
    assertThat(shuffledDeck.getPile(3), is(notNullValue()));
    assertThat(shuffledDeck.getPile(4), is(notNullValue()));
    assertThat(shuffledDeck.getPile(5), is(notNullValue()));
    assertThat(shuffledDeck.getPile(6), is(notNullValue()));
  }

  @Test
  public void shouldPlaceExactNumberOfCardsInSevenPiles() {
    shuffledDeck.initialDeal();

    List<Card> cardsFromPileOne = shuffledDeck.getPile(0).getAllCards();
    List<Card> cardsFromPileTwo = shuffledDeck.getPile(1).getAllCards();
    List<Card> cardsFromPileThree =
        shuffledDeck.getPile(2).getAllCards();
    List<Card> cardsFromPileFour =
        shuffledDeck.getPile(3).getAllCards();
    List<Card> cardsFromPileFive =
        shuffledDeck.getPile(4).getAllCards();
    List<Card> cardsFromPileSix = shuffledDeck.getPile(5).getAllCards();
    List<Card> cardsFromPileSeven =
        shuffledDeck.getPile(6).getAllCards();

    assertThat(cardsFromPileOne.size(), is(equalTo(1)));
    assertThat(cardsFromPileTwo.size(), is(equalTo(2)));
    assertThat(cardsFromPileThree.size(), is(equalTo(3)));
    assertThat(cardsFromPileFour.size(), is(equalTo(4)));
    assertThat(cardsFromPileFive.size(), is(equalTo(5)));
    assertThat(cardsFromPileSix.size(), is(equalTo(6)));
    assertThat(cardsFromPileSeven.size(), is(equalTo(7)));
  }

  @Test
  public void shouldSetTopCardOfEachPlaceFaceUp() {
    shuffledDeck.initialDeal();

    Card cardFromPileOne = shuffledDeck.getPile(0).getOneCard();
    Card cardFromPileTwo = shuffledDeck.getPile(1).getOneCard();
    Card cardFromPileThree = shuffledDeck.getPile(2).getOneCard();
    Card cardFromPileFour = shuffledDeck.getPile(3).getOneCard();
    Card cardFromPileFive = shuffledDeck.getPile(4).getOneCard();
    Card cardFromPileSix = shuffledDeck.getPile(5).getOneCard();
    Card cardFromPileSeven = shuffledDeck.getPile(6).getOneCard();

    assertThat(cardFromPileOne.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileTwo.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileThree.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileFour.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileFive.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileSix.isFaceUp(), is(equalTo(true)));
    assertThat(cardFromPileSeven.isFaceUp(), is(equalTo(true)));
  }

  @Test
  public void shouldMoveTopCardToOtherPileIfAllowed() {

  }

  @Test
  public void shouldMoveTwoTopCardsToOtherPileIfAllowed() {

  }

}
