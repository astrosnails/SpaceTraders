/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.minigames;

import java.io.IOException;
import spacetraders.Abstract.TravelListener;
import spacetraders.MainApplication;
import spacetraders.model.Planet;

/**
 *
 * @author Cathy
 */
public class MiniGameLauncher implements TravelListener {

    private PoopController poopController;
    private PongController pongController;
    private ShootingGameController shootingGameController;
    //private NewController newController;
    private MainApplication application;
    
    public MiniGameLauncher(MainApplication application) {
        poopController = new PoopController(this);
        pongController = new PongController(this);
        shootingGameController = new ShootingGameController(this);
        this.application = application;
    }
    
    public void exitMinigame(int money) throws IOException {
        application.getPlayer().increaseMoney(money);
        application.goToDashboard();
    }
    
    @Override
    public void onTravel(Planet destination) {
        //application.setScene(poopController.getScene());
        //application.setScene(pongController.getScene());
       application.setScene(shootingGameController.getScene());
    }
    
}
