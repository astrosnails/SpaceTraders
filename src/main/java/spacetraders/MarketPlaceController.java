/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import spacetraders.model.Cargo;
import spacetraders.model.Planet;
import spacetraders.model.Player;
import spacetraders.model.ResourceType;
import spacetraders.model.Resources;

/**
 * FXML Controller class
 *
 * @author saleh
 *@version 1.0
 */
public class MarketPlaceController extends Controller {
    @FXML private Label waterPriceLabel;
    private SimpleIntegerProperty waterUnitPrice;
    @FXML private Label foodPriceLabel;
    private SimpleIntegerProperty foodUnitPrice;
    @FXML private Label oilPriceLabel;
    private SimpleIntegerProperty oilUnitPrice;
    @FXML private Label goldPriceLabel;
    private SimpleIntegerProperty goldUnitPrice;
    @FXML private Label cocainePriceLabel;
    private SimpleIntegerProperty cocaineUnitPrice;
    @FXML private Label fuelPriceLabel;
    private SimpleIntegerProperty fuelUnitPrice;

    private NumberBinding totalCost;
    private NumberBinding totalProfit;
    @FXML private Label currentMoney;

    @FXML private Slider buyWaterSlider;
    @FXML private Label buyWaterUnits;
    @FXML private Slider buyFoodSlider;
    @FXML private Label buyFoodUnits;
    @FXML private Slider buyOilSlider;
    @FXML private Label buyOilUnits;
    @FXML private Slider buyGoldSlider;
    @FXML private Label buyGoldUnits;
    @FXML private Slider buyCocaineSlider;
    @FXML private Label buyCocaineUnits;
    @FXML private Slider buyFuelSlider;
    @FXML private Label buyFuelUnits;

    @FXML private Slider sellWaterSlider;
    @FXML private Label sellWaterUnits;
    @FXML private Slider sellFoodSlider;
    @FXML private Label sellFoodUnits;
    @FXML private Slider sellOilSlider;
    @FXML private Label sellOilUnits;
    @FXML private Slider sellGoldSlider;
    @FXML private Label sellGoldUnits;
    @FXML private Slider sellCocaineSlider;
    @FXML private Label sellCocaineUnits;
    @FXML private Slider sellFuelSlider;
    @FXML private Label sellFuelUnits;

    @FXML private Label waterInInventory;
    @FXML private Label foodInInventory;
    @FXML private Label oilInInventory;
    @FXML private Label goldInInventory;
    @FXML private Label cocaineInInventory;
    @FXML private Label fuelInInventory;

    @FXML private TextField totalCostTextField;
    @FXML private TextField totalProfitTextField;

    SimpleIntegerProperty buyWaterAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyFoodAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyOilAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyGoldAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyCocaineAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyFuelAmount = new SimpleIntegerProperty();
    
    SimpleIntegerProperty sellWaterAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellFoodAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellOilAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellGoldAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellCocaineAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellFuelAmount = new SimpleIntegerProperty();
    /**
    * The button click listener
    * @param ActionEvent event
    */
    @FXML
    private void onBackButtonClicked(ActionEvent event) throws IOException {
        application.goToDashboard();
    }

    /**
    * The buy button listener
    * @param ActionEvent event
    * @return none
    */
    @FXML
    private void onBuyButtonClicked(ActionEvent event) {
        Player player = application.getPlayer();
        Cargo cargo = player.getShip().getCargo();
        int money = player.getMoney().intValue();
        int cost = totalCost.intValue();
        
        if (money >= cost) {
            int waterUnits = buyWaterAmount.intValue();
            int foodUnits = buyFoodAmount.intValue();
            int oilUnits = buyOilAmount.intValue();
            int goldUnits = buyGoldAmount.intValue();
            int cocaineUnits = buyCocaineAmount.intValue();
            int fuelUnits = buyFuelAmount.intValue();
            int totalUnits = waterUnits + foodUnits + oilUnits + goldUnits + cocaineUnits;
            
            if (totalUnits <= cargo.calculateEmptySpace()) {
                Resources resources = cargo.getResources();
                resources.addResource(ResourceType.WATER, waterUnits);
                resources.addResource(ResourceType.FOOD, foodUnits);
                resources.addResource(ResourceType.OIL, oilUnits);
                resources.addResource(ResourceType.GOLD, goldUnits);
                resources.addResource(ResourceType.COCAINE, cocaineUnits);
                resources.addResource(ResourceType.FUEL, fuelUnits);
                
                player.setMoney(money - cost);
            } else {
                AlertDialog.showAlert("No space in cargo");
            }
        } else {
            AlertDialog.showAlert("No money, No resources!");
        }
    }
    
