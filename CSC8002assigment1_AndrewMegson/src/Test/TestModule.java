package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.Module;

public class TestModule {
	
	 static Module module1, module2, module3;
	
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		module1 = Module.getInstance("CSC8001", "Programming Java", 20);
		module2 = Module.getInstance("CSC8002", "Advanced Java", 20);
		module3 = Module.getInstance("CSC8003", "Databases", 10);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testGetInstance() {
	
	assertNotNull(module1);	
		
	}

	@Test
	public void testGetModuleCode() {
		
		String x = module2.getModuleCode();
		
		assertEquals(x, "CSC8002");
		
	}

	@Test
	public void testGetModuleName() {
		
		String x = module2.getModuleName();
		
		assertEquals(x, "advanced java");
		
	}

	@Test
	public void testGetModuleCredits() {
		
		int x = module2.getModuleCredits();
		
		assertEquals(x, 20);
	}

	@Test
	public void testToString() {
		
		String x = module2.toString();
		
		assertEquals(x, "CSC8002 advanced java 20");
		
		
	}

	@Test
	public void testValueOf() throws Exception {
		
		String x = "CSC8005, advanced databases, 20";
		
		Module test = Module.valueOf(x);
		
		Module test2 = Module.getInstance("CSC8005", "advanced databases", 20);
		
		assertEquals(test, test2);
		
		
		
		
		
	}

}
