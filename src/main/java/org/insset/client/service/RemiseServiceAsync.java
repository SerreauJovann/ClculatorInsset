/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;
import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 *
 * @author talend
 */
public interface RemiseServiceAsync {
    
    void remisePrice(Float price, Float remise, AsyncCallback<String> callback);
    
    void invertRemise(Float price, Float remise, AsyncCallback<String> callback);
}
