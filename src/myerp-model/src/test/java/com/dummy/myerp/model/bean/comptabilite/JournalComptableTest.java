package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.functors.ForClosure;
import org.junit.Test;

public class JournalComptableTest {

	// ArrayList <JournalComptable> pList = new ArrayList() <JournalComptable>;

	@Test
	public void testGetByCode() {

		JournalComptable pjournal = new JournalComptable();

		ArrayList<JournalComptable> pJournal = new ArrayList<JournalComptable>();

		JournalComptable pjournal1 = new JournalComptable();
		pjournal1.setLibelle("1er journal ");
		pjournal1.setCode("Code1");
		pJournal.add(pjournal1);
		JournalComptable pjournal2 = new JournalComptable();
		pjournal2.setLibelle("2eme journal");
		pjournal2.setCode("Code2");
		pJournal.add(pjournal2);
		JournalComptable pjournal3 = new JournalComptable();
		pjournal3.setLibelle("3eme journal");
		pjournal3.setCode("Code3");
		pJournal.add(pjournal3);
		
		JournalComptable pjournal4 = new JournalComptable();
		pjournal4.setLibelle("4eme journal");
		pjournal4.setCode("Code4");
		pJournal.add(pjournal4);

		assertEquals(JournalComptable.getByCode(pJournal, "Code4").getLibelle(),"4eme journal");
	}

	@Test
	public void testGetByCodePCodeNull() {
	
			ArrayList<JournalComptable> pJournal = new ArrayList<JournalComptable>();
			JournalComptable pjournal1 = new JournalComptable();
			pjournal1.setLibelle("1er journal ");
			pjournal1.setCode("Code1");
			pJournal.add(pjournal1);
			JournalComptable journalcomptable = JournalComptable.getByCode(pJournal, null);
			assertNull(journalcomptable);
	

	}

	@Test
	public void testGetByCodePListeNull() {
		try {
			ArrayList<JournalComptable> pJournal = new ArrayList<JournalComptable>();
			JournalComptable pjournal1 = new JournalComptable();
			pjournal1.setLibelle("1er journal ");
			pjournal1.setCode("Code1");
			pJournal.add(pjournal1);
			JournalComptable journalcomptable = JournalComptable.getByCode(null, "Code1");
			fail();
		} catch (Exception e) {

		}

	}
	
}
