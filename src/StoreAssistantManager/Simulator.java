
/* The Simulator class that manages the whole problem. For the re-submission version, I add 
 * a HashMap repairsList for Repairing Interface functions. */


package StoreAssistantManager;
import java.io.*;
import java.util.*;
import java.util.HashMap;


public class Simulator {
	
	public static EmployeeDatabase employeesDB;
	public static ProduceDatabase productsDB;
	
	// create a HashMap for Repairing Interface
	public static HashMap<String, Double> repairsList; 
	
	public static void main (String[] args) throws FileNotFoundException {
		// initializing
		employeesDB = new EmployeeDatabase();
		productsDB = new ProduceDatabase();
		repairsList = new HashMap<String, Double>(); //Initialize the HashMap
		
		Scanner console = new Scanner (System.in);
		
		String action = "";
		
		// determine if the user wants to exit
		while(!action.equals("Exit")) {
			// prompt the user to make decision
			System.out.println("Please choose one of the following:");
			System.out.println("Employee Interface");
			System.out.println("Product Interface");
			System.out.println("Repairing Interface");
			System.out.println("Open Your Store");
			System.out.println("Exit");
			System.out.println("");
			
			action = console.nextLine();
			if (action.equals("Exit")) {
				break;
			}
			if(action.equals("Employee Interface")) {
				// go into employee interface
				EmployeeInterface(console);
			} else if (action.equals("Product Interface")) {
				ProductInterface(console);
			} else if (action.equals("Open Your Store")) {
				OpenStore(console);
			} else if (action.equals("Repairing Interface")) {
				RepairingInterface(console);
			} 
		}
		
		System.out.println("Thank you for using Assistant Manager, goodbye!");
		
	}
	
	/**
	 * Employee Interface
	 * @param console the Scanner object
	 */
	public static void EmployeeInterface(Scanner console) throws NullPointerException {
		
		String actionEmployee = "";
		
		// Employee Interface
		while(!actionEmployee.equals("Back")) {
			// prompt the user to make decision 
			System.out.println("Employee Interface:");
			System.out.println("(To change the data of one employee, please delete his/her data first and then re-add.)");
			System.out.println("Employee List");
			System.out.println("Add An Employee");
			System.out.println("Modify Employee Data");
			System.out.println("Back");
			System.out.println("");
			
			actionEmployee = console.nextLine();
			if (actionEmployee.equals("Back")) {
				break;
			}
			if(actionEmployee.equals("Employee List")) {
				EmployList();
			} else if(actionEmployee.equals("Add An Employee")) {
				addEmployee(console);
			}else if (actionEmployee.equals("Modify Employee Data")) {
				modifyEmployee(console);
			}

		}
	}

	
	/**
	 * In the Employee Interface, user can browse all employees in the store. 
	 * @param console the Scanner object
	 */
	public static void EmployList()  {
		System.out.println("All employees in your store:");
		String[] print = employeesDB.list();
		for(int i = 0; i < print.length; i++) {
			if (print[i] != null) { // check null
				System.out.println(print[i]);
			}
		}
		System.out.println();
	}
	
	
	/**
	 * In the Employee Interface, user can add one new employee to the database 
	 * @param console the Scanner object
	 */
	public static void addEmployee(Scanner console)  {
		// prompt the user
		System.out.println("What is the name of the new employee?");
		String employeeName = console.next();
		System.out.println("What is the position of the new employee?");
		String employeePosition = console.next();
		System.out.println("What is the salary of the new employee?");
		String inputSalary = console.next();
		// convert the input designed salary into Double type
		double employeeSalary = Double.valueOf(inputSalary);
		
		// add the correct data type to the database
			if (employeePosition.equals("Manager")) {
				Manager toAdd = new Manager(employeeName, employeeSalary);
				employeesDB.add(toAdd);
			}
			else if (employeePosition.equals("Cashier")) {
				Cashier toAdd = new Cashier(employeeName, employeeSalary);
				employeesDB.add(toAdd);
			}else if (employeePosition.equals("Janitor")) {
				Janitor toAdd = new Janitor(employeeName, employeeSalary);
				employeesDB.add(toAdd);
			}else if(employeePosition.equals("Seller")) {
				Seller toAdd = new Seller(employeeName, employeeSalary);
				employeesDB.add(toAdd);
			}
	}
	
