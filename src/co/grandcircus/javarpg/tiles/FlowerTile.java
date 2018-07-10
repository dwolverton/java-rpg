package co.grandcircus.javarpg.tiles;

import co.grandcircus.javarpg.ui.Sprite;

public class FlowerTile extends TileBase {
	
	public static final FlowerTile RED_INSTANCE = new FlowerTile();
	public static final FlowerTile YELLOW_INSTANCE = new FlowerTile();
	
	static {
		RED_INSTANCE.name = "Red Flower";
		RED_INSTANCE.addonSprite = Sprite.forMap(1, 8);
		YELLOW_INSTANCE.name = "Yellow Flower";
		YELLOW_INSTANCE.addonSprite = Sprite.forMap(2, 8);
	}
	
	private FlowerTile() {
		super(null, true, Sprite.forMap(1, 2));
	}

	public static FlowerTile forColor(String color) {
		if ("red".equalsIgnoreCase(color)) {
			return RED_INSTANCE;
		} else if ("yellow".equalsIgnoreCase(color)) {
			return YELLOW_INSTANCE;
		} else {
			throw new IllegalArgumentException("FlowerTile color must be 'red' or 'yellow'.");
		}
	}
}
