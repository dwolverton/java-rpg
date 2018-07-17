package co.grandcircus.javarpg;

import co.grandcircus.javarpg.events.Event;
import co.grandcircus.javarpg.events.EventBus;
import co.grandcircus.javarpg.events.EventListener;
import co.grandcircus.javarpg.events.StartEvent;
import co.grandcircus.javarpg.ui.EventDelayer;
import co.grandcircus.javarpg.ui.Renderer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application implements EventListener {
	
    private EventBus eventBus = new EventBus();
    private Renderer renderer;
    private EventDelayer delayer;
    private Player player;
    
    private static GameRunner runner;
    private GameConfig config = new GameConfig();

	public static void launch(GameRunner runner) {
		Game.runner = runner;
		launch(new String[0]);
	}
	
	public static void launch() {
		// determine the main class automatically, create and instance and call launch(GameRunner)
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String mainClassName = stackTrace[stackTrace.length - 1].getClassName();

        try {
            Class<?> mainClass = Class.forName(mainClassName, false,
                               Thread.currentThread().getContextClassLoader());
            if (GameRunner.class.isAssignableFrom(mainClass)) {
                launch((GameRunner) mainClass.newInstance());
            } else {
                throw new RuntimeException("Error: To start a game, " + mainClass
                        + " must implement the GameRunner interface.");
            }
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
	}
    
    private void start() {
    	new Thread(() -> {
            try {
                runner.run(player, config.getMap());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }

    @Override
    public final void start(Stage primaryStage) throws Exception {
    	runner.setup(config);
    	
    	if (config.getMap() == null) {
    		throw new IllegalStateException("setMap() must be called in the setup method.");
    	}
    	if (config.getPlayerStartDirection() == null) {
    		throw new IllegalStateException("setPlayerStart() must be called in the setup method.");
    	}
    	
    	eventBus.register(this);
    	renderer = new Renderer(eventBus, config.getScale(), config.isShowPath());
    	delayer = new EventDelayer(eventBus, config.getTickDelayInMillis());
    	eventBus.register(renderer);
    	
    	config.getMap().setEventListener(delayer);
    	this.player = new Player(config.getMap(), delayer, config.getPlayerStartX(), config.getPlayerStartY(), config.getPlayerStartDirection());
    	
    	renderer.init(primaryStage);
    	renderer.drawMap(config.getMap());
    	renderer.placePlayer(player.getX(), player.getY(), player.getDirection());
    	
    	if (config.isAutoStart()) {
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
