package JUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import GamePackage.StartPanel;
/**
 * 
 * This class test GUI Frame creation
 *
 */
public class StartPanelTest {
	StartPanel obj = new StartPanel();

	@Before
	public void setUp() throws Exception {
		
		obj.addActionsToClicks();
		//obj.actionPerformed(e);
	}

	@Test
	public final void testStartPanel() {
	}

	@Test
	public final void testAddControls() {
		assertTrue("Returns true if JFrame is successfully constructed", obj.addControls());
	}

	@Test
	public final void testAddActionsToClicks() {
	}

	@Test
	public final void testActionPerformed() {
	}

}
