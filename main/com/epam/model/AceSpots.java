package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AceSpots {

	private final List<Stack<Card>> spots;

	public AceSpots() {
		this.spots = new ArrayList<Stack<Card>>();
		for (int i = 0; i < 4; i++) {
			spots.add(new Stack<Card>());
		}
	}

	public List<Stack<Card>> getSpots() {
		return spots;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spots == null) ? 0 : spots.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AceSpots other = (AceSpots) obj;
		if (spots == null) {
			if (other.spots != null)
				return false;
		} else if (!spots.equals(other.spots))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AceSpots [spots=" + spots + "]";
	}
	
}
