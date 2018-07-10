package co.grandcircus.javarpg.events;

import co.grandcircus.javarpg.Direction;

public class PlayerChangeEvent implements Event {
	
	private int x, y;
	private Direction direction;

	protected PlayerChangeEvent(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return direction;
	}
	
	
}
