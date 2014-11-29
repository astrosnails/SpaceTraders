/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Abstract;

import java.io.IOException;
import spacetraders.MainApplication;

/**
 *
 * @author saleh
 */
public interface PersistenceProvider {
    public void saveGame(MainApplication application) throws Exception;
    public void loadGame(MainApplication application) throws Exception;
}
