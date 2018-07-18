package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class CountFlowers2 implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.flowers());
		config.setPlayerStart(0, 0, Direction.EAST);
		config.setAutoStart(true);
		config.setScale(2);
		config.setSpeed1To10(5);
	}

	@Override
	public void run(Player player, Map map) {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if (player.lookDown() == Tiles.RED_FLOWER || player.lookDown() == Tiles.YELLOW_FLOWER) {
				count++;
			}
			player.moveForward();
		}
		
		System.out.println(count);
	}
		
}
