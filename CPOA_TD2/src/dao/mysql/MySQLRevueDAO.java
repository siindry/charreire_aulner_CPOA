package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IRevueDAO;
import dao.connexion.Connexion;
import metier.Revue;

public class MySQLRevueDAO implements IRevueDAO{
	
	private  static MySQLRevueDAO dao = null;
	
	public MySQLRevueDAO() {
		
	}
	
	public static IRevueDAO getInstance() {
		if(dao==null)
			dao = new MySQLRevueDAO();
		
		return dao;
	}
	
	public Revue getById(int id) {
		
		Revue r1 = new Revue(id, null, null, id, null, id);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue=?");
					requete.setInt(1 ,id);
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	r1.setId_revue(res.getInt("id_revue"));
			    System.out.println("id : " + r1.getId_revue() );
			    
			    r1.setTitre(res.getString("titre"));
			    System.out.println("titre : " + r1.getTitre() );
			    
			    r1.setDescription(res.getString("description"));
			    System.out.println("description : " + r1.getDescription() );
			    
			    r1.setTarif(res.getInt("tarif_numero"));
			    System.out.println("tarif_numero : " + r1.getTarif() );
			    
			    r1.setVisuel(res.getString("visuel"));
			    System.out.println("visuel : " + r1.getVisuel());
			    
			    r1.setId_periode(res.getInt("id_periodicite"));
			    System.out.println("id_periodicite : " + r1.getId_periode() );
			    

		    }
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		return r1;
		

	}







	public boolean create(Revue r1) {
		int i = 0;
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
	
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, r1.getDescription());
			req.setString(2, r1.getDescription());
			req.setDouble(3, r1.getTarif());
			req.setString(4, r1.getVisuel());
			req.setInt(5, r1.getId_periode());
				
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

	public boolean update(Revue r1) {
		int i = 0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Revue set titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? where id_revue=?");
			req.setString(1, r1.getTitre());
			req.setString(2, r1.getDescription());
			req.setDouble(3, r1.getTarif());
			req.setString(4, r1.getVisuel());
			req.setInt(5, r1.getId_periode());
			
			
			req.setInt(6, r1.getId_revue());

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



	public boolean delete(Revue r1) {
		int i = 0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			req.setInt(1, r1.getId_revue()); // 1 correspond au 1er para du where

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
}
