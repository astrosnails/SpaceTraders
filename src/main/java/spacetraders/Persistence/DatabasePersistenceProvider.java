/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Persistence;

import java.io.BufferedOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import spacetraders.Abstract.PersistenceProvider;
import spacetraders.MainApplication;

/**
 *
 * @author saleh
 */
public class DatabasePersistenceProvider implements PersistenceProvider {

    @Override
    public void saveGame(MainApplication application) throws Exception {
        HttpURLConnection conn = (HttpURLConnection)
            new URL("http://hamadeh.me/save")
                .openConnection();
        
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        
        OutputStream buffer = conn.getOutputStream();
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(application.getUniverse());
        output.writeObject(application.getPlayer());
        
        int status = conn.getResponseCode();
        if (status != 200) {
            throw new Exception("Cannot save game.");
        }
    }

    @Override
    public void loadGame(MainApplication application) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
