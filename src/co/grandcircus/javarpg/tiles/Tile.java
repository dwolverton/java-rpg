package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.ui.Sprite;

public interface Tile {
	
	String getName();
	boolean isCanEnter();
	Sprite getBaseSprite();
	Sprite getAddonSprite();
}
