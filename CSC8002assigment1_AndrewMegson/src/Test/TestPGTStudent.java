package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.AbstractStudent;
import uk.ac.assignment.Module;
import uk.ac.assignment.Name;
import uk.ac.assignment.PGTStudent;
import uk.ac.assignment.UGStudent;

public class TestPGTStudent {
	
	 private static Name name1, name2, name3;
	 private static Date dob1, dob2, dob3;
	 private static Module module1, module2, module3, module4, module5;	
	
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	name1 = Name.getInstance("Elton", "John");
	name2 = Name.getInstance("Billy", "Joel");
	name3 = Name.getInstance("Freddie", "Mercury");
		
	dob1 = AbstractStudent.setDob(1950, 5, 20);
	dob2 = AbstractStudent.setDob(2010, 6, 15);
	dob3 = AbstractStudent.setDob(1970, 1, 22);
		
		
	module1 = Module.getInstance("CSC8001", "Programming Java", 60);
	module2 = Module.getInstance("CSC8002", "Advanced Java", 60);
	module3 = Module.getInstance("CSC8003", "Databases", 60);
	module4 = Module.getInstance("CSC8004", "Networks", 40);
	module5 = Module.getInstance("CSC8004", "Web Technology", 60);	
		
	PGTStudent s = PGTStudent.getInstance(name1, dob1);	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testGetInstance() throws Exception {
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
		
		assertNotNull(s);
	}
	@Test
	public void testGetStudentType() throws Exception {
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
		
		String x;
		
		x = s.getStudentType();
		
		assertEquals("PGT", x);
		
	}

	@Test
	public void testListStudentModules() throws Exception {
		
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
		
		
		s.addModule(module1);
		s.addModule(module2);
		
	
		
		assertEquals(s.listStudentModules().size(), 2);
	}

	@Test
	public void testGetStudentRegistrationStatus() throws Exception {
		
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
		
		s.addModule(module1);
		s.addModule(module2);
	
		
		assertEquals(s.getStudentRegistrationStatus(), false);
	}
	
	@Test
	public void test2GetStudentRegistrationStatus() throws Exception {
		
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
		
		s.addModule(module1);
		s.addModule(module2);
		s.addModule(module3);
	

		assertEquals(s.getStudentRegistrationStatus(), true);
	}



	@Test
	public void testAddModule() throws Exception {
			
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
			
		s.addModule(module1);
		s.addModule(module2);
		s.addModule(module3);
		
			
		assertEquals(s.listStudentModules().size(), 3);
	}
		
		@Test
		public void test2AddModule() throws Exception {
			
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
			
		s.addModule(module1);
		s.addModule(module2);
		s.addModule(module3);
		s.addModule(module4);
		s.addModule(module5);
			
		assertEquals(s.listStudentModules().size(), 3);
	}
	

	@Test
	public void testRemoveModule() throws Exception {
			
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
			
		s.addModule(module1);
		s.addModule(module2);
		s.addModule(module3);
			
		s.removeModule(module2);
			
			
			
		assertEquals(s.listStudentModules().size(), 2);
			
			
	}
		
	@Test
	public void test2RemoveModule() throws Exception {
			
		PGTStudent s = PGTStudent.getInstance(name1, dob1);
			
		s.addModule(module1);
		s.addModule(module2);
		s.addModule(module3);
	
			
		s.removeModule(module3);
		s.removeModule(module2);
			
			
		assertEquals(s.listStudentModules().size(), 1);
			
			
	}

	@Test
	public void testToString() {
		
	//test
		
		
		
		
		
	}	
}
