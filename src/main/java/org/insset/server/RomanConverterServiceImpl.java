/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
       int minIn = 1;
       int maxIn = 2000;
       
       if(nbr !=null)
       {
           if(nbr >=minIn && nbr <=maxIn)
           {
               
           }
           else
           {
               new IllegalArgumentException("valeur incorrect");
           }
       }
       else
       {
            new IllegalArgumentException("valeur incorrect");
       }
       return "ok";
    }

}
