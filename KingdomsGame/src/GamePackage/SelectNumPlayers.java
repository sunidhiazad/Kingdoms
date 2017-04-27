package GamePackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * This class is made to let the user select number of players and to assign
 * strategies to them before starting the game.
 * 
 * @author ASPIRE
 * 
 */
public class SelectNumPlayers extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel label1 = new JLabel("Select number of players : ");
	JLabel player1_strategy = new JLabel("Select strategy for Player 1 : ");
	JLabel player2_strategy = new JLabel("Select strategy for Player 2 : ");
	final JLabel player3_strategy = new JLabel(
			"Select strategy for Player 3 : ");
	final JLabel player4_strategy = new JLabel(
			"Select strategy for Player 4 : ");

	JButton submit = new JButton("Start Game");

	JRadioButton playernum2 = new JRadioButton("2");
	JRadioButton playernum3 = new JRadioButton("3");
	JRadioButton playernum4 = new JRadioButton("4");
	JRadioButton p1_human = new JRadioButton("Human Player");
	JRadioButton p1_max = new JRadioButton("Maximize own score");
	JRadioButton p1_min = new JRadioButton("Minimize opponent's scores");
	JRadioButton p1_random = new JRadioButton("Play Randomly");
	JRadioButton p2_human = new JRadioButton("Human Player");
	JRadioButton p2_max = new JRadioButton("Maximize own score");
	JRadioButton p2_min = new JRadioButton("Minimize opponents' scores");
	JRadioButton p2_random = new JRadioButton("Play Randomly");
	final JRadioButton p3_human = new JRadioButton("Human Player");
	final JRadioButton p3_max = new JRadioButton("Maximize own score");
	final JRadioButton p3_min = new JRadioButton("Minimize opponent's scores");
	final JRadioButton p3_random = new JRadioButton("Play Randomly");
	final JRadioButton p4_human = new JRadioButton("Human Player");
	final JRadioButton p4_max = new JRadioButton("Maximize own score");
	final JRadioButton p4_min = new JRadioButton("Minimize opponent's scores");
	final JRadioButton p4_random = new JRadioButton("Play Randomly");

	ButtonGroup group = new ButtonGroup();
	ButtonGroup player1strats = new ButtonGroup();
	ButtonGroup player2strats = new ButtonGroup();
	ButtonGroup player3strats = new ButtonGroup();
	ButtonGroup player4strats = new ButtonGroup();

	JFrame frame_player = new JFrame("Reiner Knizia's Kingdoms");
	Container pane_player = frame_player.getContentPane();

	CreateAndShowGUI obj = new CreateAndShowGUI();
	List<Player> players = new ArrayList<Player>();
	Initialize objInitialize = new Initialize();
	Boolean isNewGame;

	/**
	 * Default Constructor
	 */
	public SelectNumPlayers() {

	}

	/**
	 * Creates the frame and determine if its called from New Game or Load Game
	 * 
	 * @param isNew
	 */
	public SelectNumPlayers(Boolean isNew) {

		isNewGame = isNew;
		frame_player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane_player.setLayout(null);
		frame_player.setSize(450, 420);
		frame_player.setVisible(true);
		frame_player.setResizable(false);
		makeRadioButtonGroups();
		setBoundsOfComponents();
		addComponentsToPane();
		addActionsToComponents();
		if (!isNewGame) {
			loadplayerstrategy();
		}

	}

	/**
	 * Assign strategies that were there before saving the game.
	 */
	private void loadplayerstrategy() {

		players = XmlOperation.ReadXML();

		playernum2.setEnabled(false);
		playernum3.setEnabled(false);
		playernum4.setEnabled(false);

		switch (players.size()) {
		case 2:
			playernum2.setEnabled(true);
			playernum2.setSelected(true);
			enable_Strategy2();
			setplayer1_strategy(players.get(0).getStrategy());
			setplayer2_strategy(players.get(1).getStrategy());
			break;
		case 3:
			playernum3.setEnabled(true);
			playernum3.setSelected(true);
			enable_Strategy3();
			setplayer1_strategy(players.get(0).getStrategy());
			setplayer2_strategy(players.get(1).getStrategy());
			setplayer3_strategy(players.get(2).getStrategy());

			break;
		case 4:
			playernum4.setEnabled(true);
			playernum4.setSelected(true);
			enable_Strategy4();
			setplayer1_strategy(players.get(0).getStrategy());
			setplayer2_strategy(players.get(1).getStrategy());
			setplayer3_strategy(players.get(2).getStrategy());
			setplayer4_strategy(players.get(3).getStrategy());
			break;
		}

	}

	/**
	 * Sets the strategy for player 4
	 * 
	 * @param strategy
	 */
	private void setplayer4_strategy(String strategy) {

		switch (strategy) {
		case "Human":
			p4_human.setSelected(true);
			break;
		case "Min":
			p4_min.setSelected(true);
			break;
		case "Max":
			p4_max.setSelected(true);
			break;
		case "Random":
			p4_random.setSelected(true);
			break;
		}

	}

	/**
	 * Sets the strategy for player 3
	 * 
	 * @param strategy
	 */
	private void setplayer3_strategy(String strategy) {
		switch (strategy) {
		case "Human":
			p3_human.setSelected(true);
			break;
		case "Min":
			p3_min.setSelected(true);
			break;
		case "Max":
			p3_max.setSelected(true);
			break;
		case "Random":
			p3_random.setSelected(true);
			break;
		}

	}

	/**
	 * Sets the strategy for player 2
	 * 
	 * @param strategy
	 */
	private void setplayer2_strategy(String strategy) {

		switch (strategy) {
		case "Human":
			p2_human.setSelected(true);
			break;
		case "Min":
			p2_min.setSelected(true);
			break;
		case "Max":
			p2_max.setSelected(true);
			break;
		case "Random":
			p2_random.setSelected(true);
			break;
		}
	}

	/**
	 * Sets the strategy for player 1
	 * 
	 * @param strategy
	 */
	private void setplayer1_strategy(String strategy) {

		switch (strategy) {
		case "Human":
			p1_human.setSelected(true);
			break;
		case "Min":
			p1_min.setSelected(true);
			break;
		case "Max":
			p1_max.setSelected(true);
			break;
		case "Random":
			p1_random.setSelected(true);
			break;
		}
	}

	/**
	 * Adds actions to every radio button and start game button
	 */
	private void addActionsToComponents() {

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				XmlOperation.WriteXML(players);
				if (isNewGame) {
					objInitialize.setScoreToInitial();
					objInitialize.InitializeAll(1);
					setInitialPlayerTiles();

					obj.createAndShowGUI(true);

				} else {

					obj.createAndShowGUI(false);
				}
				frame_player.setVisible(false);
			}
		});

		playernum2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				objInitialize.setPlayersToInitials(false, 2);
				enable_Strategy2();
			}

		});

		playernum3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				objInitialize.setPlayersToInitials(false, 3);

				enable_Strategy3();

			}

		});

		playernum4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				objInitialize.setPlayersToInitials(false, 4);
				enable_Strategy4();
			}

		});

		p1_human.addActionListener(this);
		p1_max.addActionListener(this);
		p1_min.addActionListener(this);
		p1_random.addActionListener(this);

		p2_human.addActionListener(this);
		p2_max.addActionListener(this);
		p2_min.addActionListener(this);
		p2_random.addActionListener(this);

		p3_human.addActionListener(this);
		p3_max.addActionListener(this);
		p3_min.addActionListener(this);
		p3_random.addActionListener(this);

		p4_human.addActionListener(this);
		p4_max.addActionListener(this);
		p4_min.addActionListener(this);
		p4_random.addActionListener(this);

	}

	/**
	 * Groups the radio buttons together to let the user select only one from
	 * the group
	 */
	private void makeRadioButtonGroups() {
		group.add(playernum4);
		group.add(playernum3);
		group.add(playernum2);

		player1strats.add(p1_human);
		player1strats.add(p1_max);
		player1strats.add(p1_min);
		player1strats.add(p1_random);

		player2strats.add(p2_human);
		player2strats.add(p2_max);
		player2strats.add(p2_min);
		player2strats.add(p2_random);

		player3strats.add(p3_human);
		player3strats.add(p3_max);
		player3strats.add(p3_min);
		player3strats.add(p3_random);

		player4strats.add(p4_human);
		player4strats.add(p4_max);
		player4strats.add(p4_min);
		player4strats.add(p4_random);

		// p1_human.setSelected(true);
		// p2_human.setSelected(true);
		// p3_human.setSelected(true);
		// p4_human.setSelected(true);
	}

	/**
	 * adds all the components to the pane.
	 */
	private void addComponentsToPane() {
		pane_player.add(p1_human);
		pane_player.add(p1_max);
		pane_player.add(p1_min);
		pane_player.add(p1_random);
		pane_player.add(player1_strategy);

		pane_player.add(p2_human);
		pane_player.add(p2_max);
		pane_player.add(p2_min);
		pane_player.add(p2_random);
		pane_player.add(player2_strategy);

		pane_player.add(p3_human);
		pane_player.add(p3_max);
		pane_player.add(p3_min);
		pane_player.add(p3_random);
		pane_player.add(player3_strategy);

		pane_player.add(p4_human);
		pane_player.add(p4_max);
		pane_player.add(p4_min);
		pane_player.add(p4_random);
		pane_player.add(player4_strategy);
		pane_player.add(label1);
		pane_player.add(playernum4);
		pane_player.add(playernum3);
		pane_player.add(playernum2);
		pane_player.add(submit);
	}

	/**
	 * Sets the dimensions each component on the pane with null layout.
	 */
	private void setBoundsOfComponents() {

		label1.setBounds(125, 20, 200, 50);

		playernum2.setBounds(125, 50, 50, 50);
		playernum3.setBounds(175, 50, 50, 50);
		playernum4.setBounds(225, 50, 50, 50);

		player1_strategy.setBounds(25, 90, 200, 50);
		p1_human.setBounds(25, 130, 200, 25);
		p1_max.setBounds(25, 150, 200, 25);
		p1_min.setBounds(25, 170, 200, 25);
		p1_random.setBounds(25, 190, 200, 25);

		player2_strategy.setBounds(225, 90, 200, 50);
		p2_human.setBounds(225, 130, 200, 25);
		p2_max.setBounds(225, 150, 200, 25);
		p2_min.setBounds(225, 170, 200, 25);
		p2_random.setBounds(225, 190, 200, 25);

		player3_strategy.setBounds(25, 210, 200, 50);
		p3_human.setBounds(25, 250, 200, 25);
		p3_max.setBounds(25, 270, 200, 25);
		p3_min.setBounds(25, 290, 200, 25);
		p3_random.setBounds(25, 310, 200, 25);

		player4_strategy.setBounds(225, 210, 200, 50);
		p4_human.setBounds(225, 250, 200, 25);
		p4_max.setBounds(225, 270, 200, 25);
		p4_min.setBounds(225, 290, 200, 25);
		p4_random.setBounds(225, 310, 200, 25);

		submit.setBounds(125, 340, 200, 25);

		submit.setEnabled(false);
		player1_strategy.setEnabled(false);
		p1_human.setEnabled(false);
		p1_max.setEnabled(false);
		p1_min.setEnabled(false);
		p1_random.setEnabled(false);

		player2_strategy.setEnabled(false);
		p2_human.setEnabled(false);
		p2_max.setEnabled(false);
		p2_min.setEnabled(false);
		p2_random.setEnabled(false);

		player3_strategy.setEnabled(false);
		p3_human.setEnabled(false);
		p3_max.setEnabled(false);
		p3_min.setEnabled(false);
		p3_random.setEnabled(false);

		player4_strategy.setEnabled(false);
		p4_human.setEnabled(false);
		p4_max.setEnabled(false);
		p4_min.setEnabled(false);
		p4_random.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == p1_human)
			players.get(0).setStrategy("Human");
		else if (e.getSource() == p1_max)
			players.get(0).setStrategy("Max");
		else if (e.getSource() == p1_min)
			players.get(0).setStrategy("Min");
		else if (e.getSource() == p1_random)
			players.get(0).setStrategy("Random");

		if (e.getSource() == p2_human)
			players.get(1).setStrategy("Human");
		else if (e.getSource() == p2_max)
			players.get(1).setStrategy("Max");
		else if (e.getSource() == p2_min)
			players.get(1).setStrategy("Min");
		else if (e.getSource() == p2_random)
			players.get(1).setStrategy("Random");

		if (e.getSource() == p3_human)
			players.get(2).setStrategy("Human");
		else if (e.getSource() == p3_max)
			players.get(2).setStrategy("Max");
		else if (e.getSource() == p3_min)
			players.get(2).setStrategy("Min");
		else if (e.getSource() == p3_random)
			players.get(2).setStrategy("Random");

		if (e.getSource() == p4_human)
			players.get(3).setStrategy("Human");
		else if (e.getSource() == p4_max)
			players.get(3).setStrategy("Max");
		else if (e.getSource() == p4_min)
			players.get(3).setStrategy("Min");
		else if (e.getSource() == p4_random)
			players.get(3).setStrategy("Random");

	}

	/**
	 * Selects random tile from tilebank and assigns it to the users
	 */
	public void setInitialPlayerTiles() {
		players = XmlOperation.ReadXML();
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setTile1(TileBankOperations.getRandomTileFromBank());
			players.get(i).setTile2(TileBankOperations.getRandomTileFromBank());
			players.get(i).setTile3(TileBankOperations.getRandomTileFromBank());
		}
		XmlOperation.WriteXML(players);

	}

	/**
	 * Called when number of players is 2 to enable the buttons for only those players.
	 */
	private void enable_Strategy2() {
		players = XmlOperation.ReadXML();
		submit.setEnabled(true);
		player1_strategy.setEnabled(true);
		p1_human.setEnabled(true);
		p1_max.setEnabled(true);
		p1_min.setEnabled(true);
		p1_random.setEnabled(true);

		player2_strategy.setEnabled(true);
		p2_human.setEnabled(true);
		p2_max.setEnabled(true);
		p2_min.setEnabled(true);
		p2_random.setEnabled(true);

		player3_strategy.setEnabled(false);
		p3_human.setEnabled(false);
		p3_max.setEnabled(false);
		p3_min.setEnabled(false);
		p3_random.setEnabled(false);

		player4_strategy.setEnabled(false);
		p4_human.setEnabled(false);
		p4_max.setEnabled(false);
		p4_min.setEnabled(false);
		p4_random.setEnabled(false);

	}

	/**
	 * Called when number of players is 4 to enable the buttons for only those players.
	 */
	private void enable_Strategy4() {
		players = XmlOperation.ReadXML();

		submit.setEnabled(true);
		player1_strategy.setEnabled(true);
		p1_human.setEnabled(true);
		p1_max.setEnabled(true);
		p1_min.setEnabled(true);
		p1_random.setEnabled(true);

		player2_strategy.setEnabled(true);
		p2_human.setEnabled(true);
		p2_max.setEnabled(true);
		p2_min.setEnabled(true);
		p2_random.setEnabled(true);

		player3_strategy.setEnabled(true);
		p3_human.setEnabled(true);
		p3_max.setEnabled(true);
		p3_min.setEnabled(true);
		p3_random.setEnabled(true);

		player4_strategy.setEnabled(true);
		p4_human.setEnabled(true);
		p4_max.setEnabled(true);
		p4_min.setEnabled(true);
		p4_random.setEnabled(true);
	}

	/**
	 * Called when number of players is 3 to enable the buttons for only those players.
	 */
	private void enable_Strategy3() {
		players = XmlOperation.ReadXML();

		submit.setEnabled(true);
		player1_strategy.setEnabled(true);
		p1_human.setEnabled(true);
		p1_max.setEnabled(true);
		p1_min.setEnabled(true);
		p1_random.setEnabled(true);

		player2_strategy.setEnabled(true);
		p2_human.setEnabled(true);
		p2_max.setEnabled(true);
		p2_min.setEnabled(true);
		p2_random.setEnabled(true);

		player3_strategy.setEnabled(true);
		p3_human.setEnabled(true);
		p3_max.setEnabled(true);
		p3_min.setEnabled(true);
		p3_random.setEnabled(true);

		player4_strategy.setEnabled(false);
		p4_human.setEnabled(false);
		p4_max.setEnabled(false);
		p4_min.setEnabled(false);
		p4_random.setEnabled(false);

	}

}
