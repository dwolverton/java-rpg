package co.grandcircus.javarpg;

import co.grandcircus.javarpg.tiles.BushTile;
import co.grandcircus.javarpg.tiles.RockTile;
import co.grandcircus.javarpg.tiles.StumpTile;

import static co.grandcircus.javarpg.tiles.Tiles.*;

public class Maps {
	
	public static final Map PLAIN = new Map(10, 10,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null
			);
	
	public static final Map SPARSE_OBSTACLES = new Map(10, 10,
			null, null, BushTile.INSTANCE, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, BushTile.INSTANCE, null,
			null, RockTile.INSTANCE, null, null, null, null, null, null, null, null,
			null, null, null, null, null, StumpTile.INSTANCE, null, null, null, null,
			null, null, null, null, null, null, null, null, null, RockTile.INSTANCE,
			null, null, null, BushTile.INSTANCE, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			StumpTile.INSTANCE, null, null, null, RockTile.INSTANCE, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, BushTile.INSTANCE, null, null, null, null
			);
	
	public static final Map COAST = new Map(10, 10,
			null, STUMP, BUSH, null, null, null, BUSH, BUSH, STUMP, RED_FLOWER,
			null, null, YELLOW_FLOWER, YELLOW_FLOWER, null, null, null, null, null, null,
			BUSH, YELLOW_FLOWER, null, null, null, null, null, null, BUSH, BUSH,
			null, null, null, null, null, null, null, BUSH, YELLOW_FLOWER, WATER,
			null, null, null, null, RED_FLOWER, STUMP, null, null, null, WATER,
			null, null, null, RED_FLOWER, null, RED_FLOWER, ROCK, ROCK, WATER, WATER,
			null, null, null, BUSH, null, WATER, WATER, WATER, WATER, WATER,
			RED_FLOWER, null, null, WATER, WATER, WATER, WATER, WATER, WATER, WATER,
			null, ROCK, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER,
			null, null, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER
			);

}
