package co.grandcircus.javarpg.tiles;

public class OutOfBoundsTile extends TileBase {
	
	public static final OutOfBoundsTile INSTANCE = new OutOfBoundsTile();
	
	private OutOfBoundsTile() {
		super("Out of Bounds", false, null);
	}

}
