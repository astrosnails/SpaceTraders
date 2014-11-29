/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Persistence;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import spacetraders.Abstract.PersistenceProvider;
import spacetraders.MainApplication;
import spacetraders.model.Player;
import spacetraders.model.Universe;

/**
 *
 * @author saleh
 */
public class DatabasePersistenceProvider implements PersistenceProvider {

    @Override
    public void saveGame(MainApplication application) throws Exception {
        HttpURLConnection conn = (HttpURLConnection)
            new URL("http://hamadeh.me:4711/save")
                .openConnection();
        
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        
        OutputStream buffer = conn.getOutputStream();
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(application.getUniverse());
        output.writeObject(application.getPlayer());
        output.close();
        
        int status = conn.getResponseCode();
        if (status != 200) {
            throw new Exception("Cannot save game.");
        }
    }

    @Override
    public void loadGame(MainApplication application) throws Exception {
        HttpURLConnection conn = (HttpURLConnection)
            new URL("http://hamadeh.me:4711/load")
                .openConnection();
        
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        
        InputStream file = conn.getInputStream();
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        application.setUniverse((Universe) input.readObject());
        application.setPlayer((Player) input.readObject());

        //Set singleton instance to the loaded universe
        Universe.setInstance(application.getUniverse());
    }
    
}
