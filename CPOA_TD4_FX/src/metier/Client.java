package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.connexion.Connexion;

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
		sc.close();
		
		System.out.println("Souhaitez-vous supprimer une autre ligne ? : \n1 : oui \n2 : non");
	    int refaire = sc.nextInt();
	    if(refaire==1)
	    	this.suppClient();
	    sc.close();
	}
	
	
	
	public void selectClient() {
		


		
		
		
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
	
	
	
	
	
}
