package co.grandcircus.javarpg.ui;

import co.grandcircus.javarpg.Direction;

public class PlayerSprites {

	public static final Sprite NORTH = Sprite.forPlayer(0, 0);
	public static final Sprite EAST = Sprite.forPlayer(1, 0);
	public static final Sprite SOUTH = Sprite.forPlayer(2, 0);
	public static final Sprite WEST = Sprite.forPlayer(3, 0);
	
	public static Sprite forDirection(Direction dir) {
		switch (dir) {
			case NORTH: return NORTH;
			case EAST: return EAST;
			case SOUTH: return SOUTH;
			case WEST: return WEST;
			default:
				return null;
		}
	}
}
