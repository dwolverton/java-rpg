package co.grandcircus.javarpg;

import co.grandcircus.javarpg.events.Event;
import co.grandcircus.javarpg.events.EventBus;
import co.grandcircus.javarpg.events.EventListener;
import co.grandcircus.javarpg.events.StartEvent;
import co.grandcircus.javarpg.ui.EventDelayer;
import co.grandcircus.javarpg.ui.Renderer;
import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Game extends Application implements EventListener {
	
	protected abstract void setup();

    protected abstract void run(Player player, Map map);
    
    private EventBus eventBus = new EventBus();
    private Renderer renderer;
    private EventDelayer delayer;
    private Player player;
    
    private Map map;
    private int playerStartX, playerStartY;
    private Direction playerStartDirection;
    private boolean autoStart = false;
    
    protected final void setMap(Map map) {
    	this.map = map;
    }
    
    protected final void setPlayerStart(int playerX, int playerY, Direction playerDirection) {
    	this.playerStartX = playerX;
    	this.playerStartY = playerY;
    	this.playerStartDirection = playerDirection;
    }
    
    protected final void setAutoStart(boolean autoStart) {
    	this.autoStart = autoStart;
    }
    
    
    
    private void start() {
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
    	eventBus.register(this);
    	renderer = new Renderer(eventBus);
    	delayer = new EventDelayer(eventBus, 300);
    	eventBus.register(renderer);
    	
    	setup();
    	if (map == null) {
    		throw new IllegalStateException("setMap() must be called in the setup method.");
    	}
    	if (playerStartDirection == null) {
    		throw new IllegalStateException("setPlayerStart() must be called in the setup method.");
    	}
    	
    	this.player = new Player(map, delayer, playerStartX, playerStartY, playerStartDirection);
    	
    	renderer.init(primaryStage);
    	renderer.drawMap(map);
    	renderer.placePlayer(player.getX(), player.getY(), player.getDirection());
    	
    	if (autoStart) {
    		eventBus.handleEvent(new StartEvent());
    	}
    }

	@Override
	public void handleEvent(Event event) {
		if (event instanceof StartEvent) {
			start();
		}
	}
    
}
