package co.grandcircus.javarpg.ui;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Game;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.events.Event;
import co.grandcircus.javarpg.events.EventListener;
import co.grandcircus.javarpg.events.MapChangeEvent;
import co.grandcircus.javarpg.events.PlayerChangeEvent;
import co.grandcircus.javarpg.tiles.Tile;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Renderer implements EventListener {
	
	public static final int TILE_SIZE = 32;
	
    private Canvas mapCanvas = new Canvas();
    private Canvas playerCanvas = new Canvas();
    private Game game;
    
    public Renderer(Game game) {
		this.game = game;
	}

	public void init(Stage primaryStage) {
    	Group root = new Group();
        primaryStage.setScene(new Scene(root, 10 * TILE_SIZE, 10 * TILE_SIZE));
        primaryStage.show();
        
        Pane pane = new Pane();
        pane.getChildren().add(mapCanvas);
        pane.getChildren().add(playerCanvas);
        root.getChildren().add(pane);
        pane.setOnMouseClicked((MouseEvent event) -> game.start());

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()));
        primaryStage.setY(50);
    }

    public void drawMap(Map map) {
    	mapCanvas.setWidth(TILE_SIZE * map.getWidth());
    	mapCanvas.setHeight(TILE_SIZE * map.getHeight());
    	playerCanvas.setWidth(TILE_SIZE * map.getWidth());
    	playerCanvas.setHeight(TILE_SIZE * map.getHeight());
        
        for (int y = 0; y < map.getHeight(); y++) {
        	for (int x = 0; x < map.getWidth(); x++) {
            	Tile tile = map.getTile(x, y);
        		drawTile(tile, x, y);
        	}
        }
    }
    
    public void drawPlayer(int x, int y, Direction direction) {
    	clearCanvas(playerCanvas);
    	drawSprite(playerCanvas, PlayerSprites.forDirection(direction), x, y);
    }
    
    private void drawTile(Tile tile, int x, int y) {
    	drawSprite(mapCanvas, tile.getBaseSprite(), x, y);;
    	if (tile.getAddonSprite() != null) {
    		drawSprite(mapCanvas, tile.getAddonSprite(), x, y);
    	}
    }
    
    private void drawSprite(Canvas canvas, Sprite sprite, int x, int y) {
    	sprite.draw(canvas.getGraphicsContext2D(), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
    
    private void clearCanvas(Canvas canvas) {
    	canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    @Override
    public void handleEvent(Event event) {
    	if (event instanceof PlayerChangeEvent) {
    		PlayerChangeEvent e = (PlayerChangeEvent) event;
    		drawPlayer(e.getX(), e.getY(), e.getDirection());
    	} else if (event instanceof MapChangeEvent) {
    		MapChangeEvent e = (MapChangeEvent) event;
    		drawTile(e.getTile(), e.getX(), e.getY());
    	}
    }
}
