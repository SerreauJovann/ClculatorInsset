/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RemiseService;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author talend
 */
public class RemiseServiceImpl extends RemoteServiceServlet implements
        RemiseService{

    @Override
    public String remisePrice(Float price, Float remise) throws IllegalArgumentException {
        if(price != null && remise !=null)
        {
            float max = 999999;
            float min = 1;
            float maxPer = 100;
            float minPer = 0;
            if(price >=min && price <=max)
            {
                if(remise >= minPer && remise <= maxPer)
                {
                      final float prixRemiser = price - (price * remise / 100);
                      final float remiseF = price-prixRemiser;
                      return "Prix final: "+prixRemiser+", Remise: "+remiseF;
                }
                else
                {
                    throw new IllegalArgumentException("Entrée non valide: Remise");
                }
            }
            else
            {
                throw new IllegalArgumentException("Entrée non valide: Montant");
            }
        }
        else
        {
            throw new IllegalArgumentException("Entrée non valide: Montant, Entrée non valide: Pourcentage");
        }
    }

    public String invertRemise(Float price, Float remise) throws IllegalArgumentException {
        if(price != null && remise !=null)
        {
            float max = 999999;
            float min = 1;
            float maxPer = 100;
            float minPer = 0;
             if(price >=min && price <=max)
            {
                if(remise >= minPer && remise <= maxPer)
                {
                      final float prixRemiser =  price / ( 1- (remise / 100));
                      return "Prix depart: "+prixRemiser;
                }
                else
                {
                    throw new IllegalArgumentException("Entrée non valide: Remise");
                }
            }
            else
            {
                throw new IllegalArgumentException("Entrée non valide: Montant");
            }
        }
        else
        {
            throw new IllegalArgumentException("Entrée non valide: Montant, Entrée non valide: Pourcentage");
        }
    }
    
}
