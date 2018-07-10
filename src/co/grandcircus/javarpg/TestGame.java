package co.grandcircus.javarpg;

public class TestGame extends Game {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	{
		init(Maps.COAST, 1, 1, Direction.EAST);
	}

	@Override
	protected void run(Player player, Map map) throws Exception {
		for (int i = 0; i < 8; i++) {
			player.moveForward();
			player.moveForward();
			player.turnRight();
		}
	}
		
}
