package it.polito.tdp.libretto.model;

import java.util.*;

public class Model {
	
	private List <Esame> esami;
	
	public Model(){
		this.esami = new ArrayList<Esame>();	
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia gia`
	 * @param e
	 * @return true se l'ha inserito, false se esisteva gia e quindi non l'ha inserito
	 */
	public boolean addEsame(Esame e ){
		if( !esami.contains(e)){   //contains sulla lista di esami usa equals che ho creto in Esame
			esami.add(e);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato 
	 * se esite restituisce, altrimenti restituisce null.
	 * @param codice = codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice){
		int pos = esami.indexOf(new Esame(codice,null,null));  // creo un esame "finto" per usare indexOf per trovare l'esame. La ricerca avviene solo sul codice, gli altri parametri posso anch emetterli null
		if( pos == -1){
			return null;
		}else{
			return esami.get(pos);
		}
	}

}
