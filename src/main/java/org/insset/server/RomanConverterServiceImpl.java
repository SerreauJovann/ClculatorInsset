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
                String result = "";
                 while (nbr >= 1000) {
                     result += "M";
                     nbr -= 1000;
                 }
                while (nbr >= 900) {
                    result += "CM";
                    nbr -= 900;
                }
                while (nbr >= 500) {
                    result += "D";
                    nbr -= 500;
                }
                while (nbr >= 400) {
                    result += "CD";
                    nbr -= 400;
                }
                while (nbr >= 100) {
                    result += "C";
                    nbr -= 100;
                }
                while (nbr >= 90) {
                    result += "XC";
                    nbr -= 90;
                }
                while (nbr >= 50) {
                    result += "L";
                    nbr -= 50;
                }
                while (nbr >= 40) {
                    result += "XL";
                    nbr -= 40;
                }
                while (nbr >= 10) {
                    result += "X";
                    nbr -= 10;
                }
                while (nbr >= 9) {
                    result += "IX";
                    nbr -= 9;
                }
                while (nbr >= 5) {
                    result += "V";
                    nbr -= 5;
                }
                while (nbr >= 4) {
                    result += "IV";
                    nbr -= 4;
                }
                while (nbr >= 1) {
                    result += "I";
                    nbr -= 1;
                }    
                return result;
            }
            else
            {
                throw new IllegalArgumentException("valeur incorrect");
            }
        }
        else
        {
            throw new IllegalArgumentException("valeur incorrect");
        }
    }

}
