package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.assignment.StudentID;


public class TestStudentID {
	static StudentID ID1, ID2, ID3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ID1 = StudentID.getInstance();
		ID2 = StudentID.getInstance();
		ID3 = StudentID.getInstance();
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetInstance() {
		
	assertNotNull(StudentID.getInstance());	
		

	}

	@Test
	public void testGetLetter() {
		char x;
		
		x = ID2.getLetter();
		
		assertEquals('a', x);		

	}	
	@Test
	public void testGetLetter2() {
		char x;
			
		x = ID3.getLetter();
			
		assertEquals('a', x);		

	}

	@Test
	public void testGetNumber() {
		int x;
		
		x = ID2.getNumber();
		
		assertEquals(2, x);		

	}
	@Test
	public void testGetNumber2() {
		int x;
		
		x = ID3.getNumber();
		
		assertEquals(3, x);		

	}

	@Test
	public void testToString() {
		String x;
		
		x = ID2.toString();
		
		assertEquals("a0002", x);	

	}
	
	@Test
	public void testToString2() {
		String x;
		
		x = ID3.toString();
		
		assertEquals("a0003", x);	

	}

}
