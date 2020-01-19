package Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.AbstractStudent;
import uk.ac.assignment.Module;
import uk.ac.assignment.Name;
import uk.ac.assignment.PGRStudent;
import uk.ac.assignment.PGTStudent;
import uk.ac.assignment.StudentID;
import uk.ac.assignment.UGStudent;

public class TestAbstractStudent {
	
	static Name name1, name2, name3;
	static Date dob1, dob2, dob3;
	static AbstractStudent abStudent1, abStudent2, abStudent3;

	static Module module1, module2, module3, module4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	name1 = Name.getInstance("Elton", "John");
	name2 = Name.getInstance("Billy", "Joel");
	name3 = Name.getInstance("Freddie", "Mercury");
	
	dob1 = AbstractStudent.setDob(1950, 5, 20);
	dob2 = AbstractStudent.setDob(1990, 6, 15);
	dob3 = AbstractStudent.setDob(1970, 1, 22);
	
		
	abStudent1 = UGStudent.getInstance(name1, dob1);
	abStudent2 = PGTStudent.getInstance(name2, dob2);
	abStudent3 = PGRStudent.getInstance(name3, dob3);	
	
	module1 = Module.getInstance("CSC8001", "Programming Java", 20);
	module2 = Module.getInstance("CSC8002", "Advanced Java", 20);
	module3 = Module.getInstance("CSC8003", "Databases", 10);
	module4 = Module.getInstance("CSC8004", "Networks", 10);	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAbstractStudent() {
		
		assertNotNull(abStudent1);
		
		
		
	}

	//@Test
	//public void testGetStudentType() 
	

	//@Test
	//public void testListStudentModules() {
	

	//@Test
	//public void testGetStudentRegistrationStatus() {


	@Test
	public void testGetStudentName() throws Exception {

		Name name;
		
		name = abStudent3.getStudentName();
		
		Name testName = Name.getInstance("Freddie", "Mercury");
		assertEquals(name, testName);
		
	}

	@Test
	public void testGetStudentID() {
		
		
		StudentID id = abStudent2.getStudentID();
		
		
		assertEquals(id.toString(), "a0002");

	}

	@Test
	public void testGetDob() throws Exception {
		
		Date dob4 = AbstractStudent.setDob(1950, 5, 20);
		
		Date test = abStudent1.getDob();
		
		// equals issue due to clone??
		
		assertEquals(test, dob4);
		
		
		
		
	}

	//@Test
	//public void testAddModule() {
		
		
		
		
	//}

	//@Test
	//public void testRemoveModule() {
		
	//}

	@Test
	public void testSetDob() throws Exception {
		Date dob4 = AbstractStudent.setDob(1988, 8, 24);
		
		assertNotNull(dob4);
	}

	@Test
	public void testCalStudentAgeYears() {
		
		int age;
		
		age = abStudent3.calStudentAgeYears();
		
		assertEquals(age, 49);
			
	}

}
