package com.epam.klondike;

import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.card.Card;
import com.epam.card.Color;
import com.epam.card.Rank;
import com.epam.exeptions.EndOfGameException;
import com.epam.exeptions.UnpossibleMoveException;
import com.epam.klondike.stocks.FoundationStock;
import com.epam.klondike.stocks.Stock;
import com.epam.klondike.stocks.StockDown;
import com.epam.klondike.stocks.StockUp;
import com.epam.klondike.stocks.TableauStock;

public class GameEngineImpl implements GameEngine {

    private static final Logger LOGGER = Logger.getLogger(GameEngineImpl.class.getName());

    private GameTable gameTable;
    
    public GameEngineImpl(GameTable gameTable) {
        this.gameTable = gameTable;
    }
    
    @Override
    public void generateTable() {
        generateStocks();
        shuffle(generateDeck());
    }

    @Override
    public void moveCard(Stock from, Stock to) throws UnpossibleMoveException, EndOfGameException {
        Card card;
        card = from.getCard();
        to.putCard(card);
        checkIfWon();
    }

    @Override
    public void moveManyCards(TableauStock from, TableauStock to, int count) throws UnpossibleMoveException {
        Queue<Card> cards;
        cards = from.getManyCards(count);
        to.putManyCards(cards);
    }

    @Override
    public void takeOneFromStockDown() throws UnpossibleMoveException {
        Card card;
        card = gameTable.stockDown.getCard();
        gameTable.stockUp.putCard(card);
    }

    @Override
    public void resetStockDown() throws UnpossibleMoveException {
        for(int i=0; i<gameTable.stockUp.size(); i++)
            ((StockDown)gameTable.stockDown).addCard(gameTable.stockUp.getCard());
    }

    private void generateStocks() {
        gameTable.stockDown = new StockDown();
        gameTable.stockUp = new StockUp();
        
        gameTable.foundationStocks = new Stock[4];
        gameTable.tableauStocks = new Stock[7];
        
        for (int i = 0; i < 4; i++)
            gameTable.foundationStocks[i] = new FoundationStock();
        for (int i = 0; i < 7; i++)
            gameTable.tableauStocks[i] = new FoundationStock();
    }

    private Stack<Card> generateDeck() {
        Stack<Card> cards = new Stack<Card>();
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(color, rank));
            }
        }
        return cards;
    }

    private void shuffle(Stack<Card> cards) {
        Collections.shuffle(cards);

        for (int stockCounter = 0; stockCounter < 7; stockCounter++) {
            Stock stock = gameTable.tableauStocks[stockCounter];
            for (int cardCounter = 0; cardCounter <= stockCounter; cardCounter++) {
                try {
                    Card card = cards.pop();
                    stock.putCard(card);
                    if(cardCounter == stockCounter){
                        card.setFaceUp(true);
                    }
                } catch (UnpossibleMoveException e) {
                    LOGGER.log(Level.SEVERE, "Unpossible move during shuffle");
                }
            }
        }
        
        for(Card card : cards){
            try {
                gameTable.stockDown.putCard(card);
            } catch (UnpossibleMoveException e) {
                LOGGER.log(Level.SEVERE, "Unpossible move during shuffle");
            }
        }
    }

    private void checkIfWon() throws EndOfGameException {
        for(Stock stock : gameTable.foundationStocks){
            if(stock.size() != 13)
                break;
        }
        throw new EndOfGameException("CONGRATULATIONS! YOU WON!");
    }
}
