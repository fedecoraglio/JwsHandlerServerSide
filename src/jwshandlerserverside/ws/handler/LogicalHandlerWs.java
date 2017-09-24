/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwshandlerserverside.ws.handler;

import com.sun.xml.internal.ws.streaming.SourceReaderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Federico Coraglio
 */
public class LogicalHandlerWs implements LogicalHandler<LogicalMessageContext>{

    @Override
    public boolean handleMessage(LogicalMessageContext messageContext) {
        System.out.println("LogicalHanlder. IsOutput " + messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY));   
        return true;    
    }

    @Override
    public boolean handleFault(LogicalMessageContext context) {
            return true;
    }

    @Override
    public void close(MessageContext context) {
        
    }
    
}
