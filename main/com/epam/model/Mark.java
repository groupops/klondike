package com.epam.model;

public enum Mark {
	ACE(5), SIX(6), SEVEN(7), EIHGT(8), NINE(9), TEN(10), VALET(11), QUEEN(12), KING(13);
	
	private final int value;
	
	Mark(int value) {
		this.value = value;
    }
	
	public int getValue() {
		return value;
	}
	
}
