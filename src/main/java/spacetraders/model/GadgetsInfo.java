package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

/**
*  Singleton class that holds the information about the game resources.
*  @author Team Astrosnails (6) - CS 2340 Fall 2014
*/
public class GadgetsInfo {
    private static GadgetsInfo gadgetsInfo;
    private Map<GadgetType, GadgetInfo> gadgetInfoMap;
    
    /**
    *  Creates the ResourcesInfo.
    */
    private GadgetsInfo() {
        GadgetInfo bazooka = new GadgetInfo();
        bazooka.setName("Bazooka")
            .setPrice(4000)
            .setMinTechLevelToProduce(TechnologyLevel.EARLY_INDUSTRIAL)
            .setAttack(10);
        
        GadgetInfo crystalRingShield = new GadgetInfo();
        crystalRingShield.setName("Crystal Ring Shield")
            .setPrice(5000)
            .setMinTechLevelToProduce(TechnologyLevel.INDUSTRIAL)
            .setHealth(100);
        
        GadgetInfo turboMax = new GadgetInfo();
        turboMax.setName("Turbo Max")
            .setPrice(2000)
            .setMinTechLevelToProduce(TechnologyLevel.INDUSTRIAL)
            .setSpeed(200);
        
        GadgetInfo xSpaceX = new GadgetInfo();
        xSpaceX.setName("XSpaceX")
            .setPrice(5000)
            .setMinTechLevelToProduce(TechnologyLevel.EARLY_INDUSTRIAL)
            .setCargoSpace(10);
        
        GadgetInfo missile = new GadgetInfo();
        missile.setName("Missile")
            .setPrice(6000)
            .setMinTechLevelToProduce(TechnologyLevel.POST_INDUSTRIAL)
            .setAttack(15);
        
        GadgetInfo blackKnightShield = new GadgetInfo();
        blackKnightShield.setName("Black Knight Shield")
            .setPrice(7000)
            .setMinTechLevelToProduce(TechnologyLevel.EARLY_INDUSTRIAL)
            .setHealth(150);
        
        GadgetInfo lightningSpeed = new GadgetInfo();
        lightningSpeed.setName("Lightning Speed")
            .setPrice(3000)
            .setMinTechLevelToProduce(TechnologyLevel.INDUSTRIAL)
            .setSpeed(300);
        
        GadgetInfo giantMonster = new GadgetInfo();
        giantMonster.setName("Giant Monster")
            .setPrice(8000)
            .setMinTechLevelToProduce(TechnologyLevel.INDUSTRIAL)
            .setCargoSpace(20);
        
        GadgetInfo infinitySpace = new GadgetInfo();
        infinitySpace.setName("Infinity Space")
            .setPrice(12000)
            .setMinTechLevelToProduce(TechnologyLevel.HI_TECH)
            .setCargoSpace(30);
        
        gadgetInfoMap = new EnumMap<>(GadgetType.class);
        gadgetInfoMap.put(GadgetType.BAZOOKA, bazooka);
        gadgetInfoMap.put(GadgetType.CRYSTAL_RING_SHIELD, crystalRingShield);
        gadgetInfoMap.put(GadgetType.TURBO_MAX, turboMax);
        gadgetInfoMap.put(GadgetType.XSPACEX, xSpaceX);
        gadgetInfoMap.put(GadgetType.MISSILE, missile);
        gadgetInfoMap.put(GadgetType.BLACK_KNIGHT_SHIELD, blackKnightShield);
        gadgetInfoMap.put(GadgetType.LIGHTNING_SPEED, lightningSpeed);
        gadgetInfoMap.put(GadgetType.GIANT_MONSTER, giantMonster);
        gadgetInfoMap.put(GadgetType.INFINITY_SPACE, infinitySpace);
    }
    
    /**
    *  Returns an instance of the ResouresInfo. Ensures that ResouresInfo follows
    *  the Singleton pattern.
    *  @return The universe
    */
    public static GadgetsInfo getInstance() {
        if (gadgetsInfo == null) {
            gadgetsInfo = new GadgetsInfo();
        }
        
        return gadgetsInfo;
    }
    
