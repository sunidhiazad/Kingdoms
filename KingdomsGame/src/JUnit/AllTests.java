package JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * Test suite to run all the tests
 * @author ASPIRE
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CalculateScoreAfterEachRoundTest.class,
		HandleBaseValueTest.class, InitializeTest.class, StartPanelTest.class,
		TileBankOperationsTest.class, XmlOperationTest.class })
public class AllTests {

}
