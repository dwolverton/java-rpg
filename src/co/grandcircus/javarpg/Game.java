package co.grandcircus.javarpg;

import co.grandcircus.javarpg.tiles.BushTile;
import co.grandcircus.javarpg.tiles.GrassTile;
import co.grandcircus.javarpg.tiles.RockTile;
import co.grandcircus.javarpg.tiles.StumpTile;
import co.grandcircus.javarpg.tiles.Tile;
import co.grandcircus.javarpg.tiles.WaterTile;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Screen;
import javafx.stage.Stage;

public abstract class Game extends Application {

    protected abstract void run() throws Exception;
 
    private static final int TILE_SIZE = 32;
    private Map map;
    private Group graphicsRoot;
    private GraphicsContext gc;
    
    protected void init(Map map, int playerX, int playerY) {
    	this.map = map;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	graphicsRoot = new Group();
        primaryStage.setScene(new Scene(graphicsRoot, map.getWidth() * TILE_SIZE, map.getHeight() * TILE_SIZE));
        primaryStage.show();

        new Thread(() -> {
            try {
                this.run();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).start();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()));
        primaryStage.setY(50);
        
        drawMap();
    }
    
    private void drawMap() {
    	if (map == null) {
    		throw new IllegalStateException("init() must be called in default constructor or instance initialization block.");
    	}
    	Canvas canvas = new Canvas(TILE_SIZE * map.getWidth(), TILE_SIZE * map.getHeight());
    	graphicsRoot.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        
        for (int y = 0; y < map.getHeight(); y++) {
        	for (int x = 0; x < map.getWidth(); x++) {
        		drawTile(x, y);
        	}
        }
        
    }
    
    private void drawTile(int x, int y) {
    	Tile tile = map.getTile(x, y);
    	drawSprite(tile.getBaseSprite(), x, y);;
    	if (tile.getAddonSprite() != null) {
    		drawSprite(tile.getAddonSprite(), x, y);
    	}
    }
    
    private void drawSprite(Sprite sprite, int x, int y) {
    	sprite.draw(gc, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
}
