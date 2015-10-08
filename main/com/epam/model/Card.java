package com.epam.model;

public class Card {

	private final Color color;
	private final Mark mark;
	private boolean open;
	
	public Card(Color color, Mark mark, boolean open) {
		this.color = color;
		this.mark = mark;
		this.open = open;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Color getColor() {
		return color;
	}

	public Mark getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + (open ? 1231 : 1237);
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
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (mark != other.mark)
			return false;
		if (open != other.open)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", mark=" + mark + ", open=" + open + "]";
	}
	
}
