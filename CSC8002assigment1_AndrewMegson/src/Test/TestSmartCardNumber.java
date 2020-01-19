package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.SmartCardNumber;

public class TestSmartCardNumber {
	static SmartCardNumber number1, number2, number3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	number1 = SmartCardNumber.getInstance("ej");
	number2 = SmartCardNumber.getInstance("bj");
	number3 = SmartCardNumber.getInstance("fm");
		
		
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetInstance() {
		
	assertNotNull(number1);
	
		
		
		
		
	}

	@Test
	public void testToString() {
	
	String x;
	x = "ej-2019-01";
	
	
	assertEquals(number1.toString(), x);
		
		
		
	}
	
	@Test
	public void test2ToString() {
	
	String x;
	x = "bj-2019-02";
	
	
	assertEquals(number2.toString(), x);
		
		
		
	}

	@Test
	public void testGetIssueYear() {
		
		
		assertEquals(number1.getIssueYear(), 2019);	
	}
	
	@Test
	public void test2GetIssueYear() {
		
		
		assertEquals(number1.getIssueYear(), 2019);	
	}

}
