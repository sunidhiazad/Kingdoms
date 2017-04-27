package GamePackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This class drawing the JFram and content for beginning guide
 * 
 */
public class StartPanel extends JFrame implements ActionListener {

	CreateAndShowGUI obj = new CreateAndShowGUI();

	private static final long serialVersionUID = 1L;
	// Create Buttons to be added on StartUp
	JButton newgame = new JButton("New Game");
	JButton loadgame = new JButton("Load Game");

	// Create the panel to hold the buttons
	JFrame frame = new JFrame("Reiner Knizia's Kingdoms");
	Container pane = frame.getContentPane();

	/**
	 * Initialising the frame and panel settings
	 */
	public StartPanel() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(null);
		frame.setSize(150, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		// method to add buttons on the panel
		addControls();
		// method to add action to the button events
		addActionsToClicks();

	}

	/**
	 * adds the buttons New Game and Load Game on the pane
	 * @return rootPaneCheckingEnabled
	 */
	public Boolean addControls() {
		// Set the dimensions and placement of all the buttons on the panel
		newgame.setBounds(25, 25, 100, 50);
		loadgame.setBounds(25, 100, 100, 50);
		// add the buttons to the panel
		pane.add(newgame);
		pane.add(loadgame);
		return rootPaneCheckingEnabled;
	}

	/**
	 * adds actions to buttons
	 */
	public void addActionsToClicks() {
		newgame.addActionListener(this);
		loadgame.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		if (e.getSource() == newgame) {
			new SelectNumPlayers(true);

		} else if (e.getSource() == loadgame) {
			new SelectNumPlayers(false);

		}
	}

}
