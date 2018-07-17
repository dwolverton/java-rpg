package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class PlantTriangleOutline implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.plain());
		config.setPlayerStart(2, 2, Direction.EAST);
		config.setAutoStart(true);
		config.setScale(2);
		config.setSpeed1To10(10);
		config.setShowPath(false);
	}

	@Override
	public void run(Player player, Map map) {
		for (int i = 0; i < 6; i++) {
			player.plantFlower("yellow");
			player.moveForward();
			player.turnRight();
			player.moveForward();
			player.turnLeft();
		}
		player.turnRight();
		for (int j = 0; j < 2; j++) {
			player.turnRight();
			for (int i = 0; i < 6; i++) {
				player.plantFlower("yellow");
				player.moveForward();
			}
		}
	}
		
}
