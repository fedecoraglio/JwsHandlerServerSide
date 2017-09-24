/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwshandlerserverside.ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 *
 * @author Federico Coraglio
 */
@WebService(endpointInterface = "jwshandlerserverside.ws.WebServiceExample")
@HandlerChain(file="handler/handlers.xml")
public class WebServiceExampleImpl implements WebServiceExample {

    @Override
    public String printMensage(String name) {
        if("educationIt".equals(name)) {
            throw new RuntimeException("El nombre no es permitido");
        }
        return name + ".Bienvenido a nuestro Web Service";
    }
    
}
