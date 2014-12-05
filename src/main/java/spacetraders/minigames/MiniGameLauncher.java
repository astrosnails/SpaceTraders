/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.minigames;

import java.io.IOException;
import java.util.Random;
import spacetraders.Abstract.TravelListener;
import spacetraders.MainApplication;
import spacetraders.model.Planet;
import spacetraders.model.Player;

/**
 *
 * @author Cathy
 */
public class MiniGameLauncher implements TravelListener {

    //private NewController newController;
    private MainApplication application;
    private Random random;
    
    public MiniGameLauncher(MainApplication application) {
        this.application = application;
        random = new Random();
    }
    
    public void exitMinigame(int money) throws IOException {
        application.getPlayer().increaseMoney(money);
        application.goToDashboard();
    }
    
    @Override
    public void onTravel(Planet destination) {
        int r = random.nextInt(100);
        if (r >= 0 && r < 20) {
            application.setScene(new PoopController(this).getScene());
        } else if (r >= 20 && r < 40) {
            application.setScene(new PongController(this).getScene());
        } else if (r >= 40 && r < 60) {
            application.setScene(new QuizController(this).getScene());
        } else if (r >= 60 && r < 80) {
            application.setScene(new ShootingGameController(this).getScene());
        } else if (r >= 80 && r < 100) {
            application.setScene(new TransitionController(this).getScene());
        }
    }
    
}
