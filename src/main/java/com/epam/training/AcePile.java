package com.epam.training;

public final class AcePile {
    private final Pile pile = new Pile();

    public void putCard(Card card) {
        if (!isComplete()){
            pile.putCard(card);
        }
    }

    public Card popCard() {
        return pile.popCard();
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public boolean isComplete() {
        return pile.getCardsCount() == Rank.values().length;
    }
}
