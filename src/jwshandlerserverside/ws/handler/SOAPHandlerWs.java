/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwshandlerserverside.ws.handler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


/**
 *
 * @author Federico Coraglio
 */
public class SOAPHandlerWs implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set getHeaders() {
        Set headers = new HashSet();
        headers.add("Testing");
        System.out.println("Devolviendo headers");
        return headers;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        try {
            final Boolean outboundProperty = (Boolean)
                    messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if(outboundProperty.booleanValue()) {
                System.out.println("Oubound Message: ");
            } else {                        
                System.out.println("Inbound message: ");
            }
            
            System.out.println("Response : " + messageContext.getMessage().getSOAPBody().getTextContent());
        } catch (SOAPException ex) {
            Logger.getLogger(SOAPHandlerWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("SOAPHandler. IS output " + messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY));
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        try {
            System.out.println(context.getMessage().toString());
            
            //Opción 1: pisar el message cuando se produce un error.
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage soapMsg = factory.createMessage();
            SOAPPart part = soapMsg.getSOAPPart();
            
            SOAPEnvelope envelope = part.getEnvelope();
            SOAPHeader header = envelope.getHeader();
            SOAPBody body = envelope.getBody();
            
            header.addTextNode("Error");
            
            body.addTextNode("Error al procesar informacion del servicio");
            
            context.setMessage(soapMsg);
            
            //Opción 2: Anexar informacion a la respuesta.
            /**SOAPMessage soapMessage =  context.getMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPHeader soapHeader = soapEnvelope.getHeader(); 
            soapBody.addTextNode("Error al procesar informacion del servicio");**/
            
        } catch (SOAPException ex) {
            Logger.getLogger(SOAPHandlerWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {
        
    }

    
}
