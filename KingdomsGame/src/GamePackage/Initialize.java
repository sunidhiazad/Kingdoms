package GamePackage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will set all values to initial at start of game
 * 
 */
public class Initialize {
	List<String> strategies = new ArrayList<String>();// {"Max","Min","Random","Human"};

	/**
	 * 
	 * @param epoch_no
	 */
	public void InitializeAll(int epoch_no) {

		Initialize obj = new Initialize();
		obj.setTileBankToInitial();
		obj.setBoardToInitial();
		// obj.setPlayersToInitials(isNewGame, noofplayers);
	}

	/**
	 * Set board to initial
	 */
	public void setBoardToInitial() {
		List<Blocks> blocks = new ArrayList<Blocks>();
		int id = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6; j++) {
				id++;
				Blocks block = new Blocks();
				block.setBlock_id(id);
				block.setRow(i);
				block.setColummn(j);
				block.setIs_empty(true);
				block.setPlayer_id(0);
				block.setColor("");
				block.setTile("");
				block.setColumn_base_value(0);
				block.setRow_base_value(0);
				blocks.add(block);
			}

		}
		XmlOperation.WriteBlockXML(blocks);
	}

	/**
	 * Sets tile count to initial
	 */
	private void setTileBankToInitial() {
		List<Tile> tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile();
		Tile tile2 = new Tile();
		Tile tile3 = new Tile();
		Tile tile4 = new Tile();
		for (int i = 1; i <= 6; i++) {
			Tile tile = new Tile();
			tile.setTile_name("Resource" + String.valueOf(i));
			tile.setTile_value(i);
			tile.setTile_count(2);
			tiles.add(tile);

		}
		for (int i = 1; i <= 6; i++) {
			Tile tile = new Tile();

			tile.setTile_name("Hazard" + String.valueOf(i));
			tile.setTile_value(-i);
			tile.setTile_count(1);
			tiles.add(tile);

		}

		tile1.setTile_count(1);
		tile1.setTile_name("Mountain");
		tile1.setTile_value(0);

		tile2.setTile_count(0);
		tile2.setTile_name("Dragon");
		tile2.setTile_value(0);

		tile3.setTile_count(0);
		tile3.setTile_name("GoldMine");
		tile3.setTile_value(0);

		tile4.setTile_count(0);
		tile4.setTile_name("Wizard");
		tile4.setTile_value(0);

		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);

		XmlOperation.WriteTileXML(tiles);
	}

	/**
	 * sets players to initial
	 */
	public void setPlayersToInitials(Boolean isEpoch, int noofplayers) {

		List<Player> oldplayers = new ArrayList<Player>();
		List<Player> players = new ArrayList<Player>();
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		
		if(isEpoch)
		{
			oldplayers=XmlOperation.ReadXML();
			player1.setStrategy(oldplayers.get(0).getStrategy());
			player2.setStrategy(oldplayers.get(1).getStrategy());
			switch(noofplayers)
			{
			case 3:
				player3.setStrategy(oldplayers.get(2).getStrategy());
				break;
			case 4:
				player3.setStrategy(oldplayers.get(2).getStrategy());
				player4.setStrategy(oldplayers.get(3).getStrategy());
				break;
			}
			
		}
		
			player1.setPlayer_id(1);
			player1.setRank1_castle(2);
			player1.setRank2_castle(3);
			player1.setRank3_castle(2);
			player1.setRank4_castle(1);
			

			player2.setPlayer_id(2);
			player2.setRank1_castle(2);
			player2.setRank2_castle(3);
			player2.setRank3_castle(2);
			player2.setRank4_castle(1);

			player3.setPlayer_id(3);
			player3.setRank1_castle(2);
			player3.setRank2_castle(3);
			player3.setRank3_castle(2);
			player3.setRank4_castle(1);

			player4.setPlayer_id(4);
			player4.setRank1_castle(2);
			player4.setRank2_castle(3);
			player4.setRank3_castle(2);
			player4.setRank4_castle(1);
		
			switch (noofplayers) {

			case 2:
								
				player1.setRank1_castle(4);
				player2.setRank1_castle(4);
				players.add(player1);
				players.add(player2);
				break;
			case 3:
				player1.setRank1_castle(3);
				player2.setRank1_castle(3);
				player3.setRank1_castle(3);
				
				players.add(player1);
				players.add(player2);
				players.add(player3);
				break;
			case 4:
				players.add(player1);
				players.add(player2);
				players.add(player3);
				players.add(player4);
				break;
			}
			XmlOperation.WriteXML(players);
		}

	/**
	 * set score to initial
	 */
	public void setScoreToInitial() {
		List<Epoch> epochs = new ArrayList<Epoch>();
		Epoch epoch1 = new Epoch();
		Epoch epoch2 = new Epoch();
		Epoch epoch3 = new Epoch();
		Epoch epoch4 = new Epoch();
		Epoch epoch5 = new Epoch();
		Epoch epoch6 = new Epoch();

		epoch1.setEpoch_no(1);
		epoch1.setPlayer1_score(0);
		epoch1.setPlayer2_score(0);
		epoch1.setPlayer3_score(0);
		epoch1.setPlayer4_score(0);

		epoch2.setEpoch_no(2);
		epoch2.setPlayer1_score(0);
		epoch2.setPlayer2_score(0);
		epoch2.setPlayer3_score(0);
		epoch2.setPlayer4_score(0);

		epoch3.setEpoch_no(3);
		epoch3.setPlayer1_score(0);
		epoch3.setPlayer2_score(0);
		epoch3.setPlayer3_score(0);
		epoch3.setPlayer4_score(0);

		epoch4.setEpoch_no(4);
		epoch4.setPlayer1_score(0);
		epoch4.setPlayer2_score(0);
		epoch4.setPlayer3_score(0);
		epoch4.setPlayer4_score(0);

		epoch5.setEpoch_no(5);
		epoch5.setPlayer1_score(0);
		epoch5.setPlayer2_score(0);
		epoch5.setPlayer3_score(0);
		epoch5.setPlayer4_score(0);

		epoch6.setEpoch_no(6);
		epoch6.setPlayer1_score(0);
		epoch6.setPlayer2_score(0);
		epoch6.setPlayer3_score(0);
		epoch6.setPlayer4_score(0);

		epochs.add(epoch1);
		epochs.add(epoch2);
		epochs.add(epoch3);
		epochs.add(epoch4);
		epochs.add(epoch5);
		epochs.add(epoch6);

		XmlOperation.WriteEpochXML(epochs);
	}

}
