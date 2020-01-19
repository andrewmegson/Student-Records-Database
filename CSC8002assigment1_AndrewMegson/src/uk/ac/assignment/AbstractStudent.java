package uk.ac.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;

/**
 * class AbstractStudent
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public abstract class AbstractStudent implements Student {
	
protected final Name name;
protected final Date dob;
protected final StudentID id;
//protected int numberOfCredits = 0;

/**
* Constructor for objects of AbstractStudent class
* 
* @param takes 5 parameters; a String of students first name, a string of a students last name
* and 3 int parameters to represent the year, month (i.e. January = 1), and day of a students date of birth 
* 
*/
public AbstractStudent(Name name, Date dob)
{
	
	this.name = name;
	this.dob = dob;
	id = StudentID.getInstance();

		
}




public abstract String getStudentType();

public abstract List<Module> listStudentModules();

public abstract boolean getStudentRegistrationStatus();



	
/**
 * Method to get a students name
 * 
 * 
 * @return A single Name object
 * @throws Exception 
 */
public Name getStudentName() throws Exception
{
	
	
	return Name.getInstance(name.getFirstName(), name.getLastName());
}


/**
 * Method to set a students name
 * 
 * 
 * @param 2 String; a String of the persons first name and a String of the persons last name 
 */
//public void setName(String firstName, String lastName)
//{
//	name = Name.getInstance(firstName, lastName);
//}


/**
 * Method to get a students StudentID
 * 
 * 
 * @return A single StudentID object
 */
public StudentID getStudentID()
{
	return id;
}




/**
 * Method to get a students date of birth
 * 
 * 
 * @return A single Date object
 */
public Date getDob()
{
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(dob);
	
	Date dobDefCopy = c.getTime();
	
	
	return dobDefCopy;
}




/**
 * Method to get a date (such as a date of birth) as a Date object
 * 
 * 
 * @param take 3 int parameters to represent the year, month (i.e. January = 1), and day of a students date of birth
 * 
 * @return a Date object representing a students date of birth
 * @throws Exception 
 */
public static Date setDob(int year, int month, int day) throws Exception
{
	
	
	if (!(1920<=year && year<= 2050))
	{
		throw new Exception("Invalid year for date of birth entered");
	}
	if (!(1<=month && month<=12))
	{
		throw new Exception("Invalid month for date of birth entered");
	}
	if (!(1<=day && day<=31))
	{
		throw new Exception("Invalid day for date of birth entered");	
	}		

	Date dob = new Date();
	
	final Calendar c = Calendar.getInstance();
	
	c.clear();
	c.set(year, month -1,day);
	
	dob = c.getTime();
	return dob;
}





public int calStudentAgeYears()

{
	Date today = new Date();
	
	
	
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
	int d1 = Integer.parseInt(formatter.format(dob));                            
	int d2 = Integer.parseInt(formatter.format(today));                          
	int age = (d2 - d1) / 10000;                                                       
	return age;                                                                        
}







}
