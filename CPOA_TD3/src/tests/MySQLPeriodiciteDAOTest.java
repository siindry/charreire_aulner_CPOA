package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Periodicite;

class MySQLPeriodiciteDAOTest {
	
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
	}
	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Periodicite ptest1 = new Periodicite(70,"Trimestriel");
		doas.getPeriodiciteDAO().create(ptest1);
		
		assertTrue(doas.getPeriodiciteDAO().delete(ptest1));

	}
	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Periodicite ptest1 = new Periodicite(70,"Trimestriel");
		doas.getPeriodiciteDAO().create(ptest1);
		int id = ptest1.getId_periode();
		
		assertNotNull(doas.getPeriodiciteDAO().getById(id));

	}
	
	/*@Test
	void testDeleteNotWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		DAOFactory doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		Periodicite ptest1 = new Periodicite(70,"Trimestriel");
		Periodicite ptest1 = new Periodicite(70,"Trimestriel");
		doas.getPeriodiciteDAO().create(ptest1);
		
		assertTrue(doas.getPeriodiciteDAO().create(ptest1));

	}*/
	
	/*@Test
	void testUpdateWork() {
		
		DAOFactory doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		Periodicite ptest1 = new Periodicite(0,"Trimestriel");
		Periodicite ptest2 = new Periodicite(0,"Trimestriel");
		assertTrue(doas.getPeriodiciteDAO().create(ptest1));

	}*/
	
	
	
	
	


}
