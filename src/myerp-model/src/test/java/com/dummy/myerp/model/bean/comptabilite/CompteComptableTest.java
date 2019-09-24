package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompteComptableTest {
 
	@Test
	public void testGetByNumero() {
		CompteComptable comptec = new CompteComptable();
		
		
		ArrayList<CompteComptable> ComptePremier = new ArrayList<CompteComptable>();
		CompteComptable compte1 = new CompteComptable();
		compte1.setLibelle("premier compte");
		compte1.setNumero(1157);
		ComptePremier.add(compte1);
		CompteComptable journalcomptable = CompteComptable.getByNumero(ComptePremier,1157);
		assertEquals(CompteComptable.getByNumero(ComptePremier,1157).getLibelle(),"premier compte");

	}

	
	
	
}
