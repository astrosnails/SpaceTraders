/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders;

import java.io.IOException;
import spacetraders.Abstract.TravelListener;
import spacetraders.model.Planet;

/**
 *
 * @author Cathy
 */
public class MiniGameLauncher implements TravelListener {

    private PoopController poopController;
    //private NewController newController;
    private MainApplication application;
    
    public MiniGameLauncher(MainApplication application) {
        poopController = new PoopController(this);
        
        this.application = application;
    }
    
    public void exitMinigame() throws IOException {
        application.goToDashboard();
    }
    
    @Override
    public void onTravel(Planet destination) {
        application.setScene(poopController.getScene());
    }
    
}
