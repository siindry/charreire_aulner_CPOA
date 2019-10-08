package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
		Client ptest1 = new Client("aul", "gau", 0, "35", "rue de la creation", "57535", "paradis", "jesaispas");

		assertTrue(doas.getClientDAO().create(ptest1));
	}
	

	
	@Test
	public void testDeleteWork() {
		
		System.out.println("\nSuppression fonctionne :");
		
		Client ptest1 = new Client("aul", "gau", 0, "35", "rue de la creation", "57535", "paradis", "jesaispas");
		int cle = doas.getClientDAO().createGetKey(ptest1);

		ptest1.setId_client(cle);
		Client ptest2 = doas.getClientDAO().getById(cle);
		assertTrue(doas.getClientDAO().delete(ptest2));
	}
	
	@Test
	public void testDeleteNotWorkNoId() {
		
		System.out.println("\nSuppression fonctionne pas id:");
		
		Client ptest1 = new Client("aul", "gau", -1, "35", "rue de la destrucution", "57535", "enfer", "jesaispas");

		assertFalse(doas.getClientDAO().delete(ptest1));
	}


	
	@Test
	public void testGetWork() {
		
		System.out.println("\nRecherche fonctionne :");
		
		Client ptest1 = new Client("aul", "gau", -1, "35", "rue de la recherche", "75000", "enfer", "jesaispas");
		doas.getClientDAO().create(ptest1);
		int id = ptest1.getId_client();
		
		assertNotNull(doas.getClientDAO().getById(id));

	}
	
	@Test
	public void testGetNotWorkNoId() {
		
		System.out.println("\nRecherche fonctionne pas id:");
		
		int id = -1;
		
		assertNull(doas.getClientDAO().getById(id));

	}
	
	@Test
	public void testUpdateWork() {
		
		System.out.println("\nModification fonctionne :");
		
		Client ptest1 = new Client("aul", "gau", 7, "35", "rue de la modification", "78951", "Porto", "Portugal");

		
		assertTrue(doas.getClientDAO().update(ptest1));

	}
	
	@Test
	public void testUpdateNotWorkNoId() {
		
		System.out.println("\nModification fonctionne pas id :");
		
		Client ptest1 = new Client("aul", "gau", -1, "35", "rue de la modification", "78951", "Porto", "Portugal");

		
		assertFalse(doas.getClientDAO().update(ptest1));

	}
	
	@Test
	public void testUpdateNotWorkDup() {
		
		System.out.println("\nModification fonctionne pas dup :");
		
		Client ptest1 = new Client("auln", "gaut", 7, "77", "rue de la modification", "78951", "Porto", "Portugal");
		int cle = doas.getClientDAO().createGetKey(ptest1);
		Client ptest2 = doas.getClientDAO().getById(cle);
		
		String nomtest1 = ptest1.getNom();
		String nomtest2 = ptest2.getNom();
		
		String prenomtest1 = ptest1.getPrenom();
		String prenomtest2 = ptest2.getPrenom();
		
		String notest1 = ptest1.getNo_rue();
		String notest2 = ptest2.getNo_rue();
		
		String ruetest1 = ptest1.getVoie();
		String ruetest2 = ptest2.getVoie();
		
		String codetest1 = ptest1.getCode_p();
		String codetest2 = ptest2.getCode_p();
		
		String paystest1 = ptest1.getPays();
		String paystest2 = ptest2.getPays();
		
		String villetest1 = ptest1.getVille();
		String villetest2 = ptest2.getVille();
		
		if(nomtest1.equals(nomtest2) || prenomtest1.equals(prenomtest2) || notest1.equals(notest2) || ruetest1.equals(ruetest2) || codetest1.equals(codetest2) || 
				paystest1.equals(paystest2) || villetest1.equals(villetest2) ) {
			fail("Le nom est le meme");
		}
			


	}
	
}
