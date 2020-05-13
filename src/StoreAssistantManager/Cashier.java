/* The Cashier class extends from the Employee class,
 * containing the information of a cashier */

package StoreAssistantManager;

public class Cashier extends Employee{
	
	/**
	 * Constructor
	 * @param initName the name of the employee
	 * @param initStore the store that the employee works
	 */
	public Cashier(String initName, double initSalary) {
		super(initName, initSalary);
		position = "Cashier";
		salary = initSalary;
	}
	
	@Override
	/**
	 * Add the specific information to the end of the string
	 * of the super class
	 */
	public String toString() {
		return super.toString() + " Position: cashier.";
	}
}
