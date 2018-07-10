package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.ui.Sprite;

public class TileBase implements Tile {
	
	protected String name;
	protected boolean canEnter;
	protected Sprite baseSprite;
	protected Sprite addonSprite;

	protected TileBase(String name, boolean canEnter, Sprite baseSprite) {
		this.name = name;
		this.canEnter = canEnter;
		this.baseSprite = baseSprite;
	}

	protected TileBase(String name, boolean canEnter, Sprite baseSprite, Sprite addonSprite) {
		this.name = name;
		this.canEnter = canEnter;
		this.baseSprite = baseSprite;
		this.addonSprite = addonSprite;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isCanEnter() {
		return canEnter;
	}

	@Override
	public Sprite getBaseSprite() {
		return baseSprite;
	}

	@Override
	public Sprite getAddonSprite() {
		return addonSprite;
	}

}
