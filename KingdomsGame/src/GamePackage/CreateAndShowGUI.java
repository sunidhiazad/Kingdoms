package GamePackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Strategy.PlayingStrategy;
import Strategy.RandomPlayer;

/**
 * This is the class which creates the frame, the panel and all the buttons on
 * the board. ActionListeners are implemented in this class for every button
 * present on the board.
 * 
 * 
 * 
 */
public class CreateAndShowGUI implements ActionListener {

	Blocks tempobj = new Blocks();
	Tile tile_player1 = new Tile();

	List<Player> players = new ArrayList<Player>();

	int epoch_count = 1;
	int noofplayers;
	Boolean isLoadGame = false;

	List<Blocks> blocks = new ArrayList<Blocks>();
	List<Epoch> epochlist = new ArrayList<Epoch>();

	int current_turn = 0;
	int turn_count = 0;

	ImageIcon kingdom = new ImageIcon("images/logo.jpg");
	ImageIcon savegame = new ImageIcon("images/savegame.jpg");
	ImageIcon tiles = new ImageIcon("images/tiles.jpg");
	ImageIcon imgplayer1 = new ImageIcon("images/player1.jpg");
	ImageIcon imgplayer2 = new ImageIcon("images/player2.jpg");
	ImageIcon imgplayer3 = new ImageIcon("images/player3.jpg");
	ImageIcon imgplayer4 = new ImageIcon("images/player4.jpg");

	JButton player1 = new JButton("", imgplayer1);
	JButton player2 = new JButton("", imgplayer2);
	JButton player3 = new JButton("", imgplayer3);
	JButton player4 = new JButton("", imgplayer4);

	JButton save = new JButton("", savegame);
	JButton drawtile = new JButton("", tiles);

	JButton[][] grid56 = new JButton[5][6];

	JButton rank1_1 = new JButton();
	JButton rank2_1 = new JButton();
	JButton rank3_1 = new JButton();
	JButton rank4_1 = new JButton();

	JButton rank1_2 = new JButton();
	JButton rank2_2 = new JButton();
	JButton rank3_2 = new JButton();
	JButton rank4_2 = new JButton();

	JButton rank1_3 = new JButton();
	JButton rank2_3 = new JButton();
	JButton rank3_3 = new JButton();
	JButton rank4_3 = new JButton();

	JButton rank1_4 = new JButton();
	JButton rank2_4 = new JButton();
	JButton rank3_4 = new JButton();
	JButton rank4_4 = new JButton();

	JButton btntile1_p1 = new JButton();
	JButton btntile2_p1 = new JButton();
	JButton btntile3_p1 = new JButton();

	JButton btntile1_p2 = new JButton();
	JButton btntile2_p2 = new JButton();
	JButton btntile3_p2 = new JButton();

	JButton btntile1_p3 = new JButton();
	JButton btntile2_p3 = new JButton();
	JButton btntile3_p3 = new JButton();

	JButton btntile1_p4 = new JButton();
	JButton btntile2_p4 = new JButton();
	JButton btntile3_p4 = new JButton();

	Tile tile1_1 = new Tile();
	Tile tile2_1 = new Tile();
	Tile tile3_1 = new Tile();

	Tile tile1_2 = new Tile();
	Tile tile2_2 = new Tile();
	Tile tile3_2 = new Tile();

	Tile tile1_3 = new Tile();
	Tile tile2_3 = new Tile();
	Tile tile3_3 = new Tile();

	Tile tile1_4 = new Tile();
	Tile tile2_4 = new Tile();
	Tile tile3_4 = new Tile();

	JButton strategy1 = new JButton();
	JButton strategy2 = new JButton();
	JButton strategy3 = new JButton();
	JButton strategy4 = new JButton();

	JButton score43_1[][] = new JButton[4][3];
	JButton score43_2[][] = new JButton[4][3];
	JButton tileDrawnFromBank = new JButton();

	JFrame frame = new JFrame("Reiner Knizia's Kingdoms");
	Container pane = frame.getContentPane();

	Initialize objInitialize = new Initialize();
	int TileButton = 0;

	/**
	 * This method sets the properties of the main frame and calls different
	 * methods to put up components on the main board.
	 * 
	 * @return object of container class
	 */
	public Container createAndShowGUI(Boolean isNewGame) {

		blocks = XmlOperation.ReadBlockXML();
		players = XmlOperation.ReadXML();
		noofplayers = players.size();

		if (isNewGame) {
			current_turn = new Random().nextInt(noofplayers) + 1;
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pane.setLayout(null);
			frame.setSize(1000, 725);
			frame.setVisible(true);
			frame.setResizable(false);

			addGrid56();
			addButtonOnCorners();
			addComponentsToPlayerSpace();
			addActionsToButtons();
			placeInitialTiles();
			addScoreButtonsAtBottomLeftCorner();
			rotateTurns();

		} else if (!isNewGame) {

			isLoadGame = true;
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pane.setLayout(null);
			frame.setSize(1000, 725);
			frame.setVisible(true);
			frame.setResizable(false);
			setTurnOnLoad();
			addScoreButtonsAtBottomLeftCorner();
			addGrid56();
			addButtonOnCorners();
			addComponentsToPlayerSpace();
			addActionsToButtons();
			fillBoardOnLoad();
			rotateTurns();

		}

		return pane;
	}

	/**
	 * Place the initial 3 tiles on the board randomly - Wizard, GoldMine,
	 * Dragon
	 */
	private void placeInitialTiles() {
		List<Tile> initialTiles = TileBankOperations.getInitialTiles();
		for (int i = 0; i < initialTiles.size(); i++) {
			RandomPlayer obj = new RandomPlayer();
			Blocks block = obj.getRandomEmptyBlock();
			block.setTile(initialTiles.get(i).getTile_name());
			placeobjectonboard(block);
		}

	}

