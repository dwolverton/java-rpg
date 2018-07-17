package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class PlantSquareOutline implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.plain());
		config.setPlayerStart(2, 2, Direction.EAST);
		config.setAutoStart(false);
		config.setScale(2);
		config.setSpeed1To10(10);
	}

	@Override
	public void run(Player player, Map map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				player.plantFlower("yellow");
				player.moveForward();
			}
			player.turnRight();
		}
	}
		
}
