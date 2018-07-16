package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class SignPosts implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.stumpsAndRocks());
		config.setPlayerStart(1, 1, Direction.EAST);
		config.setAutoStart(false);
		config.setScale(2);
	}

	@Override
	public void run(Player player, Map map) {
		while (player.lookDown() != Tiles.RED_FLOWER) {
			player.moveForward();
			if (player.lookAhead() == Tiles.ROCK) {
				player.turnLeft();
			} else if (player.lookAhead() == Tiles.STUMP) {
				player.turnRight();
			}
		}
	}
		
}
