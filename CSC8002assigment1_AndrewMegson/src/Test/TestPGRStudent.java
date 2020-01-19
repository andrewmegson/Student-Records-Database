package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.AbstractStudent;
import uk.ac.assignment.Name;
import uk.ac.assignment.PGRStudent;
import uk.ac.assignment.UGStudent;

public class TestPGRStudent {
	
	private static Name name1, name2, name3;
	private static Date dob1, dob2, dob3;	
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	name1 = Name.getInstance("Elton", "John");
	name2 = Name.getInstance("Billy", "Joel");
	name3 = Name.getInstance("Freddie", "Mercury");
			
	dob1 = AbstractStudent.setDob(1950, 5, 20);
	dob2 = AbstractStudent.setDob(2010, 6, 15);
	dob3 = AbstractStudent.setDob(1970, 1, 22);	

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Test
	public void testGetInstance() throws Exception {
		PGRStudent s = PGRStudent.getInstance(name1, dob1);	
		assertNotNull(s);
	}
	
	
	@Test
	public void testGetStudentType() throws Exception {
		
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
		
	String x;
		
	x = s.getStudentType();
	
	assertEquals("PGR", x);
		
	}

	@Test
	public void testListStudentModules() throws Exception {
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
		
		assertNull(s.listStudentModules());
	}

	@Test
	public void testGetStudentRegistrationStatus() throws Exception {
		
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
		
	
	assertEquals(s.getStudentRegistrationStatus(), false);
	}
	
	
	@Test
	public void test2GetStudentRegistrationStatus() throws Exception {
		
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
	
	Name supervisor = Name.getInstance("John", "Smith");
	
	s.setSupervisor(supervisor);
	
	
	assertEquals(s.getStudentRegistrationStatus(), true);
	}
	
	

	@Test
	public void testGetSupervisor() throws Exception {
		
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
		
	Name supervisor = Name.getInstance("John", "Smith");
		
	s.setSupervisor(supervisor);
	
	assertEquals("john smith", s.getSupervisor().toString());
		
		
	
	}

	@Test
	public void testSetSupervisor() throws Exception {
	PGRStudent s = PGRStudent.getInstance(name1, dob1);
		
	Name supervisor = Name.getInstance("Jim", "Carrey");
		
	s.setSupervisor(supervisor);
		
	assertNotNull(s.getSupervisor());
	}

	@Test
	public void testToString() throws Exception {
	
	}

}
