package ex01E;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CTest  extends TestCase {

	public CTest( String testName )
	{
		super( testName );
	}
	public static Test suite()
	{
		return new TestSuite( CTest.class );
	}
	public void testApp()
	{
		C c = new C();
		c.test();
		assertEquals(c.a, 1);
	}
}
