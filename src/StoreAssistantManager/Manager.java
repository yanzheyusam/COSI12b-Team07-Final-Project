/* The Manager class extends from the Employee class,
 * containing the information of a manager */


package StoreAssistantManager;

public class Manager extends Employee{
	
	/**
	 * Constructor
	 * @param initName the name of the employee
	 * @param initStore the store that the employee works
	 */
	public Manager(String initName, double initSalary) {
		super(initName, initSalary);
		position = "Manager";
		salary = initSalary;
	}
	
	/**
	 * Change the salary of a employee
	 * @param employee the employee object to be changed
	 * @param newSalary the new salary to change
	 * @return the amount of the new salary
	 */
//	public String changeSalary(Employee employee, String newSalary) {
//		employee.salary = newSalary;
//		return employee.salary;
//	}
	
	
	
	@Override
	/**
	 * Add the specific information to the end of the string
	 * of the super class
	 */
	public String toString() {
		return super.toString() + " Position: manager.";
	}
}
