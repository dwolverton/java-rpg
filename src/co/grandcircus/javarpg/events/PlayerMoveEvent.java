package co.grandcircus.javarpg.events;

import co.grandcircus.javarpg.Direction;

public class PlayerMoveEvent extends PlayerChangeEvent {

	public PlayerMoveEvent(int x, int y, Direction direction) {
		super(x, y, direction);
	}
	
}
