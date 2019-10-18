package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import dao.IPeriodiciteDAO;
import dao.connexion.Connexion;

import metier.Periodicite;

public class MySQLPeriodiciteDAO implements IPeriodiciteDAO{
	
	private  static MySQLPeriodiciteDAO dao = null;
	
	public MySQLPeriodiciteDAO() {
		
	}
	
	public static IPeriodiciteDAO getInstance() {
		if(dao==null)
			dao = new MySQLPeriodiciteDAO();
		
		return dao;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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
			System.out.println("Erreur : " + sqle.getMessage());
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
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where id_periodicite=?", Statement.RETURN_GENERATED_KEYS);
				
			req.setString(1, p1.getLibelle());
			req.setInt(2, p1.getId_periode());

			i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture r�ussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
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
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
				
			req.setInt(1, p1.getId_periode()); // 1 correspond au 1er para du where
			
			i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
		}
	    if(i==0)
	    	return false;
	    else {
	    	return true;
	    }
		
		
	}

	


	public Periodicite getById(int id){
		
		Periodicite p1 = new Periodicite(id, "");
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();

		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite,libelle from Periodicite where id_periodicite=?");
					requete.setInt(1, id);
					ResultSet res = requete.executeQuery();

					
		    if(res.next()) {
		    	p1 = new Periodicite(0, null);
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
			System.out.println("Erreur : " + sqle.getMessage());
		}
		

		return p1;
	}

	public int createGetKey(Periodicite p1) {

		int key = 0;
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
	
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) value(?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, p1.getLibelle());
			

			req.executeUpdate();
			ResultSet rs = req.getGeneratedKeys();

			while (rs.next()) {
				 key = rs.getInt(1); 
			}
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
		}
		System.out.println("key : " + key);
	    return key;

		
	}

	public boolean equals(Periodicite obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public ArrayList<String> findAllStr() {
		
		ArrayList<String> listec = new ArrayList<String>();
		Periodicite c1 = new Periodicite(0, null);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite");
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	c1.setId_periode(res.getInt("id_periodicite"));
			    System.out.println("id : " + c1.getId_periode() );
			    
			    c1.setLibelle(res.getString("libelle"));
			    System.out.println("nom : " + c1.getLibelle() + "\n");
			    
			    listec.add(c1.getLibelle());
		    }
			
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
		}
		
		return listec;
	}

	@Override
	public ArrayList<Periodicite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Periodicite getByLib(String lib) {
		Periodicite p1 = new Periodicite(0, null);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();

		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite,libelle from Periodicite where libelle=?");
					requete.setString(1, lib);
					ResultSet res = requete.executeQuery();

					
		    if(res.next()) {
		    	p1 = new Periodicite(0, null);
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
			System.out.println("Erreur : " + sqle.getMessage());
		}
		

		return p1;
	}
	
	





	
	
}
