package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public class WaterTile extends TileBase {
	
	public static final WaterTile INSTANCE = new WaterTile();

	private WaterTile() {
		super("Water", false, Sprite.forMap(5, 21));
	}
}
