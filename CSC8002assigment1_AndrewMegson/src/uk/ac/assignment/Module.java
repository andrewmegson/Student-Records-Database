package uk.ac.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * class Module,stores information for a module; 
 * the module code as a String, 
 * the module name as a String, 
 * and the number of credits the module is worth as an int.
 *
 * @author Andrew Megson 
 * @version 18/02/19
 */

public final class Module {
	
// basic module class may need to use abstract if require different modules for undergrads and postgrads
	
public static final Map<String, Module> MODULES = new HashMap<>();	
	
private final String moduleCode;
private final String moduleName;
private final int moduleCredits;




/**
* Constructor for objects of Module class
* 
* @param takes 2 String objects and an int; a String of the moduleCode,
* a String of the moduleName, and an int of the moduleCredits
*/
private Module(String code, String name, int credits)
{
	moduleCode = code;
	moduleName = name;
	moduleCredits = credits;
}

/**
 * Method to create a unique instance of a Module, 
 * this method assumes that all Modules are worth between 10 and 60 credits
 * 
 * @return a unique instance of a Module object
 * @throws Exception 
 */

public static Module getInstance(String code, String name, int credits) throws Exception
{
	String regexcode = "[A-Z]{3}[0-9]{4}";
	String regexname = "[a-z\\s]+";

	name = name.trim().toLowerCase();
	
	if (!code.matches(regexcode))
	{
		throw new Exception("module code is in incorrect format");
	}
	if (!name.matches(regexname))
	{
		throw new Exception("module name is in incorrect format");
	}
	if (!(10<=credits && credits<=60))
	{
		throw new Exception("module credits are an invalid amount");
	}
	
	
	Module m = MODULES.get(code);
	if(m ==null) 
	{
		m = new Module(code, name, credits);
		MODULES.put(code,m);
	}

	return m;
}







/**
 * Method to get the module code
 * 
 * @return a String representing the moduleCode
 */
public String getModuleCode() {
	
	
	return new String(moduleCode);
}





/**
 * Method to get the module name
 * 
 * @return a String representing the moduleName
 */
public String getModuleName() {
	
	
	return new String(moduleName);
}





/**
 * Method to get the number of credits the module is worth
 * 
 * @return an int representing the moduleCredits
 */
public int getModuleCredits() {
	
	return moduleCredits;
}




/**
 * toString method, to get a String representation of module information
 * 
 * @return a String of module information
 */
public String toString()
{
	String x;
	x = moduleCode + " " + moduleName + " " + moduleCredits;
	
	return x;
	
}



	


/**
 * valueOf method, to create an instance
 * @param a String representation of module data in the form 
 * "moduleCode, moduleName, moduleCredits"
 * 
 * @return a Module object created form data taken from input String
 * @throws Exception 
 */
public static Module valueOf(String module) throws Exception 
{
	String inputStringFormat = ".+,\\s.+,\\s.+";  //checks string has ', ' in it twice (i.e. the correct format)
	
	if (!module.matches(inputStringFormat))
	{
		throw new Exception("module String representation read from file is in incorrect format");
	}
	
final String[] parts = module.split(", ");

//final String name = parts[0].equals("null")? null : parts[0];

final String code = parts[0];
final String name = parts[1];
final int credits = Integer.parseInt(parts[2]);

Module m = Module.getInstance(code, name, credits);

return m;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((moduleCode == null) ? 0 : moduleCode.hashCode());
	result = prime * result + moduleCredits;
	result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
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
	Module other = (Module) obj;
	if (moduleCode == null) {
		if (other.moduleCode != null)
			return false;
	} else if (!moduleCode.equals(other.moduleCode))
		return false;
	if (moduleCredits != other.moduleCredits)
		return false;
	if (moduleName == null) {
		if (other.moduleName != null)
			return false;
	} else if (!moduleName.equals(other.moduleName))
		return false;
	return true;
}
	

}
