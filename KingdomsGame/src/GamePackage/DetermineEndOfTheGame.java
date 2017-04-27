package GamePackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Instance of this class calculates if any player has total score of 500 and if
 * it has, calls the FinishTheGame class to display the score.
 * 
 * @author ASPIRE
 * 
 */
public class DetermineEndOfTheGame {
	List<Epoch> epochlist = new ArrayList<Epoch>();
	int player1_total = 0;
	int player2_total = 0;
	int player3_total = 0;
	int player4_total = 0;

	/**
	 * Calculates the total score and determines if it has reached 500 for any player
	 * @param Nplayers
	 */
	public DetermineEndOfTheGame(int Nplayers) {
		epochlist = XmlOperation.ReadEpochXML();
		for (int i = 0; i < epochlist.size(); i++) {
			player1_total += epochlist.get(i).getPlayer1_score();
			player2_total += epochlist.get(i).getPlayer2_score();
			player3_total += epochlist.get(i).getPlayer3_score();
			player4_total += epochlist.get(i).getPlayer4_score();
		}

		if (player1_total == 500 || player2_total == 500
				|| player3_total == 500 || player4_total == 500) {
			new FinishTheGame(Nplayers);
		}
	}
}
