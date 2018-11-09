/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author talend
 */
@RemoteServiceRelativePath("remise")
public interface RemiseService extends RemoteService{
    
    String remisePrice(Float price, Float remise) throws IllegalArgumentException;
    
    String invertRemise(Float price, Float remise) throws IllegalArgumentException;
}
