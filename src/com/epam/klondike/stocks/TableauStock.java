package com.epam.klondike.stocks;

import java.util.Queue;

import com.epam.card.Card;
import com.epam.exeptions.UnpossibleMoveException;

public interface TableauStock extends Stock{

    Queue<Card> getManyCards(int count) throws UnpossibleMoveException;
    void putManyCards(Queue<Card> cards) throws UnpossibleMoveException;
    void faceUpCard() throws UnpossibleMoveException;
}
