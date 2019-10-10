package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Abonnement;

public class ListeMemoireAbonnementDAOTest {

	 //sur listes les fonctions sont update, create, delete, getById et findAll
	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
	}
	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation Liste Memoire fonctionne :");
		String date1 = "2018-09-03";
		String date2 = "2019-09-03";
		LocalDate dateDebut1 = LocalDate.parse(date1);
		LocalDate dateFin2 = LocalDate.parse(date2);
		
		Abonnement ptest1 = new Abonnement(0, 0, dateDebut1, dateFin2);

		assertTrue(doas.getAbonnementDAO().create(ptest1));
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
	public void testFindAll() {
		
		System.out.println("\n Le Find All fonctionne");
		
		assertNotNull(doas.getAbonnementDAO().findAll());
	}
	
	
	
}



