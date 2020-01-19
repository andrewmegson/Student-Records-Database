package Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.assignment.AbstractStudent;
import uk.ac.assignment.Name;
import uk.ac.assignment.PGRStudent;
import uk.ac.assignment.PGTStudent;
import uk.ac.assignment.SmartCard;
import uk.ac.assignment.SmartCardNumber;
import uk.ac.assignment.Student;
import uk.ac.assignment.UGStudent;

public class TestSmartCard {
	
	static Name name1, name2, name3;
	static Date dob1, dob2, dob3;
	static AbstractStudent abStudent1, abStudent2, abStudent3;
	
	
	
	
	

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
		
	Student s = PGTStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);
			
	assertNotNull(sm);
		
		
	}

	@Test
	public void testGetStudentName() throws Exception {
		
	Student s = PGTStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);
	
	String name = sm.getStudentName();
	
	assertEquals(name, "elton john");
	
		
	}

	@Test
	public void testGetDob() throws Exception {
		
	Student s = PGTStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);
	
	Date dob = sm.getDob();
	Calendar c = Calendar.getInstance();
	c.setTime(dob);

	
	
	final Calendar c2 = Calendar.getInstance();
	c2.clear();
	c2.set(1950, 4, 20);
	
	
	
	assertEquals(c,c2);
	
	
	}

	@Test
	public void testGetCardNumber() throws Exception {
		
	Student s = PGTStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);
	
	SmartCardNumber smartCN = sm.getCardNumber();
	
	assertEquals(smartCN.toString(), "ej-2019-07");  // -7 as its run as the 7th instance made in this class when run!!
	
		
		
	}



	@Test
	public void testGetExpiryDate() throws Exception {
	
	Student s = UGStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);	
	
	Date expiryDate = sm.getExpiryDate();
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(expiryDate);
	
	
	Date issueDate = sm.getDateOfIssue();
	Calendar c2 = Calendar.getInstance();
	c2.clear();
	c2.setTime(issueDate);
	
	
	
	
	int year = c2.get(Calendar.YEAR);
	year = year + 4;
	c2.set(Calendar.YEAR, year);
	
		
	assertEquals(c,c2);
		
		
	}
	
	@Test
	public void test2GetExpiryDate() throws Exception {
	
	Student s = PGTStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);	
	
	Date expiryDate = sm.getExpiryDate();
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(expiryDate);
	
	
	Date issueDate = sm.getDateOfIssue();
	Calendar c2 = Calendar.getInstance();
	c2.clear();
	c2.setTime(issueDate);
	
	
	
	
	int year = c2.get(Calendar.YEAR);
	year = year + 2;
	c2.set(Calendar.YEAR, year);
	
		
	assertEquals(c,c2);
		
		
	}
	
	@Test
	public void test3GetExpiryDate() throws Exception {
	
	Student s = PGRStudent.getInstance(name1, dob1);
	SmartCard sm = SmartCard.getInstance(s);	
	
	Date expiryDate = sm.getExpiryDate();
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(expiryDate);
	
	
	Date issueDate = sm.getDateOfIssue();
	Calendar c2 = Calendar.getInstance();
	c2.clear();
	c2.setTime(issueDate);
	
	
	
	
	int year = c2.get(Calendar.YEAR);
	year = year + 5;
	c2.set(Calendar.YEAR, year);
	
		
	assertEquals(c,c2);
		
		
	}

}
