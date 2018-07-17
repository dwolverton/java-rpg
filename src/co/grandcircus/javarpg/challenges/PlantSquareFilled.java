package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class PlantSquareFilled implements GameRunner {
	
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
	}

	@Override
	public void run(Player player, Map map) {
		
		for (int length = 5; length > 0; length -= 2) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < length; j++) {
					player.plantFlower("yellow");
					if (i != 3 || j != length - 1) {
						player.moveForward();
					}
				}
				player.turnRight();
			}
			player.moveForward();
		}

//		for (int length = 5; length > 0; length--) {
//			player.moveForward();
//			player.plantFlower("yellow");
//			for (int i = 0; i < 4; i++) {
//				if (i == 3) {
//					length--;
//				}
//				for (int j = 0; j < length; j++) {
//					player.moveForward();
//					player.plantFlower("yellow");
//				}
//				player.turnRight();
//			}
//		}
	}
		
}
