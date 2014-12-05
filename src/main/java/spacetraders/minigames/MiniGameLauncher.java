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

    private PoopController poopController;
    private PongController pongController;
    private ShootingGameController shootingGameController;
    //private NewController newController;
    private MainApplication application;
    private Player player;
    
    public MiniGameLauncher(MainApplication application) {
        poopController = new PoopController(this);
        pongController = new PongController(this);
        shootingGameController = new ShootingGameController(this);
        this.application = application;
        this.player = application.getPlayer();
    }
    
    public void exitMinigame(int money) throws IOException {
        application.getPlayer().increaseMoney(money);
        application.goToDashboard();
    }
    
    @Override
    public void onTravel(Planet destination) {
        Random rand = new Random();
        int randomNumber;
        int traderSkill = this.player.getTraderSkill();
        int engineerSkill = this.player.getEngineerSkill();
        int fighterSkill = this.player.getFighterSkill();
        int pilotSkill = this.player.getPilotSkill();
        //integrating skill points!
        int compare = Math.max(traderSkill, engineerSkill);
        compare = Math.max(compare, fighterSkill);
        compare = Math.max(compare, pilotSkill);
        //setting the chances of a game based on skill points
        if(compare == traderSkill) {
            randomNumber = rand.nextInt(10) + 1;
            //50 percent chance of having a pong game for trader skill
            if(randomNumber <= 4) {
                application.setScene(pongController.getScene());
            }
            else {
                if(randomNumber <= 7 && randomNumber > 4) {
                    application.setScene(shootingGameController.getScene());
                }
                else {
                    application.setScene(poopController.getScene());
                }
            }
        }
        else if(compare == engineerSkill) {
            
        }
        else if(compare == fighterSkill) {
            randomNumber = rand.nextInt(10) + 1;
            if(randomNumber <= 4) {
                application.setScene(shootingGameController.getScene());
            }
            else {
                if(randomNumber <= 7 && randomNumber > 4) {
                    application.setScene(pongController.getScene());
                }
                else {
                    application.setScene(poopController.getScene());
                }
            }
        }
        
        else if(compare== pilotSkill){
            randomNumber = rand.nextInt(10) + 1;
            if(randomNumber <= 4) {
                application.setScene(poopController.getScene());
            }
            else {
                if(randomNumber <= 7 && randomNumber > 4) {
                    application.setScene(pongController.getScene());
                }
                else {
                    application.setScene(shootingGameController.getScene());
                }
            }
        }
    }
    
}
