package metier;


import java.sql.*;
import java.util.Scanner;

import dao.connexion.Connexion;

public class Periodicite {
	
	private int id_periode;
	private String libelle;

	
	public Periodicite(int id_periode, String libelle) {
		super();
		this.id_periode = id_periode;
		this.libelle = libelle;
	}
	
	public Periodicite(String libelle) {
		super();
		this.libelle = libelle;
	}
	

	public int getId_periode() {
		return id_periode;
	}


	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
	}



	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public void choixPeriode() {
		
		
		

		System.out.println("Que souhaitez-vous faire sur la table Periodicit�: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.S�lectionner \n 5.Afficher la table");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		switch(choix) {
		case "1": 
			break;
		case "2": this.modifPeriode();
			break;
		case "3": this.suppPeriode();
			break;
		case "4": this.selectPeriode();
			break;
		case "5": this.tablePeriode();
			break;
		default: System.out.println("Entr�e inconnue");
		
		}
		sc.close();
	}
	
	
	
	public void tablePeriode() {
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite");
					ResultSet res = requete.executeQuery();
	
			while(res.next()) {

				String id  = res.getString("id_periodicite");
			    System.out.println("	id : " + id );
			    
			    String lib  = res.getString("libelle");
			    System.out.println("	libelle : " + lib + "\n");
				
		    }

		if (laConnexion != null) {
			System.out.println("Fermeture de la connexion r�ussie! ");
			laConnexion.close();
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
	}
	
	
	
		
		
		
	
	public void suppPeriode(){
		
		System.out.println("Quel type de periodicit� souhaitez-vous supprimer ?");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		this.setLibelle(nom);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		sc.close();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where libelle=?");
				
			req.setString(1, this.getLibelle()); // 1 correspond au 1er para du where
			
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
	    	this.suppPeriode();
	}
	
	
	
	public void selectPeriode() {
		
		System.out.println("Quel type de periodicit� souhaitez-vous choisir ?");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		this.setLibelle(nom);
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		sc.close();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite,libelle from Periodicite where libelle=?");
					requete.setString(1, this.getLibelle());
					ResultSet res = requete.executeQuery();
					
		    while(res.next()) {
		    	 
		         int id  = res.getInt("id_periodicite");
		         System.out.println("id : " + id );
		         
		         String lib  = res.getString("libelle");
		         System.out.println("libelle : " + lib + "\n");
		    }
		    
		if (laConnexion != null) {
			System.out.println("Fermeture de la connexion r�ussie! ");
			laConnexion.close();
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		System.out.println("Souhaitez-vous selectionner une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.modifPeriode();

	}
	
	
	
	
	public void modifPeriode(){
			
			System.out.println("Quel type de periodicit� souhaitez-vous modifier ?");
			Scanner sc = new Scanner(System.in);
			String nom_av = sc.nextLine();
			this.setLibelle(nom_av);

			System.out.println("Avec quel mot souhaiter vous remplacer la p�riodicite '" + nom_av + "' ?");
			String nom_ap = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			sc.close();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle=? where libelle=?");
					
				req.setString(1, this.getLibelle()); // 1 correspond au 1er para du where
				req.setString(2, nom_av);
	
				int i = req.executeUpdate();
				System.out.println("ligne touch� : " + i);
				
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
				
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connect�" + sqle.getMessage());
			}
			
			System.out.println("Souhaitez-vous modifier une autre ligne ? : \n1 : oui \n2 : non");
		    int refaire = sc.nextInt();
		    if(refaire==1)
		    	this.modifPeriode();
			
	}
	
}
