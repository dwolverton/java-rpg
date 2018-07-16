package co.grandcircus.javarpg.challenges;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;
import co.grandcircus.javarpg.tiles.Tiles;

public class TrailOfFlowers implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.trailOfFlowers());
		config.setPlayerStart(1, 1, Direction.EAST);
		config.setAutoStart(false);
		config.setScale(1.5);
	}

	@Override
	public void run(Player player, Map map) {
		while (player.lookDown() != Tiles.RED_FLOWER) {
			if (player.lookLeft() == Tiles.YELLOW_FLOWER) {
				player.turnLeft();
			} else if (player.lookRight() == Tiles.YELLOW_FLOWER) {
				player.turnRight();
			}
			player.moveForward();
		}
	}
		
}
