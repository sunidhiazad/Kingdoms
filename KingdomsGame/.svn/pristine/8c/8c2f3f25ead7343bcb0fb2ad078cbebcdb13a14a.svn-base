package Strategy;

import GamePackage.Blocks;
import GamePackage.Player;

/**
 * This class act as interface between different playing strategies and player's
 * strategy who has turn
 */

public class PlayingStrategy {
	/**
	 * This method will take player as input and select strategy same as
	 * player's strategy and returns block where tile or castle is to be place
	 * 
	 * @param player
	 * @param blocks
	 * @return block
	 */
	public static Blocks Strategy(Player player) {
		Blocks block = new Blocks();
		RandomPlayer ranobj = new RandomPlayer();
		MaxOwnScorePlayer maxobj=new MaxOwnScorePlayer();
		MinOtherScorePlayer minobj = new MinOtherScorePlayer();
		switch (player.getStrategy()) {
		case "Max":
			block = maxobj.playingStrategy(player);
			break;
		case "Min":
			block = minobj.playingStrategy(player);
			break;
		case "Random":
			block = ranobj.playingStrategy(player);
			break;
		}
		return block;

	}

}
