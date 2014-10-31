package spacetraders.model;

import java.util.Random;
import spacetraders.Abstract.TravelListener;
import spacetraders.model.PlanetEvent;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
*This class implements the Planet Class
*to set up and create the methods of creating coordinates
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class Planet implements TravelListener, Serializable {
    
    private String name;
    private Coordinates coordinates;
    private TechnologyLevel technologyLevel;
    private ResourceLevel resourceLevel;
    private Resources resources;
    private PlanetEvent planetEvent; //added in constructor
    private Set<ShipType> shipsInShipyard;
    private Set<GadgetType> gadgetsInShipyard;
    
    /**
    * This constructor sets up a planet
    * @param String name, Coordinates coordinates, TechnologyLevel technologyLevel,
    *   ResourceLevel resourceLevel, Resources resources, PlanetEvent planetEvent
    * 
    */
    public Planet(String name, Coordinates coordinates, TechnologyLevel technologyLevel,
        ResourceLevel resourceLevel, Resources resources, PlanetEvent planetEvent,
        Set<ShipType> shipyard, Set<GadgetType> gadgets) {
        this.name = name;
        this.coordinates = coordinates;
        this.technologyLevel = technologyLevel;
        this.resourceLevel = resourceLevel;
        this.resources = resources;
        this.planetEvent = planetEvent;
        this.shipsInShipyard = shipyard;
        this.gadgetsInShipyard = gadgets;
    }
    
    /**
    * sets planet name
    * @param String name
    * @return none
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * gets name of planet
    * @param none
    * @return String name
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * this method gets resource price
    * @param ResourceType type
    * @return price as int
    */
    public int getResourcePrice(ResourceType type) {
        //get the instance of this singleton class
        ResourcesInfo a = ResourcesInfo.getInstance();
        
        double randomness = -1.0 * a.getVariance(type) / 100 + 
        Math.random()*2*a.getVariance(type) / 100;
        
        double value = a.getBasePrice(type) * (1 + randomness); 
        
        value += (a.getPriceIncreasePerTechLevel(type) * 
            (technologyLevel.ordinal() - a.getMinTechLevelToProduce(type).ordinal()));
        
        if (getResourceLevel() == a.getConditionForCheap(type)) {
            value /= 2;
        } else if (getResourceLevel() == a.getConditionForExpensive(type)) {
            value *= 1.5;
        }
        
        //checking for planet events
        if(type == PlanetEventsInfo.getInstance().getAffectedResource(planetEvent)) {
            value *= 1.3;
        }
        
        return (int) value; 
    }

    /**
    * this method gets the Planet event
    * @param none
    * @return none
    */
    public PlanetEvent getPlanetEvent() {
    	return this.planetEvent;
    }
    
    /**
    * this method sets cooridnates of planet
    * @param Coordinates coordinates
    * @return none
    */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    /**
    * this method gets planet coordinates
    * @param none
    * @return Coordinate coordinates
    */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
    /**
    * this method sets technology level of the planet
    * @param TechnologyLevel technologyLevel
    * @return none
    */
    public void setTechnologyLevel(TechnologyLevel technologyLevel) {
        this.technologyLevel = technologyLevel;
    }
   
    /**
    * this method gets the technology level of planet
    * @param none 
    * @return TechnologyLevel technologyLevel
    */
    public TechnologyLevel getTechnologyLevel() {
        return this.technologyLevel;
    }
   
    /**
    * this method sets Resource level
    * @param ResourceLevel resourceLevel
    * @return none
    */
    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
    * this method gets Resource level
    * @param none
    * @return ResourceLevel
    */
    public ResourceLevel getResourceLevel() {
        return this.resourceLevel;
    }
   
    /**
    * this method sets Resources
    * @param Resources resources
    * @return none
    */
    public void setResources(Resources resources) {
        this.resources = resources;
    }
   
    /**
    * this method gets Resources
    * @param none
    * @return Resources
    */
    public Resources getResources() {
        return this.resources;
    }
    /**
     * get ship in ship yard
     * @return set of ship type
     */
    public Set<ShipType> getShipsInShipyard() {
        return shipsInShipyard;
    }
    /**
     * get gadgests in ship yard
     * @return set of gadget type
     */
    public Set<GadgetType> getGadgetsInShipyard() {
        return gadgetsInShipyard;
    }
    
    /**
    * This method is called when the player travels, in other words, when time
    * passes.
    * @param destination The destination that the player is traveling to.
    */
    public void onTravel(Planet destination) {
    	Random rand = new Random();
    	int num = rand.nextInt(PlanetEvent.values().length);
    	planetEvent = PlanetEvent.values()[num];
    }
}
