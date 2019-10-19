package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Client;

public class MySQLClientDAOTest {

	
	private DAOFactory doas;
	
	@Before
	public void setUp() {
		doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	}
	
	// une classe = une classeTest et  une méthode = une méthodeTest

	
	@Test
	public void testCreateWork() {
		System.out.println("\nCreation fonctionne :");
		Client ctest1 = new Client("Aulner", "Gautier", 0, "35", "rue de la creation", "57535", "Marange", "France");

		assertTrue(doas.getClientDAO().create(ctest1));
		doas.getClientDAO().delete(ctest1);
	}
	

	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Client ctest1 = new Client("Aulner", "Gautier", 0, "35", "rue de la creation", "57535", "Marange", "France");
		int cle = doas.getClientDAO().createGetKey(ctest1);

		ctest1.setId_client(cle);
		Client ctest2 = doas.getClientDAO().getById(cle);
		assertTrue(doas.getClientDAO().delete(ctest2));
		
	}
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne : pas id:");
		
		Client ctest1 = new Client("Aulner", "Gautier", -1, "35", "rue de la destruction", "57535", "Marange", "France");

		assertFalse(doas.getClientDAO().delete(ctest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Client ctest1 = new Client("Aulner", "Gautier", -1, "35", "rue de la recherche", "57535", "Marange", "France");
		doas.getClientDAO().create(ctest1);
		int id = ctest1.getId_client();
		
		assertNotNull(doas.getClientDAO().getById(id));
		doas.getClientDAO().delete(ctest1);
		

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne : pas id:");
		
		int id = -1;
		Client ctest1 = doas.getClientDAO().getById(id);
		
		boolean rempli = ctest1.getNom()==null;
		assertTrue(rempli);
	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Client ctest1 = new Client("nom", "prenom", 0, "num", "rue", "code", "ville", "pays");
		int cle = doas.getClientDAO().createGetKey(ctest1);
		Client ctest2 = new Client("Nouveau nom", "Nouveau prenom", cle, "Nouveau num", "Nouvelle rue", "Nouveau code", "Nouvelle ville", "Nouveau pays");

		
		assertTrue(doas.getClientDAO().update(ctest2));
		doas.getClientDAO().delete(ctest2);

	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Client ctest1 = new Client("aul", "gau", -1, "35", "rue de la modification", "78951", "Porto", "Portugal");

		
		assertFalse(doas.getClientDAO().update(ctest1));

	}
	
	@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne :  pas de duplication :");
		
		Client ctest1 = new Client("Aulner", "Gautier", 0, "7", "rue de la modification", "57535", "Marange", "France");
		int cle = doas.getClientDAO().createGetKey(ctest1);
		Client ctest2 = doas.getClientDAO().getById(cle);
		
		String nomtest1 = ctest1.getNom();
		String nomtest2 = ctest2.getNom();
		
		String prenomtest1 = ctest1.getPrenom();
		String prenomtest2 = ctest2.getPrenom();
		
		String notest1 = ctest1.getNo_rue();
		String notest2 = ctest2.getNo_rue();
		
		String ruetest1 = ctest1.getVoie();
		String ruetest2 = ctest2.getVoie();
		
		String codetest1 = ctest1.getCode_p();
		String codetest2 = ctest2.getCode_p();
		
		String paystest1 = ctest1.getPays();
		String paystest2 = ctest2.getPays();
		
		String villetest1 = ctest1.getVille();
		String villetest2 = ctest2.getVille();
		
		if(nomtest1.equals(nomtest2) || prenomtest1.equals(prenomtest2) || notest1.equals(notest2) || ruetest1.equals(ruetest2) || codetest1.equals(codetest2) || 
				paystest1.equals(paystest2) || villetest1.equals(villetest2) ) {
			System.out.println("Le nom est le meme : le test foctionne");
			doas.getClientDAO().delete(ctest1);
			fail("Le nom est le meme");
		}
			


	}
	
}
