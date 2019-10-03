package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.IPeriodiciteDAO;
import dao.connexion.Connexion;
import metier.Periodicite;

public class MySQLPeriodiciteDAO implements IPeriodiciteDAO{
	
	private  static MySQLPeriodiciteDAO dao = null;
	
	public MySQLPeriodiciteDAO() {
		
	}
	
	public static MySQLPeriodiciteDAO getInstance() {
		if(dao==null)
			dao = new MySQLPeriodiciteDAO();
		
		return dao;
	}
	
	
	public boolean create(Periodicite p1) {
		
		int i = 0;
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
	
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) value(?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, p1.getLibelle());
				
			i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
	    
	    if(i==0)
	    	return false;
	    else {
	    	return true;
	    }

	}




	public boolean update(Periodicite p1) {
		
		int i = 0;

		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where id_periodicite=?");
				
			req.setString(1, p1.getLibelle());
			req.setInt(2, p1.getId_periode());

			i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture r�ussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		 if(i==0)
		    	return false;
		    else {
		    	return true;
		    }
		
}
		
		
		
	


	public boolean delete(Periodicite p1) {
		
		int i =0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where libelle=?");
				
			req.setString(1, p1.getLibelle()); // 1 correspond au 1er para du where
			
			i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
	    if(i==0)
	    	return false;
	    else {
	    	return true;
	    }
		
		
	}

	


	public Periodicite getById(int id){
		
		Periodicite p1 = new Periodicite(0, null);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite,libelle from Periodicite where id_periodicite=?");
					requete.setInt(1, id);
					ResultSet res = requete.executeQuery();
					
		    while(res.next()) {
		    	System.out.println("Ligne trouvé : \n"); 
		    	
		         p1.setId_periode(res.getInt("id_periodicite"));
		         System.out.println("id : " + p1.getId_periode());
		         
		         p1.setLibelle(res.getString("libelle"));
		         System.out.println("libelle : " + p1.getLibelle() + "\n");
		    }
		    
		if (laConnexion != null) {
			System.out.println("Fermeture de la connexion r�ussie! ");
			laConnexion.close();
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		System.out.println("Souhaitez-vous selectionner une autre ligne ? : \n1 : oui \n2 : non");
		Scanner sc = new Scanner(System.in);
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.getById(id);
	    
		return p1;
	    
	}








	
	
}
