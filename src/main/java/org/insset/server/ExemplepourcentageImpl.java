package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.ExemplePourcentage;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ExemplepourcentageImpl extends RemoteServiceServlet implements
        ExemplePourcentage {


    public String inverserChaine2(String input, String input2) throws IllegalArgumentException {
        int longueurPrix = input.length();
        int longueurRemise = input2.length();
        
        int i;

        for (i = 0; i < longueurPrix; i++) {
            
        }
        return input;
    }
    

}