    /**
    * The sell button click listener
    * @param ActionEvent event
    * @return none
    */
    @FXML
    private void onSellButtonClicked(ActionEvent event) {
        Player player = application.getPlayer();
        Resources resources = player.getShip().getCargo().getResources();
        int money = player.getMoney().intValue();
        int profit = totalProfit.intValue();
        int waterUnits = sellWaterAmount.intValue();
        int foodUnits = sellFoodAmount.intValue();
        int oilUnits = sellOilAmount.intValue();
        int goldUnits = sellGoldAmount.intValue();
        int cocaineUnits = sellCocaineAmount.intValue();
         int fuelUnits = sellFuelAmount.intValue();
         
        if (waterUnits > resources.getResourceAmount(ResourceType.WATER) ||
                foodUnits > resources.getResourceAmount(ResourceType.FOOD) ||
                oilUnits > resources.getResourceAmount(ResourceType.OIL) ||
                goldUnits > resources.getResourceAmount(ResourceType.GOLD) ||
                cocaineUnits > resources.getResourceAmount(ResourceType.COCAINE) ||
                fuelUnits > resources.getResourceAmount(ResourceType.FUEL)) {
            AlertDialog.showAlert("No resources, no money");
        } else {
            resources.removeResource(ResourceType.WATER, waterUnits);
            resources.removeResource(ResourceType.FOOD, foodUnits);
            resources.removeResource(ResourceType.OIL, oilUnits);
            resources.removeResource(ResourceType.GOLD, goldUnits);
            resources.removeResource(ResourceType.COCAINE, cocaineUnits);
            resources.removeResource(ResourceType.FUEL, fuelUnits);
            
            player.setMoney(money + profit);
        }
    }
    
