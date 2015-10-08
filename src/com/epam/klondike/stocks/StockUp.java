package com.epam.klondike.stocks;

import java.util.Stack;

import com.epam.card.Card;
import com.epam.exeptions.UnpossibleMoveException;

public class StockUp implements Stock {

    private Stack<Card> cards = new Stack<Card>();
    private boolean ready;

    @Override
    public Card getCard() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("The stock is empty");
        return cards.pop();
    }

    @Override
    public void putCard(Card card) throws UnpossibleMoveException {
        card.setFaceUp(true);
        validatePut(card);
        cards.push(card);
    }

    private void validatePut(Card card) throws UnpossibleMoveException {
        if (!card.isFaceUp())
            throw new UnpossibleMoveException("Can't place: " + card + " on StockDown because it has to be faceDown");
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card peekCard() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("The stock is empty");
        return cards.peek();
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
