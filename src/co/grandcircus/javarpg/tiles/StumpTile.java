package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public class StumpTile extends TileBase {
	
	public static final StumpTile INSTANCE = new StumpTile();

	private StumpTile() {
		super("Stump", false, Sprite.forMap(1, 2), Sprite.forMap(1, 7));
	}
}
