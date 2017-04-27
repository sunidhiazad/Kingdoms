package GamePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class for randomly drawing tile from Tile bank
 * 
 */
public class TileBankOperations {
	public static Tile getRandomTileFromBank() {
		Tile tile = new Tile();
		List<Tile> tiles = XmlOperation.ReadTileXML();
		List<Tile> tiles_left = new ArrayList<Tile>();
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).getTile_count() != 0)
				tiles_left.add(tiles.get(i));
		}
		if (tiles_left.size() == 0)
			return null;
		else {
			int chosen_index = new Random().nextInt(tiles_left.size());
			tile = tiles_left.get(chosen_index);

			for (int i = 0; i < tiles.size(); i++) {
				if (tiles.get(i).getTile_name().equals(tile.tile_name)) {
					tiles.get(i)
							.setTile_count(tiles.get(i).getTile_count() - 1);
				}
			}
			XmlOperation.WriteTileXML(tiles);
			return tile;
		}

	}

	public static List<Tile> getInitialTiles() {
		List<Tile> tiles = XmlOperation.ReadTileXML();
		List<Tile> initialTiles = new ArrayList<Tile>();
		for (int i = 0; i < tiles.size(); i++) {
			String tileName = tiles.get(i).getTile_name();
			if (tileName.equals("Dragon") || tileName.equals("GoldMine")
					|| tileName.equals("Wizard")) {
				initialTiles.add(tiles.get(i));
				tiles.get(i).setTile_count(0);
			}

		}
		XmlOperation.WriteTileXML(tiles);
		return initialTiles;
	}

	public static Boolean isTileBankEmpty() {
		List<Tile> tiles = XmlOperation.ReadTileXML();
		int tiles_left = 0;
		for (int i = 0; i < tiles.size(); i++) {
			tiles_left+=tiles.get(i).getTile_count();
		}
		if (tiles_left == 0)
			return true;
		else
			return false;
	}
}
