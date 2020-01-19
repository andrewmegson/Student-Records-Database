package uk.ac.assignment;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * class StudentID, generates unique ID numbers for student class in form 
 * of a letter followed by a 4 digit number i.e. a1002.
 *
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */



public final class StudentID {
	
private static final Map<String, StudentID> STUDENTIDS = new HashMap<>();

private static int currentNumber = 1;
private static char currentLetter = 'a';

private static final int maxNumber = 9999; //string.format
private static final int minNumber = 1;

private final char c;
private final int i;
private final String strRep;



/**
* Constructor for objects of StudentID class
* 
* @param takes 3 paramemter; a char, an int that make up the id and a String representation of the id
*/
private StudentID(char c, int i, String strRep)
{
	//need to check c and i are valid?
	this.c = c;
	this.i = i;
	this.strRep = strRep;
	incrementVariables();
}


/**
 * Method to create a unique instance of a StudentID
 * 
 * @return a unique instance of a StudentID object
 */

public static StudentID getInstance()
{
	if (currentLetter == 'z' && currentNumber == 9999)
	{
		
		throw new IllegalArgumentException("No ID's left!!");
	}
	
	
	
	
	
	//String pattern = "####";									//formats current number to 4 digit string
	//DecimalFormat decimalFormat = new DecimalFormat(pattern);

	//String number = decimalFormat.format(currentNumber);
	
	String format = String.format("%04d", currentNumber);
	
	String strRep = currentLetter + format;
	StudentID id = STUDENTIDS.get(strRep);
	if(id == null)
	{
		id = new StudentID(currentLetter, currentNumber, strRep);
		STUDENTIDS.put(strRep, id);
		
	}
	else
		
	{ 
		throw new IllegalArgumentException("ID already issued");
	}

		return id;
}
		

/**
 * Private method of class to increment the variables used to create id's
 */
private final void incrementVariables()
{
	// need to check over incrementing variables to include a0001. DecimalFormat class??
	
	if (currentNumber == maxNumber)
	{
		currentLetter++;
		currentNumber = minNumber;
	}
	else
	{
		currentNumber++;
	}
	
}	
		

/**
 * Method to get the letter of the StudentID
 * 
 * 
 * @return a single char
 */
public final char getLetter()
{
	return c;
}


/**
 * Method to get the number of the StudentID
 * 
 * 
 * @return a single int
 */
public final int getNumber()
{
	return i;
}


/**
 * toString method to get a String representation of StudentID
 * 
 * 
 * @return a single String
 */
public final String toString()
{
	return strRep;
	
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + c;
	result = prime * result + i;
	result = prime * result + ((strRep == null) ? 0 : strRep.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	StudentID other = (StudentID) obj;
	if (c != other.c)
		return false;
	if (i != other.i)
		return false;
	if (strRep == null) {
		if (other.strRep != null)
			return false;
	} else if (!strRep.equals(other.strRep))
		return false;
	return true;
}



}	
		
		

