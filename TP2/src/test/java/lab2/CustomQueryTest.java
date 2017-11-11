package lab2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CustomQueryTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CustomQueryTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CustomQueryTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {

		CustomQuery.main(new String[] {"jdbc:mysql://localhost/sakila", "com.mysql.jdbc.Driver", "root", "", "Select id from actor"});

		CustomQuery.main(new String[] {"jdbc:mysql://localhost/sakila", "com.mysql.jdbc.Driver", "root", "", "Select actor_id from actor"});
	}
}