	/**
	 * Rotate the turn to next player after saving and loading.
	 */
	private void setTurnOnLoad() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isHasturn()) {
				current_turn = i + 1;
			}
		}
	}

	/**
	 * Adds score Buttons on the Left side of the board.
	 */
	private void addScoreButtonsAtBottomLeftCorner() {
		JPanel pane43_1 = new JPanel();
		pane43_1.setLayout(new GridLayout(4, 3));
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				score43_1[i][j] = new JButton();
				pane43_1.add(score43_1[i][j]);
				if (i == 0)
					score43_1[i][j].setBackground(Color.CYAN);
				if (i == 1)
					score43_1[i][j].setBackground(Color.RED);
				if (i == 2)
					score43_1[i][j].setBackground(Color.GREEN);
				if (i == 3)
					score43_1[i][j].setBackground(Color.YELLOW);
			}
		}
		pane43_1.setBounds(0, 600, 200, 99);
		pane.add(pane43_1);

		JPanel pane43_2 = new JPanel();
		pane43_2.setLayout(new GridLayout(4, 3));
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				score43_2[i][j] = new JButton();
				pane43_2.add(score43_2[i][j]);
				if (i == 0)
					score43_2[i][j].setBackground(Color.CYAN);
				if (i == 1)
					score43_2[i][j].setBackground(Color.RED);
				if (i == 2)
					score43_2[i][j].setBackground(Color.GREEN);
				if (i == 3)
					score43_2[i][j].setBackground(Color.YELLOW);
			}
		}
		pane43_2.setBounds(0, 0, 200, 99);
		pane.add(pane43_2);

		if (noofplayers == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					score43_1[i][j].setVisible(true);
					score43_2[i][j].setVisible(true);
				}
			}
			for (int i = 2; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					score43_1[i][j].setVisible(false);
					score43_2[i][j].setVisible(false);
				}
			}

		} else if (noofplayers == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					score43_1[i][j].setVisible(true);
					score43_2[i][j].setVisible(true);
				}
			}
			for (int i = 3; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					score43_1[i][j].setVisible(false);
					score43_2[i][j].setVisible(false);
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					score43_1[i][j].setVisible(true);
					score43_2[i][j].setVisible(true);
				}
			}
		}
	}

	/**
	 * This method adds events to mouse clicks of castles of player 1 buttons.
	 */
	private void addActionsToButtons() {

		btntile1_p1.addActionListener(this);
		btntile2_p1.addActionListener(this);
		btntile3_p1.addActionListener(this);

		btntile1_p2.addActionListener(this);
		btntile2_p2.addActionListener(this);
		btntile3_p2.addActionListener(this);

		btntile1_p3.addActionListener(this);
		btntile2_p3.addActionListener(this);
		btntile3_p3.addActionListener(this);

		btntile1_p4.addActionListener(this);
		btntile2_p4.addActionListener(this);
		btntile3_p4.addActionListener(this);

		rank1_1.addActionListener(this);
		rank2_1.addActionListener(this);
		rank3_1.addActionListener(this);
		rank4_1.addActionListener(this);

		rank1_2.addActionListener(this);
		rank2_2.addActionListener(this);
		rank3_2.addActionListener(this);
		rank4_2.addActionListener(this);

		rank1_3.addActionListener(this);
		rank2_3.addActionListener(this);
		rank3_3.addActionListener(this);
		rank4_3.addActionListener(this);

		rank1_4.addActionListener(this);
		rank2_4.addActionListener(this);
		rank3_4.addActionListener(this);
		rank4_4.addActionListener(this);

		// btntile1_p1.addActionListener(this);
		save.addActionListener(this);
		drawtile.addActionListener(this);

	}

	/**
	 * Sets the properties of temp Blocks object. used for setting values on
	 * board's block object
	 * 
	 * @param player
	 *            ,castlerank
	 */
	private void CopyInfo(int player, int castlerank) {

		tempobj.setPlayer_id(player);
		tempobj.setCastle_rank(castlerank);

	}

	/**
	 * This method rotate turns among players anti-clockwise.
	 * 
	 */
	private void rotateTurns() {
		Player tempPlayer = new Player();
		if (turn_count <= 30) {
			turn_count++;
			if (turn_count % noofplayers == 0) {
				new CalculateScoreAfterEachRound(epoch_count, noofplayers);
				new DetermineEndOfTheGame(noofplayers);
				setTextOnScoreButtons(epoch_count);
			}
			Blocks block = new Blocks();
			if (current_turn < noofplayers) {

				switch (current_turn) {
				case 1:
					tempPlayer = players.get(0);
					current_turn++;

					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer1();
						getCastlePlayer_1();
					}

					else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_1();
						rotateTurns();
					}

					break;
				case 2:
					tempPlayer = players.get(1);
					current_turn++;
					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer2();
						getCastlePlayer_2();

					} else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_2();
						rotateTurns();
					}

					break;
				case 3:
					tempPlayer = players.get(2);
					current_turn++;
					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer3();
						getCastlePlayer_3();

					} else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_3();
						rotateTurns();
					}

				}
			} else if (current_turn == noofplayers) {
				current_turn = 1;
				switch (noofplayers) {
				case 2:
					tempPlayer = players.get(1);
					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer2();
						getCastlePlayer_2();
					} else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_2();
						rotateTurns();
					}
					break;
				case 3:
					tempPlayer = players.get(2);
					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer3();
						getCastlePlayer_3();
					} else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_3();
						rotateTurns();
					}
					break;
				case 4:
					tempPlayer = players.get(3);
					if (tempPlayer.getStrategy().equals("Human")) {
						enablePlayer4();
						getCastlePlayer_4();
					} else {
						block = PlayingStrategy.Strategy(tempPlayer);
						placeobjectonboard(block);
						getCastlePlayer_4();
						rotateTurns();
					}
					break;
				}

			}
		}
	}

	/**
	 * Distributes the tiles and castles to player 4
	 */
	private void enablePlayer4() {
		tile1_4 = players.get(3).getTile1();
		tile2_4 = players.get(3).getTile2();
		tile3_4 = players.get(3).getTile3();

		btntile1_p4.setText(tile1_4.getTile_name());
		btntile2_p4.setText(tile2_4.getTile_name());
		btntile3_p4.setText(tile3_4.getTile_name());

		btntile1_p4.setEnabled(true);
		btntile2_p4.setEnabled(true);
		btntile3_p4.setEnabled(true);

		rank1_4.setEnabled(true);
		rank2_4.setEnabled(true);
		rank3_4.setEnabled(true);
		rank4_4.setEnabled(true);

		rank1_2.setEnabled(false);
		rank2_2.setEnabled(false);
		rank3_2.setEnabled(false);
		rank4_2.setEnabled(false);

		rank1_3.setEnabled(false);
		rank2_3.setEnabled(false);
		rank3_3.setEnabled(false);
		rank4_3.setEnabled(false);

		rank1_1.setEnabled(false);
		rank2_1.setEnabled(false);
		rank3_1.setEnabled(false);
		rank4_1.setEnabled(false);

	}

	/**
	 * Distributes the tiles and castles to player 3
	 */
	private void enablePlayer3() {
		tile1_3 = players.get(2).getTile1();
		tile2_3 = players.get(2).getTile2();
		tile3_3 = players.get(2).getTile3();

		btntile1_p3.setText(tile1_3.getTile_name());
		btntile2_p3.setText(tile2_3.getTile_name());
		btntile3_p3.setText(tile3_3.getTile_name());

		btntile1_p3.setEnabled(true);
		btntile2_p3.setEnabled(true);
		btntile3_p3.setEnabled(true);

		rank1_3.setEnabled(true);
		rank2_3.setEnabled(true);
		rank3_3.setEnabled(true);
		rank4_3.setEnabled(true);

		rank1_1.setEnabled(false);
		rank2_1.setEnabled(false);
		rank3_1.setEnabled(false);
		rank4_1.setEnabled(false);

		rank1_2.setEnabled(false);
		rank2_2.setEnabled(false);
		rank3_2.setEnabled(false);
		rank4_2.setEnabled(false);

		rank1_4.setEnabled(false);
		rank2_4.setEnabled(false);
		rank3_4.setEnabled(false);
		rank4_4.setEnabled(false);

	}

	/**
	 * Distributes the tiles and castles to player 2
	 */
	private void enablePlayer2() {
		tile1_2 = players.get(1).getTile1();
		tile2_2 = players.get(1).getTile2();
		tile3_2 = players.get(1).getTile3();

		btntile1_p2.setText(tile1_2.getTile_name());
		btntile2_p2.setText(tile2_2.getTile_name());
		btntile3_p2.setText(tile3_2.getTile_name());

		btntile1_p2.setEnabled(true);
		btntile2_p2.setEnabled(true);
		btntile3_p2.setEnabled(true);

		rank1_2.setEnabled(true);
		rank2_2.setEnabled(true);
		rank3_2.setEnabled(true);
		rank4_2.setEnabled(true);

		rank1_1.setEnabled(false);
		rank2_1.setEnabled(false);
		rank3_1.setEnabled(false);
		rank4_1.setEnabled(false);

		rank1_3.setEnabled(false);
		rank2_3.setEnabled(false);
		rank3_3.setEnabled(false);
		rank4_3.setEnabled(false);

		rank1_4.setEnabled(false);
		rank2_4.setEnabled(false);
		rank3_4.setEnabled(false);
		rank4_4.setEnabled(false);

	}

	/**
	 * Distributes the tiles and castles to player 1
	 */
	private void enablePlayer1() {
		tile1_1 = players.get(0).getTile1();
		tile2_1 = players.get(0).getTile2();
		tile3_1 = players.get(0).getTile3();

		btntile1_p1.setText(tile1_1.getTile_name());
		btntile2_p1.setText(tile2_1.getTile_name());
		btntile3_p1.setText(tile3_1.getTile_name());

		btntile1_p1.setEnabled(true);
		btntile2_p1.setEnabled(true);
		btntile3_p1.setEnabled(true);

		rank1_1.setEnabled(true);
		rank2_1.setEnabled(true);
		rank3_1.setEnabled(true);
		rank4_1.setEnabled(true);

		rank1_2.setEnabled(false);
		rank2_2.setEnabled(false);
		rank3_2.setEnabled(false);
		rank4_2.setEnabled(false);

		rank1_3.setEnabled(false);
		rank2_3.setEnabled(false);
		rank3_3.setEnabled(false);
		rank4_3.setEnabled(false);

		rank1_4.setEnabled(false);
		rank2_4.setEnabled(false);
		rank3_4.setEnabled(false);
		rank4_4.setEnabled(false);

	}

	/**
	 * Checks if Board is full and if it is, runs the next epoch and if its the
	 * last epoch, display the score.
	 */
	void isBoardfull() {
		List<Blocks> tempblocklist = XmlOperation.ReadBlockXML();
		Boolean isFull = true;
		for (int i = 0; i < tempblocklist.size(); i++) {
			if (tempblocklist.get(i).getIs_empty()) {
				isFull = false;
				break;
			}
		}
		if (isFull) {

			if (epoch_count < 6) {
				new CalculateScoreAfterEachRound(epoch_count, noofplayers);
				setTextOnScoreButtons(epoch_count);
				objInitialize.InitializeAll(epoch_count);
				objInitialize.setPlayersToInitials(true, noofplayers);
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 6; j++) {
						grid56[i][j].setBackground(null);
						grid56[i][j].setText(null);
						grid56[i][j].setEnabled(true);
					}
				}
				epochlist = XmlOperation.ReadEpochXML();
				tempobj = new Blocks();
				current_turn = 1;
				turn_count = 0;
				blocks = XmlOperation.ReadBlockXML();
				players = XmlOperation.ReadXML();
				placeInitialTiles();
				new SelectNumPlayers().setInitialPlayerTiles();
				for (int i = 0; i < players.size(); i++) {
					if (players.get(i).getStrategy().equals("Human")) {
						switch (i + 1) {
						case 1:
							btntile1_p1.setVisible(true);
							btntile2_p1.setVisible(true);
							btntile3_p1.setVisible(true);
							enablePlayer1();
							break;
						case 2:
							btntile1_p2.setVisible(true);
							btntile2_p2.setVisible(true);
							btntile3_p2.setVisible(true);
							enablePlayer2();
							break;
						case 3:
							btntile1_p3.setVisible(true);
							btntile2_p3.setVisible(true);
							btntile3_p3.setVisible(true);
							enablePlayer3();
							break;
						case 4:
							btntile1_p4.setVisible(true);
							btntile2_p4.setVisible(true);
							btntile3_p4.setVisible(true);
							enablePlayer4();
							break;
						}

					}
				}
				getCastlePlayer_1();
				getCastlePlayer_2();

				switch (noofplayers) {
				case 3:
					getCastlePlayer_3();
					break;
				case 4:
					getCastlePlayer_3();
					getCastlePlayer_4();
					break;
				}

				rotateTurns();
			} else if (epoch_count == 6) {
				frame.setVisible(false);
				new FinishTheGame(noofplayers);
				System.out.println("I am here");
				epochlist = XmlOperation.ReadEpochXML();
				new CalculateScoreAfterEachRound(epoch_count, noofplayers);
				setTextOnScoreButtons(epoch_count);

				int player1score = epochlist.get(0).getPlayer1_score()
						+ epochlist.get(1).getPlayer1_score()
						+ epochlist.get(2).getPlayer1_score();
				int player2score = epochlist.get(0).getPlayer2_score()
						+ epochlist.get(1).getPlayer2_score()
						+ epochlist.get(2).getPlayer2_score();
				int player3score = epochlist.get(0).getPlayer3_score()
						+ epochlist.get(1).getPlayer3_score()
						+ epochlist.get(2).getPlayer3_score();
				int player4score = epochlist.get(0).getPlayer4_score()
						+ epochlist.get(1).getPlayer4_score()
						+ epochlist.get(2).getPlayer4_score();
				System.out.println("FINAL SCORE");
				System.out.println("Player 1:" + player1score);
				System.out.println("Player 2:" + player2score);
				System.out.println("Player 3:" + player3score);
				System.out.println("Player 4:" + player4score);
			}
			epoch_count++;
		}
	}

	/**
	 * Sets the score on the score buttons
	 * 
	 * @param epoch
	 */
	private void setTextOnScoreButtons(int epoch) {

		epochlist = XmlOperation.ReadEpochXML();
		System.out.println(epoch);
		if (epoch == 1) {

			score43_1[0][0].setText("" + epochlist.get(0).getPlayer1_score());
			score43_1[1][0].setText("" + epochlist.get(0).getPlayer2_score());
			score43_1[2][0].setText("" + epochlist.get(0).getPlayer3_score());
			score43_1[3][0].setText("" + epochlist.get(0).getPlayer4_score());
		}
		if (epoch == 2) {
			
			score43_1[0][1].setText("" + epochlist.get(1).getPlayer1_score());
			score43_1[1][1].setText("" + epochlist.get(1).getPlayer2_score());
			score43_1[2][1].setText("" + epochlist.get(1).getPlayer3_score());
			score43_1[3][1].setText("" + epochlist.get(1).getPlayer4_score());
		}
		if (epoch == 3) {
			score43_1[0][2].setText("" + epochlist.get(2).getPlayer1_score());
			score43_1[1][2].setText("" + epochlist.get(2).getPlayer2_score());
			score43_1[2][2].setText("" + epochlist.get(2).getPlayer3_score());
			score43_1[3][2].setText("" + epochlist.get(2).getPlayer4_score());
		}
		if (epoch == 4) {

			score43_2[0][0].setText("" + epochlist.get(3).getPlayer1_score());
			score43_2[1][0].setText("" + epochlist.get(3).getPlayer2_score());
			score43_2[2][0].setText("" + epochlist.get(3).getPlayer3_score());
			score43_2[3][0].setText("" + epochlist.get(3).getPlayer4_score());
		}
		if (epoch == 5) {
			score43_2[0][1].setText("" + epochlist.get(4).getPlayer1_score());
			score43_2[1][1].setText("" + epochlist.get(4).getPlayer2_score());
			score43_2[2][1].setText("" + epochlist.get(4).getPlayer3_score());
			score43_2[3][1].setText("" + epochlist.get(4).getPlayer4_score());
		}
		if (epoch == 6) {
			score43_2[0][2].setText("" + epochlist.get(5).getPlayer1_score());
			score43_2[1][2].setText("" + epochlist.get(5).getPlayer2_score());
			score43_2[2][2].setText("" + epochlist.get(5).getPlayer3_score());
			score43_2[3][2].setText("" + epochlist.get(5).getPlayer4_score());
		}

	}

	/**
	 * Fill board on game load
	 */
	public void fillBoardOnLoad() {
		List<Blocks> blocks = XmlOperation.ReadBlockXML();
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).getIs_empty() == false) {
				placeobjectonboard(blocks.get(i));
			}

		}
	}

	/**
	 * This method place selected castle or tile on board
	 * 
	 * @param block
	 */
	private void placeobjectonboard(Blocks block) {
		if (block.row > 5) {
			block.row = block.row / 10;
		}
		if (block.colummn > 6) {
			block.colummn = block.colummn / 10;
		}
		if (block.row > 0 && block.colummn > 0) {
			if (block.castle_rank != 0) {
				grid56[block.row - 1][block.colummn - 1].setText(String
						.valueOf(block.castle_rank));
			} else {

				grid56[block.row - 1][block.colummn - 1].setText(String
						.valueOf(block.tile));
			}
			grid56[block.row - 1][block.colummn - 1]
					.setBackground(setBlockcolor(block.getPlayer_id()));
			grid56[block.row - 1][block.colummn - 1].setEnabled(false);
		}
		updateBlockList(block);
	}

	/**
	 * Update block list when something(tile/castle) is placed on board
	 * 
	 * @param block
	 */
	private void updateBlockList(Blocks obj) {

		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).getRow() == obj.getRow()
					&& blocks.get(i).getColummn() == obj.getColummn()) {
				blocks.get(i).setColor(obj.getColor());
				blocks.get(i).setIs_empty(false);
				blocks.get(i).setCastle_rank(obj.castle_rank);
				blocks.get(i).setTile(obj.getTile());
				blocks.get(i).setPlayer_id(obj.getPlayer_id());
				blocks.get(i).setPoints(obj.getPoints());
			}
		}
		XmlOperation.WriteBlockXML(blocks);
		new HandleBaseValue(obj);
		isBoardfull();

	}

	/**
	 * Sets block color according to player
	 * 
	 * @param player_id
	 * @return Color
	 */
	public static Color setBlockcolor(int player_id) {
		switch (player_id) {
		case 1:
			return Color.cyan;
		case 2:
			return Color.red;
		case 3:
			return Color.green;
		case 4:
			return Color.yellow;
		default:
			return Color.white;

		}
	}

	/**
	 * This method adds buttons on player spaces in which first tile drawn is
	 * shown.
	 */
	private void addComponentsToPlayerSpace() {

		btntile1_p1.setEnabled(false);
		btntile2_p1.setEnabled(false);
		btntile3_p1.setEnabled(false);

		btntile1_p2.setEnabled(false);
		btntile2_p2.setEnabled(false);
		btntile3_p2.setEnabled(false);

		btntile1_p3.setEnabled(false);
		btntile2_p3.setEnabled(false);
		btntile3_p3.setEnabled(false);

		btntile1_p4.setEnabled(false);
		btntile2_p4.setEnabled(false);
		btntile3_p4.setEnabled(false);

		btntile1_p1.setBounds(700, 600, 100, 33);
		btntile2_p1.setBounds(700, 633, 100, 33);
		btntile3_p1.setBounds(700, 666, 100, 33);

		btntile1_p2.setBounds(800, 100, 100, 33);
		btntile2_p2.setBounds(800, 133, 100, 33);
		btntile3_p2.setBounds(800, 166, 100, 33);

		btntile1_p3.setBounds(200, 0, 100, 33);
		btntile2_p3.setBounds(200, 33, 100, 33);
		btntile3_p3.setBounds(200, 66, 100, 33);

		btntile1_p4.setBounds(100, 500, 100, 33);
		btntile2_p4.setBounds(100, 533, 100, 33);
		btntile3_p4.setBounds(100, 566, 100, 33);

		pane.add(btntile1_p1);
		pane.add(btntile2_p1);
		pane.add(btntile3_p1);

		rank1_1.setBounds(200, 600, 200, 20);
		rank2_1.setBounds(200, 620, 200, 20);
		rank3_1.setBounds(200, 640, 200, 20);
		rank4_1.setBounds(200, 660, 200, 20);

		strategy1.setBounds(425, 650, 150, 50);
		strategy2.setBounds(850, 325, 150, 50);
		strategy3.setBounds(425, 0, 150, 50);
		strategy4.setBounds(0, 325, 150, 50);

		rank1_2.setBounds(800, 500, 200, 20);
		rank2_2.setBounds(800, 520, 200, 20);
		rank3_2.setBounds(800, 540, 200, 20);
		rank4_2.setBounds(800, 560, 200, 20);

		rank1_3.setBounds(600, 0, 200, 20);
		rank2_3.setBounds(600, 20, 200, 20);
		rank3_3.setBounds(600, 40, 200, 20);
		rank4_3.setBounds(600, 60, 200, 20);

		rank1_4.setBounds(0, 100, 200, 20);
		rank2_4.setBounds(0, 120, 200, 20);
		rank3_4.setBounds(0, 140, 200, 20);
		rank4_4.setBounds(0, 160, 200, 20);

		player1.setBounds(400, 600, 200, 50);
		player2.setBounds(800, 250, 50, 200);
		player3.setBounds(400, 50, 200, 50);
		player4.setBounds(150, 250, 50, 200);

		pane.add(rank1_1);
		pane.add(rank2_1);
		pane.add(rank3_1);
		pane.add(rank4_1);
		pane.add(strategy1);
		pane.add(player1);
		getCastlePlayer_1();

		switch (noofplayers) {
		case 2:
			addPlayer2();
			break;
		case 3:
			addPlayer2();
			addPlayer3();
			break;
		case 4:
			addPlayer2();
			addPlayer3();
			addPlayer4();
			break;
		}
	}

	/**
	 * Adds the castle buttons and tile buttons to player 4 space.
	 */
	private void addPlayer4() {

		pane.add(rank1_4);
		pane.add(rank2_4);
		pane.add(rank3_4);
		pane.add(rank4_4);
		pane.add(strategy4);
		pane.add(player4);
		pane.add(btntile1_p4);
		pane.add(btntile2_p4);
		pane.add(btntile3_p4);
		getCastlePlayer_4();

	}

	/**
	 * Adds the castle buttons and tile buttons to player 3 space.
	 */
	private void addPlayer3() {

		pane.add(rank1_3);
		pane.add(rank2_3);
		pane.add(rank3_3);
		pane.add(rank4_3);
		pane.add(strategy3);
		pane.add(player3);
		pane.add(btntile1_p3);
		pane.add(btntile2_p3);
		pane.add(btntile3_p3);
		getCastlePlayer_3();

	}

	/**
	 * Adds the castle buttons and tile buttons to player 2 space.
	 */
	private void addPlayer2() {

		pane.add(rank1_2);
		pane.add(rank2_2);
		pane.add(rank3_2);
		pane.add(rank4_2);
		pane.add(strategy2);
		pane.add(player2);
		pane.add(btntile1_p2);
		pane.add(btntile2_p2);
		pane.add(btntile3_p2);
		getCastlePlayer_2();
	}

	/**
	 * This method adds buttons on the four corners - Kingdoms logo, Save Game,
	 * Epoch Counter, Tile Bank.
	 */
	private void addButtonOnCorners() {
		save.setBounds(800, 0, 200, 100);
		drawtile.setBounds(800, 600, 200, 100);
		drawtile.setEnabled(false);
		pane.add(save);
		pane.add(drawtile);
	}

	/**
	 * This method adds the game board to the middle of the frame and adds
	 * actions to mouse clicks when playing the game.
	 */
	private void addGrid56() {

		// Making the 5*6 grid for placing the tiles and playing the game.
		JPanel pane56 = new JPanel();
		pane56.setLayout(new GridLayout(5, 6));
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 6; y++) {
				final int i, j;
				i = x;
				j = y;
				grid56[x][y] = new JButton(); // creates new button
				pane56.add(grid56[x][y]);// adds button to grid

				grid56[x][y].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (tempobj.player_id != 0 && tempobj.castle_rank != 0) {
							tempobj.setRow(i + 1);
							tempobj.setColummn(j + 1);
							int castlecount;
							int index = tempobj.getPlayer_id() - 1;
							switch (tempobj.castle_rank) {

							case 1:
								castlecount = players.get(index)
										.getRank1_castle();
								players.get(index).setRank1_castle(
										castlecount - 1);

								break;
							case 2:
								castlecount = players.get(index)
										.getRank2_castle();
								players.get(index).setRank2_castle(
										castlecount - 1);
								break;
							case 3:
								castlecount = players.get(index)
										.getRank3_castle();
								players.get(index).setRank3_castle(
										castlecount - 1);
								break;
							case 4:
								castlecount = players.get(index)
										.getRank4_castle();
								players.get(index).setRank4_castle(
										castlecount - 1);

							}
							XmlOperation.WriteXML(players);

							switch (tempobj.getPlayer_id()) {
							case 1:
								getCastlePlayer_1();
								break;
							case 2:
								getCastlePlayer_2();
								break;
							case 3:
								getCastlePlayer_3();
								break;
							case 4:
								getCastlePlayer_4();
								break;
							}

						} else if (tempobj.tile != null) {
							// set row and column in block object to be used
							// later for calculating base values
							tempobj.setRow(i + 1);
							tempobj.setColummn(j + 1);
							handleTilePlacement(tempobj.tile);

						}
						placeobjectonboard(tempobj);
						rotateTurns();

						// reset tempobj parameters to ensure dummy text does
						// not get placed on grid
						tempobj.setPlayer_id(0);
						tempobj.setCastle_rank(0);
						tempobj.setTile(null);

					}

				});

			}
		}
		pane56.setBounds(200, 100, 600, 500);
		pane.add(pane56);
	}

	/**
	 * Randomly assign tiles to player from tile bank and update the same in
	 * playerstats.xml
	 * 
	 * @param tile
	 */
	protected void handleTilePlacement(String tile) {
		List<Player> playerslist = XmlOperation.ReadXML();
		switch (TileButton) {
		case 11:

			tile1_1 = TileBankOperations.getRandomTileFromBank();
			if (tile1_1.equals(null))
				btntile1_p1.setVisible(false);
			else
				btntile1_p1.setText(tile1_1.getTile_name());
			playerslist.get(0).setTile1(tile1_1);
			XmlOperation.WriteXML(playerslist);

			break;
		case 21:
			tile2_1 = TileBankOperations.getRandomTileFromBank();
			if (tile2_1.equals(null))
				btntile2_p1.setVisible(false);
			else
				btntile2_p1.setText(tile2_1.getTile_name());
			playerslist.get(0).setTile2(tile2_1);
			XmlOperation.WriteXML(playerslist);
			break;

		case 31:
			tile3_1 = TileBankOperations.getRandomTileFromBank();
			if (tile3_1.equals(null))
				btntile3_p1.setVisible(false);
			else
				btntile3_p1.setText(tile3_1.getTile_name());
			playerslist.get(0).setTile3(tile3_1);
			XmlOperation.WriteXML(playerslist);
			break;

		case 12:
			tile1_2 = TileBankOperations.getRandomTileFromBank();
			if (tile1_2.equals(null))
				btntile1_p2.setVisible(false);
			else
				btntile1_p2.setText(tile1_2.getTile_name());
			playerslist.get(1).setTile1(tile1_2);
			XmlOperation.WriteXML(playerslist);
			break;
		case 22:
			tile2_2 = TileBankOperations.getRandomTileFromBank();
			if (tile2_2.equals(null))
				btntile2_p2.setVisible(false);
			else
				btntile2_p2.setText(tile2_2.getTile_name());
			playerslist.get(1).setTile2(tile2_2);
			XmlOperation.WriteXML(playerslist);
			break;
		case 32:
			tile3_2 = TileBankOperations.getRandomTileFromBank();
			if (tile3_2.equals(null))
				btntile3_p2.setVisible(false);
			else
				btntile3_p2.setText(tile3_2.getTile_name());
			playerslist.get(1).setTile1(tile3_2);
			XmlOperation.WriteXML(playerslist);
			break;

		case 13:
			tile1_3 = TileBankOperations.getRandomTileFromBank();
			if (tile1_3.equals(null))
				btntile1_p3.setVisible(false);
			else
				btntile1_p3.setText(tile1_3.getTile_name());
			playerslist.get(2).setTile1(tile1_3);
			XmlOperation.WriteXML(playerslist);
			break;
		case 23:
			tile2_3 = TileBankOperations.getRandomTileFromBank();
			if (tile2_3.equals(null))
				btntile2_p3.setVisible(false);
			else
				btntile2_p3.setText(tile2_3.getTile_name());
			playerslist.get(2).setTile1(tile2_3);
			XmlOperation.WriteXML(playerslist);
			break;
		case 33:
			tile3_3 = TileBankOperations.getRandomTileFromBank();
			if (tile3_3.equals(null))
				btntile3_p3.setVisible(false);
			else
				btntile3_p3.setText(tile3_3.getTile_name());
			playerslist.get(2).setTile1(tile3_3);
			XmlOperation.WriteXML(playerslist);
			break;
		case 14:
			tile1_4 = TileBankOperations.getRandomTileFromBank();
			if (tile1_4.equals(null))
				btntile1_p4.setVisible(false);
			else
				btntile1_p4.setText(tile1_4.getTile_name());
			playerslist.get(3).setTile1(tile1_4);
			XmlOperation.WriteXML(playerslist);
			break;
		case 24:
			tile2_4 = TileBankOperations.getRandomTileFromBank();
			if (tile2_4.equals(null))
				btntile2_p4.setVisible(false);
			else
				btntile2_p4.setText(tile2_4.getTile_name());
			playerslist.get(3).setTile1(tile2_4);
			XmlOperation.WriteXML(playerslist);
			break;
		case 34:
			tile3_4 = TileBankOperations.getRandomTileFromBank();
			if (tile3_4.equals(null))
				btntile3_p4.setVisible(false);
			else
				btntile3_p4.setText(tile3_4.getTile_name());
			playerslist.get(3).setTile1(tile3_4);
			XmlOperation.WriteXML(playerslist);
			break;
		}

	}

	/**
	 * Sets the text on rank buttons for player 4
	 * 
	 */
	private void getCastlePlayer_4() {

		players = XmlOperation.ReadXML();
		Player player4 = players.get(3);

		if (player4.getRank1_castle() == 0)
			rank1_4.setEnabled(false);
		else
			rank1_4.setEnabled(true);
		if (player4.getRank2_castle() == 0)
			rank2_4.setEnabled(false);
		else
			rank2_4.setEnabled(true);
		if (player4.getRank3_castle() == 0)
			rank3_4.setEnabled(false);
		else
			rank3_4.setEnabled(true);
		if (player4.getRank4_castle() == 0)
			rank4_4.setEnabled(false);
		else
			rank4_4.setEnabled(true);

		rank1_4.setText(" Rank 1 : " + player4.getRank1_castle());
		rank2_4.setText(" Rank 2 : " + player4.getRank2_castle());
		rank3_4.setText(" Rank 3 : " + player4.getRank3_castle());
		rank4_4.setText(" Rank 4 : " + player4.getRank4_castle());
		strategy4.setText(player4.getStrategy());

	}

	/****
	 * Sets the text on rank buttons for player 3
	 */
	private void getCastlePlayer_3() {

		players = XmlOperation.ReadXML();
		Player player3 = players.get(2);

		if (player3.getRank1_castle() == 0)
			rank1_3.setEnabled(false);
		else
			rank1_3.setEnabled(true);
		if (player3.getRank2_castle() == 0)
			rank2_3.setEnabled(false);
		else
			rank2_3.setEnabled(true);
		if (player3.getRank3_castle() == 0)
			rank3_3.setEnabled(false);
		else
			rank3_3.setEnabled(true);
		if (player3.getRank4_castle() == 0)
			rank4_3.setEnabled(false);
		else
			rank4_3.setEnabled(true);

		rank1_3.setText(" Rank 1 : " + player3.getRank1_castle());
		rank2_3.setText(" Rank 2 : " + player3.getRank2_castle());
		rank3_3.setText(" Rank 3 : " + player3.getRank3_castle());
		rank4_3.setText(" Rank 4 : " + player3.getRank4_castle());
		strategy3.setText(player3.getStrategy());

	}

	/****
	 * Sets the text on rank buttons for player 2
	 */
	private void getCastlePlayer_2() {

		players = XmlOperation.ReadXML();
		Player player2 = players.get(1);

		if (player2.getRank1_castle() == 0)
			rank1_2.setEnabled(false);
		else
			rank1_2.setEnabled(true);
		if (player2.getRank2_castle() == 0)
			rank2_2.setEnabled(false);
		else
			rank2_2.setEnabled(true);
		if (player2.getRank3_castle() == 0)
			rank3_2.setEnabled(false);
		else
			rank3_2.setEnabled(true);
		if (player2.getRank4_castle() == 0)
			rank4_2.setEnabled(false);
		else
			rank4_2.setEnabled(true);

		rank1_2.setText(" Rank 1 : " + player2.getRank1_castle());
		rank2_2.setText(" Rank 2 : " + player2.getRank2_castle());
		rank3_2.setText(" Rank 3 : " + player2.getRank3_castle());
		rank4_2.setText(" Rank 4 : " + player2.getRank4_castle());
		strategy2.setText(player2.getStrategy());

	}

	/****
	 * Sets the text on castle buttons for player 1
	 */
	private void getCastlePlayer_1() {

		players = XmlOperation.ReadXML();
		Player player1 = players.get(0);
		if (player1.getRank1_castle() == 0)
			rank1_1.setEnabled(false);
		else
			rank1_1.setEnabled(true);
		if (player1.getRank2_castle() == 0)
			rank2_1.setEnabled(false);
		else
			rank2_1.setEnabled(true);
		if (player1.getRank3_castle() == 0)
			rank3_1.setEnabled(false);
		else
			rank3_1.setEnabled(true);
		if (player1.getRank4_castle() == 0)
			rank4_1.setEnabled(false);
		else
			rank4_1.setEnabled(true);
		rank1_1.setText(" Rank 1 : " + player1.getRank1_castle());
		rank2_1.setText(" Rank 2 : " + player1.getRank2_castle());
		rank3_1.setText(" Rank 3 : " + player1.getRank3_castle());
		rank4_1.setText(" Rank 4 : " + player1.getRank4_castle());
		strategy1.setText(player1.getStrategy());

	}

	/**
	 * This method contains the actions on various buttons click events.
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == rank1_1) {
			CopyInfo(1, 1);
		} else if (e.getSource() == rank2_1) {
			CopyInfo(1, 2);
		} else if (e.getSource() == rank3_1) {
			CopyInfo(1, 3);
		} else if (e.getSource() == rank4_1) {
			CopyInfo(1, 4);
		} else if (e.getSource() == btntile1_p1) {
			CopyInfo(tile1_1, 1, 11);
			btntile1_p1.setText("");
		} else if (e.getSource() == btntile2_p1) {
			CopyInfo(tile2_1, 1, 21);

		} else if (e.getSource() == btntile3_p1) {
			CopyInfo(tile3_1, 1, 31);

		}

		else if (e.getSource() == rank1_2) {
			CopyInfo(2, 1);
		} else if (e.getSource() == rank2_2) {
			CopyInfo(2, 2);
		} else if (e.getSource() == rank3_2) {
			CopyInfo(2, 3);
		} else if (e.getSource() == rank4_2) {
			CopyInfo(2, 4);
		} else if (e.getSource() == btntile1_p2) {
			CopyInfo(tile1_2, 2, 12);

		} else if (e.getSource() == btntile2_p2) {
			CopyInfo(tile2_2, 2, 22);

		} else if (e.getSource() == btntile3_p2) {
			CopyInfo(tile3_2, 2, 32);

		}

		else if (e.getSource() == rank1_3) {
			CopyInfo(3, 1);
		} else if (e.getSource() == rank2_3) {
			CopyInfo(3, 2);
		} else if (e.getSource() == rank3_3) {
			CopyInfo(3, 3);
		} else if (e.getSource() == rank4_3) {
			CopyInfo(3, 4);
		} else if (e.getSource() == btntile1_p3) {
			CopyInfo(tile1_3, 3, 13);

		} else if (e.getSource() == btntile2_p3) {
			CopyInfo(tile2_3, 3, 23);

		} else if (e.getSource() == btntile3_p3) {
			CopyInfo(tile3_3, 3, 33);

		}

		else if (e.getSource() == rank1_4) {
			CopyInfo(4, 1);
		} else if (e.getSource() == rank2_4) {
			CopyInfo(4, 2);
		} else if (e.getSource() == rank3_4) {
			CopyInfo(4, 3);
		} else if (e.getSource() == rank4_4) {
			CopyInfo(4, 4);
		} else if (e.getSource() == btntile1_p4) {
			CopyInfo(tile1_4, 4, 14);

		} else if (e.getSource() == btntile2_p4) {
			CopyInfo(tile2_4, 4, 24);

		} else if (e.getSource() == btntile3_p4) {
			CopyInfo(tile3_4, 4, 34);

		}

		if (e.getSource() == save) {
			switch (current_turn) {
			case 1:
				players.get(0).setHasturn(true);
				break;
			case 2:
				players.get(1).setHasturn(true);
				break;
			case 3:
				players.get(2).setHasturn(true);
				break;
			case 4:
				players.get(3).setHasturn(true);
				break;
			}

			XmlOperation.WriteBlockXML(blocks);
			XmlOperation.WriteXML(players);
		}

	}

	/**
	 * Sets the properties of temporary block object when tile is placed
	 * 
	 * @param tile
	 */
	@SuppressWarnings("unused")
	private void CopyInfo(Tile tile, int playerid) {
		tempobj.tile = tile.tile_name;
		tempobj.points = tile.tile_value;
		tempobj.player_id = playerid;
		tempobj.castle_rank = 0;

	}

	/**
	 * Sets the properties of temporary block object when tile is placed
	 * 
	 * @param tile
	 */
	private void CopyInfo(Tile tile, int playerid, int tilebtn) {
		tempobj.tile = tile.tile_name;
		tempobj.points = tile.tile_value;
		tempobj.player_id = playerid;
		tempobj.castle_rank = 0;
		TileButton = tilebtn;
	}

}
