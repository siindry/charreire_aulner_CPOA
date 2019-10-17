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
		Revue rtest1 = new Revue(0,"Titre","Description", 0, "visuel.jpg", 2);

		assertTrue(doas.getRevueDAO().create(rtest1));
		doas.getRevueDAO().delete(rtest1);
	}
	

	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Revue rtest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		int cle = doas.getRevueDAO().createGetKey(rtest1);

		rtest1.setId_revue(cle);
		Revue rtest2 = doas.getRevueDAO().getById(cle);
		assertTrue(doas.getRevueDAO().delete(rtest2));
	}
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne pas id:");
		
		Revue rtest1 = new Revue(-1, "Titre", "Description", 0, "visuel.jpg", 0);

		assertFalse(doas.getRevueDAO().delete(rtest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Revue rtest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		doas.getRevueDAO().create(rtest1);
		int id = rtest1.getId_periode();
		
		assertNotNull(doas.getRevueDAO().getById(id));
		doas.getRevueDAO().delete(rtest1);

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne pas id:");
		
		int id = -1;
		Revue rtest1 = doas.getRevueDAO().getById(id);
		
		boolean rempli = rtest1.getTitre()==null;
		assertTrue(rempli);

	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Revue rtest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 1);
		int cle = doas.getRevueDAO().createGetKey(rtest1);
		Revue rtest2 = new Revue(cle, "Nouveau titre", "Nouvelle Description", 1, "Nouveau visuel", 3);

		assertTrue(doas.getRevueDAO().update(rtest2));
		doas.getRevueDAO().delete(rtest2);
	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Revue rtest1 = new Revue(-1, "Titre", "Description", 0, "visuel.jpg", 0);

		
		assertFalse(doas.getRevueDAO().update(rtest1));
		
	}
	
	@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		Revue rtest1 = new Revue(0, "Titre", "Description", 0, "visuel.jpg", 0);
		int cle = doas.getRevueDAO().createGetKey(rtest1);
		Revue rtest2 = doas.getRevueDAO().getById(cle);
		
		String strTitre = rtest1.getTitre();
		String strTitre2 = rtest2.getTitre();
		
		String strDesc1 = rtest1.getDescription();
		String strDesc2 = rtest2.getDescription();
		
		String strRue1 = rtest1.getVisuel();
		String strRue2 = rtest2.getVisuel();
		

		
		if(strTitre.equals(strTitre2) || strDesc1.equals(strDesc2)|| strRue1.equals(strRue2)) {
			System.out.println("Le nom est le meme le test foctionne");
			doas.getRevueDAO().delete(rtest2);
			fail("Le nom est le meme");
		}
			


	}
	
}
	