	/**
	 * In the Employee Interface, user can remove one employee from the database 
	 * @param console the Scanner object
	 */
	public static void modifyEmployee(Scanner console) {
		EmployList();
		System.out.println("Which employee you want to modify?");
		String modifyEmployee = console.next();
		while(!employeesDB.contains(modifyEmployee)) {
			System.out.println("Please enter a valid input.");
			System.out.println("Which employee you want to dismiss?");
			modifyEmployee = console.next();
		}
		System.out.println("What modifications you want to make? (Position, Salary, or Dismiss)");
		System.out.println("Position");
		System.out.println("Salary");
		System.out.println("Dismiss");
		String modifytype = console.next();
		
		if(modifytype.equals("Position")) {
			System.out.println("Please input the new position");
			String newPosition = console.next();
			Employee[] temp = employeesDB.copy();
			for (int i = 0; i < 100; i++) {
				if (temp[i]!= null) {
					if (temp[i].getName().equals(modifyEmployee)) { // if same
						Employee a = temp[i];
						String name = a.name;
						Double salary = a.salary;
						if (newPosition.equals("Manager")) {
							Manager toAdd = new Manager(name, salary);
							employeesDB.add(toAdd);
						}
						else if (newPosition.equals("Cashier")) {
							Cashier toAdd = new Cashier(name, salary);
							employeesDB.add(toAdd);
						}else if (newPosition.equals("Janitor")) {
							Janitor toAdd = new Janitor(name, salary);
							employeesDB.add(toAdd);
						}else if(newPosition.equals("Seller")) {
							Seller toAdd = new Seller(name, salary);
							employeesDB.add(toAdd);
						}
						employeesDB.remove(modifyEmployee);
					}
				}
			}
		} else if(modifytype.equals("Salary")) {
			System.out.println("Please input the new salary");
			String input = console.next();
			double newSalary = Double.valueOf(input);
			Employee[] temp = employeesDB.copy();
			for (int i = 0; i < 100; i++) {
				if (temp[i]!= null) {
					if (temp[i].getName().equals(modifyEmployee)) { // if same
						employeesDB.newSalary(i, newSalary);
					}
				}
			}
		} else if (modifytype.equals("Dismiss")) {
			employeesDB.remove(modifyEmployee);
		}

	}

	
	/**
	 * Product Interface
	 * @param console the Scanner object
	 */
	public static void ProductInterface(Scanner console) throws NullPointerException {

		String actionProduct = "";
		
		// Product Interface
		while(!actionProduct.equals("Back")) {
			// prompt the user to make decision again
			System.out.println("Product Interface:");
			System.out.println("Product List");
			System.out.println("Add A New Product");
			System.out.println("Modify A Product");
			System.out.println("Back");
			System.out.println("");
			
			actionProduct = console.nextLine();
			
			if (actionProduct.equals("Back")) {
				break;
			}
			if(actionProduct.equals("Product List")) {
				ProductList();
			} else if(actionProduct.equals("Add A New Product")) {
				addProduct(console);
			} else if (actionProduct.equals("Modify A Product")) {
				modifyProduct(console);
			} 
		}
	}
	
	
	/**
	 * In the Product Interface, user can browse all products in the store. 
	 * @param console the Scanner object
	 */
	public static void ProductList()  {
		System.out.println("All products in your store:");
		String[] print = productsDB.list();
		for(int i = 0; i < print.length; i++) {
			if (print[i] != null) { // check null
				System.out.println(print[i]);
			}
		}
		System.out.println();
	}
	
	
	/**
	 * In the Product Interface, user can add one new product to the database 
	 * @param console the Scanner object
	 */
	public static void addProduct(Scanner console)  {
		// prompt the user
		System.out.println("What is the name of the new product?");
		String productName = console.next();
		System.out.println("What is the cost of the new product?");
		String inputCost = console.next();
		double productCost = Double.valueOf(inputCost);
		System.out.println("What is the price of the new product?");
		String inputPrice = console.next();
		double productPrice = Double.valueOf(inputPrice);
		System.out.println("What is the initial stock of the new product?");
		String inputStock = console.next();
		int productStock = Integer.parseInt(inputStock);


		// add the correct data type to the database
		Product toAdd = new Product(productName, productCost, productPrice, productStock);
		productsDB.add(toAdd);
	}
	
	/**
	 * In the Product Interface, user can modify one product from the database 
	 * @param console the Scanner object
	 */
	public static void modifyProduct(Scanner console) {
		ProductList();
		System.out.println("Which product you want to modify?");
		String modifyProduct = console.next();
		while(!productsDB.contains(modifyProduct)) {
			System.out.println("Please enter a valid input.");
			System.out.println("Which product you want to modify?");
			modifyProduct = console.next();
		}
		
		System.out.println("What modifications you want to make? (Cost, Price, Stock, or Remove)");
		System.out.println("Cost");
		System.out.println("Price");
		System.out.println("Stock");
		System.out.println("Remove");
		
		String modifytype = console.next();
		
		if(modifytype.equals("Cost")) {
			System.out.println("Please input the new cost");
			String input = console.next();
			double newCost = Double.valueOf(input);
			Product [] temp = productsDB.copy();
			for (int i = 0; i < 100; i++) {
				if (temp[i]!= null) {
					if (temp[i].getName().equals(modifyProduct)) { // if same
						productsDB.newCost(i, newCost);
					}
				}
			}
		} else if(modifytype.equals("Price")) {
			System.out.println("Please input the new price");
			String input = console.next();
			double newPrice = Double.valueOf(input);
			Product [] temp = productsDB.copy();
			for (int i = 0; i < 100; i++) {
				if (temp[i]!= null) {
					if (temp[i].getName().equals(modifyProduct)) { // if same
						productsDB.newPrice(i, newPrice);
					}
				}
			}
		} else if(modifytype.equals("Stock")) {
			System.out.println("Please input the new stock");
			String input = console.next();
			int newStock = Integer.parseInt(input);
			Product[] temp = productsDB.copy();
			for (int i = 0; i < 100; i++) {
				if (temp[i]!= null) {
					if (temp[i].getName().equals(modifyProduct)) { // if same
						productsDB.newStock(i, newStock);
					}
				}
			}
		} else if (modifytype.equals("Remove")) {
			productsDB.remove(modifyProduct);
		}
	}
	
