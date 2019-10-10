package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Periodicite;

public class ListeMemoirePeriodiciteDAOTest {

	 //sur listes les fonctions sont update, create, delete, getById et findAll
	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
	}
	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation Liste Memoire fonctionne :");
		Periodicite ptest1 = new Periodicite(0,"Trimestriel");

		assertTrue(doas.getPeriodiciteDAO().create(ptest1));
	}

	
	@Test
	public void testDeleteWork() {
		//obligé d'en créé 2 puisqu'on ne peut pas supprimer qlqchose en fin de liste.
		
		System.out.println("\nSuppression Liste Memoire fonctionne :");
		
		//1er
		Periodicite ptest1 = new Periodicite("Deletation1");
		int cle1 = doas.getPeriodiciteDAO().createGetKey(ptest1);
		//2e
		Periodicite ptest2 = new Periodicite("Deletation2");
		int cle2 = doas.getPeriodiciteDAO().createGetKey(ptest2);
		
		//1er entré à supprimer
		ptest1.setId_periode(cle1);
		Periodicite ptest = doas.getPeriodiciteDAO().getById(cle1);
		assertTrue(doas.getPeriodiciteDAO().delete(ptest));
	}
	

	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Periodicite ptest1 = new Periodicite("dddddd");
		doas.getPeriodiciteDAO().create(ptest1);
		int id = ptest1.getId_periode();
		
		assertNotNull(doas.getPeriodiciteDAO().getById(id));

	}
	

	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Periodicite ptest1 = new Periodicite(13,"test3");
		int id = doas.getPeriodiciteDAO().createGetKey(ptest1);
		ptest1.setId_periode(id);

		assertTrue(doas.getPeriodiciteDAO().update(ptest1));
	
	}
	

	
	@Test 
	public void testFindAll() {
		
		System.out.println("\n Le Find All fonctionne");
		
		assertNotNull(doas.getPeriodiciteDAO().findAll());
	}
	

}



