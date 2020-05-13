
/* The interface that holds outline for all kinds of Database */

package StoreAssistantManager;

public interface Database {
	

	/**
	 * remove the appropriate object from the corresponding array
	 * @param toRemove the String to be removed
	 */
	public void remove(String toRemove);
	
	/**
	 * check whether the appropriate object exists within the database
	 * @param toFind the String to be found
	 * @return true if found, false if not
	 */
	public boolean contains(String toFind);
	
	/**
	 * return an array of the result of the 
	 * toString() method for each object stored 
	 * in the database
	 * @return an array of the result of the toString() method for each object
	 */
	public String[] list();
}
