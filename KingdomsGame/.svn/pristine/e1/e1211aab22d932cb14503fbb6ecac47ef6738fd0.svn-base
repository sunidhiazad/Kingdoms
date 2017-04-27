package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GamePackage.*;

/**
 * Tests every unit of the class CalculateScoreAfterEachRound
 * 
 * @author ASPIRE
 * 
 */
public class CalculateScoreAfterEachRoundTest {
	List<Blocks> block_list = new ArrayList<Blocks>();
	List<Player> player_list = new ArrayList<Player>();
	List<Epoch> epoch_list = new ArrayList<Epoch>();

	@Before
	public void setUp() throws Exception {
		epoch_list = XmlOperation.ReadEpochXML();
		new Initialize().setBoardToInitial();
		block_list = XmlOperation.ReadBlockXML();
		block_list.get(14).setTile("Dragon");
		block_list.get(22).setTile("Mountain");
		block_list.get(7).setTile("Wizard");
		block_list.get(26).setTile("GoldMine");
		block_list.get(16).setTile("Resource6");
		block_list.get(16).setPoints(6);
		block_list.get(12).setTile("Hazard6");
		block_list.get(12).setPoints(-6);
		block_list.get(25).setTile("Resource5");
		block_list.get(25).setPoints(5);
		block_list.get(27).setTile("Hazard3");
		block_list.get(27).setPoints(-3);
		block_list.get(1).setPlayer_id(1);
		block_list.get(13).setPlayer_id(2);
		block_list.get(6).setPlayer_id(3);
		block_list.get(8).setPlayer_id(4);
		block_list.get(1).setCastle_rank(1);
		block_list.get(13).setCastle_rank(2);
		block_list.get(6).setCastle_rank(3);
		block_list.get(8).setCastle_rank(4);
		XmlOperation.WriteBlockXML(block_list);
		new HandleBaseValue(block_list.get(1));
		new HandleBaseValue(block_list.get(6));
		new HandleBaseValue(block_list.get(7));
		new HandleBaseValue(block_list.get(8));
		new HandleBaseValue(block_list.get(12));
		new HandleBaseValue(block_list.get(13));
		new HandleBaseValue(block_list.get(14));
		new HandleBaseValue(block_list.get(16));
		new HandleBaseValue(block_list.get(22));
		new HandleBaseValue(block_list.get(25));
		new HandleBaseValue(block_list.get(26));
		new HandleBaseValue(block_list.get(27));

	}

	@Test
	public final void testCalculateScore_NPlayers2() {
		block_list = XmlOperation.ReadBlockXML();
		new CalculateScoreAfterEachRound(1, 2).calculateScore_NPlayers2(1);
		assertEquals(20, epoch_list.get(0).getPlayer1_score());
	}

	@Test
	public final void testCalculateScore() {
		epoch_list = XmlOperation.ReadEpochXML();
		assertEquals(20, epoch_list.get(0).getPlayer1_score());
		assertEquals(40, epoch_list.get(0).getPlayer2_score());
		assertEquals(-36, epoch_list.get(0).getPlayer3_score());
		assertEquals(00, epoch_list.get(0).getPlayer4_score());
	}

	@Test
	public final void testWorkOnDragonTile() {
		new CalculateScoreAfterEachRound(1, 4).WorkOnDragonTile();
		block_list = XmlOperation.ReadBlockXML();
		assertEquals("Dragon tile should have destroyed the resource tile", 0,
				block_list.get(16).getPoints());
		assertNotSame("Dragon tile should not destroy the hazard tile", 0,
				block_list.get(12).getPoints());
	}

	@Test
	public final void testWorkOnMountainTileRows() {
		new CalculateScoreAfterEachRound(1, 4).WorkOnMountainTile();
		block_list = XmlOperation.ReadBlockXML();
		assertEquals("Mountain tile should divide the row into two parts", 41,
				block_list.get(18).getRow());
		assertEquals("Mountain tile should divide the row into two parts", 41,
				block_list.get(19).getRow());
		assertEquals("Mountain tile should divide the row into two parts", 41,
				block_list.get(20).getRow());
		assertEquals("Mountain tile should divide the row into two parts", 41,
				block_list.get(21).getRow());
		assertEquals("Mountain tile should divide the row into two parts", 42,
				block_list.get(23).getRow());

	}

	@Test
	public final void testWorkOnMountainTileColumns() {
		new CalculateScoreAfterEachRound(1, 4).WorkOnMountainTile();
		block_list = XmlOperation.ReadBlockXML();

		assertEquals("Mountain tile should divide the column into two parts",
				51, block_list.get(4).getColummn());
		assertEquals("Mountain tile should divide the column into two parts",
				51, block_list.get(10).getColummn());
		assertEquals("Mountain tile should divide the column into two parts",
				51, block_list.get(16).getColummn());
		assertEquals("Mountain tile should divide the column into two parts",
				52, block_list.get(28).getColummn());
		assertEquals("Mountain tile should divide the column into two parts",
				5, block_list.get(22).getColummn());
	}

}
