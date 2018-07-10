package co.grandcircus.javarpg;

public enum Direction {

	NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);
	
	private int x, y;

	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Direction getLeft() {
		switch (this) {
		case NORTH:
			return WEST;
		case EAST:
			return NORTH;
		case SOUTH:
			return EAST;
		case WEST:
			return SOUTH;
		default:
			return null;
		}
	}
	
	public Direction getRight() {
		switch (this) {
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		case WEST:
			return NORTH;
		default:
			return null;
		}
	}
	
	public Direction getReverse() {
		switch (this) {
		case NORTH:
			return SOUTH;
		case EAST:
			return WEST;
		case SOUTH:
			return NORTH;
		case WEST:
			return EAST;
		default:
			return null;
		}
	}
}
