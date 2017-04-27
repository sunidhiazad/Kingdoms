package GamePackage;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Creates a new JFrame and display the scores of every player and highlights
 * the winner score.
 * 
 * @author ASPIRE
 * 
 */
public class FinishTheGame {
	JFrame frame = new JFrame("Reiner Knizia's Kingdoms");
	Container pane = frame.getContentPane();
	List<Epoch> epochlist = new ArrayList<Epoch>();
	JButton player1 = new JButton();
	JButton player2 = new JButton();
	JButton player3 = new JButton();
	JButton player4 = new JButton();
	int player1_score = 0;
	int player2_score = 0;
	int player3_score = 0;
	int player4_score = 0;
	List<Integer> scores = new ArrayList<Integer>();
	int temp = 0;

	/**
	 * Constructor for handling the scores.
	 * 
	 * @param NPlayers
	 */
	public FinishTheGame(int NPlayers) {
		epochlist = XmlOperation.ReadEpochXML();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(null);
		frame.setSize(400, 350);
		frame.setVisible(true);
		frame.setResizable(false);
		setBoundsforSpaces();
		createPlayerSpaces(NPlayers);
		setScoreOnButtons();
		findthemaximumscore();
		highlightTheWinner(temp);
	}

	/**
	 * takes as input the winner id and highlights it in pink
	 * 
	 * @param temp
	 */
	private void highlightTheWinner(int temp) {
		switch (temp) {
		case 1:
			player1.setBackground(Color.PINK);
			break;
		case 2:
			player2.setBackground(Color.PINK);
			break;
		case 3:
			player3.setBackground(Color.PINK);
			break;
		case 4:
			player4.setBackground(Color.PINK);
		}
	}

	/**
	 * Finds out the winner with the maximum score
	 */
	private void findthemaximumscore() {
		int holder = 0;
		if (player1_score > player2_score) {
			temp = 1;
			holder = player1_score;
		} else {
			temp = 2;
			holder = player2_score;
		}
		if (player3_score > holder) {
			temp = 3;
			holder = player3_score;
		}
		if (player4_score > holder) {
			temp = 4;
			holder = player4_score;
		}

	}

	/**
	 * Sets text on the buttons for scores
	 */
	private void setScoreOnButtons() {
		for (int i = 0; i < epochlist.size(); i++) {
			player1_score += epochlist.get(i).getPlayer1_score();
			player2_score += epochlist.get(i).getPlayer2_score();
			player3_score += epochlist.get(i).getPlayer3_score();
			player4_score += epochlist.get(i).getPlayer4_score();
		}
		scores.add(player1_score);
		scores.add(player2_score);
		scores.add(player3_score);
		scores.add(player4_score);
		player1.setText("Player 1 score : " + player1_score);
		player2.setText("Player 2 score : " + player2_score);
		player3.setText("Player 3 score : " + player3_score);
		player4.setText("Player 4 score : " + player4_score);
	}

	/**
	 * Specifies the dimensions of the score buttons
	 */
	private void setBoundsforSpaces() {
		player1.setBounds(50, 50, 300, 50);
		player2.setBounds(50, 110, 300, 50);
		player3.setBounds(50, 170, 300, 50);
		player4.setBounds(50, 230, 300, 50);
	}

	/**
	 * Adds the buttons and manages the visibility of them.
	 * 
	 * @param nPlayers
	 */
	private void createPlayerSpaces(int nPlayers) {
		if (nPlayers == 2) {
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(false);
			player4.setVisible(false);

		} else if (nPlayers == 3) {
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(true);
			player4.setVisible(false);
		} else {
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(true);
			player4.setVisible(true);
		}

		pane.add(player1);
		pane.add(player2);
		pane.add(player3);
		pane.add(player4);
		
	}
}
