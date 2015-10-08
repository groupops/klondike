package com.epam.klondike;

import com.epam.exeptions.UnpossibleMoveException;
import com.epam.klondike.stocks.Stock;

public class GameTable {

    public Stock stockDown, stockUp;
    public Stock[] foundationStocks;
    public Stock[] tableauStocks;
    
    public String getState() throws UnpossibleMoveException {
        String state = 
                "StockDown size: " + stockDown.size() +
                "\nStockUp card: " + stockUp.peekCard() +
                "\nFoundation1: " + foundationStocks[0].peekCard() +
                "\nFoundation2: " + foundationStocks[1].peekCard() +
                "\nFoundation3: " + foundationStocks[2].peekCard() +
                "\nFoundation4: " + foundationStocks[3].peekCard() +
                "\nTableau1: " + tableauStocks[0].peekCard() +
                "\nTableau2: " + tableauStocks[1].peekCard() +
                "\nTableau3: " + tableauStocks[2].peekCard() +
                "\nTableau4: " + tableauStocks[3].peekCard() +
                "\nTableau5: " + tableauStocks[4].peekCard() +
                "\nTableau6: " + tableauStocks[5].peekCard() +
                "\nTableau7: " + tableauStocks[6].peekCard();
       return state;
    }
}
