/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwshandlerserverside;

import javax.xml.ws.Endpoint;
import jwshandlerserverside.ws.WebServiceExampleImpl;

/**
 *
 * @author Federico Coraglio
 */
public class JwsHandlerServerSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Endpoint.publish("http://localhost:8989/ws/webService", new WebServiceExampleImpl());
    }
    
}
