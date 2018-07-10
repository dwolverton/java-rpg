package co.grandcircus.javarpg;

public class TestGame extends Game {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	protected void setup() {
		setMap(Maps.COAST);
		setPlayerStart(1, 1, Direction.EAST);
	}

	@Override
	protected void run(Player player, Map map) {
		player.plantFlower("yellow");
		player.moveForward();
//		player.pickFlower();
//		player.plantFlower("red");
//		player.turnRight();
//		
//		while (player.lookAhead().isCanEnter()) {
//			player.moveForward();
//			player.plantFlower("red");
//		}
		
		
//		for (int i = 0; i < 4; i++) {
//			player.moveForward();
//			player.moveForward();
//			player.turnRight();
//		}
//		while (player.tryMoveForward()) {
//		}
//		player.turnLeft();
//		player.moveForward();
	}
		
}
