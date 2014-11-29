/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Tests;

import static org.junit.Assert.*;
import spacetraders.model.Coordinates;
import org.junit.Test;
/**
 * Junit test class for the 
 * public double distanceTo(Coordinates other) method
 * @author Catherine Chen
 */
public class CoordinatesTest {

    @Test
    public void distanceToTest_Horizontal() {
        Coordinates distance = new Coordinates(9, 0);
        Coordinates distance2 = new Coordinates(70, 0);
        assertEquals(61,(int) distance.distanceTo(distance2));
        
    }
    
    @Test
    public void distanceToTest_Vertical() {
        Coordinates distance = new Coordinates(9, 10);
        Coordinates distance2 = new Coordinates(9, 80);
        assertEquals(70,(int) distance.distanceTo(distance2));
        
    }
    
    @Test
    public void distanceToTest_DiagDown() {
        Coordinates distance = new Coordinates(100, 10);
        Coordinates distance2 = new Coordinates(9, 80);
        assertEquals(114,(int)distance.distanceTo(distance2));
    }
    
    @Test
    public void distanceToTest_DiagUp() {
        Coordinates distance = new Coordinates(100, 100);
        Coordinates distance2 = new Coordinates(9, 80);
        assertEquals(93,(int)distance.distanceTo(distance2));
    }
}
