/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.model;
import java.util.EnumMap;
import java.util.Map;

/**
 * Singleton class that holds the information of the ships in SpadeTrader
 * @author Team 6
 */
public class ShipsInfo {
    private static ShipsInfo shipsInfo;
    private Map<ShipType, ShipInfo> shipInfoMap; 
    
    /**
     *  Creates the ShipInfo
     */
    private ShipsInfo() {
        ShipInfo XWingInfo = new ShipInfo();
        XWingInfo.setname("Xwing")
                .setPrice(1000000)
                .setAttack(200)
                .setCargoSpace(200)
                .setSpeed(1000)
                .setMaxHealth(800)
                .setDescription("Xwing")
                .setSlotsAvailable(3);
        ShipInfo LunarWhaleInfo = new ShipInfo();
        LunarWhaleInfo.setname("LunarWhale")
                .setPrice(500000)
                .setAttack(150)
                .setCargoSpace(165)
                .setSpeed(700)
                .setMaxHealth(700)
                .setDescription("LunarWhale")
                .setSlotsAvailable(2);
        ShipInfo USGIshimuraInfo = new ShipInfo();
        USGIshimuraInfo.setname("USGIshimura")
                .setPrice(200000)
                .setAttack(110)
                .setCargoSpace(130)
                .setSpeed(600)
                .setMaxHealth(600)
                .setDescription("USGIshimura")
                .setSlotsAvailable(2);
        ShipInfo SamusInfo = new ShipInfo();
        SamusInfo.setname("Samus")
                .setPrice(100000)
                .setAttack(75)
                .setCargoSpace(100)
                .setSpeed(500)
                .setMaxHealth(500)
                .setDescription("Samus")
                .setSlotsAvailable(1);
        ShipInfo ArwingInfo = new ShipInfo();
        ArwingInfo.setname("Arwing")
                .setPrice(50000)
                .setAttack(50)
                .setCargoSpace(75)
                .setSpeed(400)
                .setMaxHealth(400)
                .setDescription("Arwing")
                .setSlotsAvailable(1);
        ShipInfo ProtossInfo = new ShipInfo();
        ProtossInfo.setname("Protoss")
                .setPrice(35000)
                .setAttack(30)
                .setCargoSpace(50)
                .setSpeed(300)
                .setMaxHealth(300)
                .setDescription("If the Viper talks, the Protoss shouts. Boasting\n"
                        + " a reasonable price tag for superiority in every category,\n"
                        + " this ship is a clear choice for those who want to take\n"
                        + " their trading game to the next level.")
                .setSlotsAvailable(1);
        ShipInfo VicViperInfo = new ShipInfo();
        VicViperInfo.setname("VicViper")
                .setPrice(20000)
                .setAttack(20)
                .setCargoSpace(40)
                .setSpeed(200)
                .setMaxHealth(200)
                .setDescription("Built to be as fast as it looks, the VicViper\n"
                        + "is the very essence of being slick.")
                .setSlotsAvailable(0);
        ShipInfo NormandyInfo = new ShipInfo();
        NormandyInfo.setname("Normandy")
                .setPrice(10000)
                .setAttack(10)
                .setCargoSpace(30)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("A hardy ship that is the workhorse of the small\n"
                        + "trader, many trading empires have been built on the decks\n"
                        + " on these reliable vessels.")
                .setSlotsAvailable(0);
        
       shipInfoMap = new EnumMap<>(ShipType.class);
       shipInfoMap.put(ShipType.XWing, XWingInfo);
       shipInfoMap.put(ShipType.LunarWhale, LunarWhaleInfo);
       shipInfoMap.put(ShipType.USGIshimura, XWingInfo);
       shipInfoMap.put(ShipType.Samus, SamusInfo);
       shipInfoMap.put(ShipType.Arwing, ArwingInfo);
       shipInfoMap.put(ShipType.Protoss, ProtossInfo);
       shipInfoMap.put(ShipType.VicViper, VicViperInfo);
       shipInfoMap.put(ShipType.Normandy, NormandyInfo);
       
    }
    
    /**
     * Returns an instance of the singleton
     * @return ShipsInfo instance
     */
    public static ShipsInfo getInstance() {
        if (shipsInfo == null) {
            shipsInfo = new ShipsInfo();
        }
        return shipsInfo;
    }
    
