package com.mini.javaProject;

import org.junit.Test;
import static org.junit.Assert.*;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
//    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }

    /**
     * @return the suite of tests being tested
     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }

    /**
     * Rigourous Test :-)
     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
    
	@Test
	public void sumTest() { 
		int a = 1;
		int b = 2;
		int expected = 3;
		int result = App.sum(a, b);
		
		assertEquals(expected, result);
	}
}