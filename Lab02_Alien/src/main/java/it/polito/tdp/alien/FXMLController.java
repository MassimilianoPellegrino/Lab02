package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnClear;

    @FXML
    void doTranslate(ActionEvent event) {
    	String inserimento = this.txtInserisci.getText().toLowerCase();
    	if(inserimento.matches(".*[0-9].*")) {
    		this.txtRisultato.setText("Inserire solamente caratteri alfabetici");
    		return;
    	}
    	this.txtInserisci.clear();
    	if(inserimento.matches(".*[a-z].*")) {
	    	if(inserimento.contains(" ")) {
	    		String[] array = inserimento.split(" ");
	    		model.addWord(array[0], model.generaLista(array));
	    		this.txtRisultato.setText("Nuova traduzione inserita nel dizionario");
	    		return;
	    	}else {
	    		try{
	    			this.txtRisultato.setText(model.printTranslation(model.translateWord(inserimento)));
	    		}catch(NullPointerException e) {
	    			this.txtRisultato.setText("Parola insesistente");
	    		}
	    		return;
	    	}
    	}
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	this.txtInserisci.clear();
    	this.txtRisultato.clear();
    	model.reset();
    }

    public void setModel(AlienDictionary model) {
    	this.model=model;
    }
    
    @FXML
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
