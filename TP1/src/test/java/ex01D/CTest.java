package ex01D;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ex01D.C;

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
		int i = 0;
		StringBuffer s = new StringBuffer("abc");
		C.method1(i, s);
		assertEquals(i, 0);
		assertEquals(s.toString(), "abcd");
	}
}
