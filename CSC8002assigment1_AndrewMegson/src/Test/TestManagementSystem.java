package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.ManagementSystem;
import uk.ac.assignment.Module;
import uk.ac.assignment.SmartCard;
import uk.ac.assignment.Student;
import uk.ac.assignment.ManagementSystem.Modifier;
import uk.ac.assignment.ManagementSystem.StudentType;

public class TestManagementSystem {
	
	static ManagementSystem managementSystem;
	
	static Module module1, module2, module3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	managementSystem = ManagementSystem.getInstance();
	
	managementSystem.registerStudent("Elton", "John", 1955, 10, 22, StudentType.UG);
	managementSystem.registerStudent("Billy", "Joel", 1970, 10, 17, StudentType.UG);
	managementSystem.registerStudent("Freddie", "Mercury", 1944, 11, 2, StudentType.PGT);
	managementSystem.registerStudent("Brian", "Johnson", 1978, 6, 22, StudentType.PGR);
	managementSystem.registerStudent("Steven", "Tyler", 1940, 5, 12, StudentType.UG);
	
	module1 = Module.getInstance("CSC8001", "Programming Java", 20);
	module2 = Module.getInstance("CSC8002", "Advanced Java", 20);
	module3 = Module.getInstance("CSC8003", "Databases", 10);
	
	
	//managementSystem.
	
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetInstance() {
		
		ManagementSystem system1 = ManagementSystem.getInstance();
		
		assertNotNull(system1);
	
		
		
		
		
	}

	@Test
	public void testNoOfStudents() {
		
		int i = managementSystem.noOfStudents(StudentType.UG);
		
		assertEquals(i,3);
		
	}

	@Test
	public void test2NoOfStudents() {
		
		int i = managementSystem.noOfStudents(StudentType.PGT);
		
		assertEquals(i,1);
		
	}
	@Test
	public void testRegisterStudent() {
		
		
		
	}

	@Test
	public void testAmendStudentDataStringStringModifier() throws Exception {
	
		managementSystem.amendStudentData("a0001", "CSC8001", Modifier.Add);
		managementSystem.amendStudentData("a0001", "CSC8002", Modifier.Add);
		
		Student s = managementSystem.getStudent("a0001");
		
		int size = s.listStudentModules().size();
		
		assertEquals(size,2);
		
		
	}

	@Test
	public void test2AmendStudentDataStringStringModifier() throws Exception {
		
		managementSystem.amendStudentData("a0002", "CSC8001", Modifier.Add);
		managementSystem.amendStudentData("a0002", "CSC8002", Modifier.Add);
		managementSystem.amendStudentData("a0002", "CSC8001", Modifier.Delete);
		
		
		Student s = managementSystem.getStudent("a0002");
		
		int size = s.listStudentModules().size();
		
		assertEquals(size,1);		
		
		
	}

	
	@Test
	public void testTerminateStudent() throws Exception {
		
	 managementSystem.terminateStudent("a0004");
	 
	 int i = managementSystem.noOfStudents(StudentType.PGR);
		
		assertEquals(i,0); 
	 
	 
	}

	

	@Test
	public void testIssueSmartCard() throws Exception {
		managementSystem.issueSmartCard("a0001");
		
		SmartCard sc = managementSystem.getSmartCard("a0001");
		
		
		assertEquals(sc.getCardNumber().toString(), "ej-2019-01");
		
		
		
	}

	
	

}
