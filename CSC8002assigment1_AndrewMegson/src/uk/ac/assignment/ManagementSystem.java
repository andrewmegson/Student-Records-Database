package uk.ac.assignment;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * class ManagemetSystem, this class is a driver class that uses methods from Student classes, 
 * the SmartCard class and the Modules class to hold Student data. 
 * This is a singleton class and so can only be instantiated once.
 * Thisclass stores Lists of students, Modules, and Supervisors.
 * It has methods to read in Module and Supervisor information from a file, add different types of students, 
 * issue Smart cards and add/remove modules/supervisors from students.
 * 
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */
public class ManagementSystem {
public static enum Modifier {Add, Delete}; 
public static enum StudentType {UG, PGT, PGR};

private static final ManagementSystem INSTANCE = new ManagementSystem();  // to make this class a singleton	
	


private ArrayList<Student> Students;
private ArrayList<Name> Supervisors;
private ArrayList<Module> Modules;

private static final Map<String, SmartCard> SMARTCARDS = new HashMap<>();

/**
 * Private constructor of ManagementSystem class
 */
private ManagementSystem()
{
	Students = new ArrayList<>(); 
	Supervisors = new ArrayList<>();
	Modules = new ArrayList<>();
}



/**
 * Method allowing strictly the creation of a single instance of the ManagementSystem class, 
 * as this is a singleton class
 * 
 * @return a unique single instance of a ManagementSystem object
 */

public static ManagementSystem getInstance()    // to make this class a singleton	
{
	return INSTANCE;
}


/**
 * Method to count the number of a specified type of students registered 
 * i.e. undergraduate, postgraduate taught or postgraduate research.
 * 
 * @param an enum representing the type of students to be counted; 'UG' for undergraduate,
 * 'PGT' for postgraduate taught and 'PGR' for postgraduate research.
 * 
 * @return an int of the number of students registered of the specified type.
 */

public int noOfStudents(StudentType typeOfStudent) 
{
	int count = 0;
	
switch (typeOfStudent) 
{
  case UG:
	  for(Student s: Students)
		{
				if(s.getStudentType().equals("UG"))
				{
					count++;
					
				}
		}	
	  break;
  case PGT:
	  for(Student s: Students)
		{
				if(s.getStudentType().equals("PGT"))
				{
					count++;
					
				}
		}	
	  break;
  case PGR:
	  for(Student s: Students)
		{
				if(s.getStudentType().equals("PGR"))
				{
					count++;
					
				}
		}		  
    break;

}
		return count;
		
		
}	  


/**
* Method to register a new student on the system
* 
* @param takes 6 parameters; a String of students first name, a string of a students last name
* and 3 int parameters to represent the year, month (i.e. January = 1), and day of a students date of birth
* and an enum representing a students type; 'UG' for undergraduate,
* 'PGT' for postgraduate taught and 'PGR' for postgraduate research.
 * @throws Exception 
* 
*/
public void registerStudent(String firstName, String lastName, int year, int month, int day, StudentType typeOfStudent)
{
	try
	{
	
		Name name = Name.getInstance(firstName, lastName);
		Date dob = AbstractStudent.setDob(year, month, day);
		Student s;
			
		switch (typeOfStudent) 
		{
		  case UG:
				
				s = (Student) UGStudent.getInstance(name, dob);	// s = a new instance of ug student			
				Students.add(s); //add to ArrayList		
				
			  break;
			  
		  case PGT:
			
				s = (Student) PGTStudent.getInstance(name, dob);	// s = a new instance of pgt student		
				Students.add(s); //add to ArrayList	
					
			  break;
			  
		  case PGR:
				
				s = (Student) PGRStudent.getInstance(name, dob);	// s = a new instance of pgr student		
				Students.add(s); //add to ArrayList	
						  
		    break;
	
		}
	
	}
	catch (Exception e)
	{
		System.err.println("Oh no!" + e);
	}
}


/**
 * Method to issue a smartcard to a registered student.
 * 
 * @param takes a String representation of the students id number
 * 
 * @return a boolean returning true if smartcard is successfully issued, false otherwise.
 * 
 */


public boolean issueSmartCard(String id) throws Exception
{
	
	boolean b=false;
	
	try
	{
	
		AbstractStudent abStudent;
		SmartCard SC;
		
		for (Student s: Students)
		{
			
	
			
			abStudent = (AbstractStudent) s;
			int age = abStudent.calStudentAgeYears();
			if (id.equals(abStudent.getStudentID().toString()))
			{
		
				if((s instanceof UGStudent && age >= 17) || (s instanceof PGTStudent && age >= 20) || (s instanceof PGRStudent && age >= 20))  // check age constraints
						{
							SC = SmartCard.getInstance(s);
							b = true;	
							
							SMARTCARDS.put(id, SC);
							
							
						}	
			}
		}
	}
	catch (Exception e)
	{
			System.err.println("Oh no!" + e);
	}	
return b;

}



/**
 * Method to add or delete modules from a specified student
 * @param it takes 3 parameters; a string of the students id, a string of the module code 
 * and an enum of 'Add' or 'Delete' to specify action required.
 * 
 * @return a boolean true if specified action was successful, false otherwise.
 * 
 * NOTE:The amendStudentData method allows a user to change a students registered modules for undergraduates 
 * and postgraduate taught students and allows a user to add/update a postgraduate research students supervisor 
 * via parameter overloading.  
 * ***It doesn't allow a students name or date of birth to be changed to prevent data errors***
 */
public boolean amendStudentData(String id, String moduleCode, Modifier mod)
{
	boolean b = false;
	try
	{
	

		switch (mod) 
		{
		  case Add:
	
			String regex = "[a-z][0-9]{4}";
			
			id = id.trim().toLowerCase();
			
			
			if (!id.matches(regex))
			{
				throw new Exception("id input is in incorrect format or invalid");
			}	
				
			
			//boolean b = false;
			
			Module m = Module.MODULES.get(moduleCode);
			
			
			for (Student s: Students)
			{
				
				if (id.equals(s.getStudentID().toString()) && s instanceof UGStudent)
					
				{
					UGStudent ug = (UGStudent) s;
					
					ug.addModule(m);
					b = true;
				}
				
				if (id.equals(s.getStudentID().toString()) && s instanceof PGTStudent)
					
				{
					PGTStudent pgt = (PGTStudent) s;
					
					pgt.addModule(m);
					b = true;
				}
				
				
				
			}
			//return b;
			
		break;
		
	
	
		case Delete:
		
			String regex2 = "[a-z][0-9]{4}";
			
			id = id.trim().toLowerCase();
			
			
			if (!id.matches(regex2))
			{
				throw new Exception("id input is in incorrect format or invalid");
			}	
				
			
			//boolean b = false;
			
			Module m2 = Module.MODULES.get(moduleCode);
			
			
			for (Student s: Students)
			{
			
				
				if (id.equals(s.getStudentID().toString()) && s instanceof UGStudent )
				{
					UGStudent ug = (UGStudent) s;
					
					ug.removeModule(m2);
					b = true;
				}
				
				if (id.equals(s.getStudentID().toString()) && s instanceof PGTStudent )
				{
					PGTStudent pgt = (PGTStudent) s;
					
					pgt.removeModule(m2);
					b = true;
				}
			
			
			
			}
	
			
		break;
		  
	
		
		}
		

	
	}
	catch (Exception e)
	{
		System.err.println("Oh no!" + e);
	}	
	
	return b;
}


/** 
 * Method to add or update a supervisor to a postgraduate student
 * @param it takes 3 parameters; a string of the students id, 
 * a string of the supervisors first name and a string of the supervisors last name.
 * 
 * @return a boolean true if action was successful, false otherwise.
 * 
 * 
 * NOTE:The amendStudentData method allows a user to change a students registered modules for undergraduates 
 * and postgraduate taught students and allows a user to add/update a postgraduate research students supervisor 
 * via parameter overloading.  
 * ***It doesn't allow a students name or date of birth to be changed to prevent data errors***
 */
public boolean amendStudentData(String id, String supervisorFirstName, String supervisorLastName) 
{
	boolean b = false;
try
{
	
String regex = "[a-z][0-9]{4}";

id = id.trim().toLowerCase();


if (!id.matches(regex))
{
	throw new Exception("id input is in incorrect format or invalid");
}	
	
Name supervisorName = Name.getInstance(supervisorFirstName, supervisorLastName);


//boolean b = false;





if(Supervisors.contains(supervisorName))
{	

		for (Student s: Students)
		{
		
			
			if (id.equals(s.getStudentID().toString()) && (s instanceof PGRStudent))
			{
				//cast to PGRStudent
				
				PGRStudent PGR = (PGRStudent) s;
				
				PGR.setSupervisor(supervisorName);
				
				b = true;
				
				
				
				
			}
			
		}
		
}	

}

catch (Exception e)
{
	System.err.println("Oh no!" + e);
}	
return b;
}

/**
 * Method to remove a students record from the data base. 
 * (removes all student and smartcard data).
 * 
 * @param takes a string representation of the students id number
 * 
 * @return a boolean, true if the students record is successfully removed, false otherwise.
 */


public boolean terminateStudent(String id)
{ 
	boolean b = false;
	
	try
	{
		//check parameters
		
			String regex = "[a-z][0-9]{4}";
		
		id = id.trim().toLowerCase();
		
		
		if (!id.matches(regex))
		{
			throw new Exception("id input is in incorrect format or invalid");
		}
		//boolean b = false;
	
		
		for (Student s: Students)
		{
			
			if (id.equals(s.getStudentID().toString()))
			{
				Students.remove(s);
				b=true;
				SMARTCARDS.remove(id, s);
			}
			
		}
		
	}
	catch (Exception e)
	{
		System.err.println("Oh no!" + e);
	}	

	return b;
}

//method to read in all modules data

/**
 * Method to read in Module data from a file and create and store Module objects accordingly.
 * The file should contain one data entry (i.e. one modules information) per line, each line should have the modules; 
 * code, name and credits separated by a comma i.e. CSC8002, Advanced Programming, 20.
 * 
 * 
 * @param takes a scanner object that reads from a file in the described format 
 * 
 */

public void readModuleInfo(Scanner inFileM)

{
   try
   {

   
	    while (inFileM.hasNext())    //loop until no lines left to read times
	    {
	    	
	    	String moduleStrRep = inFileM.nextLine().trim().toLowerCase();
	    	Module m = Module.valueOf(moduleStrRep);
	    	Modules.add(m);
	    	
	    }
   }
   catch (Exception e)
   {
		System.err.println("Oh no!" + e);
   }	
 
}

//method to read in all supervisors data

/**
 * Method to read in Supervisor names from a file and create and store Supervisor names accordingly.
 * The file should contain one data entry (i.e. one supervisors name) per line, each line should have the supervisors; 
 * first name and last name separated by a comma i.e. John, Smith.
 * 
 * 
 * @param takes a scanner object that reads from a file in the described format 
 * 
 */
public void readSupervisorInfo(Scanner inFileS)

{
   try
   {

	   
	    while (inFileS.hasNext())    //loop until no lines left to read times
	    {
	    	
	    	String nameStrRep = inFileS.nextLine().trim().toLowerCase();
	    	Name n = Name.valueOf(nameStrRep);
	    	Supervisors.add(n);
	    	
	    }
   }
   catch (Exception e)
   {
 		System.err.println("Oh no!" + e);
   }	    

}




/**
 * Method to get a students full details
 * 
 * 
 * @param takes a string representation of the students id number
 * 
 * @return a String representation of all the students details
 */
public String getStudentDetails(String id)
{
	String x = "";
	
	for (Student s: Students)
	{
		
		if (id.equals(s.getStudentID().toString()))	
		{
			x = s.toString();
		}
	}
	return x;
}


/**
 * Method to get full details of a students smartcard
 * 
 * 
 * @param takes a string representation of the students id number
 * 
 * @return a String representation of all the details contain of the specific students smartcard
 */
public String getSmartCardDetails(String id)
{
	String x = "";
	
	x = SMARTCARDS.get(id).toString();
	
	return x;
}

/**
 * Method to get a specific student object
 * 
 * @param  takes a string representation of the students id number
 * 
 * @return a Student object corresponding to the entered student id
 */


public Student getStudent(String id)
{
	
Student student = null;

	for (Student s: Students)
	{
		
		if (id.equals(s.getStudentID().toString())) 
				{
					student = s;
				}
	}
		return student;
	
}

/**
 * Method to get a specific SmartCard object
 * 
 * @param  takes a string representation of the students id number
 * 
 * @return a SmartCard object corresponding to the entered student id
 */
public SmartCard getSmartCard(String id)
{
	
return SMARTCARDS.get(id);
	
}

}
