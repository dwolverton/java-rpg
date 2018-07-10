package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.ui.Sprite;

public class BushTile extends TileBase {
	
	public static final BushTile INSTANCE = new BushTile();

	private BushTile() {
		super("Rock", false, Sprite.forMap(1, 2), Sprite.forMap(4, 13));
	}
}
