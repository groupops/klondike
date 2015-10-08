package com.epam.training;

import java.util.Stack;

/**
 * Created by Dmytro_Ulanovych on 10/8/2015.
 */
public final class Pile {
    private Stack<Card> cards = new Stack<>();

    public void putCard(Card card) {
        cards.push(card);
    }

    public Card popCard() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getCardsCount() {
        return cards.size();
    }

}
