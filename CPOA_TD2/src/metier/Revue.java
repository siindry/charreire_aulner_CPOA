package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import metier.Revue;

public class Revue {

	private int id_revue;
	private String titre;
	private String description;
	private double tarif;
	private String visuel;
	private int id_periode;
	
	
		public Revue(int id_revue, String titre, String description, double tarif, String visuel, int id_periode) {
		super();
		this.id_revue = id_revue;
		this.titre = titre;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.id_periode = id_periode;
	}
		
		public int getId_revue() {
			return id_revue;
		}
		
		public void setId_revue(int id_revue) {
			this.id_revue = id_revue;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getTarif() {
			return tarif;
		}

		public void setTarif(double tarif) {
			this.tarif = tarif;
		}

		public String getVisuel() {
			return visuel;
		}

		public void setVisuel(String visuel) {
			this.visuel = visuel;
		}

		public int getId_periode() {
			return id_periode;
		}

		public void setId_periode(int id_periode) {
			this.id_periode = id_periode;
		}

		
		
		public void choixRevue() {
			
			
			System.out.println("Que souhaitez-vous faire sur la table Revue: \n 1.Ajouter \n 2.Modifier "
					+ "\n 3.Supprimer \n 4.S�lectionner \n 5.Afficher la table");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			
			switch(choix) {
			case "1": this.insereRevue();
				break;
			case "2": this.modifRevue();
				break;
			case "3": this.suppRevue();
				break;
			case "4": this.selectRevue();
				break;
			case "5": this.tableRevue();
				break;
			default: System.out.println("Entr�e inconnue");
			
			}	
			
			
		}
		
		public int rechIdPeriode(String a) {
			
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
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
				
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connect�" + sqle.getMessage());
			}
			
			return sauv;
		}
		
		public void tableRevue() {
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement requete = laConnexion.prepareStatement("select * from Revue");
						ResultSet res = requete.executeQuery();
		
				while(res.next()) {
	
					String id  = res.getString("id_revue");
				    System.out.println("	id : " + id );
				    
				    String titre  = res.getString("titre");
				    System.out.println("	titre : " + titre );
				    
				    String desc  = res.getString("description");
				    System.out.println("	description : " + desc );
				    
				    String tar  = res.getString("tarif_numero");
				    System.out.println("	tarif : " + tar );
				    
				    String visu  = res.getString("visuel");
				    System.out.println("	visuel : " + visu );
				    
				    String id_p  = res.getString("id_periodicite");
				    System.out.println("	id_periodicite : " + visu + "\n");
					
			    }

			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connect�" + sqle.getMessage());
			}
			
		}
		
		
		
		
		
		public void insereRevue(){
			
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			System.out.println("Entrez une information par ligne ces informations suivantes : titre, description, tarif du nemoro, visuel, son type periodicite commencant par une maj :");
			Scanner sc = new Scanner(System.in);
			String titre = sc.nextLine();
			this.setTitre(titre);
			String desc = sc.nextLine();
			this.setDescription(desc);
			String tar = sc.nextLine();
			String vis = sc.nextLine();
			this.setVisuel(vis);
			String type_p = sc.nextLine();
			this.setId_periode(id_periode);
			
			double tarif = Float.parseFloat(tar);
			this.setTarif(tarif);
			
			try {
				
				
				
	    
			    PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setString(1, this.getDescription());
				req.setString(2, this.getDescription());
				req.setDouble(3, this.getTarif());
				req.setString(4, this.getVisuel());
				req.setInt(5, this.rechIdPeriode(String.valueOf(this.getId_periode())));

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
		    	this.insereRevue();
		} 
			
			
			
		
		public void suppRevue(){
			
			this.tableRevue();
			
			System.out.println("Mettez le num�ro de la revue que vous souhaitez supprimer?");
			Scanner sc = new Scanner(System.in);
			this.setId_revue(sc.nextInt());
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
				req.setInt(1, this.getId_revue()); // 1 correspond au 1er para du where

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
		    	this.suppRevue();
		}
		
		
		
		public void selectRevue() {
			
			System.out.println("Voici le tableau des revues :");
			this.tableRevue();
			
			System.out.println("Mettez le num�ro pour le titre que vous voulez choisir ?");
			
			Scanner sc = new Scanner(System.in);
			
			this.setId_revue(sc.nextInt());
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue=?");
						requete.setInt(1, this.getId_revue());
						ResultSet res = requete.executeQuery();

			    while(res.next()) {
			    	
			    	String id  = res.getString("id_revue");
				    System.out.println("id : " + id );
				    
				    String tit  = res.getString("titre");
				    System.out.println("titre : " + tit );
				    
				    String desc  = res.getString("description");
				    System.out.println("description : " + desc );
				    
				    double tar  = res.getDouble("tarif_numero");
				    System.out.println("tarif : " + tar );
				    
				    String visu  = res.getString("visuel");
				    System.out.println("visuel : " + visu );
				    
				    int id_p  = res.getInt("id_periodicite");
				    System.out.println("id_periodicite : " + id_p + "\n");
			    }
			    
			    
			    
			    
				
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
				
			}	
			} catch (SQLException sqle) {
				System.out.println("Pas connect�" + sqle.getMessage());
				
			
			}
			
			
		}
		
		
		
		
		public void modifRevue(){
				
				System.out.println("Quel donn�e de Revue souhaitez-vous modifier ? \n Entrer son titre puis sa description");
				Scanner sc = new Scanner(System.in);
				this.setTitre(sc.nextLine());
				this.setDescription(sc.nextLine());
				
				System.out.println("Avec quel mot souhaiter vous remplacer le titre :'" + titre + "' et la description : '" + getDescription() + "' ?");
				String titre_ap = sc.nextLine();
				String desc_ap = sc.nextLine();
				
				Connexion connection = new Connexion();
				Connection laConnexion = connection.creeConnexion();
				
				try {
					PreparedStatement req = laConnexion.prepareStatement("update Revue set titre=?, description=? where titre=? and description=?");
						
					req.setString(1, titre_ap); // 1 correspond au 1er para du where
					req.setString(2, desc_ap);
					req.setString(3, this.getTitre());
					req.setString(4, this.getDescription());
		
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
			    	this.modifRevue();
			}
	
}
