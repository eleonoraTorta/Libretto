package it.polito.tdp.libretto.db;

import it.polito.tdp.libretto.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
		
		EsameDAO dao = new EsameDAO();
		
		Esame e1 = dao.find("03FYZ");
		System.out.println(e1);
		
		Esame e2 = dao.find("99QQQ");
		System.out.println(e2);
		

	}

}
