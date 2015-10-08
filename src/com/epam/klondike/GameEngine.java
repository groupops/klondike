package com.epam.klondike;

import com.epam.exeptions.EndOfGameException;
import com.epam.exeptions.UnpossibleMoveException;
import com.epam.klondike.stocks.Stock;
import com.epam.klondike.stocks.TableauStock;

public interface GameEngine {
    void generateTable();
    void moveCard(Stock from, Stock to) throws UnpossibleMoveException, EndOfGameException;
    void moveManyCards(TableauStock from, TableauStock to, int count) throws UnpossibleMoveException;
    void takeOneFromStockDown() throws UnpossibleMoveException;
    void resetStockDown() throws UnpossibleMoveException;
}
