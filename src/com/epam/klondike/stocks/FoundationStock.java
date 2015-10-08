package com.epam.klondike.stocks;

import java.util.Stack;

import com.epam.card.Card;
import com.epam.card.Rank;
import com.epam.exeptions.UnpossibleMoveException;

public class FoundationStock implements Stock {

    private Stack<Card> cards = new Stack<Card>();

    @Override
    public Card getCard() {
        return cards.pop();
    }

    @Override
    public void putCard(Card card) throws UnpossibleMoveException {
        validatePut(card);
        cards.push(card);
    }

    private void validatePut(Card card) throws UnpossibleMoveException {

        if (cards.size() == 0)
            return;
        else if (!cards.peek().getColor().equals(card.getColor()))
            throw new UnpossibleMoveException("Can't place: " + card + " on Foundation card: " + cards.peek() + "wrong color.");
        else if(cards.peek().getRank().ordinal() - card.getRank().ordinal() != 1)
            throw new UnpossibleMoveException("Can't place: " + card + " on Foundation card: " + cards.peek() + 
                    "Must be: " + Rank.values()[cards.peek().getRank().ordinal()+1]);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card peekCard() {
        return cards.peek();
    }

}
