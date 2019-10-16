package com.dummy.myerp.testbusiness.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

//////////

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.TransactionStatus;
import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.technical.exception.NotFoundException;
//////////
import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;



/**
 * Classe de test de l'initialisation du contexte Spring
 */
public class ComptabiliteManagerImplTest extends BusinessTestCase {


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
    public void testFunctionalExceptionInsertEcritureComptable()  {
        SpringRegistry.init();
        ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
        EcritureComptable ecritureComptable = new  EcritureComptable();
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
    
    @Test()
    public void checkEcritureComptableUnit()  {
    	SpringRegistry.init();
    	String g = "33500-2019/15278";
    	 ComptabiliteManagerImpl comptabiliteManagerImpl = new ComptabiliteManagerImpl();
         EcritureComptable ecritureComptable = new  EcritureComptable();
         JournalComptable pJournal = new JournalComptable();
         pJournal.setCode(g);
         pJournal.setLibelle(g);
         ecritureComptable.setJournal(pJournal);
         ecritureComptable.setLibelle(g);
         ecritureComptable.setReference(g);
         
         ecritureComptable.setId(1);
         Date pDate = new Date();
         ecritureComptable.setDate(pDate);
         ComptabiliteManagerImpl cmpl = new ComptabiliteManagerImpl();
        // BusinessManager
         //DaoProxy pDaoProxy=getDaoProxy();
		//cmpl.configure(getBusinessProxy(), pDaoProxy, getTransactionManager());
         //cmpl.getListJournalComptable();
         //BusinessTestCase.getBusinessProxy().getComptabiliteManager().getListEcritureComptable();
         try {
			comptabiliteManagerImpl.checkEcritureComptable(ecritureComptable);
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}
