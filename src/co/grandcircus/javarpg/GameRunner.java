package co.grandcircus.javarpg;

public interface GameRunner {
	void setup(GameConfig config);

    void run(Player player, Map map);
}
