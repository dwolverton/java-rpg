package co.grandcircus.javarpg;

import java.util.Scanner;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.GameConfig;
import co.grandcircus.javarpg.GameRunner;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.Maps;
import co.grandcircus.javarpg.Player;

public class TestGame implements GameRunner {
	
	public static void main(String[] args) {
		Game.launch();
	}
	
	@Override
	public void setup(GameConfig config) {
		config.setMap(Maps.COAST);
		config.setPlayerStart(0, 1, Direction.EAST);
		config.setAutoStart(false);
		config.setScale(2.5);
	}

	@Override
	public void run(Player player, Map map) {
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
		
		
//		for (int i = 0; i < 8; i++) {
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
