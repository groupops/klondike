package com.epam.training;

public final class Card {
    private Rank rank;
    private Suite suite;
    private boolean faceUp;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public void turnOver(){
        faceUp = !faceUp;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Card card = (Card) obj;
        return super.equals(obj) || (rank == card.rank && suite == card.suite);
    }
}
