package uk.ac.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * class SmartCard, makes a SmartCard object for a given student. It contains the students; 
 * first and last names as Strings, date of birth, date of card issue and expiry date of card as Date objects, 
 * the students ID number as a StudentID object and the smartcard number as a SmartCardNumber object.
 *
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public final class SmartCard {
	
	
private final Name name;
private final Date dob;
private final SmartCardNumber cardNumber;
private final Date dateOfIssue;
private final Date expiryDate;
private final StudentID id;

/**
 * Constructor for a SmartCard object
 * 
 * @param takes a Student object as a parameter
 * @throws Exception 
 */

private SmartCard(Student s) throws Exception
{
	AbstractStudent abS = (AbstractStudent) s;
	
	
	this.name = abS.getStudentName();
	this.dob = abS.getDob();
	this.dateOfIssue = new Date();
	this.id = s.getStudentID();
	
	this.cardNumber = SmartCardNumber.getInstance(abS.getStudentName().getInitials());
			
	expiryDate = setExpiryDate(s);
}


/**
 * Method to create a unique instance of SmartCard class
 * 
 * @param a Student object
// * @return a SmartCard object
 * 
 * @throws Exception
 */

public static SmartCard getInstance(Student s) throws Exception

{
	if(s == null)   //parameter checks
	{
		throw new IllegalArgumentException("null Name parameter passed to PGTStudent getInstance method");
	}
	
	SmartCard SC = new SmartCard(s);
		
	//AbstractStudent abS = (AbstractStudent) s;
	//int age = abS.calStudentAgeYears();		
	
	return SC;
	
}





/**
 * Private class method to set the expiry date of a SmartCard
 * 
 * @param takes a student object as a parameter
 * 
 * @return a Date object representing the SmartCard expiry date
 */


private Date setExpiryDate(Student s)
{
	Date expiryDate = new Date();
	
	if (s instanceof UGStudent)
	{
		// set to issue date plus 4 years
		//expiryDate = dateOfIssue + 4 years
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTime(dateOfIssue);
		int year = c.get(Calendar.YEAR);
		year = year + 4;
		c.set(Calendar.YEAR, year);
		
		expiryDate = c.getTime();		
	}
	
	if (s instanceof PGTStudent)
	{
		// set to issue date plus 2 years
		//expiryDate = dateOfIssue + 2 years
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTime(dateOfIssue);
		int year = c.get(Calendar.YEAR);
		year = year + 2;
		c.set(Calendar.YEAR, year);
				
		expiryDate = c.getTime();		
	}
	
	if (s instanceof PGRStudent)
	{
		// set to issue date plus 5 years
		
		//expiryDate = dateOfIssue + 5 years
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTime(dateOfIssue);
		int year = c.get(Calendar.YEAR);
		year = year + 5;
		c.set(Calendar.YEAR, year);
				
		expiryDate = c.getTime();				
	}
		
	return expiryDate ;
}




/**
 * Method to get the first name of SmartCard
 * 
 * @return a String representing the first name
 */
public String getStudentName() 
{
	return new String(name.toString());
}



/**
 * Method to get the date of birth of the SmartCard
 * 
 * @return a Date object representing the date of birth
 */
public Date getDob() {
	
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(dob);
	
	Date dobDefCopy = c.getTime();
	
	
	return dobDefCopy;
}


/**
 * Method to get the card number of the SmartCard
 * 
 * @return a SmartCardNumber object representing the card number
 */
public SmartCardNumber getCardNumber() {
	return cardNumber;
}



/**
 * Method to get the date of issue of the SmartCard
 * 
 * @return a Date object representing the date of issue
 */
public Date getDateOfIssue() {
	
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(dateOfIssue);
	
	Date dateOfIssueDefCopy = c.getTime();
	
	
	
	return dateOfIssueDefCopy;
}

/**
 * Method to get the expiry date of the SmartCard
 * 
 * @return a Date object representing the expiry date
 */
public Date getExpiryDate() {
	
	Calendar c = Calendar.getInstance();
	c.clear();
	c.setTime(expiryDate);
	
	Date expiryDateDefCopy = c.getTime();
	
	
	return expiryDateDefCopy;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
	result = prime * result + ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
	result = prime * result + ((dob == null) ? 0 : dob.hashCode());
	result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	SmartCard other = (SmartCard) obj;
	if (cardNumber == null) {
		if (other.cardNumber != null)
			return false;
	} else if (!cardNumber.equals(other.cardNumber))
		return false;
	if (dateOfIssue == null) {
		if (other.dateOfIssue != null)
			return false;
	} else if (!dateOfIssue.equals(other.dateOfIssue))
		return false;
	if (dob == null) {
		if (other.dob != null)
			return false;
	} else if (!dob.equals(other.dob))
		return false;
	if (expiryDate == null) {
		if (other.expiryDate != null)
			return false;
	} else if (!expiryDate.equals(other.expiryDate))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}


	

}
