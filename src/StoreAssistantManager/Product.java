/* The Product class that is abstract, 
   containing the information of a product */


package StoreAssistantManager;


public class Product {
	public String name;
	public double cost;
	public double price;
	public int stock;

	
	/**
	 * Constructor
	 * @param initName the name of the product
	 * @param initStore the store that the employee works
	 */
	public Product(String initName, double initcost, double initprice, int initstock) {
		name = initName;
		cost = initcost;
		price = initprice;
		stock = initstock;
	}
	
	/**
	 * Return the cost of the product
	 * @return the cost of the product
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Return the price of the product
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Return the name of the product
	 * @return the name of the product
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the stock of the product
	 * @return the stock of the product
	 */
	public double getStock() {
		return stock;
	}
	
	/**
	 * Formatting the product's information in a string
	 */
	public String toString() {
		return "Name: " + name + ". Cost: " + cost + ". Price: " + price + ". Stock: " + stock + ".";
	}
}
