package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public class RockTile extends TileBase {
	
	public static final RockTile INSTANCE = new RockTile();

	private RockTile() {
		super("Rock", false, Sprite.forMap(1, 2), Sprite.forMap(0, 14));
	}
}
