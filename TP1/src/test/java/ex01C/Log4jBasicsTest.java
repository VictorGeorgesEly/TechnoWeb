package ex01C;
import org.apache.log4j.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Log4jBasicsTest extends TestCase
{
	protected static Logger log = Logger.getLogger(Log4jBasicsTest.class);

	public Log4jBasicsTest( String testName )
	{
		super( testName );
	}
	public static Test suite()
	{
		return new TestSuite( Log4jBasicsTest.class );
	}
	public void testApp()
	{
		log.setLevel(Level.DEBUG);
		assertEquals(log.getLevel(), Level.DEBUG);
	}
}
