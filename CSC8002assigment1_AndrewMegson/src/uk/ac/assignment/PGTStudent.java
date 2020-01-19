package uk.ac.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class PGTStudent, stores all information of an undergraduate student
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public class PGTStudent extends AbstractStudent {
	
private final static int maxNumberCredits = 180;
private int numberOfCredits;
private List<Module> Modules;	

private static final int PASSMARK = 50;
private static final Map<String, String> MODULEGRADES = new HashMap<>();

/**
* Constructor for objects of PGTStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //will need to adjust parameters 
* 
*/
private PGTStudent(Name name, Date dob)
{
	super(name, dob);
	Modules = new ArrayList<>();
	numberOfCredits = 0;
		
}


/**
* Method to create a unique instance of PGTStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //may need to adjust parameters 
 * @throws Exception 
* 
*/
public static PGTStudent getInstance(Name name, Date dob) throws Exception
{
	if(name == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Name parameter passed to PGTStudent getInstance method");
	}
	if(dob == null)
	{
		throw new IllegalArgumentException("null Date parameter passed to PGTStudent getInstance method");		
	}

	Date today = new Date();
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
	int d1 = Integer.parseInt(formatter.format(dob));                            
	int d2 = Integer.parseInt(formatter.format(today));                          
	int age = (d2 - d1) / 10000;  
	
	if(!(age >= 20))
	{
		throw new Exception("student is not old enough to be a postgrad taught student");
	}
	
	PGTStudent pgt = new PGTStudent(name, dob);
	
	return pgt;
	
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
	x = "PGT"; //for postgraduate taught student
		
	return x;
				
}

/**
 * Method to get a list of modules the student is enrolled on
 * 
 * @return a single List<Module>
 */
public final List<Module> listStudentModules()
{
	return Modules;
}


/**
 * Method to get a students registration status
 * 
 * @return a boolean; true is returned if postgraduate taught student is registered 
 * for their full amount of module credits.
 * Otherwise false is returned.
 */
public final boolean getStudentRegistrationStatus()
{
	boolean b = false;
	
	if(numberOfCredits==maxNumberCredits)
	{
		b = true;
	}

		return b; 
	
}

/**
 * Method to add a module to a student object
 * @param a single Module object
 * 
 * @return a boolean; true if the Module is successfully added to the student, false otherwise
 */

public final boolean addModule(Module m)
{	
	if(m == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Module parameter passed to addModule method");
	}
	boolean b = false;
	// if current total + module credits < maxCredits
	if(numberOfCredits + m.getModuleCredits() <= maxNumberCredits)
	{
		if(!Modules.contains(m));
		{
			Modules.add(m);
			b = true;
			numberOfCredits = numberOfCredits + m.getModuleCredits();
		}
	
	}
		return b;
	
}



/**
 * Method to remove a module from a student object 
 * @param a single Module object
 * 
 * @return a boolean; true if the Module is successfully removed from the student, false otherwise
 */
public final boolean removeModule(Module m)
{
	
	if(m == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Module parameter passed to removeModule method");
	}
	boolean b = false;
	
	
	if(Modules.contains(m))
	{
		Modules.remove(m);
		b = true;
		numberOfCredits = numberOfCredits - m.getModuleCredits();
	}
	return b;
}

public void addGrade(String moduleCode, int mark) throws Exception
{
	
	String inputStringFormat = ".+,\\s.+,\\s.+";  //checks string has ', ' in it twice (i.e. the correct format)
	
	if (!moduleCode.matches(inputStringFormat))
	{
		throw new Exception("module String representation is in incorrect format");
	}
	
	if(!(0<=mark&&mark<=100))
	{
		throw new Exception("mark is not between 0 and 100, as expected!");
	}
	
	
	
	String status = "Fail";
	if(mark>= PASSMARK)
	{
		status = "Pass";
	}
	
	MODULEGRADES.put(moduleCode, status);
	
}


public String getGrade(String moduleCode) throws Exception
{
	
	String inputStringFormat = ".+,\\s.+,\\s.+";  //checks string has ', ' in it twice (i.e. the correct format)
	
	if (!moduleCode.matches(inputStringFormat))
	{
		throw new Exception("module String representation is in incorrect format");
	}	
	String status = "no mark yet";
	if (MODULEGRADES.containsKey(moduleCode))
	{
		status = MODULEGRADES.get(moduleCode);
	}
	return status;
}
@Override
public String toString() {
	return "PGTStudent [numberOfCredits=" + numberOfCredits + ", Modules=" + Modules + ", name=" + name + ", dob=" + dob
			+ ", id=" + id + "]";
}


}
