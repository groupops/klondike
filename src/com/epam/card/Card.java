package com.epam.card;

public final class Card {
    private final Color color;
    private final Rank rank;
    private boolean faceUp;

    public Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public Color getColor() {
        return color;
    }

    public Rank getRank() {
        return rank;
    }
    
    @Override
    public String toString(){
        return color + " " + rank + " " + (faceUp ? "faceUp" : "faceDown");
    }
}
