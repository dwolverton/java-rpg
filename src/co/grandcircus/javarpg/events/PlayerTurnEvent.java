package co.grandcircus.javarpg.events;

import co.grandcircus.javarpg.Direction;

public class PlayerTurnEvent extends PlayerChangeEvent {

	public PlayerTurnEvent(int x, int y, Direction direction) {
		super(x, y, direction);
	}

}
