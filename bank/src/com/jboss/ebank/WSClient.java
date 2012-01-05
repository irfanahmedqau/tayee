package com.jboss.ebank;

import javax.xml.rpc.Call;
import javax.xml.rpc.Service;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.ParameterMode;

import javax.xml.namespace.QName;
import java.util.ArrayList;

import java.net.URL;

import java.io.*;
import org.jboss.ws.jaxrpc.ServiceFactoryImpl;
import org.jboss.ws.jaxrpc.ServiceImpl;

public class WSClient {
    public static void main(String[] args) 
        throws Exception 
    {
        URL url = 
            new URL("http://localhost:8080/bankws-ejb/TellerBean?wsdl");


        QName qname = new QName("http://ebank.jboss.com/teller",
                                "TellerService");

        File mapping = new File("dd/ws/jaxrpc-mapping.xml");
        //ServiceFactory factory = ServiceFactory.newInstance();
        ServiceFactoryImpl factory = new ServiceFactoryImpl();
        Service        service = factory.createService(url, qname, mapping.toURL());

        TellerEndpoint endpoint = (TellerEndpoint)
            service.getPort(TellerEndpoint.class);

        String customer = "200";
        System.out.println("Customer: " + customer);
        
        AccountList accounts = endpoint.getAccountsOfCustomer(customer);
        String[]    ids      = accounts.getAccounts();
        for (int i=0; i<ids.length; i++) {
            System.out.println("account[" + ids[i] +  "]  " + 
                               endpoint.getAccountBalance(ids[i]));
        }
    }

}
