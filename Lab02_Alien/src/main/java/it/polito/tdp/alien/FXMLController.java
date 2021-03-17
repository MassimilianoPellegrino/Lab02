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
    		this.txtRisultato.setText("ATTENZIONE: Inserire solamente caratteri alfabetici");
    		return;
    	}
    	this.txtInserisci.clear();
    	if(inserimento.contains(" ")) {
    		String[] array = inserimento.split(" ");
    		if(array.length==2) {
    			model.addWord(array[0], array[1]);
    			this.txtRisultato.setText("Nuova traduzione inserita nel dizionario");
    		}else {
    			this.txtRisultato.setText("ATTENZIONE: Non inserire più di due parole");
    		}
    	}else {
    		try{
    			model.translateWord(inserimento);
    			this.txtRisultato.setText(model.findWord(inserimento).getTranslation());
    		}catch(NullPointerException e) {
    			this.txtRisultato.setText("ATTENZIONE: Parola insesistente");
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
