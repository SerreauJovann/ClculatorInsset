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

    /**
     *
     * @param nbr
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException{
        int minIn = 1;
        int maxIn = 2000;
       
        String result = "";
        int temp = 0;
        
        if(nbr !=null)
        {
            if(nbr >=minIn && nbr <=maxIn)
            {
                temp = nbr;
                 while (temp >= 1000) {
                     result += "M";
                     temp = this.removeValue(temp, 1000);
                 }
                while (temp >= 900) {
                    result += "CM";
                    temp = this.removeValue(temp, 900);
                }
                while (temp >= 500) {
                    result += "D";
                    temp = this.removeValue(temp, 500);
                }
                while (temp >= 400) {
                    result += "CD";
                    temp = this.removeValue(temp, 400);
                }
                while (temp >= 100) {
                    result += "C";
                    temp = this.removeValue(temp, 100);
                }
                while (temp >= 90) {
                    result += "XC";
                    temp = this.removeValue(temp, 90);
                }
                while (temp >= 50) {
                    result += "L";
                    temp = this.removeValue(temp, 50);
                }
                while (temp >= 40) {
                    result += "XL";
                    temp = this.removeValue(temp, 40);
                }
                while (temp >= 10) {
                    result += "X";
                    temp = this.removeValue(temp, 10);
                }
                while (temp >= 9) {
                    result += "IX";
                    temp = this.removeValue(temp, 9);
                }
                while (temp >= 5) {
                    result += "V";
                    temp = this.removeValue(temp, 5);
                }
                while (temp >= 4) {
                    result += "IV";
                    temp = this.removeValue(temp, 4);
                }
                while (temp >= 1) {
                    result += "I";
                    temp = this.removeValue(temp, 1);
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
    
    /**
     *
     * @param nbr
     * @param modif
     * @return
     * @throws IllegalArgumentException
     */
    public int addValue(Integer nbr,Integer modif) throws IllegalArgumentException
    {
         if(nbr != null && modif != null)
        {
            if(nbr > 0 && modif >0)
            {
                return nbr+modif;
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
    
    /**
     *
     * @param nbr
     * @param modif
     * @return
     * @throws IllegalArgumentException
     */
    public int removeValue(Integer nbr,Integer modif) throws IllegalArgumentException
    { 
        if(nbr != null && modif != null)
        {
            if(nbr > 0 && modif >0)
            {
                return nbr-modif;
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
