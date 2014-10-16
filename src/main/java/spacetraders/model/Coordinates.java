package spacetraders.model;

import java.io.Serializable;

/**
*This class implements the Coordinates Class
*to set up and create the methods of creating coordinates
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/

public class Coordinates implements Serializable {
    
    private int x, y;
    
    /**
	 * This constructor sets up a coordinates,
	 * setting up x and y value
	 * @param int x, int y
	 * @no return
	 */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
    * gets x value
    * @no param
    * @return x value as int
    */
    public int getX() {
        return x;
    }
    
    /**
    * gets y value
    * @no param
    * @return y value as int
    */
    public int getY() {
        return y;
    }
    /**
    * gets distance to another coordinate
    * @param: Coordinate other
    * @return double distance
    */
    public double distanceTo(Coordinates other) {
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }
    
    /**
    * compares a coordinate object to another cooridnate
    * @no Object other
    * @return boolean value, true if it is equal, false if it is not equal
    */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof Coordinates)) {
            return false;
        } else {
            Coordinates otherCoordinate = (Coordinates) other;
            return otherCoordinate.x == x && otherCoordinate.y == y;
        }
    }
}
