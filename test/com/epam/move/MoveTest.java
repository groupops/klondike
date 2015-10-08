package com.epam.move;

import static org.junit.Assert.*;


import org.junit.Test;

import com.epam.model.AceSpots;
import com.epam.model.Card;
import com.epam.model.Color;
import com.epam.model.Mark;

public class MoveTest {

//	we have next objects:
//	- 4 AceSpot
//	- 7 MainSpot
//	- 1 LoopSpot
//  - Card
	
	@Test
	public void aceCanBeMovedToEmptyAceSpot() {
		AceSpots aceSpots = new AceSpots();
		Card card = new Card(Color.BLACK, Mark.ACE, true);
		
		Move move = new Move(aceSpots, null, null);
		move.moveToAceSpot(card);
		
		AceSpots expectedAceSpots = new AceSpots();
		expectedAceSpots.getSpots().get(0).push(card);
		
		assertEquals(expectedAceSpots, aceSpots);
	}
	
	@Test
	public void greaterCardCanBeMovedOnATopOfLowerInAceSpot() {
		AceSpots aceSpots = new AceSpots();
		aceSpots.getSpots().get(0).push(new Card(Color.BLACK, Mark.ACE, true));
		
		Card card = new Card(Color.BLACK, Mark.SIX, true);
		
		Move move = new Move(aceSpots, null, null);
		move.moveToAceSpot(card);
		
		AceSpots expectedAceSpots = new AceSpots();
		expectedAceSpots.getSpots().get(0).push(new Card(Color.BLACK, Mark.ACE, true));
		expectedAceSpots.getSpots().get(0).push(card);
		
		assertEquals(expectedAceSpots, aceSpots);
	}

}
