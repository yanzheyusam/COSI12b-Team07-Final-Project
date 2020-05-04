/* The Janitor class extends from the Employee class,
 * containing the information of a janitor */


package src;

public class Janitor extends Employee{
	
	/**
	 * Constructor
	 * @param initName the name of the employee
	 * @param initStore the store that the employee works
	 */
	public Janitor(String initName, double initSalary) {
		super(initName, initSalary);
		position = "Janitor";
		salary = initSalary;
	}
	
	@Override
	/**
	 * Add the specific information to the end of the string
	 * of the super class
	 */
	public String toString() {
		return super.toString() + " Position: janitor.";
	}
}
