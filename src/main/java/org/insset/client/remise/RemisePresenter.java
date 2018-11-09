/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.remise;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.RemiseService;
import org.insset.client.service.RemiseServiceAsync;
import org.insset.client.service.RomanConverterServiceAsync;

/**
 *
 * @author talend
 */
public class RemisePresenter extends Composite{

    @UiField
    public TextBox price;
    @UiField
    public TextBox percentage;
    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonEnregistrer;
    @UiField
    public Label errorLabel;
    @UiField
    public TextBox price1;
    @UiField
    public TextBox percentage1;
    @UiField
    public ResetButton boutonClear1;
    @UiField
    public SubmitButton boutonEnregistrer1;
    @UiField
    public Label errorLabel1;
    
    interface MainUiBinder extends UiBinder<HTMLPanel, RemisePresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final RemiseServiceAsync service = GWT.create(RemiseService.class);

    public RemisePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }
    
    protected void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                price.setText("");
                percentage.setText("");
                errorLabel.setText("");
            }
        });
        boutonClear1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                price1.setText("");
                percentage1.setText("");
                errorLabel1.setText("");
            }
        });
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                convertPrice();
            }

        });
        boutonEnregistrer1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            }

        });       
    }
    
    private void convertPrice() {
        errorLabel.setText("");
        final String priceText = price.getText();
        final String montantText = percentage.getText();
        final Float prixNumber = Float.parseFloat(priceText);
        final Float remiseNumber = Float.parseFloat(montantText);
        
        service.remisePrice(prixNumber,remiseNumber,new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                errorLabel.addStyleName("serverResponseLabelError");
                errorLabel.setText(caught.getMessage());
            }

            public void onSuccess(String result) {
                new DialogBoxInssetPresenter("Votre remise", "", result);
            }
        });
    }

}
