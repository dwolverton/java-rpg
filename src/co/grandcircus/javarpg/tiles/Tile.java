package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public interface Tile {
	
	String getName();
	boolean isCanEnter();
	Sprite getBaseSprite();
	Sprite getAddonSprite();
}
