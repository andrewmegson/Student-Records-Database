package uk.ac.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class UGStudent, stores all information of an undergraduate student
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public class UGStudent extends AbstractStudent {
	
private final static int maxNumberCredits = 120;
private List<Module> Modules;
private int numberOfCredits = 0;

private static final int PASSMARK = 40;
private static final Map<String, String> MODULEGRADES = new HashMap<>();

//private Map<String, int> Grades;  //hashmap to contain students grades for modules

/**
* Constructor for objects of UGStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //will need to adjust parameters 
* 
*/
private UGStudent(Name name, Date dob)
{
	super(name, dob);
	Modules = new ArrayList<>();
	
	
}

/**
* Method to create a unique instance of UGStudent class
* 
* @param takes 3 paramemter; a String of students first name, a string of a students last name
* and a Date of a students date of birth      //may need to adjust parameters 
 * @throws Exception 
* 
*/
public static UGStudent getInstance(Name name, Date dob) throws Exception
{

	
	if(name == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Name parameter passed to UGStudent getInstance method");
	}
	if(dob == null)
	{
		throw new IllegalArgumentException("null Date parameter passed to UGStudent getInstance method");		
	}
	
	
	Date today = new Date();
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
	int d1 = Integer.parseInt(formatter.format(dob));                            
	int d2 = Integer.parseInt(formatter.format(today));                          
	int age = (d2 - d1) / 10000;  
	
	if(!(age >= 17))
	{
		throw new Exception("student is not old enough to be an undergrad student");
	}
	
	
	
	
	
	
	
	UGStudent ug = new UGStudent(name, dob);
	return ug;
	
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
	x = "UG"; //for undergraduate student
	
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
 * @return a boolean; true is returned if an undergraduate student is registered 
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
/**
 * Method to record if a student has passed a module or not
 * 
 * @param a String of the module code for the module and an int of the students achieved mark (assumed to be out of a maximum of 100)
 * 
 * @throws Exception
 */
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
	if(mark>= PASSMARK )
	{
		status = "Pass";
	}
	
	MODULEGRADES.put(moduleCode, status);
	
}



/**
 * Method to get the grade (pass or fail) that a student has achieved for a given module
 * 
 * @param a String of the moduleCode for the module
 * 
 * @return a String of the achieved grade i.e. pass or fail
 * @throws Exception
 */
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
	return "UGStudent [name=" + name + ", dob=" + dob + ", id=" + id + ", Modules=" + Modules + "]";
}
}
