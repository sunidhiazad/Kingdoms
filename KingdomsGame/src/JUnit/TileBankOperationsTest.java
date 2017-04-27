package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import GamePackage.Tile;
import GamePackage.TileBankOperations;

/**
 * 
 * Tests if the method is returning a tile and not a null object.
 * 
 */
public class TileBankOperationsTest {
	Tile tile = new Tile();

	@Test
	public final void testGetRandomTileFromBank() {
		tile = TileBankOperations.getRandomTileFromBank();
		assertNotNull("Should not return empty object", tile);
	}

}
