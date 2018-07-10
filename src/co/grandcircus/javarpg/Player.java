package co.grandcircus.javarpg;

import co.grandcircus.javarpg.events.EventListener;
import co.grandcircus.javarpg.events.MapChangeEvent;
import co.grandcircus.javarpg.events.PlayerMoveEvent;
import co.grandcircus.javarpg.events.PlayerTurnEvent;
import co.grandcircus.javarpg.tiles.FlowerTile;
import co.grandcircus.javarpg.tiles.Tile;
import co.grandcircus.javarpg.tiles.Tiles;

public class Player {
	
	private Map map;
	private int x, y;
	private Direction direction;
	EventListener eventListener;
	
	protected Player(Map map, EventListener eventListener, int x, int y, Direction direction) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.eventListener = eventListener;
	}

	public void moveForward() throws MovementException {
		if (!tryMoveForward()) {
			throw new MovementException("Cannot move into " + lookAhead().getName());
		}
	}
	
	public boolean tryMoveForward() {
		if (lookAhead().isCanEnter()) {
			x += direction.getX();
			y += direction.getY();
			eventListener.handleEvent(new PlayerMoveEvent(x, y, direction));
			return true;
		} else {
			return false;
		}
	}
	
	public void turnLeft() {
		direction = direction.getLeft();
		eventListener.handleEvent(new PlayerTurnEvent(x, y, direction));
	}
	
	public void turnRight() {
		direction = direction.getRight();
		eventListener.handleEvent(new PlayerTurnEvent(x, y, direction));
	}
	
	public Tile lookDown() {
		return map.getTile(x, y);
	}
	
	public Tile lookAhead() {
		return map.getTile(x + direction.getX(), y + direction.getY());
	}
	
	public Tile lookLeft() {
		return map.getTile(x + direction.getLeft().getX(), y + direction.getLeft().getY());
	}
	
	public Tile lookRight() {
		return map.getTile(x + direction.getRight().getX(), y + direction.getRight().getY());
	}
	
	public void plantFlower(String color) {
		Tile flower = FlowerTile.forColor(color);
		map.setTile(x, y, flower);
		eventListener.handleEvent(new MapChangeEvent(x, y, flower));
	}
	
	public void pickFlower() {
		map.setTile(x, y, Tiles.GRASS);
		eventListener.handleEvent(new MapChangeEvent(x, y, Tiles.GRASS));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return direction;
	}

}
