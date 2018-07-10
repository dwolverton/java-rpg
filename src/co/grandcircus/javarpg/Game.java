package co.grandcircus.javarpg;

import co.grandcircus.javarpg.ui.EventDelayer;
import co.grandcircus.javarpg.ui.Renderer;
import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Game extends Application {
	
	protected abstract void setup();

    protected abstract void run(Player player, Map map);
    
    private Map map;
    private int playerStartX, playerStartY;
    private Direction playerStartDirection;
    private Player player;
    private Renderer renderer;
    private EventDelayer delayer;
    
    protected final void setMap(Map map) {
    	this.map = map;
    }
    
    protected final void setPlayerStart(int playerX, int playerY, Direction playerDirection) {
    	this.playerStartX = playerX;
    	this.playerStartY = playerY;
    	this.playerStartDirection = playerDirection;
    }
    
    public final void start() {
    	new Thread(() -> {
            try {
                this.run(player, map);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }

    @Override
    public final void start(Stage primaryStage) throws Exception {
    	setup();
    	if (map == null) {
    		throw new IllegalStateException("setMap() must be called in the setup method.");
    	}
    	if (playerStartDirection == null) {
    		throw new IllegalStateException("setPlayerStart() must be called in the setup method.");
    	}
    	renderer = new Renderer(this);
    	delayer = new EventDelayer(renderer, 300);
    	this.player = new Player(map, delayer, playerStartX, playerStartY, playerStartDirection);
    	
    	renderer.init(primaryStage);
    	renderer.drawMap(map);
    	renderer.drawPlayer(player.getX(), player.getY(), player.getDirection());
    }
}
