package com.epam.klondike.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.card.Card;
import com.epam.card.Color;
import com.epam.card.Rank;
import com.epam.exeptions.EndOfGameException;
import com.epam.exeptions.UnpossibleMoveException;
import com.epam.klondike.GameEngine;
import com.epam.klondike.GameEngineImpl;
import com.epam.klondike.GameTable;
import com.epam.klondike.stocks.Stock;
import com.epam.klondike.stocks.StockUp;

public class StockTest {
    
    private GameTable gameTable;
    private GameEngine gameEngine;
    
    @Before
    public void prepareTableAndEngine(){
        gameTable = new GameTable();
        gameEngine = new GameEngineImpl(gameTable);
        gameEngine.generateTable();
    }
    
    
    @Test
    public void addToStockUp() throws UnpossibleMoveException, EndOfGameException{
        gameEngine.moveCard(gameTable.stockDown, gameTable.stockUp);
    }
    
}
