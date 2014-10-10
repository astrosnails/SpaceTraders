

package spacetraders.Abstract;

import spacetraders.model.Planet;

/**
 * The TravelListener interface.
 * @author saleh
 */
public interface TravelListener {
    /**
    * Lets you travel.
    * @param: Planet destination
    * @return: none
    */
    public void onTravel(Planet destination);
}
