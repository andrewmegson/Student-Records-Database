package uk.ac.assignment;

import java.util.List;

/**
 * Interface Student, store information relating to a student; name as a Name object, 
 * date of birth as a Date object, student ID as a StudentID object 
 * and a list of the students modules as a List object.
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public interface Student {
	
	
/**
* Method to get a Students ID number
* 
* 
* @return a single String
*/	
StudentID getStudentID();

/**
 * Method to get a students type
 * 
 * @return a single String; 'UG' for an undergraduate student, 
 * 'PGST' for a postgraduate taught student and 'PGSR' for a postgraduate research student
 */
String getStudentType();


/**
 * Method to get all the modules a student is registered for
 * 
 * @return a List<Module>
 */
List<Module> listStudentModules();


/**
 * Method to get a students registration status
 * 
 * @return true is returned if an undergraduate or postgraduate taught student is registered 
 * for their full amount of module credits or if a postgraduate research student has a 
 * supervisor assigned to them.  Otherwise false is returned.
 */
boolean getStudentRegistrationStatus();


	
	
	

}
