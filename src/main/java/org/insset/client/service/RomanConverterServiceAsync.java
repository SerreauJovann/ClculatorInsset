/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author user
 */
public interface RomanConverterServiceAsync {

    void convertRomanToArabe(String nbr, AsyncCallback<Integer> callback);

    void convertArabeToRoman(Integer nbr, AsyncCallback<String> callback);

    void convertDateYears(String nbr, AsyncCallback<String> callback);
}
