package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Periodicite;
import metier.Revue;

public class MySQLPeriodiciteDAOTest {
	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	}
	
	// une classe = une classeTest et  une méthode = une méthodeTest

	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation fonctionne :");
		Periodicite ptest1 = new Periodicite(0,"Trimestriel");

		assertTrue(doas.getPeriodiciteDAO().create(ptest1));
		doas.getPeriodiciteDAO().delete(ptest1);
	}
	

	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Periodicite ptest1 = new Periodicite("Deletation");
		int cle = doas.getPeriodiciteDAO().createGetKey(ptest1);

		ptest1.setId_periode(cle);
		Periodicite ptest2 = doas.getPeriodiciteDAO().getById(cle);
		assertTrue(doas.getPeriodiciteDAO().delete(ptest2));
	}
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne : pas id:");
		
		Periodicite ptest1 = new Periodicite(-1, "Deletation");

		assertFalse(doas.getPeriodiciteDAO().delete(ptest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Periodicite ptest1 = new Periodicite("TrimestrielFormat2");
		doas.getPeriodiciteDAO().create(ptest1);
		int id = ptest1.getId_periode();
		
		assertNotNull(doas.getPeriodiciteDAO().getById(id));
		doas.getPeriodiciteDAO().delete(ptest1);

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne : pas id:");
		
		int id = -1;
		Periodicite ptest1 = doas.getPeriodiciteDAO().getById(id);
		
		boolean rempli = ptest1.getLibelle()=="";
		assertTrue(rempli);
		

	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Periodicite ptest1 = new Periodicite(0, "libelle");
		int cle = doas.getPeriodiciteDAO().createGetKey(ptest1);
		Periodicite ptest2 = new Periodicite(cle, "Nouveau libelle");


		assertTrue(doas.getPeriodiciteDAO().update(ptest2));
		doas.getPeriodiciteDAO().delete(ptest2);

	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Periodicite ptest1 = new Periodicite(-1,"TrimestrielFormat4");

		
		assertFalse(doas.getPeriodiciteDAO().update(ptest1));

	}
	
	@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		Periodicite ptest1 = new Periodicite(0,"AnnuelFormat2");
		int cle = doas.getPeriodiciteDAO().createGetKey(ptest1);
		Periodicite ptest2 = doas.getPeriodiciteDAO().getById(cle);
		
		String strtest1 = ptest1.getLibelle();
		String strtest2 = ptest2.getLibelle();
		
		if(strtest1.equals(strtest2)) {
			System.out.println("Le nom est le meme : le test fonctionne");
			doas.getPeriodiciteDAO().delete(ptest1);
			fail("Le nom est le meme");
		}
			


	}
	

	
	
	
	
	


}
