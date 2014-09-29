import java.util.ArrayList;

/**
*This class implements the Cargo Class
*to set up and create the methods of cargo
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/

public class Cargo {

	ArrayList<Resources> a;
	int maxSize;
   
    /**
	 * This constructor sets up a Cargo
	 * @param int maxSize
	 * 
	 */

	public Cargo(int maxSize) {
		this.maxSize = maxSize;
		a = new ArrayList();
	}

    /**
    * sees if there is free cargo space
    * @param none
    * @return boolean, true if there is space, false if there is no space
    */
	public boolean validateCargoSpace() {
		if (a.size() < maxSize) {
			return true;
		} 
		return false;
	}

    /**
    * gets amount of space in cargo
    * @param none
    * @return amount of size left in cargo as integer
    */
	public int getSpace() {
		return maxSize - a.size();
	}

    /**
    * adds resource into cargo
    * @param Resources addMe
    * @return boolean, true if the cargo was successfully added, false if it did not add
    */
	public boolean add(Resources addMe) {
		if (a == null) {
			return false;
		} 
		if (validateCargoSpace()) {
			a.add(addMe);
			return true;
		}
		return false;
	}

    /**
    * sees if cargo has that resource
    * @param Resources seeMe
    * @return boolean, true if cargo does contain resource, false if it does not contain
    */
	public boolean contains(Resources seeMe) {
		if (seeMe == null) {
			return false;
		} 
		if (a.size() != 0) {
			for (Resources x: a) {
				if (x != null && x.equals(seeMe)) {
					return true;
				}
			}
		}
		return false;
	}
   
    /**
    * removes resource from cargo
    * @param Resources removeMe
    * @return boolean, true if the resource was successfully removed, false if the resource was not removed
    */
	public boolean remove(Resources removeMe) {
		if (removeMe == null) {
			return false;
		} 
		if (contains(removeMe)) {
			for (Resources x: a) {
				if (x != null && x.equals(removeMe)) {
					a.remove(x);
					return true;
				}
			}		
		}
		return false;
	}
}