/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import spacetraders.model.*;

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
    @FXML private Slider sellWaterSlider;
    @FXML private Label sellWaterUnits;
    @FXML private Label sellFoodUnits;
    @FXML private Slider sellOilSlider;
    @FXML private Label sellOilUnits;
    @FXML private Slider sellGoldSlider;
    @FXML private Label sellGoldUnits;
    @FXML private Slider sellCocaineSlider;
    @FXML private Label sellCocaineUnits;
    @FXML private Slider sellFoodSlider;
    @FXML private Label buyCocaineUnits;
    @FXML private Label waterInInventory;
    @FXML private Label foodInInventory;
    @FXML private Label oilInInventory;
    @FXML private Label goldInInventory;
    @FXML private Label cocaineInInventory;
    @FXML private TextField totalCostTextField;
    @FXML private TextField totalProfitTextField;
    
    SimpleIntegerProperty buyWaterAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyFoodAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyOilAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyGoldAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty buyCocaineAmount = new SimpleIntegerProperty();
    
    SimpleIntegerProperty sellWaterAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellFoodAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellOilAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellGoldAmount = new SimpleIntegerProperty();
    SimpleIntegerProperty sellCocaineAmount = new SimpleIntegerProperty();
    
    @FXML
    private void onBackButtonClicked(ActionEvent event) throws IOException {
        application.goToDashboard();
    }
    
    private void updatePrices() {
        Planet planet = application.getPlayer().getLocation();
        waterUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.WATER));
        foodUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.FOOD));
        oilUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.OIL));
        goldUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.GOLD));
        cocaineUnitPrice = new SimpleIntegerProperty(planet.getResourcePrice(ResourceType.COCAINE));
        
        waterPriceLabel.textProperty().bind(waterUnitPrice.asString());
        foodPriceLabel.textProperty().bind(foodUnitPrice.asString());
        oilPriceLabel.textProperty().bind(oilUnitPrice.asString());
        goldPriceLabel.textProperty().bind(goldUnitPrice.asString());
        cocainePriceLabel.textProperty().bind(cocaineUnitPrice.asString());
        
        totalCost = Bindings.add(Bindings.multiply(waterUnitPrice, buyWaterAmount),
                Bindings.add(Bindings.multiply(foodUnitPrice, buyFoodAmount), 
                Bindings.add(Bindings.multiply(oilUnitPrice, buyOilAmount),
                Bindings.add(Bindings.multiply(goldUnitPrice, buyGoldAmount),
                Bindings.multiply(cocaineUnitPrice, buyCocaineAmount)))));
        totalProfit = Bindings.add(Bindings.multiply(waterUnitPrice, sellWaterAmount),
                Bindings.add(Bindings.multiply(foodUnitPrice, sellFoodAmount), 
                Bindings.add(Bindings.multiply(oilUnitPrice, sellOilAmount),
                Bindings.add(Bindings.multiply(goldUnitPrice, sellGoldAmount),
                Bindings.multiply(cocaineUnitPrice, sellCocaineAmount)))));
        totalCostTextField.textProperty().bind(totalCost.asString());
        totalProfitTextField.textProperty().bind(totalProfit.asString());
    }
    
    public void updateInventory() {
        Player player = application.getPlayer();
        Resources cargoResources = player.getShip().getCargo().getResources();
        foodInInventory.setText(Integer.toString(cargoResources.getResourceAmount(ResourceType.FOOD)));
        waterInInventory.setText(Integer.toString(cargoResources.getResourceAmount(ResourceType.WATER)));
        oilInInventory.setText(Integer.toString(cargoResources.getResourceAmount(ResourceType.OIL)));
        goldInInventory.setText(Integer.toString(cargoResources.getResourceAmount(ResourceType.GOLD)));
        cocaineInInventory.setText(Integer.toString(cargoResources.getResourceAmount(ResourceType.COCAINE)));
        
        currentMoney.setText(Integer.toString(player.getMoney().intValue()));
    }
    

            
            /*int min = Math.min((int)application.getPlayer().getShip().getCargo().getSpace(), (int)application.getPlayer().getMoney());
            buyGoldSlider.setMax(min);
            buyWaterSlider.setMax(min);
            buyFoodSlider.setMax(min);
            buyCocaineSlider.setMax(min);
            buyOilSlider.setMax(min);
            
            //SET MAX BASED ON AMOUNT OF RESOURCE LEFT IN RESOURCE CLASS
            sellGoldSlider.setMax((int)resources.getResourceAmount(Gold));
            sellCocaineSlider.setMax((int)resources.getResourceAmount(Cocaine)));
            sellWaterSlider.setMax((int)resources.getResourceAmount(Water));
            sellOilSlider.setMax((int)resources.getResourceAmount(Oil));
            sellFoodSlider.setMax((int)resources.getResourceAmount(Food));
            
            label.setText(String.format("%.0f", newValue));*/

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
    }
}