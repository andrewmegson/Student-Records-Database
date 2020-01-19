package uk.ac.assignment;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * class SmartCardNumber, generates unique ID numbers for studentcards in form 
 * of a students initials year of issue and an arbitary number 
 * i.e. JS-2018-10.
 *
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */


public final class SmartCardNumber {
	
private static final Map<String, SmartCardNumber> SMARTCARDNUMBERS = new HashMap<>();

private static int currentNumber = 1;
	
private final String initials;
private final int year;
private final int arbitaryNumber;
private final String strRep;
private int maxNumber = 99;
private int minNumber = 1;



/**
* Constructor for objects of SmartCardNumber class
* 
* @param takes 3 paramemter; a String of students initials, an int of the year of issue 
* and a String representation of the Smartcard number
*/
private SmartCardNumber(String initials, int year, String strRep) //not correct parameters at the moment!!
{
	//probably take student id as parameter, get student object, then get info from student object methods etc
	//check valid entries?
	this.initials = initials;
	this.year = year;
	this.arbitaryNumber = currentNumber;
	this.strRep = strRep;
	
	
	if (currentNumber == maxNumber)
	{
		currentNumber = minNumber;
	}
	else 
	{
	currentNumber++;
	}
}


/**
 * Method to create a unique instance of a SmartCardNumber
 * 
 * @param takes 2 parameters; a String of students initials and an int of the year of issue
 * 
 * @return a unique instance of a SmartCardNumber object
 */
public static SmartCardNumber getInstance(String initials) //parameters will be student ID to get initials and year from, check parameters valid
{
	//get current year
	Calendar c = Calendar.getInstance();
	int currentYear = c.get(Calendar.YEAR);
	
	
	String format = String.format("%02d", currentNumber);
	
	
	String strRep = initials + "-" + currentYear + "-" + format;
	SmartCardNumber sCardNumber = SMARTCARDNUMBERS.get(strRep);
	if (sCardNumber == null)
	{
		sCardNumber = new SmartCardNumber(initials, currentYear, strRep);
		SMARTCARDNUMBERS.put(strRep, sCardNumber);
	}
	else 
	{	
		throw new IllegalArgumentException("Smartcard number already exsists!!");
	}
		return sCardNumber;
			
	
}

/**
 * toString method to get a String representation of SmartCardNumber
 * 
 * 
 * @return a single String
 */
public String toString()
{
	return strRep;
	
}
	

public int getIssueYear()
{
	return year;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + arbitaryNumber;
	result = prime * result + ((initials == null) ? 0 : initials.hashCode());
	result = prime * result + ((strRep == null) ? 0 : strRep.hashCode());
	result = prime * result + year;
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
	SmartCardNumber other = (SmartCardNumber) obj;
	if (arbitaryNumber != other.arbitaryNumber)
		return false;
	if (initials == null) {
		if (other.initials != null)
			return false;
	} else if (!initials.equals(other.initials))
		return false;
	if (strRep == null) {
		if (other.strRep != null)
			return false;
	} else if (!strRep.equals(other.strRep))
		return false;
	if (year != other.year)
		return false;
	return true;
}



}
