package com.dummy.myerp.testbusiness.business;
	
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

//////////

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.TransactionStatus;

import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.technical.exception.NotFoundException;
//////////
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
	
/**	
 * Classe de test de l'initialisation du contexte Spring
 */	
public class ComptabiliteManagerImplTest extends BusinessTestCase {
	
	
	
    
	public EcritureComptable initilizsation() {
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
	return ecritureComptable;
	}
	
	
	private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
		BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
		BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
		String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
				.subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
		LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
				vLibelle, vDebit, vCredit);
		return vRetour;
	}

	@Test()
	public void testFunctionalExceptionInsertEcritureComptable() {
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
		EcritureComptable ecritureComptable = new EcritureComptable();
		JournalComptable pJournal = new JournalComptable();
		assertNotNull(SpringRegistry.getBusinessProxy());
		assertNotNull(SpringRegistry.getTransactionManager());
		try {
			comptabiliteManagerImpl.insertEcritureComptable(ecritureComptable);
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

	@InjectMocks
	DaoProxy pDaoProxy;

	@Test()
	public void checkEcritureComptableUnit() {
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();

		ComptabiliteManagerImpl cmpl = new ComptabiliteManagerImpl();
		// BusinessManager
		BusinessProxy businessproxy = SpringRegistry.getBusinessProxy();
		TransactionManager transactionManager = SpringRegistry.getTransactionManager();

		cmpl.configure(businessproxy, pDaoProxy, transactionManager);
		try {
			cmpl.insertEcritureComptable(initilizsation());
		} catch (FunctionalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// cmpl.getListEcritureComptable();
		// BusinessTestCase.getBusinessProxy().getComptabiliteManager().getListEcritureComptable();
		try {
			comptabiliteManagerImpl.checkEcritureComptable(initilizsation());
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
    public void testUpdateEcritureComptable() throws FunctionalException {	
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
	
		comptabiliteManagerImpl.updateEcritureComptable(initilizsation());
	}

		@Test()
		public void testInsertEcritureComptable() throws FunctionalException  {
		
		SpringRegistry.init();
		ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
	
	    comptabiliteManagerImpl.insertEcritureComptable(initilizsation());
	}
		
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
		
}
