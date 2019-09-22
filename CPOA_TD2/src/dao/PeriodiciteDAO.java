package dao;


import java.sql.*;
import java.util.Scanner;

import metier.Connexion;
import metier.Periodicite;

public class PeriodiciteDAO implements DAO<Periodicite> {
	


	@Override
	public boolean create(Periodicite objet) {
		
		int i = 0;
		
		Periodicite p1 = new Periodicite(i, null);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		System.out.println("Quel type de periodicit� souhaitez-vous ajouter ?");
		Scanner sc = new Scanner(System.in);
		String nm = sc.nextLine();
		p1.setLibelle(nm);
		
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
		
		System.out.println("Souhaitez-vous ins�rer une nouvelle ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    
	    if(i==0)
	    	return false;
	    else {
	    	return true;
	    }

	}



	@Override
	public boolean update(Periodicite objet) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public boolean delete(Periodicite objet) {
		// TODO Stub de la méthode généré automatiquement
		return false;
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

	/*@Override
	public boolean update(Periodicite objet) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public boolean delete(Periodicite objet) {
		
		Periodicite p1 = null;
		
		System.out.println("Quel type de periodicit� souhaitez-vous supprimer ?");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		p1.setLibelle(nom);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where libelle=?");
				
			req.setString(1, p1.getLibelle()); // 1 correspond au 1er para du where
			
			int i = req.executeUpdate();
			System.out.println("ligne touch� : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		System.out.println("Souhaitez-vous supprimer une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	p1.suppPeriode();
		
	}*/


	
}
