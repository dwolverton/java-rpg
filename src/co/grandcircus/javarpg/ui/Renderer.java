package co.grandcircus.javarpg.ui;

import co.grandcircus.javarpg.Direction;
import co.grandcircus.javarpg.Map;
import co.grandcircus.javarpg.events.Event;
import co.grandcircus.javarpg.events.EventListener;
import co.grandcircus.javarpg.events.MapChangeEvent;
import co.grandcircus.javarpg.events.PlayerChangeEvent;
import co.grandcircus.javarpg.events.StartEvent;
import co.grandcircus.javarpg.tiles.Tile;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Renderer implements EventListener {
	
	public static final int TILE_SIZE = 32;
	
	private Pane pane = new Pane();
    private Canvas mapCanvas = new Canvas();
    private Canvas pathCanvas = new Canvas();
    private Canvas playerCanvas = new Canvas();
    private EventListener eventListener;
    private Label startLabel = new Label("Click to Start");
    
    private int lastPlayerX, lastPlayerY;
    
    public Renderer(EventListener eventListener) {
		this.eventListener = eventListener;
	}

	public void init(Stage primaryStage) {
    	Group root = new Group();
        primaryStage.setScene(new Scene(root, 10 * TILE_SIZE, 10 * TILE_SIZE));
        primaryStage.show();
        
        pane.getChildren().add(mapCanvas);
        pane.getChildren().add(pathCanvas);
        pane.getChildren().add(playerCanvas);
        pane.getChildren().add(startLabel);
        startLabel.setPrefSize(10 * TILE_SIZE, 8 * TILE_SIZE);
        startLabel.setFont(Font.font(42));
        startLabel.setAlignment(Pos.CENTER);
        startLabel.setTextFill(new Color(1, 1, 1, .7));
        
        root.getChildren().add(pane);
        pane.setOnMouseClicked((MouseEvent event) -> eventListener.handleEvent(new StartEvent()));
        
        pathCanvas.getGraphicsContext2D().setLineWidth(4);
        pathCanvas.getGraphicsContext2D().setStroke(Color.web("#87CEFA", .7));

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()));
        primaryStage.setY(50);
    }

    public void drawMap(Map map) {
    	mapCanvas.setWidth(TILE_SIZE * map.getWidth());
    	mapCanvas.setHeight(TILE_SIZE * map.getHeight());
    	pathCanvas.setWidth(TILE_SIZE * map.getWidth());
    	pathCanvas.setHeight(TILE_SIZE * map.getHeight());
    	playerCanvas.setWidth(TILE_SIZE * map.getWidth());
    	playerCanvas.setHeight(TILE_SIZE * map.getHeight());
        
        for (int y = 0; y < map.getHeight(); y++) {
        	for (int x = 0; x < map.getWidth(); x++) {
            	Tile tile = map.getTile(x, y);
        		drawTile(tile, x, y);
        	}
        }
    }
    
    public void placePlayer(int x, int y, Direction direction) {
    	clearCanvas(pathCanvas);
    	drawPlayer(x, y, direction);
    	lastPlayerX = x;
    	lastPlayerY = y;
    	pathCanvas.getGraphicsContext2D().strokeOval(x * TILE_SIZE + 4, y * TILE_SIZE + 4, TILE_SIZE - 8, TILE_SIZE - 8);
    }
    
    private void drawPlayer(int x, int y, Direction direction) {
    	clearCanvas(playerCanvas);
    	drawSprite(playerCanvas, PlayerSprites.forDirection(direction), x, y);
    }
    
    private void drawTile(Tile tile, int x, int y) {
    	drawSprite(mapCanvas, tile.getBaseSprite(), x, y);;
    	if (tile.getAddonSprite() != null) {
    		drawSprite(mapCanvas, tile.getAddonSprite(), x, y);
    	}
    }
    
    private void drawPathTo(int x, int y) {
    	pathCanvas.getGraphicsContext2D().strokeLine((lastPlayerX + .5) * TILE_SIZE, (lastPlayerY + .5) * TILE_SIZE, (x +.5)  * TILE_SIZE, (y + .5) * TILE_SIZE);
    	lastPlayerX = x;
    	lastPlayerY = y;
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
    		drawPathTo(e.getX(), e.getY());
    		drawPlayer(e.getX(), e.getY(), e.getDirection());
    	} else if (event instanceof MapChangeEvent) {
    		MapChangeEvent e = (MapChangeEvent) event;
    		drawTile(e.getTile(), e.getX(), e.getY());
    	} else if (event instanceof StartEvent) {
    		pane.getChildren().remove(startLabel);
    	}
    }
}
