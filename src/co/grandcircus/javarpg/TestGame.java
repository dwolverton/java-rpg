package co.grandcircus.javarpg;

import java.util.Scanner;

public class TestGame extends Game {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	protected void setup() {
		setMap(Maps.COAST);
		setPlayerStart(0, 1, Direction.EAST);
		setAutoStart(true);
	}

	@Override
	protected void run(Player player, Map map) {
//		Scanner scnr = new Scanner(System.in);
//		
//		System.out.println("How far?");
//		int distance = scnr.nextInt();
//		for (int i = 0; i < distance; i++) {
//			player.moveForward();
//		}
//		player.turnRight();
//		
//		System.out.println("How far?");
//		distance = scnr.nextInt();
//		for (int i = 0; i < distance; i++) {
//			player.moveForward();
//		}
		
//		String color = "red";
//		do {
//			player.plantFlower(color);
//			color = color == "red" ? "yellow" : "red";
//		} while (player.tryMoveForward());
		
		
		player.plantFlower("yellow");
		player.moveForward();
		player.pickFlower();
		player.plantFlower("red");
//		player.turnRight();
//		
//		while (player.lookAhead().isCanEnter()) {
//			player.moveForward();
//			player.plantFlower("red");
//		}
		
		
		for (int i = 0; i < 8; i++) {
			player.moveForward();
			player.moveForward();
			player.turnRight();
		}
//		while (player.tryMoveForward()) {
//		}
//		player.turnLeft();
//		player.moveForward();
	}
		
}
