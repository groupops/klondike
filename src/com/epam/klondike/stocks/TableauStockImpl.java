package com.epam.klondike.stocks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.epam.card.Card;
import com.epam.card.Color;
import com.epam.card.Rank;
import com.epam.exeptions.UnpossibleMoveException;

public class TableauStockImpl implements TableauStock {

    private Stack<Card> cards = new Stack<Card>();
    private boolean ready;
    
    @Override
    public Card getCard() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("The stock is empty");
        return cards.pop();
    }

    @Override
    public void putCard(Card card) throws UnpossibleMoveException {
        validatePut(card);
        cards.push(card);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card peekCard() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("The stock is empty");
        return cards.peek();
    }

    @Override
    public Queue<Card> getManyCards(int count) throws UnpossibleMoveException {
        validateGetMany(count);
        Queue<Card> cards = new LinkedList<Card>();
        for (int i = 0; i < count; i++) {
            cards.add(this.cards.pop());
        }
        return cards;
    }

    @Override
    public void putManyCards(Queue<Card> cards) throws UnpossibleMoveException {
        validateAddMany(cards);
        this.cards.addAll(cards);
    }

    @Override
    public void faceUpCard() throws UnpossibleMoveException {
        validateFaceUp();
        cards.peek().setFaceUp(true);
    }

    private void validateFaceUp() throws UnpossibleMoveException {
        if (cards.size() == 0)
            throw new UnpossibleMoveException("Can't faceUp empty stock");
        else if (cards.peek().isFaceUp())
            throw new UnpossibleMoveException("Can't faceUp already facedUp card");
    }

    private void validateGetMany(int count) throws UnpossibleMoveException {
        if (cards.size() < count)
            throw new UnpossibleMoveException("Can't get " + count + " cards from the stock. Not enough cards");
        else if (!cards.elementAt(cards.size() - count).isFaceUp())
            throw new UnpossibleMoveException(
                    "Can't get " + count + " cards from the stock. Not enough faced up cards");
    }

    private void validateAddMany(Queue<Card> cards) throws UnpossibleMoveException {

        Color matchingColor = cards.peek().getColor();
        if (this.cards.size() == 0 && !cards.peek().getRank().equals(Rank.KING))
            throw new UnpossibleMoveException(
                    "Can't put cards with: " + cards.peek() + " on the bottom. Only " + Rank.KING + " is allowed.");
        else if (this.cards.size() != 0) {
            switch (this.cards.peek().getColor()) {
            case CLUB:
                if (matchingColor == Color.DIAMOND || matchingColor == Color.HEART)
                    throw new UnpossibleMoveException("Can't put " + matchingColor + " on " + Color.CLUB);
                break;
            case DIAMOND:
                if (matchingColor == Color.SPADE || matchingColor == Color.CLUB)
                    throw new UnpossibleMoveException("Can't put " + matchingColor + " on " + Color.DIAMOND);
                break;
            case HEART:
                if (matchingColor == Color.SPADE || matchingColor == Color.CLUB)
                    throw new UnpossibleMoveException("Can't put " + matchingColor + " on " + Color.HEART);
                break;
            case SPADE:
                if (matchingColor == Color.DIAMOND || matchingColor == Color.HEART)
                    throw new UnpossibleMoveException("Can't put " + matchingColor + " on " + Color.SPADE);
                break;
            default:
                break;
            }
        }
    }

    private void validatePut(Card card) throws UnpossibleMoveException {
        if (ready && this.cards.size() == 0 && !card.getRank().equals(Rank.KING))
            throw new UnpossibleMoveException(
                    "Can't put cards with: " + card + " on the bottom. Only " + Rank.KING + " is allowed.");
        if (ready && !cards.peek().getColor().equals(card.getColor()))
            throw new UnpossibleMoveException(
                    "Can't place: " + card + " on Foundation card: " + cards.peek() + "wrong color.");
        else if (ready && cards.peek().getRank().ordinal() - card.getRank().ordinal() != 1)
            throw new UnpossibleMoveException("Can't place: " + card + " on Foundation card: " + cards.peek()
                    + "Must be: " + Rank.values()[cards.peek().getRank().ordinal() + 1]);
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
