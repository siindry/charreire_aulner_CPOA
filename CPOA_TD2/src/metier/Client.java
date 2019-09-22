package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client {
	
	private String nom;
	private String prenom;
	private int id_client;
	private String no_rue;
	private String voie;
	private String code_p;
	private String ville;
	private String pays;
	
	
	
	
	public Client(String nom, String prenom, int id_client, String no_rue, String voie, String code_p, String ville,
			String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id_client = id_client;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_p = code_p;
		this.ville = ville;
		this.pays = pays;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNo_rue() {
		return no_rue;
	}

	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCode_p() {
		return code_p;
	}

	public void setCode_p(String code_p) {
		this.code_p = code_p;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void choixClient() {
		
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.S�lectionner \n 5.Afficher la table");
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
		default: System.out.println("Entr�e inconnue");
		
		}
		
		
	}
	
	
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
			System.out.println("Fermeture de la connexion r�ussie! ");
			laConnexion.close();
		}	
		
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
	}
	
	
	
	
	
	public void insereClient(){
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		System.out.println("Entrez une information par ligne ces informations suivantes : nom, prenom, no de rue\n , voie, code postal, ville, pays dans l'ordre et en commencant par une maj :");
		Scanner sc = new Scanner(System.in);
		this.setNom(sc.nextLine());
		this.setPrenom(sc.nextLine());
		this.setNo_rue(sc.nextLine());
		this.setVoie(sc.nextLine());
		this.setCode_p(sc.nextLine());
		this.setVille(sc.nextLine());
		this.setPays(sc.nextLine());
		
		try {

		    PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, this.getNom());
			req.setString(2, this.getPrenom());
			req.setString(3, this.getNo_rue());
			req.setString(4, this.getVoie());
			req.setString(5, this.getCode_p());
			req.setString(6, this.getVille());
			req.setString(7, this.getPays());

			int i = req.executeUpdate();
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
	    if(refaire==1)
	    	this.insereClient();
	} 
		
		
		
	
	public void suppClient(){
		
		this.tableClient();
		
		System.out.println("Mettez le num�ro de Client que vous souhaitez supprimer?");
		Scanner sc = new Scanner(System.in);
		this.setId_client(sc.nextInt());

		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_Client=?");
			req.setInt(1, this.getId_client()); // 1 correspond au 1er para du where

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
	    	this.suppClient();
	}
	
	
	
	public void selectClient() {
		
		System.out.println("Voici le tableau des Clients :");
		this.tableClient();
		
		System.out.println("Mettez le num�ro pour le client que vous voulez choisir ?");
		Scanner sc = new Scanner(System.in);
		this.setId_client(sc.nextInt());
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client=?");
					requete.setInt(1, this.getId_client());
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	String id  = res.getString("id_client");
			    System.out.println("id : " + id );
			    
			    String nom  = res.getString("nom");
			    System.out.println("nom : " + nom );
			    
			    String prenom  = res.getString("prenom");
			    System.out.println("prenom : " + prenom );
			    
			    String nr  = res.getString("no_rue");
			    System.out.println("no_rue : " + nr );
			    
			    String voie  = res.getString("voie");
			    System.out.println("voie : " + voie );
			    
			    String id_p  = res.getString("code_postal");
			    System.out.println("code_postal : " + id_p );
			    
			    String ville  = res.getString("ville");
			    System.out.println("ville : " + ville );
			    
			    String pays  = res.getString("pays");
			    System.out.println("pays : " + pays + "\n");
		    }
			
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
	}
	
	
	
	
	public void modifClient(){
		
			this.tableClient();
			
			System.out.println("Quelle donn�e souhaitez-vous modifier parmi (recopier exactement le terme) : \nnom \nprenom \nno_rue \nvoie \ncode_postal \nville \npays \ncode_postal");
			Scanner sc = new Scanner(System.in);
			String col = sc.nextLine();
			
			System.out.println("Entrez l'id da votre ligne :");
			this.setId_client(sc.nextInt());
			
			System.out.println("Par quel mot ? : ");
			String val_ap = sc.nextLine();
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("update Client set " + col + "=? where id_client=?");
				req.setString(1, val_ap); // 1 correspond au 1er para du where
				req.setInt(2, this.getId_client());
	
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
		    	this.modifClient();

	}
}
