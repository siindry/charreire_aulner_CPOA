package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Revue;

public class MySQLRevueDAOTest {
	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	}
	
	// une classe = une classeTest et  une méthode = une méthodeTest

	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation fonctionne :");
		Revue ptest1 = new Revue(0,"Titre","Description", 0, "visuel.jpg", 2);

		assertTrue(doas.getRevueDAO().create(ptest1));
	}
	

	
	/*@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Revue ptest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		int cle = doas.getRevueDAO().createGetKey(ptest1);

		ptest1.setId_revue(cle);
		Revue ptest2 = doas.getRevueDAO().getById(cle);
		assertTrue(doas.getRevueDAO().delete(ptest2));
	}*/
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne pas id:");
		
		Revue ptest1 = new Revue(-1, "Titre", "Description", 0, "visuel.jpg", 0);

		assertFalse(doas.getRevueDAO().delete(ptest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Revue ptest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		doas.getRevueDAO().create(ptest1);
		int id = ptest1.getId_periode();
		
		assertNotNull(doas.getRevueDAO().getById(id));

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne pas id:");
		
		int id = -1;
		
		assertNull(doas.getRevueDAO().getById(id));

	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Revue ptest1 = new Revue(13, "Titre", "Description", 0, "visuel.jpg", 0);

		assertTrue(doas.getRevueDAO().update(ptest1));

	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Revue ptest1 = new Revue(-1, "Titre", "Description", 0, "visuel.jpg", 0);

		
		assertFalse(doas.getRevueDAO().update(ptest1));

	}
	
	/*@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		Revue ptest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		int cle = doas.getRevueDAO().createGetKey(ptest1);
		Revue ptest2 = doas.getRevueDAO().getById(cle);
		
		String strtest1 = ptest1.getLibelle();
		String strtest2 = ptest2.getLibelle();
		
		if(strtest1.equals(strtest2)) {
			fail("Le nom est le meme");
		}
			


	}*/
	
}
	