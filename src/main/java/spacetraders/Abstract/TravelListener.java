

package spacetraders.Abstract;

import spacetraders.model.Planet;

/**
 * The TravelListener interface.
 * @author saleh
 */
public interface TravelListener {
    /**
    * Called when the player travels.
    * @param destination destination
    */
    public void onTravel(Planet destination);
}
