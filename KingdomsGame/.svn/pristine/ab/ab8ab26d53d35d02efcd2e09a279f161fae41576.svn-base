package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GamePackage.*;

/**
 * Gives a scenario and test the handling of base values
 * @author ASPIRE
 *
 */
public class HandleBaseValueTest {
	List<Blocks> block_list = new ArrayList<Blocks>();
	List<Player> player_list = new ArrayList<Player>();
	List<Epoch> epoch_list = new ArrayList<Epoch>();

	@Before
	public void setUp() throws Exception {
		new Initialize().setBoardToInitial();
		block_list=XmlOperation.ReadBlockXML();
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
		new HandleBaseValue(block_list.get(7));
		new HandleBaseValue(block_list.get(12));
		new HandleBaseValue(block_list.get(14));
		new HandleBaseValue(block_list.get(16));
		new HandleBaseValue(block_list.get(22));
	}

	@Test
	public final void testWorkOnWizardMineTile() {
		new HandleBaseValue(block_list.get(1));
		new HandleBaseValue(block_list.get(6));
		new HandleBaseValue(block_list.get(8));
		new HandleBaseValue(block_list.get(13));
		block_list=XmlOperation.ReadBlockXML();
		assertEquals("Wizard Tile should have doubled the rank of the castle",2, block_list.get(1).getCastle_rank());
		assertEquals("Wizard Tile should have doubled the rank of the castle",4, block_list.get(13).getCastle_rank());
		assertEquals("Wizard Tile should have doubled the rank of the castle",6, block_list.get(6).getCastle_rank());
		assertEquals("Wizard Tile should have doubled the rank of the castle",8, block_list.get(8).getCastle_rank());
	}

	@Test
	public final void testWorkOnGoldMineTile() {
		new HandleBaseValue(block_list.get(26));
		new HandleBaseValue(block_list.get(25));
		new HandleBaseValue(block_list.get(27));
		block_list=XmlOperation.ReadBlockXML();
		assertEquals("GoldMine Tile should have doubled the points of the tile",10, block_list.get(25).getPoints());
		assertEquals("GoldMine Tile should have doubled the points of the tile",-6, block_list.get(27).getPoints());
	}

	@Test
	public final void testSetBaseValueForColumns() {
		block_list=XmlOperation.ReadBlockXML();
		assertEquals(-6, block_list.get(0).getColumn_base_value());
		assertEquals(-6, block_list.get(6).getColumn_base_value());
		assertEquals(-6, block_list.get(12).getColumn_base_value());
		assertEquals(-6, block_list.get(18).getColumn_base_value());
		assertEquals(-6, block_list.get(24).getColumn_base_value());
		
		assertEquals(5, block_list.get(1).getColumn_base_value());
		assertEquals(5, block_list.get(7).getColumn_base_value());
		assertEquals(5, block_list.get(13).getColumn_base_value());
		assertEquals(5, block_list.get(19).getColumn_base_value());
		assertEquals(5, block_list.get(25).getColumn_base_value());
		
		assertEquals(0, block_list.get(2).getColumn_base_value());
		assertEquals(0, block_list.get(8).getColumn_base_value());
		assertEquals(0, block_list.get(14).getColumn_base_value());
		assertEquals(0, block_list.get(20).getColumn_base_value());
		assertEquals(0, block_list.get(26).getColumn_base_value());
		
		assertEquals(-3, block_list.get(3).getColumn_base_value());
		assertEquals(-3, block_list.get(9).getColumn_base_value());
		assertEquals(-3, block_list.get(15).getColumn_base_value());
		assertEquals(-3, block_list.get(21).getColumn_base_value());
		assertEquals(-3, block_list.get(27).getColumn_base_value());
		
		assertEquals(6, block_list.get(4).getColumn_base_value());
		assertEquals(6, block_list.get(10).getColumn_base_value());
		assertEquals(6, block_list.get(16).getColumn_base_value());
		assertEquals(6, block_list.get(22).getColumn_base_value());
		assertEquals(6, block_list.get(28).getColumn_base_value());
		
		assertEquals(0, block_list.get(5).getColumn_base_value());
		assertEquals(0, block_list.get(11).getColumn_base_value());
		assertEquals(0, block_list.get(17).getColumn_base_value());
		assertEquals(0, block_list.get(23).getColumn_base_value());
		assertEquals(0, block_list.get(29).getColumn_base_value());
	}

	@Test
	public final void testSetBaseValueForRows() {
		block_list=XmlOperation.ReadBlockXML();
		assertEquals(0, block_list.get(0).getRow_base_value());
		assertEquals(0, block_list.get(6).getRow_base_value());
		assertEquals(0, block_list.get(12).getRow_base_value());
		assertEquals(0, block_list.get(18).getRow_base_value());
		assertEquals(2, block_list.get(24).getRow_base_value());
		
	}
}
