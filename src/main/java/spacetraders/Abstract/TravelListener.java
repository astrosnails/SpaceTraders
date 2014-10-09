/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Abstract;

import spacetraders.model.Planet;

/**
 *
 * @author saleh
 */
public interface TravelListener {
    public void onTravel(Planet destination);
}