    /**
    *  Returns the name of the gadget of the given type.
    *  @param type The resource type
    *  @return Name
    */
    public String getName(GadgetType type) {
        return gadgetInfoMap.get(type).name;
    }
    
    /**
    *  Returns the price of the gadget of the given type.
    *  @param type The resource type
    *  @return Price
    */
    public int getPrice(GadgetType type) {
        return gadgetInfoMap.get(type).price;
    }
    
    /**
    *  Returns the attack of the gadget of the given type.
    *  @param type The resource type
    *  @return Attack
    */
    public int getAttack(GadgetType type) {
        return gadgetInfoMap.get(type).attack;
    }
    
    /**
    *  Returns the health of the gadget of the given type.
    *  @param type The resource type
    *  @return Health
    */
    public int getHealth(GadgetType type) {
        return gadgetInfoMap.get(type).health;
    }
    
    /**
    *  Returns the speed of the gadget of the given type.
    *  @param type The resource type
    *  @return Speed
    */
    public int getSpeed(GadgetType type) {
        return gadgetInfoMap.get(type).speed;
    }
    
    /**
    *  Returns the cargo space of the gadget of the given type.
    *  @param type The resource type
    *  @return Cargo Space
    */
    public int getCargoSpace(GadgetType type) {
        return gadgetInfoMap.get(type).cargoSpace;
    }
    
    /**
    *  Returns the minimum tech level to produce the gadget of the given type.
    *  @param type The resource type
    *  @return Minimum technology level to produce this gadget
    */
    public TechnologyLevel getMinTechLevelToProduce(GadgetType type) {
        return gadgetInfoMap.get(type).minTechToProduce;
    }
    /**
     * get information of gadget
     * @param type
     * @return String
     */
    public String getInformationAsText(GadgetType type) {
          StringBuilder info = new StringBuilder();
          info.append("Name: " + getName(type) + " (" + getPrice(type) + ")\n");
          if (getHealth(type) > 0) {
              info.append("Health: +" + getHealth(type) + "\n");
          }
          if (getAttack(type) > 0) {
              info.append("Attack: +" + getAttack(type) + "\n");
          }
          if (getSpeed(type) > 0) {
              info.append("Speed: +" + getSpeed(type) + "\n");
          }
          if (getCargoSpace(type) > 0) {
              info.append("Maximum Cargo Space: +" + getCargoSpace(type) + "\n");
          }
 
          return info.toString();
      }
    
    /**
    *  GadgetInfo holds the information for one resource.
    */
    private class GadgetInfo {
        private String name;
        private int price;
        private TechnologyLevel minTechToProduce;
        private int attack;
        private int health;
        private int speed;
        private int cargoSpace;
        /**
         * setter for Name
         * @param name
         * @return 
         */
        private GadgetInfo setName(String name) {
            this.name = name;
            return this;
        }
        /**
         * setter for price
         * @param price
         * @return 
         */
        private GadgetInfo setPrice(int price) {
            this.price = price;
            return this;
        }
        
        private GadgetInfo setAttack(int attack) {
            this.attack = attack;
            return this;
        }
        
        private GadgetInfo setHealth(int health) {
            this.health = health;
            return this;
        }
        /**
         * setter for speed
         * @param speed
         * @return 
         */
        private GadgetInfo setSpeed(int speed) {
            this.speed = speed;
            return this;
        }
        /**
         * setter for cargo space
         * @param cargoSpace
         * @return 
         */
        private GadgetInfo setCargoSpace(int cargoSpace) {
            this.cargoSpace = cargoSpace;
            return this;
        }
        /**
         * setter for min tech level to produce
         * @param level
         * @return 
         */
        private GadgetInfo setMinTechLevelToProduce(TechnologyLevel level) {
            this.minTechToProduce = level;
            return this;
        }
    }
}
