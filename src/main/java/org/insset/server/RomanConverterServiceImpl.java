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

    String MessageError = "valeur incorrect";
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
        final int minIn = 1;
        final int maxIn = 2000;
        
        final int M = 1000;
        final int CM = 900;
        String result = "";
        int temp = 0;
        if(nbr !=null)
        {
            if(nbr >=minIn && nbr <=maxIn)
            {
                temp = nbr;
                 while (nbr >= M) {
                     result += "M";
                     temp = this.removeValue(temp, M);
                 }
                while (nbr >= CM) {
                    result += "CM";
                    temp = this.removeValue(temp, CM);
                }
                while (nbr >= 500) {
                    result += "D";
                    temp = this.removeValue(temp, 500);
                }
                while (nbr >= 400) {
                    result += "CD";
                    temp = this.removeValue(temp, 400);
                }
                while (nbr >= 100) {
                    result += "C";
                    temp = this.removeValue(temp, 100);
                }
                while (nbr >= 90) {
                    result += "XC";
                    temp = this.removeValue(temp, 90);
                }
                while (nbr >= 50) {
                    result += "L";
                    temp = this.removeValue(temp, 50);
                }
                while (nbr >= 40) {
                    result += "XL";
                    temp = this.removeValue(temp, 40);
                }
                while (nbr >= 10) {
                    result += "X";
                    temp = this.removeValue(temp, 10);
                }
                while (nbr >= 9) {
                    result += "IX";
                    temp = this.removeValue(temp, 9);
                }
                while (nbr >= 5) {
                    result += "V";
                    temp = this.removeValue(temp, 5);
                }
                while (nbr >= 4) {
                    result += "IV";
                    temp = this.removeValue(temp, 4);
                }
                while (nbr >= 1) {
                    result += "I";
                    temp = this.removeValue(temp, 1);
                }    
                return result;
            }
            else
            {
                throw new IllegalArgumentException(this.MessageError);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.MessageError);
        }
    }
    
    public int addValue(Integer nbr,Integer modif)
    {
         if(nbr != null && modif != null)
        {
            if(nbr > 0 && modif >0)
            {
                return nbr+modif;
            }
            else
            {
                throw new IllegalArgumentException(this.MessageError);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.MessageError);
        }
    }
    
    public int removeValue(Integer nbr,Integer modif)
    { 
        if(nbr != null && modif != null)
        {
            if(nbr > 0 && modif >0)
            {
                return nbr-modif;
            }
            else
            {
                throw new IllegalArgumentException(this.MessageError);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.MessageError);
        }
    }
}
