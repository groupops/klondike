package com.epam.klondike.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.epam.exeptions.EndOfGameException;
import com.epam.exeptions.UnpossibleMoveException;
import com.epam.klondike.GameEngine;
import com.epam.klondike.GameEngineImpl;
import com.epam.klondike.GameTable;

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
    public void printState() throws UnpossibleMoveException, EndOfGameException{
        System.out.println(gameTable.getState());
    }
    
    @Test
    public void moveFromStockDownToStockUp() throws UnpossibleMoveException, EndOfGameException{
        int stockDownSize = gameTable.stockDown.size();
        gameEngine.moveCard(gameTable.stockDown, gameTable.stockUp);
        assertEquals(1, gameTable.stockUp.size());
        assertEquals(stockDownSize-1, gameTable.stockDown.size());
    }
    
}