	/**
	 * Repairing Interface
	 * @param console the Scanner object
	 */
	public static void RepairingInterface(Scanner console) throws NullPointerException {
		
		String actionRepairing = "";
		
		// Repairing Interface
		while(!actionRepairing.equals("Back")) {
			// prompt the user to make decision 
			System.out.println("Repairing Interface:");
			//System.out.println("(To change the data of one employee, please delete his/her data first and then re-add.)");
			System.out.println("Repairing List");
			System.out.println("Add An Item To Repair");
			System.out.println("Remove A Repaired Item");
			System.out.println("Back");
			System.out.println("");
			
			actionRepairing = console.nextLine();
			if (actionRepairing.equals("Back")) {
				break;
			}
			if(actionRepairing.equals("Repairing List")) {
				RepairingList();
			} else if(actionRepairing.equals("Add An Item To Repair")) {
				addRepairing(console);
			}else if (actionRepairing.equals("Remove A Repaired Item")) {
				removeRepairing(console);
			}

		}
	}
	
	/**
	 * In the Repairing List, user can browse all items need to repair in the store. 
	 * @param console the Scanner object
	 */
	public static void RepairingList()  {
		System.out.println("All items need to repair in your store:");
		// Print keys and values of HashMap
		for (String i : repairsList.keySet()) {
		  System.out.println("Name: " + i + " Cost: " + repairsList.get(i));
		}
		System.out.println();
	}
	
	/**
	 * In the Item Add Interface, user can add one new item need to repair to the Map 
	 * @param console the Scanner object
	 */
	public static void addRepairing(Scanner console)  {
		// prompt the user
		System.out.println("What is the name of the item need to repair?");
		String repairName = console.next();
		System.out.println("What is the cost of that item to repair?");
		String inputCost = console.next();
		// convert the input designed salary into Double type
		double repairCost = Double.valueOf(inputCost);
		
	    // Add keys and values to Map
	    repairsList.put(repairName, repairCost);
	}
	
	/**
	 * In the Item Remove Interface, user can remove one repaired item from the Map 
	 * @param console the Scanner object
	 */
	public static void removeRepairing(Scanner console)  {
		//print out the list of items
		RepairingList();
		// prompt the user
		System.out.println("What is the name of the REPAIRED item?");
		String repairedName = console.next();
	    // input keys and remove
		repairsList.remove(repairedName);
	}
	
	/**
	 * After one day, compute the balance report for user
	 * @return the total income
	 */
	public static void OpenStore(Scanner console) {
		
		double income = 0;
		double employeeCost = 0;
		double productBenefits = 0;
		double repairCost = 0;
		
		// compute the cost from employees
		Employee[] temp = employeesDB.copy();
		for (int i = 0; i < 100; i++) {
			if (temp[i] != null) {
					double personSalary = temp[i].getSalary(); 
					employeeCost += personSalary;
			}
		}
		
		// compute the cost from items need to repair
		// add all item's cost
		for (String i : repairsList.keySet()) {
			repairCost += repairsList.get(i);
		}
		
		String YN = "Yes";
		
		// compute the benefits from sold products
		while (YN.equals("Yes")) {
			ProductList();
			System.out.println("Any new product has been sold? ('Yes' or 'No')");
			YN = console.next();
			if (YN.equals("Yes")) {
				double benefits = productBenefits(console);
				productBenefits += benefits;
			} 
		}
		
		// print the balance report to user
		income = productBenefits - employeeCost - repairCost;
		System.out.println("Today, your cost from employees is " + employeeCost + "; ");
		System.out.println("Today, your cost from repairing is " + repairCost + "; ");
		System.out.println("Today, your gross benefits of sold products is " + productBenefits + "; ");
		System.out.println("Today, your gross income is " + income + ". ");
		System.out.println("");
		

	}
	

	/**
	 * compute the benefit for one product
	 * @return the total income
	 */
	public static double productBenefits(Scanner console) {
		double benefits = 0; 
		
		System.out.println("Which product has been sold? (input 'product name' )");
		String modifyProduct = console.next();
		while(!productsDB.contains(modifyProduct)) {
			System.out.println("Please enter a valid input.");
			System.out.println("Which product you want to dismiss?");
			modifyProduct = console.next();
		}
		System.out.println("Please input the amount sold of this product: ");
		String input = console.next();
		int amount = Integer.parseInt(input);
		Product [] temp = productsDB.copy();
		for (int i = 0; i < 100; i++) {
			if (temp[i]!= null) {
				if (temp[i].getName().equals(modifyProduct)) { // if same
					double gross = productsDB.gross(i);
					benefits = amount*gross;
					productsDB.sold(i, amount);
				}
			}
		}
		return benefits;
	}
	
}

