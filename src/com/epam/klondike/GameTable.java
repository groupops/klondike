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
                "\nStockUp card: " + (stockUp.size()==0 ? "empty" : stockUp.peekCard()) +
                "\nFoundation1: " + (foundationStocks[0].size()==0 ? "empty" : foundationStocks[0].peekCard()) +
                "\nFoundation2: " + (foundationStocks[1].size()==0 ? "empty" : foundationStocks[1].peekCard()) +
                "\nFoundation3: " + (foundationStocks[2].size()==0 ? "empty" : foundationStocks[2].peekCard()) +
                "\nFoundation4: " + (foundationStocks[3].size()==0 ? "empty" : foundationStocks[3].peekCard()) +
                "\nTableau1: " + (tableauStocks[0].size()==0 ? "empty" : tableauStocks[0].peekCard()) +
                "\nTableau2: " + (tableauStocks[1].size()==0 ? "empty" : tableauStocks[1].peekCard()) +
                "\nTableau3: " + (tableauStocks[2].size()==0 ? "empty" : tableauStocks[2].peekCard()) +
                "\nTableau4: " + (tableauStocks[3].size()==0 ? "empty" : tableauStocks[3].peekCard()) +
                "\nTableau5: " + (tableauStocks[4].size()==0 ? "empty" : tableauStocks[4].peekCard()) +
                "\nTableau6: " + (tableauStocks[5].size()==0 ? "empty" : tableauStocks[5].peekCard()) +
                "\nTableau7: " + (tableauStocks[6].size()==0 ? "empty" : tableauStocks[6].peekCard());
       return state;
    }
}
