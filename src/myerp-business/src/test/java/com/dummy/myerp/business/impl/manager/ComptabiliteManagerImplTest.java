package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.testbusiness.business.BusinessTestCase;
import com.dummy.myerp.testbusiness.business.SpringRegistry;


public class ComptabiliteManagerImplTest  extends BusinessTestCase  {
    private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();

 // FIXME tuto sur la gestions des exceptions en java
 // FIXME tuto sur jdbc template
    
    
    

	public EcritureComptable initilizsation() {
	String g = "33500-2019/15278";
	//g = "33500";
	EcritureComptable ecritureComptable = new EcritureComptable();
	JournalComptable pJournal = new JournalComptable();
	pJournal.setCode("BQ");
	pJournal.setLibelle("Banque");
    
	ecritureComptable.setId(1);
	Date pDate = new Date();
	pDate.setTime(1571244332105L);
    
	ecritureComptable.setJournal(pJournal);
	ecritureComptable.setLibelle("TMA Appli Yyy");
	ecritureComptable.setReference(g);
	//ecritureComptable.setDate(pDate);
	List<LigneEcritureComptable> plistLigneEcriture = new ArrayList<LigneEcritureComptable>();
    
	LigneEcritureComptable ligneEcritureComptable = new LigneEcritureComptable();
	CompteComptable pCompteComptable = new CompteComptable();
	ligneEcritureComptable.setCompteComptable(pCompteComptable);
	BigDecimal pCredit = new BigDecimal(7643);
	ligneEcritureComptable.setCredit(pCredit);
	BigDecimal pDebit = new BigDecimal(7643);
	ligneEcritureComptable.setDebit(pDebit);
	String pLibelle = "pLibelle";
    
	ligneEcritureComptable.setLibelle(pLibelle);
	plistLigneEcriture.add(ligneEcritureComptable);
	plistLigneEcriture.add(ligneEcritureComptable);
	plistLigneEcriture.add(ligneEcritureComptable);
    
	ecritureComptable.setListLigneEcriture(plistLigneEcriture);
    
	ecritureComptable.getJournal();
	ecritureComptable.getLibelle();
	ecritureComptable.getReference();
	ecritureComptable.getDate();
	ecritureComptable.getId();
	ecritureComptable.getListLigneEcriture();
	EcritureComptable e = new EcritureComptable();
	e.setId(2);
	e.setId(2);
	e.setId(2);
	e.setId(2);
	return ecritureComptable;
	}
	

    
    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitViolationJournalNull() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(null);
   manager.checkEcritureComptableUnit(vEcritureComptable);
    
    }
    
    
    
   /* @Test
    public void checkEcritureComptableUnitTest() throws FunctionalException  {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                               ;                                  null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }
*/
    

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG2() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(1234)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptableUnitRG3() throws Exception {
        try {
			EcritureComptable vEcritureComptable;
			vEcritureComptable = new EcritureComptable();
			//vEcritureComptable = initilizsation();
			vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
			vEcritureComptable.setDate(new Date());
			vEcritureComptable.setLibelle("Libelle");
			vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
			                                                                         null, new BigDecimal(123),
			                                                                         new BigDecimal(123)));
			manager.checkEcritureComptableUnit(vEcritureComptable);
			System.out.println("test de la rg3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    

   

	
    
	@Test()
    public void testUpdateEcritureComptable() throws FunctionalException {	
		
		try {
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
	
		comptabiliteManagerImpl.updateEcritureComptable(initilizsation());} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("second error");

		//	e.printStackTrace();
		}
	}
		@Test()
		public void testInsertEcritureComptable() throws FunctionalException  {
		
		SpringRegistry.init();
		try {
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
	
	    comptabiliteManagerImpl.insertEcritureComptable(initilizsation());} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("third error");
			//e.printStackTrace();
		}
	}
		/*
		@Test()
		public void testCheckEcritureComptableContext() throws FunctionalException  {
		
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
		String g = "33500-2019/15278";
		EcritureComptable ecritureComptable = new EcritureComptable();
		JournalComptable pJournal = new JournalComptable();
		pJournal.setCode(g);
		pJournal.setLibelle(g);
		ecritureComptable.setId(1);
		Date pDate = new Date();
		pDate.setTime(1571244332105L);
		ecritureComptable.setJournal(pJournal);
		ecritureComptable.setLibelle("2");
		ecritureComptable.setReference(g);
		ecritureComptable.setDate(pDate);
		List<LigneEcritureComptable> plistLigneEcriture = new ArrayList<LigneEcritureComptable>();
		LigneEcritureComptable ligneEcritureComptable = new LigneEcritureComptable();
		CompteComptable pCompteComptable = new CompteComptable();
		ligneEcritureComptable.setCompteComptable(pCompteComptable);
		BigDecimal pCredit = new BigDecimal(7643);
		ligneEcritureComptable.setCredit(pCredit);
		BigDecimal pDebit = new BigDecimal(743);
		ligneEcritureComptable.setDebit(pDebit);
		String pLibelle = "pLibelle";
		ligneEcritureComptable.setLibelle(pLibelle);
		plistLigneEcriture.add(ligneEcritureComptable);
		plistLigneEcriture.add(ligneEcritureComptable);
		plistLigneEcriture.add(ligneEcritureComptable);
		ecritureComptable.setListLigneEcriture(plistLigneEcriture);
		ecritureComptable.getJournal();
		ecritureComptable.getLibelle();
		ecritureComptable.getReference();
		ecritureComptable.getDate();
		ecritureComptable.getId();
		ecritureComptable.getListLigneEcriture();
	
	
	    comptabiliteManagerImpl.checkEcritureComptable(ecritureComptable);
	}
		
		
		@Test()
		public void testMoinsDeDeuxElementsLignesEcritureComptable() throws FunctionalException  {
		
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
		String g = "33500-2019/15278";
		EcritureComptable ecritureComptable = new EcritureComptable();
		JournalComptable pJournal = new JournalComptable();
		pJournal.setCode(g);
		pJournal.setLibelle(g);
		Date pDate = new Date();
		pDate.setTime(1571244332105L);
		ecritureComptable.setJournal(pJournal);
		ecritureComptable.setLibelle("2");
		ecritureComptable.setReference(g);
		ecritureComptable.setDate(pDate);
		List<LigneEcritureComptable> plistLigneEcriture = new ArrayList<LigneEcritureComptable>();
		LigneEcritureComptable ligneEcritureComptable = new LigneEcritureComptable();
		CompteComptable pCompteComptable = new CompteComptable();
		ligneEcritureComptable.setCompteComptable(pCompteComptable);
		BigDecimal pCredit = new BigDecimal(7643);
		ligneEcritureComptable.setCredit(pCredit);
		BigDecimal pDebit = new BigDecimal(743);
		ligneEcritureComptable.setDebit(pDebit);
		String pLibelle = "pLibelle";
		ligneEcritureComptable.setLibelle(pLibelle);
		ecritureComptable.setListLigneEcriture(plistLigneEcriture);
		ecritureComptable.getJournal();
		ecritureComptable.getLibelle();
		ecritureComptable.getReference();
		ecritureComptable.getDate();
		ecritureComptable.getId();
		ecritureComptable.getListLigneEcriture();
	
	
	    comptabiliteManagerImpl.checkEcritureComptable(ecritureComptable);
	}
		*/
    
    
    // FIXME ccheckEcritureComptableUnitRG4
    // FIXME ccheckEcritureComptableUnitRG5
// TODO some todo
    // FIXME -> Faire un test unitaire pour la méthode "JournalComptable getByCode(...)" de l'objet JournalComptable

	 // FIXME -> Dans le projet business: Bien comprendre à quoi sert et que fait la méthode checkEcritureComptableUnit dans le manager
	
	 // FIXME -> Compléter la classe de test qui test les cas de figure decheckEcritureComptableUnit (RGx)
	
	 // FIXME Note: pour la RG5, N'oublie pas d'ajouter 2 Lignes d'écriture comptable à ton mock EcritureComptable en début de test-> ex: ecritureComptable.getListEcritureComptable.add(...)
	
	 // FIXME -> Dans le projet business, revoir la configuration Spring et t'assurer que le testInit
}
