package magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client {
	
	public void choixClient() {
		
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner \n 5.Afficher la table");
		
		Scanner sc = new Scanner(System.in);
		
		String choix = sc.nextLine();
		switch(choix) {
		case "1": this.insereClient();
			break;
		case "2": this.modifClient();
			break;
		case "3": this.suppClient();
			break;
		case "4": this.selectClient();
			break;
		case "5": this.tableClient();
		break;
		default: System.out.println("Entrée inconnue");
		
		}
		
		
	}
	
	/*public int rechIdPeriode(String a) {
		
		int sauv = 0;
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select id_periodicite from Periodicite where libelle=?");
					requete.setString(1, a);
					ResultSet res = requete.executeQuery();
					
			
	
			while(res.next()) {

			    int id  = res.getInt("id_periodicite");
			    sauv = id;
			    System.out.println("id : " + id );
				
		    }

					

			
		if (laConnexion != null) {
			System.out.println("Fermeture de la co réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		return sauv;
	}*/
	
	public void tableClient() {
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client");
					ResultSet res = requete.executeQuery();
					
			
	
			while(res.next()) {

				String id  = res.getString("id_client");
			    System.out.println("	id : " + id );
			    
			    String nom  = res.getString("nom");
			    System.out.println("	nom : " + nom );
			    
			    String pre  = res.getString("prenom");
			    System.out.println("	prenom : " + pre );
			    
			    String nrue  = res.getString("no_rue");
			    System.out.println("	no_rue : " + nrue );
			    
			    String voie  = res.getString("voie");
			    System.out.println("	voie : " + voie );
			    
			    String code_p  = res.getString("code_postal");
			    System.out.println("	code_postal : " + code_p);
			    
			    String ville  = res.getString("ville");
			    System.out.println("	ville : " + ville);
			    
			    String pays  = res.getString("pays");
			    System.out.println("	pays : " + pays + "\n");
			    
				
		    }

					

			
		if (laConnexion != null) {
			System.out.println("Fermeture de la co réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
	}
	
	
	
	
	
	public void insereClient(){
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		System.out.println("Entrez une information par ligne ces informations suivantes : nom, prenom, no de rue\n , voie, code postal, ville, pays dans l'ordre et en commencant par une maj :");
		
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.nextLine();
		String prenom = sc.nextLine();
		String no_rue = sc.nextLine();
		String voie = sc.nextLine();
		String code_p = sc.nextLine();
		String ville = sc.nextLine();
		String pays = sc.nextLine();
		
		
		try {
			
			
			
    
		    PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, nom);
			req.setString(2, prenom);
			req.setString(3, no_rue);
			req.setString(4, voie);
			req.setString(5, code_p);
			req.setString(6, ville);
			req.setString(7, pays);

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture réussie! ");
				laConnexion.close();
			}

		
				
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("Souhaitez-vous inserer une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.insereClient();
		
		
	} 
		
		
		
	
	public void suppClient(){
		
		this.tableClient();
		
		System.out.println("Mettez le numéro de la Client que vous souhaitez supprimer?");
		
		Scanner sc = new Scanner(System.in);
		
		String id = sc.nextLine();
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_Client=?");
				
			req.setString(1, id); // 1 correspond au 1er para du where

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture réussie! ");
			laConnexion.close();
			
		}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
			
		
		}
		
		System.out.println("Souhaitez-vous supprimer une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.suppClient();
		
		
		}
	
	
	
public void selectClient() {
		
		System.out.println("Voici le tableau des Clients :");
		this.tableClient();
		
		System.out.println("Mettez le numéro pour le client que vous voulez choisir ?");
		Scanner sc = new Scanner(System.in);
		String titre = sc.nextLine();
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client=?");
					requete.setString(1, titre);
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	String id  = res.getString("id_client");
			    System.out.println("	id : " + id );
			    
			    String nom  = res.getString("nom");
			    System.out.println("	nom : " + nom );
			    
			    String prenom  = res.getString("prenom");
			    System.out.println("	prenom : " + prenom );
			    
			    String nr  = res.getString("no_rue");
			    System.out.println("	no_rue : " + nr );
			    
			    String voie  = res.getString("voie");
			    System.out.println("	voie : " + voie );
			    
			    String id_p  = res.getString("code_postal");
			    System.out.println("	code_postal : " + id_p );
			    
			    String ville  = res.getString("ville");
			    System.out.println("	ville : " + ville );
			    
			    String pays  = res.getString("pays");
			    System.out.println("	pays : " + pays + "\n");
		    }
			
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion réussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
		}
	}
	
	
	
	
	public void modifClient(){
		
		this.tableClient();
		
		System.out.println("Quelle donnée souhaitez-vous modifier parmi (recopier exactement le terme) : \nnom \nprenom \nno_rue \nvoie \ncode_postal \nville \npays \ncode_postal");
		Scanner sc = new Scanner(System.in);
		String col = sc.nextLine();
		
		System.out.println("Entrez l'id da votre ligne :");
		String num = sc.nextLine();
		
		System.out.println("Par quel mot ? : ");
		String val_ap = sc.nextLine();
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Client set " + col + "=? where id_client=?");
			req.setString(1, val_ap); // 1 correspond au 1er para du where
			req.setString(2, num);

			int i = req.executeUpdate();
			System.out.println("ligne touché : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture réussie! ");
			laConnexion.close();
		}	
		
		} catch (SQLException sqle) {
			System.out.println("Pas connecté" + sqle.getMessage());
		}
		
		System.out.println("Souhaitez-vous modifier une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.modifClient();

}
}
