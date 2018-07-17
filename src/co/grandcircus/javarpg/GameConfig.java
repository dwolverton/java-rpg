package co.grandcircus.javarpg;

public class GameConfig {
	
	private Map map;
    private int playerStartX, playerStartY;
    private Direction playerStartDirection;
    private boolean autoStart = false;
    private double scale = 1;
    private int tickDelayInMillis = 300;
    private boolean showPath = true;
    
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setPlayerStart(int playerX, int playerY, Direction playerDirection) {
    	this.playerStartX = playerX;
    	this.playerStartY = playerY;
    	this.playerStartDirection = playerDirection;
    }
	public int getPlayerStartX() {
		return playerStartX;
	}
	public int getPlayerStartY() {
		return playerStartY;
	}
	public Direction getPlayerStartDirection() {
		return playerStartDirection;
	}
	public boolean isAutoStart() {
		return autoStart;
	}
	public void setAutoStart(boolean autoStart) {
		this.autoStart = autoStart;
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public int getTickDelayInMillis() {
		return tickDelayInMillis;
	}
	public void setTickDelayInMillis(int tickDelayInMillis) {
		this.tickDelayInMillis = tickDelayInMillis;
	}
	public void setSpeed1To10(int speed) {
		setTickDelayInMillis(50 + (10 - speed) * 100);
	}
	public boolean isShowPath() {
		return showPath;
	}
	public void setShowPath(boolean showPath) {
		this.showPath = showPath;
	}
    
    

}
