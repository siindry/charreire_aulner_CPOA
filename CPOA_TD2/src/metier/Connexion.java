package metier;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Connexion {

	
	

	public Connection creeConnexion() {
		
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/aulner4u_db_cpoa1";
		url +=  "?serverTimezone=Europe/Paris";
		String login = "aulner4u_appli";
		String pwd = "Diablo57000";
		Connection maConnection = null;

		try {
			maConnection = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnection;
	}


	}
	
	
	


