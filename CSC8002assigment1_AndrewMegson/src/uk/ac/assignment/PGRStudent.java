package uk.ac.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * class PGRStudent, stores all information of an undergraduate student
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public final class PGRStudent extends AbstractStudent {

	
private Name supervisor;

//private static int maxNumberCredits = 0;
//private int numberOfCredits = 0;
	

/**
* Constructor for objects of PGRStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //will need to adjust parameters 
* 
*/
private PGRStudent(Name name, Date dob)
{
	super(name, dob);

	//Modules = new ArrayList<>();
	//numberOfCredits = 0;
	//should supervisor be initialised to a value or left as null??
		
}


/**
* Method to create a unique instance of PGRStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //may need to adjust parameters 
 * @throws Exception 
* 
*/
public static PGRStudent getInstance(Name name, Date dob) throws Exception
{
	if(name == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Name parameter passed to PGRStudent getInstance method");
	}
	if(dob == null)
	{
		throw new IllegalArgumentException("null Date parameter passed to PGRStudent getInstance method");		
	}
	
	Date today = new Date();
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
	int d1 = Integer.parseInt(formatter.format(dob));                            
	int d2 = Integer.parseInt(formatter.format(today));                          
	int age = (d2 - d1) / 10000;  
	
	if(!(age >= 20))
	{
		throw new Exception("student is not old enough to be a postgrad research student");
	}
	
	
	PGRStudent pgr = new PGRStudent(name, dob);
	
	return pgr;
	
}

/**
 * Method to get a students type
 * 
 * 
 * @return a single String; 'UG' for an undergraduate student, 
 * 'PGST' for a postgraduate taught student and 'PGSR' for a postgraduate research student
 */	
public final String getStudentType()
{
	String x;
	x = "PGR"; //for postgraduate taught student
		
	return x;
				
}


/**
 * Method to get a students registration status
 * 
 * @return a boolean; true is returned if postgraduate research student has a 
 * supervisor assigned to them.  Otherwise false is returned.
 */
public final boolean getStudentRegistrationStatus()
{
	boolean b = false;
		
	if(!(supervisor == null))
	{
		b = true;
	}

		return b; 
		
}

public final List<Module> listStudentModules()
{
	//List<Module> emptyList= new ArrayList<>();  // return any empty arraylist ?? want to prevent any action??
	
	return null;
}


/**
 * Method to get a students supervisors name
 * 
 * @return a single Name object which represents the supervisors name
 */
public final Name getSupervisor()
{
	return supervisor;   //if supervisor is a seperate unique class could return supervisor.name
}

public final void setSupervisor(Name name) throws Exception
{
	
	
	supervisor = name;
}


@Override
public String toString() {
	return "PGRStudent [supervisor=" + supervisor + ", name=" + name + ", dob=" + dob + ", id=" + id + "]";
}



}
