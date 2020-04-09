package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagramma.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Ricerca ricerca;
   
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaCorretta;

    @FXML
    private TextArea txtAreaErrata;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String s = txtParola.getText();
    	List<String>lista=new ArrayList<>();
    	List<String>corretta=new ArrayList<>();
    	List<String>errata=new ArrayList<>();
    	lista.addAll(ricerca.anagrammi(s));
    	String giusto ="";
    	String sbagliato ="";
    	for(int i=0;i<lista.size();i++) {
    		if(ricerca.isCorretto(lista.get(i))==true) {
    			giusto+=lista.get(i)+"\n";
    		}else {
    			sbagliato+=lista.get(i)+"\n";
    		}
    	}
    	txtAreaCorretta.appendText(giusto);
    	txtAreaErrata.appendText(sbagliato);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*String result="";
    	for(String ss : lista) {
    		if(result.equals(""))
    			result+=ss;
    		else
    			result+="\n"+ss;
    	}
    	txtAreaCorretta.appendText(result);*/
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtAreaCorretta.clear();
    	txtAreaErrata.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaCorretta != null : "fx:id=\"txtAreaCorretta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaErrata != null : "fx:id=\"txtAreaErrata\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setRicerca(Ricerca ricerca) {
		this.ricerca = ricerca;
	}
}
