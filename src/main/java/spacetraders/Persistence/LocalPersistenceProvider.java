/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import spacetraders.Abstract.PersistenceProvider;
import spacetraders.MainApplication;
import spacetraders.model.Player;
import spacetraders.model.Universe;

/**
 *
 * @author saleh
 */
public class LocalPersistenceProvider implements PersistenceProvider {

    @Override
    public void saveGame(MainApplication application) throws IOException {
        OutputStream file = new FileOutputStream("game.data");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(application.getUniverse());
        output.writeObject(application.getPlayer());

        output.close();
    }

    @Override
    public void loadGame(MainApplication application) throws IOException,
            ClassNotFoundException {
        InputStream file = new FileInputStream("game.data");
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        application.setUniverse((Universe) input.readObject());
        application.setPlayer((Player) input.readObject());

        //Set singleton instance to the loaded universe
        Universe.setInstance(application.getUniverse());
    }
    
}
