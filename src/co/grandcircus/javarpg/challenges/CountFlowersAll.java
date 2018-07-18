package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class CountFlowersAll implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.flowers());
		config.setPlayerStart(0, 0, Direction.EAST);
		config.setAutoStart(true);
		config.setScale(2);
		config.setSpeed1To10(10);
		config.setShowPath(false);
	}

	@Override
	public void run(Player player, Map map) {
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			if (player.lookDown() == Tiles.RED_FLOWER || player.lookDown() == Tiles.YELLOW_FLOWER) {
				count++;
			}
			if (!player.tryMoveForward()) {
				if (i / 10 % 2 == 0) {
					player.turnRight();
					player.tryMoveForward();
					player.turnRight();
				} else {
					player.turnLeft();
					player.tryMoveForward();
					player.turnLeft();
				}
			}
		}
		
		System.out.println(count);
	}
		
}
