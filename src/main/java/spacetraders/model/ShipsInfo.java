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
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("Xwing");
        ShipInfo LunarWhaleInfo = new ShipInfo();
        LunarWhaleInfo.setname("LunarWhale")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("LunarWhale");
        ShipInfo USGIshimuraInfo = new ShipInfo();
        USGIshimuraInfo.setname("USGIshimura")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("USGIshimura");
        ShipInfo SamusInfo = new ShipInfo();
        SamusInfo.setname("Samus")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("Samus");
        ShipInfo ArwingInfo = new ShipInfo();
        ArwingInfo.setname("Arwing")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("Arwing");
        ShipInfo ProtossInfo = new ShipInfo();
        ProtossInfo.setname("Protoss")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("Protoss");
        ShipInfo VicViperInfo = new ShipInfo();
        VicViperInfo.setname("VicViper")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("VicViper");
        ShipInfo NormandyInfo = new ShipInfo();
        NormandyInfo.setname("Normandy")
                .setPrice(1000)
                .setAttack(100)
                .setCargoSpace(100)
                .setSpeed(100)
                .setMaxHealth(100)
                .setDescription("Normandy");
        
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
    
    public static ShipsInfo getInstance() {
        if (shipsInfo == null) {
            shipsInfo = new ShipsInfo();
        }
        return shipsInfo;
    }
     public int getCargoSpace(ShipType type) {
        return shipInfoMap.get(type).cargoSpace;
    }
    public String getName(ShipType type) {
        return shipInfoMap.get(type).name;
    }
    public int getPrice(ShipType type) {
        return shipInfoMap.get(type).price;
    }
    public int getSpeed(ShipType type) {
        return shipInfoMap.get(type).speed;
    }
    public int getAttack(ShipType type) {
        return shipInfoMap.get(type).attack;
    }
     public int getMaxHealth(ShipType type) {
        return shipInfoMap.get(type).maxHealth;
    }
      public String getDescription(ShipType type) {
        return shipInfoMap.get(type).description;
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
          
       public ShipInfo setCargoSpace(int cargoSpace) {
          this.cargoSpace = cargoSpace; 
          return this; 
      }
      public ShipInfo setname(String name) {
          this.name = name; 
          return this; 
      }
      public ShipInfo setPrice(int price) {
          this.price = price; 
          return this; 
      }
      public ShipInfo setSpeed(int speed) {
          this.speed = speed; 
          return this; 
      }
      public ShipInfo setAttack(int attack) {
          this.attack = attack; 
          return this; 
      }
      public ShipInfo setMaxHealth(int maxHealth) {
          this.maxHealth = maxHealth; 
          return this; 
      }
      public ShipInfo setDescription(String description) {
          this.description = description; 
          return this; 
      }
   }
}
