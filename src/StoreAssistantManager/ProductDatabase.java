
/* The ProductDatabase stores Employee values */

package StoreAssistantManager;

class ProduceDatabase implements Database {
	
	public Product[] products;
	
	/**
	 * Constructor
	 */
	public ProduceDatabase() {
		products = new Product [100];
	}
	
	/**
	 * Method to copy the array
	 */
	public Product[] copy() {
		return products;
	}

	/**
	 * Method to change the cost of one product
	 */
	public void newCost(int i, double newCost) {
		products[i].cost = newCost;
	}
	/**
	 * Method to change the price of one product
	 */
	public void newPrice(int i, double newPrice) {
		products[i].price = newPrice;
	}	
	/**
	 * Method to replenish for one product
	 */
	public void newStock(int i, int stock) {
		products[i].stock = stock;
	}
	/**
	 * Method to substract the sold amount for one product
	 */
	public void sold(int i, int amount) {
		products[i].stock -= amount;
	}
	
	
	/**
	 * Method to compute the benefits for one single product
	 */
	public double gross(int i) {
		double gross = products[i].price - products[i].cost;
		return gross;
	}
	
	/**
	 * Method to add a new product
	 */
	public void add(Product toAdd) {
		for (int i = 0; i < 100; i++) {
			if (products[i] == null) { // check if null
				products[i] = toAdd;
				return;
			}
		}
	}
	
	@Override
	/**
	 * remove one product from the array
	 * @param toRemove the String to be removed
	 */
	public void remove(String toRemove) {
		for (int i = 0; i < 100; i++) {
			if (products[i] != null) {
				if (products[i].getName().equals(toRemove)) { // if same
					products[i] = null; // remove
					return;
				}
			}
		}
	}

	@Override
	/**
	 * Check if the array contains a certain product
	 * @param toFind the String to be compared
	 */
	public boolean contains(String toFind) {
		for (int i = 0; i < 100; i++) {
			if (products[i] != null) {
				if (products[i].getName().equals(toFind)) { // compare
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
		String[] l = new String [products.length];
		for(int i = 0; i < products.length; i++) {
			if (products[i] != null) { // check null
				l[i] = products[i].toString();
			}
		}
		return l;
	}
}






