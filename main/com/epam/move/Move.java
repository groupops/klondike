package com.epam.move;

import java.util.List;
import java.util.Stack;

import com.epam.model.AceSpots;
import com.epam.model.Card;
import com.epam.model.Mark;


public class Move {

	private AceSpots aceSpots;
	private List<Card> loopSpot;
	private List<List<Card>> mainSpots;
	
	public Move(AceSpots aceSpots, List<Card> loopSpot, List<List<Card>> mainSpots) {
		this.aceSpots = aceSpots;
		this.loopSpot = loopSpot;
		this.mainSpots = mainSpots;
	}
	
	public void moveToAceSpot(Card card) {
		if (card.getMark().equals(Mark.ACE)) {
			for (Stack<Card> aceSpot : aceSpots.getSpots()) {
				if (aceSpot.isEmpty()) {
					aceSpot.push(card);
					return;
				}
			}
		} else {
			for (Stack<Card> aceSpot : aceSpots.getSpots()) {
				if (aceSpot.peek().getMark().getValue() < card.getMark().getValue()) {
					aceSpot.push(card);
					return;
				}
			}
		}
	}
	
}
