package uk.ac.assignment;



/**
 * class Name,stores a persons first and last name as String objects.
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */


// need to override equals/hashcode methods
public final class Name {
	
	private final String firstName;
	private final String lastName;
	
	
/**
* Constructor for objects of Name class
* 
* @param takes 2 String objects of a persons first and last Name
*/
private Name(String firstName, String lastName)
{
	this.firstName = firstName;
	this.lastName = lastName;
		
}


	
public static Name getInstance(String firstName, String lastName) throws Exception
{
	String regex = "[a-z]+";
	
	firstName = firstName.trim().toLowerCase();
	lastName = lastName.trim().toLowerCase();
	
	if (!firstName.matches(regex))
	{
		throw new Exception("first name is in incorrect format");
	}
	if (!lastName.matches(regex))
	{
		throw new Exception("last name is in incorrect format");
	}
	
	
	Name nameDefCopy = new Name(firstName, lastName);
		
	return nameDefCopy;
		
}
	
	
	
	
/**
* toString method to return a String representation of a persons fullname
* 
* 
* 
* @returns a String representation of a persons fullname
*/	
public final String toString()
	{
		String x;
		x = firstName + " " + lastName;
		
		return x;
		
	}
	
/**
 * Method to return a persons initials
 * 
 * 
 * @return A String representing a persons initials
 */
public final String getInitials()
	{
		char a;
		char b;
		
		a = firstName.charAt(0);
		b = lastName.charAt(0);
		
		String x = "" + a + b;
		x = x.trim();
		
		
		return x;
		
	}
		
// valueOf method


/**
* valeOf method, 
* @param a String representation of Name data in the form 
* "firstName, lastName"
* 
* @return a Name object created form data taken from input String
 * @throws Exception 
*/
public final static Name valueOf(String name) throws Exception 
{
	String inputStringFormat = ".+,\\s.+";  //checks string has ', ' in it (i.e. the correct format)
	
	if (!name.matches(inputStringFormat))
	{
		throw new Exception("name String representation read from file is in incorrect format");
	}
	
	
	
final String[] parts = name.split(", ");

//final String name = parts[0].equals("null")? null : parts[0];

final String firstName = parts[0];
final String lastName = parts[1];

Name newName = Name.getInstance(firstName, lastName);

return newName;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
	Name other = (Name) obj;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	return true;
}



/**
 * Method to get a persons first name
 * 
 * @return a String representing the first name
 */

public final String getFirstName()
{
	
	
	return new String(firstName);
}


/**
 * Method to get a persons last name
 * 
 * @return a String representing the last name
 */
public final String getLastName()
{
	return new String(lastName);
}


}
