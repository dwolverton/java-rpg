package co.grandcircus.javarpg;

import co.grandcircus.javarpg.ui.EventDelayer;
import co.grandcircus.javarpg.ui.Renderer;
import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Game extends Application {

    protected abstract void run(Player player, Map map) throws Exception;

    
    private Map map;
    private Player player;
    private Renderer renderer;
    private EventDelayer delayer;
    
    protected void init(Map map, int playerX, int playerY, Direction playerDirection) {
    	this.renderer = new Renderer();
    	this.delayer = new EventDelayer(renderer, 400);
    	this.map = map;
    	this.player = new Player(map, delayer, playerX, playerY, playerDirection);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	if (renderer == null) {
    		throw new IllegalStateException("init() must be called in default constructor or instance initialization block.");
    	}
    	renderer.init(primaryStage);
    	renderer.drawMap(map);
    	renderer.drawPlayer(player.getX(), player.getY(), player.getDirection());

        new Thread(() -> {
            try {
                this.run(player, map);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }
}
