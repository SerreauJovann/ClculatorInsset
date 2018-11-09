/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

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
//import org.insset.client.pourcentage.ExemplePourcentagePresenter;
import org.insset.client.message.Messages;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
//import org.insset.client.service.ExemplePourcentagePresenter;
import org.insset.client.service.ExemplePourcentageAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author talend
 */
public class ExemplePourcentagePresenter extends Composite{
    
    
    @UiField
    public ResetButton boutonClearP;
    @UiField
    public ResetButton boutonClearR;
    @UiField
    public SubmitButton boutonEnregistrerP;
    @UiField
    public Label errorLabelP;
    @UiField
    public Label errorLabelR;
    @UiField
    public TextBox prix;
    @UiField
    public TextBox remise;
    

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final ExemplePourcentageAsync service = GWT.create(ExemplePourcentagePresenter.class);

    private final Messages messages = GWT.create(Messages.class);

    interface AddUiBinder extends UiBinder<HTMLPanel, ExemplePourcentagePresenter> {
    }

    /**
     * Create UiBinder for the view
     */
    private static final AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);

    /**
     * Constructeur
     */
    public ExemplePourcentagePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }


    /**
     * Init des handler
     */
    private void initHandler() {
        boutonClearP.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                prix.setText("");
                errorLabelP.setText("");
            }
        });
        boutonEnregistrerP.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                appRemise();
            }

        });
        boutonClearR.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remise.setText("");
                errorLabelR.setText("");
            }
        });
    }

    private void appRemise() {
        errorLabelP.setText("");
        errorLabelR.setText("");
        final String textToServerP = prix.getText();
        final String textToServerR = remise.getText();
        if (!FieldVerifier.isValidName(textToServerP)) {
            errorLabelP.addStyleName("serverResponseLabelError");
            errorLabelP.setText("Aucun prix entré!!");
            return;
        }
        if (!FieldVerifier.isValidName(textToServerR)) {
            errorLabelR.addStyleName("serverResponseLabelError");
            errorLabelR.setText("Aucune remise entré!!");
            return;
        }
        final Float prixNumber = Float.parseFloat(textToServerP);
        final Float remiseNumber = Float.parseFloat(textToServerR);
        service.inverserChaine2(textToServerP, textToServerR, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                final float prixRemiser = prixNumber - (prixNumber * remiseNumber / 100);
                String prixChaine = String.valueOf(prixRemiser);
                new DialogBoxInssetPresenter("Le prix final est de :", prixChaine, result);
            }
        });
        
        
    }
    
        private void avtRemise() {
        errorLabelP.setText("");
        errorLabelR.setText("");
        final String textToServerP = prix.getText();
        final String textToServerR = remise.getText();
        if (!FieldVerifier.isValidName(textToServerP)) {
            errorLabelP.addStyleName("serverResponseLabelError");
            errorLabelP.setText("Aucun prix entré!!");
            return;
        }
        if (!FieldVerifier.isValidName(textToServerR)) {
            errorLabelR.addStyleName("serverResponseLabelError");
            errorLabelR.setText("Aucune remise entré!!");
            return;
        }
        final Float prixNumber = Float.parseFloat(textToServerP);
        final Float remiseNumber = Float.parseFloat(textToServerR);
        service.inverserChaine2(textToServerP, textToServerR, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(String result) {
                final float prixRemiser = prixNumber / ( 1- (remiseNumber / 100));
                String prixChaine = String.valueOf(prixRemiser);
                new DialogBoxInssetPresenter("Le prix final est de :", prixChaine, result);
            }
        });
        
        
    }
}