    /**
    * Updates the prices
    * @param none
    * @return none
    */
    private void updatePrices() {
        Planet planet = application.getPlayer().getLocation();
        waterUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.WATER));
        foodUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.FOOD));
        oilUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.OIL));
        goldUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.GOLD));
        cocaineUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.COCAINE));
        fuelUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.FUEL));
        
        waterPriceLabel.textProperty().bind(waterUnitPrice.asString());
        foodPriceLabel.textProperty().bind(foodUnitPrice.asString());
        oilPriceLabel.textProperty().bind(oilUnitPrice.asString());
        goldPriceLabel.textProperty().bind(goldUnitPrice.asString());
        cocainePriceLabel.textProperty().bind(cocaineUnitPrice.asString());
        fuelPriceLabel.textProperty().bind(fuelUnitPrice.asString());
        
        totalCost = Bindings.add(Bindings.multiply(waterUnitPrice, buyWaterAmount),
                Bindings.add(Bindings.multiply(foodUnitPrice, buyFoodAmount), 
                Bindings.add(Bindings.multiply(oilUnitPrice, buyOilAmount),
                Bindings.add(Bindings.multiply(goldUnitPrice, buyGoldAmount),
                Bindings.add(Bindings.multiply(fuelUnitPrice, buyFuelAmount),         
                Bindings.multiply(cocaineUnitPrice, buyCocaineAmount))))));
        
        totalProfit = Bindings.add(Bindings.multiply(waterUnitPrice, sellWaterAmount),
                Bindings.add(Bindings.multiply(foodUnitPrice, sellFoodAmount), 
                Bindings.add(Bindings.multiply(oilUnitPrice, sellOilAmount),
                Bindings.add(Bindings.multiply(goldUnitPrice, sellGoldAmount),
                Bindings.add(Bindings.multiply(fuelUnitPrice, sellFuelAmount),         
                Bindings.multiply(cocaineUnitPrice, sellCocaineAmount))))));
        totalCostTextField.textProperty().bind(totalCost.asString());
        totalProfitTextField.textProperty().bind(totalProfit.asString());
    }
    
    /**
    * Updates the inventory
    * @param none
    * @return none
    */
    public void updateInventory() {
        Player player = application.getPlayer();
        Resources cargoResources = player.getShip().getCargo().getResources();
        foodInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.FOOD).asString());
        waterInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.WATER).asString());
        oilInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.OIL).asString());
        goldInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.GOLD).asString());
        cocaineInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.COCAINE).asString());
         fuelInInventory.textProperty().bind(
                cargoResources.getResourceAmountProperty(ResourceType.FUEL).asString());
        currentMoney.textProperty().bind(player.getMoney().asString());
        
        /*sellGoldSlider.setMax(
        cargoResources.getResourceAmount(ResourceType.GOLD));
        sellCocaineSlider.setMax(
        cargoResources.getResourceAmount(ResourceType.COCAINE));
        sellWaterSlider.setMax(
        cargoResources.getResourceAmount(ResourceType.WATER));
        sellOilSlider.setMax(
        cargoResources.getResourceAmount(ResourceType.OIL));
        sellFoodSlider.setMax(
        cargoResources.getResourceAmount(ResourceType.FOOD));
        */
    }
    /*
    private void setBuySliderMax() {
        int emptySpace = application.getPlayer().getShip().getCargo().getSpace();
        int money = application.getPlayer().getMoney().getValue();
        Planet planet = application.getPlayer().getLocation();
                        
        buyGoldSlider.setMax(Math.min(emptySpace, money / 
        planet.getResourcePrice(ResourceType.GOLD)));
        buyWaterSlider.setMax(Math.min(emptySpace, money /
         planet.getResourcePrice(ResourceType.WATER)));
        buyFoodSlider.setMax(Math.min(emptySpace, money / 
        planet.getResourcePrice(ResourceType.FOOD)));
        buyCocaineSlider.setMax(Math.min(emptySpace, money / 
        planet.getResourcePrice(ResourceType.COCAINE)));
        buyOilSlider.setMax(Math.min(emptySpace, money / 
        planet.getResourcePrice(ResourceType.OIL)));     
    }
    */
    /**
    * Sets the main application
    * @param MainApplication application
    */
    @Override
    public void setMainApplication(MainApplication application) {
        this.application = application;
        updateInventory();
        updatePrices();
        buyWaterAmount.bind(buyWaterSlider.valueProperty());
        buyWaterUnits.textProperty().bind(buyWaterAmount.asString());
        buyFoodAmount.bind(buyFoodSlider.valueProperty());
        buyFoodUnits.textProperty().bind(buyFoodAmount.asString());
        buyOilAmount.bind(buyOilSlider.valueProperty());
        buyOilUnits.textProperty().bind(buyOilAmount.asString());
        buyGoldAmount.bind(buyGoldSlider.valueProperty());
        buyGoldUnits.textProperty().bind(buyGoldAmount.asString());
        buyCocaineAmount.bind(buyCocaineSlider.valueProperty());
        buyCocaineUnits.textProperty().bind(buyCocaineAmount.asString());
        buyFuelAmount.bind(buyFuelSlider.valueProperty());
        buyFuelUnits.textProperty().bind(buyFuelAmount.asString());
        sellWaterAmount.bind(sellWaterSlider.valueProperty());
        sellWaterUnits.textProperty().bind(sellWaterAmount.asString());
        sellFoodAmount.bind(sellFoodSlider.valueProperty());
        sellFoodUnits.textProperty().bind(sellFoodAmount.asString());
        sellOilAmount.bind(sellOilSlider.valueProperty());
        sellOilUnits.textProperty().bind(sellOilAmount.asString());
        sellGoldAmount.bind(sellGoldSlider.valueProperty());
        sellGoldUnits.textProperty().bind(sellGoldAmount.asString());
        sellCocaineAmount.bind(sellCocaineSlider.valueProperty());
        sellCocaineUnits.textProperty().bind(sellCocaineAmount.asString());
        sellFuelAmount.bind(sellFuelSlider.valueProperty());
        sellFuelUnits.textProperty().bind(sellFuelAmount.asString());
    }
}