    /**
     * Returns the cargo space of ship with type type.
     * @param type The ship's type
     * @return Cargo space
     */
     public int getCargoSpace(ShipType type) {
        return shipInfoMap.get(type).cargoSpace;
    }
     
    /**
    * Returns the name of ship with type type.
    * @param type The ship's type
    * @return Ship's name
    */
    public String getName(ShipType type) {
        return shipInfoMap.get(type).name;
    }
    
    /**
    * Returns the price of ship with type type.
    * @param type The ship's type
    * @return Ship's price
    */
    public int getPrice(ShipType type) {
        return shipInfoMap.get(type).price;
    }
    
    /**
    * Returns the speed of ship with type type.
    * @param type The ship's type
    * @return Ship's speed
    */
    public int getSpeed(ShipType type) {
        return shipInfoMap.get(type).speed;
    }
    
    /**
    * Returns the attack of ship with type type.
    * @param type The ship's type
    * @return Ship's attack
    */
    public int getAttack(ShipType type) {
        return shipInfoMap.get(type).attack;
    }
    
    /**
    * Returns the max health of ship with type type.
    * @param type The ship's type
    * @return Ship's max health
    */
     public int getMaxHealth(ShipType type) {
        return shipInfoMap.get(type).maxHealth;
    }
     
     /**
    * Returns the description of ship with type type.
    * @param type The ship's type
    * @return Ship's description
    */
      public String getDescription(ShipType type) {
        return shipInfoMap.get(type).description;
    }
      
      /**
    * Returns the number of available gadget slots of ship with type type.
    * @param type The ship's type
    * @return Number of available gadget slots
    */
    public int getSlotsAvailable(ShipType type) {
        return shipInfoMap.get(type).slotsAvailable;
    }
    
    /**
    * Returns a string that fully describes the ship. The string is used in the
    * description text area for shipyard.
    * @param type The ship's type
    * @return Ship's information
    */
    public String getInformationAsText(ShipType type) {
        StringBuilder info = new StringBuilder();
        info.append("Name: " + getName(type) + " (" + getPrice(type) + ")\n");
        info.append(getDescription(type) + "\n\n");
        info.append("Details\n");
        info.append("-------------------------------------\n");
        info.append("Health: " + getMaxHealth(type) + "\n");
        info.append("Attack: " + getAttack(type) + "\n");
        info.append("Speed: " + getSpeed(type) + "\n");
        info.append("Maximum Cargo Space: " + getCargoSpace(type) + "\n");
        info.append("Gadget slots: " + getSlotsAvailable(type) + "\n");

        return info.toString();
      }
    /**
     * ShipInfo holds the information for one ship
     */
      private class ShipInfo {
        private int cargoSpace;
        private String name;
        private int price;
        private int speed;
        private int attack;
        private int maxHealth; 
        private String description; 
        private int slotsAvailable;
        
        /**
         * Set the cargo space
         * @param cargoSpace
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setCargoSpace(int cargoSpace) {
            this.cargoSpace = cargoSpace; 
            return this; 
        }
        
        /**
         * Set the name
         * @param name
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setname(String name) {
            this.name = name; 
            return this; 
        }
        
        /**
         * Set the price
         * @param price
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setPrice(int price) {
            this.price = price; 
            return this; 
        }
        
        /**
         * Set the speed
         * @param speed
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setSpeed(int speed) {
            this.speed = speed; 
            return this; 
        }
        
        /**
         * Set the attack
         * @param attack
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setAttack(int attack) {
            this.attack = attack; 
            return this; 
        }
        
        /**
         * Set the max health
         * @param maxHealth
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth; 
            return this; 
        }
        
        /**
         * Set the description
         * @param description
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setDescription(String description) {
            this.description = description; 
            return this; 
        }
        
        /**
         * Set the number of available slots
         * @param slotsAvailable Number of available slots
         * @return ShipInfo This class to allow method chaining
         *   (Builder pattern)
         */
        public ShipInfo setSlotsAvailable(int slotsAvailable) {
            this.slotsAvailable = slotsAvailable;
            return this;
        }
   }
}
