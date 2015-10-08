package com.epam.klondike.stocks;

import com.epam.card.Card;
import com.epam.exeptions.UnpossibleMoveException;

public interface Stock {

    Card getCard() throws UnpossibleMoveException;
    Card peekCard() throws UnpossibleMoveException;
    void putCard(Card card) throws UnpossibleMoveException;
    int size();
    void setReady(boolean ready);
}
