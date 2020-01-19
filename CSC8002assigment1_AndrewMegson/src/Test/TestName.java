/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.Name;

/**
 * @author a6637526
 *
 */
public class TestName {
	
	static Name name1, name2, name3;
	
	
	
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		name1 = Name.getInstance("Elton", "John");
		name2 = Name.getInstance("Billy", "Joel");
		name3 = Name.getInstance("Freddie", "Mercury");
		
		
	
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#getInstance(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetInstance() throws Exception {
		Name name4 = Name.getInstance("Steven", "Tyler");
		
		assertNotNull(name4);
		
		
		
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#toString()}.
	 */
	@Test
	public void testToString() {
		String x;
		
		x = name1.toString();
		
		assertEquals("elton john", x);
		
		
		
		
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#getInitials()}.
	 */
	@Test
	public void testGetInitials() {
		String x;
		
		x = name2.getInitials();
		
		assertEquals("bj", x);
		
		
		
		
		

		
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#valueOf(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testValueOf() throws Exception {
		
		Name testName = Name.valueOf("elton, john");
		
		assertEquals(testName, name1);
		
		
		
		
		
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
	
	String x;
	x = name3.getFirstName();
	
	assertEquals(x, "freddie");
		
		
	}

	/**
	 * Test method for {@link uk.ac.assignment.Name#getLastName()}.
	 */
	@Test
	public void testGetLastName() {

	String x;
	x = name3.getLastName();
		
	assertEquals(x, "mercury");
			
			
	}

}
