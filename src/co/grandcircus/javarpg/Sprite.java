package co.grandcircus.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	
	private static final Image MAP_TILES_IMAGE = new Image("co/grandcircus/javarpg/resources/maptiles.png");
	
	private Image image;
	private int x;
	private int y;
	
	public static final int TILE_SIZE = 32;
	
	public static Sprite forMap(int x, int y) {
		return new Sprite(MAP_TILES_IMAGE, x, y);
	}

	private Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public void draw(GraphicsContext gc, double x, double y, double width, double height) {
		gc.drawImage(this.image,
    			this.x * TILE_SIZE, this.y * TILE_SIZE, TILE_SIZE, TILE_SIZE,
    			x, y, width, height);
	}
	
	
}
