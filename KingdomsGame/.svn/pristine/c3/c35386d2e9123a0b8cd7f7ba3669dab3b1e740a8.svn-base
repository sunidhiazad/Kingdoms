package Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GamePackage.Blocks;
import GamePackage.Player;
import GamePackage.Tile;
import GamePackage.XmlOperation;

/**
 * Strategy for the player who is trying to minimize other's scores
 * @author ASPIRE
 *
 */
public class MinOtherScorePlayer {
	static int chosen_index;
	List<Blocks> random_blocks = new ArrayList<Blocks>();
	List<Blocks> blocks = new ArrayList<Blocks>();
	Blocks selectedblock = new Blocks();
	Tile tile = new Tile();
	int listIndex = 0;
	List<String> selectOptions = new ArrayList<String>();
	int randomcastle;
	int selectedRandonIndex;
	
	/**
	 * 
	 * @param player
	 * @return Blocks
	 */
	public Blocks playingStrategy(Player player) {
		Tile tile1 = player.getTile1();
		Tile tile2 = player.getTile2();
		Tile tile3 = player.getTile3();
		selectOptions.add("castle");
		selectOptions.add("tile");
		
		if (!(tile1.getTile_name().equals("") || tile1.getTile_name().equals(
				null)))
			tile = tile1;
		else if (!(tile2.getTile_name().equals("") || tile2.getTile_name()
				.equals(null)))
			tile = tile2;
		else if (!(tile3.getTile_name().equals("") || tile3.getTile_name()
				.equals(null)))
			tile = tile3;
		else
			selectOptions.remove("tile");
		
		selectedRandonIndex = new Random().nextInt(selectOptions.size());
		selectedblock = getRandomEmptyBlock();
		selectedblock.setPlayer_id(player.getPlayer_id());

		switch (selectOptions.get(selectedRandonIndex)) {
		case "castle":

			List<Player> players = XmlOperation.ReadXML();
			Player obj = new Player();

			ArrayList<Integer> castleoptions = new ArrayList<Integer>();

			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getPlayer_id() == player.getPlayer_id()) {
					listIndex = i;
					obj = players.get(i);
					if (obj.getRank1_castle() > 0)
						castleoptions.add(1);
					if (obj.getRank2_castle() > 0)
						castleoptions.add(2);
					if (obj.getRank3_castle() > 0)
						castleoptions.add(3);
					if (obj.getRank4_castle() > 0)
						castleoptions.add(4);
				}

			}

			randomcastle = new Random().nextInt(castleoptions.size());

			int rank1_castle = obj.getRank1_castle();
			int rank2_castle = obj.getRank2_castle();
			int rank3_castle = obj.getRank3_castle();
			int rank4_castle = obj.getRank4_castle();

			switch (castleoptions.get(randomcastle)) {
			case 1:
				selectedblock.setCastle_rank(1);
				players.get(listIndex).setRank1_castle(rank1_castle - 1);
				break;
			case 2:
				selectedblock.setCastle_rank(2);
				players.get(listIndex).setRank2_castle(rank2_castle - 1);
				break;
			case 3:
				selectedblock.setCastle_rank(3);
				players.get(listIndex).setRank3_castle(rank3_castle - 1);
				break;
			case 4:
				selectedblock.setCastle_rank(4);
				players.get(listIndex).setRank4_castle(rank4_castle - 1);
				break;

			}

			XmlOperation.WriteXML(players);
			break;

		case "tile":

			selectedblock.setTile(tile.getTile_name());
			selectedblock.setPoints(tile.getTile_value());
			break;

		}
		return selectedblock;

	}

	public Blocks getRandomEmptyBlock() {
		blocks = XmlOperation.ReadBlockXML();
		Blocks randomBlock = new Blocks();
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).getIs_empty())
				random_blocks.add(blocks.get(i));
		}

		if (random_blocks.size() > 0)
			randomBlock = random_blocks.get(new Random().nextInt(random_blocks
					.size()));
		return randomBlock;
	}
}
