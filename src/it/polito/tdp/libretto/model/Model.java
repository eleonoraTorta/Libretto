package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {
	
	private List <Esame> esami;					//dichiarazione lista
	
	public Model(){    							//(il costruttore non richiede parametri)
		this.esami = new ArrayList<Esame>();	//inizializzazione lista
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia gia`
	 * @param e
	 * @return true se l'ha inserito, false se esisteva gia e quindi non l'ha inserito
	 */
	public boolean addEsame(Esame e ){
		EsameDAO dao = new EsameDAO();
		return dao.create(e);
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato 
	 * se esite restituisce, altrimenti restituisce null.
	 * @param codice = codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice){
		EsameDAO dao = new EsameDAO();
		Esame e = dao.find(codice);
		return e;
	}

}
