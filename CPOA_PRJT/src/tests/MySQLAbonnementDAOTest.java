package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Abonnement;

public class MySQLAbonnementDAOTest {
	
private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	}
	
	// une classe = une classeTest et  une mÃ©thode = une mÃ©thodeTest

	// !!!! Pour cette table, les fonctions difère car il y a une clé composite donc pas de AutoInc !!!!
	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation fonctionne :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		
		Abonnement atest1 = new Abonnement(2, 3, dateDebut, dateFin);
		
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}
		doas.getAbonnementDAO().delete(atest1);
	}
	

	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		Abonnement atest1 = new Abonnement(2, 3, dateDebut, dateFin);
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}

		assertTrue(doas.getAbonnementDAO().delete(atest1));
	}
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne pas id:");
		
		Abonnement atest1 = new Abonnement(-1, -1, null, null);

		assertFalse(doas.getAbonnementDAO().delete(atest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		Abonnement atest1 = new Abonnement(2, 3, dateDebut, dateFin);
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}
		
		int id1 = atest1.getIdRev();
		int id2 = atest1.getIdCl();
		
		assertNotNull(doas.getAbonnementDAO().getBy2Id(id2, id1));
		doas.getAbonnementDAO().delete(atest1);

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne pas id:");
		
		int id = -1;
		Abonnement ctest1 = doas.getAbonnementDAO().getBy2Id(id, id);
		
		boolean rempli = ctest1.getDateDeb()!=null;
		assertFalse(rempli);

	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		Abonnement atest1 = new Abonnement(2, 3, dateDebut, dateFin);
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}

		assertTrue(doas.getAbonnementDAO().update(atest1));
		doas.getAbonnementDAO().delete(atest1);

	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		Abonnement atest1 = new Abonnement(-2, -3, dateDebut, dateFin);

		
		assertFalse(doas.getAbonnementDAO().update(atest1));

	}
	
	@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		String date1 = "2000-09-03";
		String date2 = "2000-10-23";
		
		LocalDate dateDebut = LocalDate.parse(date1);
		LocalDate dateFin = LocalDate.parse(date2);
		Abonnement atest1 = new Abonnement(2, 3, dateDebut, dateFin);
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}
		
		Abonnement atest2 = new Abonnement(2, 4, dateDebut, dateFin);
		if(doas.getAbonnementDAO().create(atest1)==false) {
			System.out.println("Cette erreur est normale");
		}
		
		LocalDate strDateD1 = atest1.getDateDeb();
		LocalDate strDateD2 = atest2.getDateDeb();
		
		LocalDate strDateF1 = atest1.getDateFin();
		LocalDate strDateF2 = atest2.getDateFin();
		
		if(strDateD1.equals(strDateD2) || strDateF1.equals(strDateF2)) {
			System.out.println("Le nom est le meme, le test foctionne");
			doas.getAbonnementDAO().delete(atest1);
			fail("Le nom est le meme");
		}
			


	}
}
