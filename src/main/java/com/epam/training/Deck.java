package com.epam.training;

import java.util.*;

public final class Deck {
    private static final int DECK_SIZE = 52;
    private final Queue<Card> cards = new LinkedList<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suite suite : Suite.values()) {
                cards.add(new Card(rank, suite));
            }
        }
    }

    public Card getNext() {
        return cards.poll();
    }

    public void putBack(Card card) {
        cards.add(card);
    }

    public void size(){
        cards.size();
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public void shuffle(){
        Collections.shuffle((List<?>) cards);
    }
}
