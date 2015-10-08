package com.epam.klondike.stocks;

import java.util.Stack;

import com.epam.card.Card;
import com.epam.exeptions.UnpossibleMoveException;

public class StockDown implements Stock {

    private Stack<Card> cards = new Stack<Card>();
    private boolean ready; 
    
    @Override
    public Card getCard() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("The stock is empty");
        return cards.pop();
    }

    public void putCard(Card card) throws UnpossibleMoveException {
        card.setFaceUp(false);
        validatePut(card);
        cards.push(card);
    }

    private void validatePut(Card card) throws UnpossibleMoveException {
        if (ready)
            throw new UnpossibleMoveException("You can't add cards to stockDown");
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card peekCard() throws UnpossibleMoveException {
        throw new UnpossibleMoveException("You can't peek this stock, you little cheater:)");
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
