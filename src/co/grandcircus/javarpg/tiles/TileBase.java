package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.Sprite;

public class TileBase implements Tile {
	
	private String name;
	private boolean canEnter;
	private Sprite baseSprite;
	private Sprite addonSprite;

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
