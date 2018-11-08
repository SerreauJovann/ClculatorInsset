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

    String ACTION = "valeur incorrect";
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
        
        if(nbr !=null)
        {
            if(nbr >=minIn && nbr <=maxIn)
            {
                String result = "";
                 while (nbr >= M) {
                     result += "M";
                     nbr = this.removeValue(nbr, M);
                 }
                while (nbr >= CM) {
                    result += "CM";
                    nbr = this.removeValue(nbr, CM);
                }
                while (nbr >= 500) {
                    result += "D";
                    nbr = this.removeValue(nbr, 500);
                }
                while (nbr >= 400) {
                    result += "CD";
                    nbr = this.removeValue(nbr, 400);
                }
                while (nbr >= 100) {
                    result += "C";
                    nbr = this.removeValue(nbr, 100);
                }
                while (nbr >= 90) {
                    result += "XC";
                    nbr = this.removeValue(nbr, 90);
                }
                while (nbr >= 50) {
                    result += "L";
                    nbr = this.removeValue(nbr, 50);
                }
                while (nbr >= 40) {
                    result += "XL";
                    nbr = this.removeValue(nbr, 40);
                }
                while (nbr >= 10) {
                    result += "X";
                    nbr = this.removeValue(nbr, 10);
                }
                while (nbr >= 9) {
                    result += "IX";
                    nbr = this.removeValue(nbr, 9);
                }
                while (nbr >= 5) {
                    result += "V";
                    nbr = this.removeValue(nbr, 5);
                }
                while (nbr >= 4) {
                    result += "IV";
                    nbr = this.removeValue(nbr, 4);
                }
                while (nbr >= 1) {
                    result += "I";
                    nbr = this.removeValue(nbr, 1);
                }    
                return result;
            }
            else
            {
                throw new IllegalArgumentException(this.ACTION);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.ACTION);
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
                throw new IllegalArgumentException(this.ACTION);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.ACTION);
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
                throw new IllegalArgumentException(this.ACTION);
            }
        }
        else
        {
            throw new IllegalArgumentException(this.ACTION);
        }
    }
}
