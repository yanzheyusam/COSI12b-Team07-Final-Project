/* The Employee class that is abstract, 
   containing the information of an employee */


package src;

public class Employee {
	public double salary;
	public String name;
	public String position;

	
	/**
	 * Constructor
	 * @param initName the name of the employee
	 * @param initSalary the salary that the employee has
	 */
	public Employee(String initName, double initSalary) {
		name = initName;
		salary = initSalary;
	}
	
	/**
	 * Return the position of the employee
	 * @return the position of the employee
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Return the salary of the employee
	 * @return the salary of the employee
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Return the name of the employee
	 * @return the name of the employee
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Formatting the employee's information in a string
	 */
	public String toString() {
		return "Name: " + name + ". Salary: " + salary + ".";
	}
}
