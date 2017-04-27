package JUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import GamePackage.XmlOperation;

/**
 * 
 * Tests if xml file is properly created and upon reading the files, it is
 * returning proper objects.
 * 
 */
public class XmlOperationTest {
	File blockxml = new File("Block.xml");
	File playerstatsxml = new File("playerstats.xml");
	File scorexml = new File("score.xml");
	File TileBankxml = new File("TileBank.xml");

	@Test
	public final void testWriteXML() {
		assertTrue("File should exist", playerstatsxml.exists());
	}

	@Test
	public final void testWriteTileXML() {
		assertTrue("File should exist", TileBankxml.exists());
	}

	@Test
	public final void testWriteBlockXML() {
		assertTrue("File should exist", blockxml.exists());
	}

	@Test
	public final void testWriteEpochXML() {
		assertTrue("File should exist", scorexml.exists());
	}

	@Test
	public final void testReadXML() {
		assertNotNull("Should return a List<Player> object",
				XmlOperation.ReadXML());
	}

	@Test
	public final void testReadTileXML() {
		assertNotNull("Should return a List<Tile> object",
				XmlOperation.ReadTileXML());
	}

	@Test
	public final void testReadBlockXML() {
		assertNotNull("Should return a List<Blocks> object",
				XmlOperation.ReadBlockXML());
	}

	@Test
	public final void testReadEpochXML() {
		assertNotNull("Should return a List<Epoch> object",
				XmlOperation.ReadEpochXML());
	}

}
