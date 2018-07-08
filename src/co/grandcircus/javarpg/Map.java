package co.grandcircus.javarpg;

import co.grandcircus.javarpg.tiles.GrassTile;
import co.grandcircus.javarpg.tiles.OutOfBoundsTile;
import co.grandcircus.javarpg.tiles.Tile;

public class Map {

	Tile[] tiles;
	private int width;
	private int height;

	public Map(int width, int height, Tile... tiles) {
		if (tiles.length != width * height) {
			throw new IllegalArgumentException(
					tiles.length + " is not the correct number of tiles for a map of " + width + " * " + height);
		}
		this.width = width;
		this.height = height;
		this.tiles = tiles;
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] == null) {
				tiles[i] = GrassTile.INSTANCE;
			}
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile getTile(int x, int y) {
		if (isOutOfBounds(x, y)) {
			return OutOfBoundsTile.INSTANCE;
		} else {
			return tiles[width * y + x];
		}
	}
	
	private boolean isOutOfBounds(int x, int y) {
		return x < 0 || y < 0 || x >= width || y >= height;
	}
}
