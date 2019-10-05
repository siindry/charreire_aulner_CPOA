package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.connexion.Connexion;
import dao.factory.DAOFactory;
import dao.mysql.MySQLPeriodiciteDAO;
import enumeration.EPersistance;
import metier.Periodicite;

class MySQLPeriodiciteDAOTest {
	

	
	
	// une classe = une classeTest et  une méthode = une méthodeTest

	
	@Test
	void testCreateWork() {
		DAOFactory doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		Periodicite ptest1 = new Periodicite(0,"Trimestriel");
		
		assertTrue(doas.getPeriodiciteDAO().create(ptest1));
	}
	


}
