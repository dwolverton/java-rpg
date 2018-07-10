package co.grandcircus.javarpg.events;

import co.grandcircus.javarpg.tiles.Tile;

public class MapChangeEvent implements Event {
	
	private int x, y;
	private Tile tile;
	
	public MapChangeEvent(int x, int y, Tile tile) {
		super();
		this.x = x;
		this.y = y;
		this.tile = tile;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Tile getTile() {
		return tile;
	}
	
}
