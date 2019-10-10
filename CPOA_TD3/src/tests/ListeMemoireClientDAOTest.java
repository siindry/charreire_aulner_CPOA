package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Client;
import metier.Client;

public class ListeMemoireClientDAOTest {

	 //sur listes les fonctions sont update, create, delete, getById et findAll
	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
	}
	
	@Test
	public void testCreateWork() {
		Client ptest1 = new Client("jean","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");

		assertTrue(doas.getClientDAO().create(ptest1));
	}

	
	@Test
	public void testDeleteWork() {
		//obligé d'en créé 2 puisqu'on ne peut pas supprimer qlqchose en fin de liste.
		
		System.out.println("\nSuppression Liste Memoire fonctionne :");
		
		//1er
		Client ptest1 = new Client("JEANNE","dupont", 0, "4", "rue Saulcy", "57000", "Metz", "France");
		int cle1 = doas.getClientDAO().createGetKey(ptest1);
		//2e
		Client ptest2 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		int cle2 = doas.getClientDAO().createGetKey(ptest2);
		
		//1er entré à supprimer
		ptest1.setId_client(cle1);
		Client ptest = doas.getClientDAO().getById(cle1);
		assertTrue(doas.getClientDAO().delete(ptest));
	}
	
	/*@Test
	public void testDeleteNotWorkNoId() {
	//attention : 2 à rentrer! se référer au dessus
		
		System.out.println("\nSuppression fonctionne pas id:");
		
		Client ptest1 = new Client("JEAN","dupont", -1, "3", "rue Saulcy", "57000", "Metz", "France");

		assertFalse(doas.getClientDAO().delete(ptest1));
	}*/
	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Client ptest1 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		doas.getClientDAO().create(ptest1);
		int id = ptest1.getId_client();
		
		assertNotNull(doas.getClientDAO().getById(id));

	}
	
	/*@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne pas id:");
		
		int id = -1;
		
		assertNull(doas.getClientDAO().getById(id));

	}*/
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Client ptest1 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		int id = doas.getClientDAO().createGetKey(ptest1);
		ptest1.setId_client(id);

		assertTrue(doas.getClientDAO().update(ptest1));
	
	}
	
	
	/*@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Client ptest1 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		int id = doas.getClientDAO().createGetKey(ptest1);
		ptest1.setId_client(id);

		assertFalse(doas.getClientDAO().update(ptest1));
	}*/
	
	@Test 
	public void testFindAll() {
		
		System.out.println("\n Le Find All fonctionne");
		
		assertNotNull(doas.getClientDAO().findAll());
	}
	
	
	/*public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		Client ptest1 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		int cle = doas.getClientDAO().createGetKey(ptest1);
		Client ptest2 = doas.getClientDAO().getById(cle);
		
		String strtest1 = ptest1.getLibelle();
		String strtest2 = ptest2.getLibelle();
		
		if(strtest1.equals(strtest2)) {
			fail("Le nom est le meme");
			
		}
		
	}*/
}



