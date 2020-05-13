
/* The EmployeeDatabase stores Employee values */

package StoreAssistantManager;

public class EmployeeDatabase implements Database {
	
	public Employee[] employees;
	
	/**
	 * Constructor
	 */
	public EmployeeDatabase() {
		employees = new Employee [100];
	}

	/**
	 * Method to copy the array
	 */
	public Employee[] copy() {
		return employees;
	}

	/**
	 * Method to change the salary of one employee
	 */
	public void newSalary(int i, double newSalary) {
		employees[i].salary = newSalary;
	}
	
	/**
	 * Method to add new employee
	 */
	public void add(Employee toAdd) {
		for (int i = 0; i < 100; i++) {
			if (employees[i] == null) { // check if null
				employees[i] = toAdd;
				return;
			}
		}
	}

	
	@Override
	/**
	 * remove one Employee from the array
	 * @param toRemove the String to be removed
	 */
	public void remove(String toRemove) {
		for (int i = 0; i < 100; i++) {
			if (employees[i] != null) {
				if (employees[i].getName().equals(toRemove)) { // if same
					employees[i] = null; // remove
					return;
				}
			}
		}
	}

	@Override
	/**
	 * Check if the array contains a certain Employee
	 * @param toFind the String to be compared
	 */
	public boolean contains(String toFind) {
		for (int i = 0; i < 100; i++) {
			if (employees[i] != null) {
				if (employees[i].getName().equals(toFind)) { // compare
					return true;
				}
			}
		}
		return false;
	}

	@Override
	/**
	 * Array of result of all toString() method
	 * @return a String array contains all the toString method
	 */
	public String[] list() {
		String[] l = new String [employees.length];
		for(int i = 0; i < employees.length; i++) {
			if (employees[i] != null) { // check null
				l[i] = employees[i].toString();
			}
		}
		return l;
	}
}
