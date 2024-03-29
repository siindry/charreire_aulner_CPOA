package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
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
		Client ctest1 = new Client("jean","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");

		assertTrue(doas.getClientDAO().create(ctest1));
		doas.getClientDAO().delete(ctest1);
	}

	

	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Client ctest1 = new Client("JEAN","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		doas.getClientDAO().create(ctest1);
		int id = ctest1.getId_client();
		
		assertNotNull(doas.getClientDAO().getById(id));

	}

	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		

		Client ctest1 = new Client("JEANNINE","dupont", 0, "3", "rue Saulcy", "57000", "Metz", "France");
		if(doas.getClientDAO().create(ctest1)==false) {
			System.out.println("Cette erreur est normale");
		}

		assertTrue(doas.getClientDAO().update(ctest1));
		doas.getClientDAO().delete(ctest1);

	}
	
	

	
	@Test 
	public void testFindAll() {
		
		System.out.println("\n Le Find All fonctionne");
		
		assertNotNull(doas.getClientDAO().findAll());
	}
	
	

}



