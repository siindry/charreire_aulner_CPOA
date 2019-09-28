package dao;


import java.sql.*;
import java.util.Scanner;

import metier.Connexion;
import metier.Periodicite;

public class PeriodiciteDAO implements DAO<Periodicite> {
	


	@Override
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



	@Override
	public boolean update(Periodicite p1) {
		
		int i = 1;

	
		Scanner sc = new Scanner(System.in);
		System.out.println("Avec quel mot souhaiter vous remplacer la p�riodicite '" + p1.getLibelle() + "' ?");
		String nom_ap = sc.nextLine();
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where libelle=?");
				
			req.setString(1, nom_ap);
			req.setString(2, p1.getLibelle());

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
		
		
		
	

	@Override
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

	

	@Override
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
