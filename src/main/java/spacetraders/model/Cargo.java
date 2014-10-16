package spacetraders.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
*This class implements the Cargo Class
*to set up and create the methods of cargo
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/

public class Cargo implements Serializable {

	private Resources resources;
	private int maxSize;
   
    /**
	 * This constructor sets up a Cargo
	 * @param int maxSize
	 * 
	 */

	public Cargo(int maxSize) {
            this.maxSize = maxSize;
            resources = new Resources();
	}

        public Resources getResources() {
            return resources;
        }
        
        public int calculateTotalResources() {
            int waterAmount = resources.getResourceAmount(ResourceType.WATER);
            int foodAmount = resources.getResourceAmount(ResourceType.FOOD);
            int oilAmount = resources.getResourceAmount(ResourceType.OIL);
            int goldAmount = resources.getResourceAmount(ResourceType.GOLD);
            int cocaineAmount = resources.getResourceAmount(ResourceType.COCAINE);
            int totalAmount = waterAmount + foodAmount + oilAmount + goldAmount + cocaineAmount;
            return totalAmount;
        }
        
        public int calculateEmptySpace() {
            return maxSize - calculateTotalResources();
        }
        
        public boolean validateCargoSpace(int amount) {
            if (calculateEmptySpace() >= amount) {
                return true;
            }
            return false;
        }
        
        
        public int getMaxSize() {
            return maxSize;
        }
}