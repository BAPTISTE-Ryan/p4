package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EcritureComptableTest {

    private List<String> list;

    @Before
    public void init() {
        System.out.println(" S t a r t - U P ");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
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

    @Test
    public void isEquilibree() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();

        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        Assert.assertTrue(vEcriture.toString(), vEcriture.isEquilibree());

    }

    @Test
    public void isNotEquilibree() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();

        vEcriture.setLibelle("Non Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "22", "2"));
        System.out.println(vEcriture);
        Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
        System.out.println(vEcriture.toString());
        System.out.println(vEcriture.isEquilibree());
        Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
    }

    @After
    public void finalize() {
        // LOG.info("finalize");
        System.out.println(" S h u t - D O W N ");
        list.clear();
    }

}
