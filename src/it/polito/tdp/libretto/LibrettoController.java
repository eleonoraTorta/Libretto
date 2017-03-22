package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnCerca;

    @FXML
    void doCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice corso non valido\n");
    		return;
    	}
    	Esame e = model.trovaEsame(codice);
    	
    	if(e== null){
    		txtMessage.appendText("Codice "+codice+ " non valido\n");
    	}else{
    		txtMessage.appendText("Codice "+ codice + "trovato\n");
    		txtCodice.setText(e.getTitolo());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }
    
    @FXML
    private TextArea txtMessage;

    @FXML
    void doInserisci(ActionEvent event) {
    	//recupera i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//verifica la validita dei dati
    	if(codice.length()<5 || titolo.length() ==0 || docente.length()==0){
    		txtMessage.appendText("Dati esami insufficienti\n");	
    	}
    	
    	//chiedi al Model di effettuare l'operazione
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	//aggiorna la vista con il risulato dell'operazione
    	if(result){
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	}else{
    		txtMessage.appendText("Esame NON AGGIUNTO (codice dupilcato)\n");
    	}
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
    
    public void setModel(Model m){
    	this.model= m;
    }
}

