package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public class GrassTile extends TileBase {
	
	public static final GrassTile INSTANCE = new GrassTile();

	private GrassTile() {
		super("Grass", true, Sprite.forMap(1, 2));
	}
}
