package metier;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Abonnement{
	
	private int idCl;
	private int idRev;
	private Date dateDeb;
	private Date dateFin;
	
	
	public Abonnement(int idCl, int idRev, Date dateDeb, Date dateFin) {
		super();
		this.idCl = idCl;
		this.idRev = idRev;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}
	
	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	public int getIdRev() {
		return idRev;
	}

	public void setIdRev(int idRev) {
		this.idRev = idRev;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	

	public void tableAbo() {
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement");
					ResultSet res = requete.executeQuery();
					
			while(res.next()) {

				String id  = res.getString("id_client");
			    System.out.println("	id du client : " + id );
			    
			    String nom  = res.getString("id_revue");
			    System.out.println("	id de la revue : " + nom );
			    
			    java.sql.Date dateD  = res.getDate("date_debut");
			    System.out.println("	date d�but : " + dateD );
			    
			    java.sql.Date dateF  = res.getDate("date_fin");
			    System.out.println("	date fin : " + dateF + "\n");
		    }
			
		if (laConnexion != null) {
			System.out.println("Fermeture de la connexion r�ussie! ");
			laConnexion.close();
		}	
		
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
	}
		public void choixAbo() throws Exception {

			System.out.println("Que souhaitez-vous faire sur la table Abonnement�: \n 1.Ajouter \n 2.Modifier "
					+ "\n 3.Supprimer \n 4.Afficher la table");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			
			switch(choix) {
			case "1": this.insereAbo();
				break;
			case "2": this.modifAbo();
				break;
			case "3": this.suppAbo();
				break;
			case "4": this.tableAbo();
				break;
			default: System.out.println("Entr�e inconnue");
			
			}
			
			
		}
		
		public Date lireDate() throws Exception{
		    String dateFormat = "dd-MM-yyyy";
		    Scanner scanner = new Scanner(System.in);
		    Date date1 = new SimpleDateFormat(dateFormat).parse(scanner.nextLine());
		    return date1;
		}
		
		private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
	        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	        return sDate;
	    }
		
		
		
		public void insereAbo() throws Exception{

				Connexion connection = new Connexion();
				Connection laConnexion = connection.creeConnexion();
				
				System.out.println("Ecrivez dans l'ordre les suivantes que souhaitez-vous ajouter ? id_client, id_revue, date_debut et date_fin au fromat (JJ-MM-AAAA)");
				
				Scanner sc = new Scanner(System.in);
				
				this.setIdCl(sc.nextInt());
				this.setIdRev(sc.nextInt());
				
				Date date1 = this.lireDate();
				java.sql.Date sDate = convertUtilToSql(date1);
				System.out.println(sDate);
				
				Date date2 = this.lireDate();
				java.sql.Date uDate = convertUtilToSql(date2);
				System.out.println(uDate);
				
				this.setDateDeb(uDate);
				this.setDateFin(sDate);
				
			    try {
			    	
						PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (id_client, id_revue, date_debut, date_fin) value(?,?,?,?)",
								 Statement.RETURN_GENERATED_KEYS);
						
						req.setInt(1, idCl);
						req.setInt(2, idRev);
						req.setDate(3, sDate);
						req.setDate(4, uDate);
						
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
			    	this.insereAbo();

			}
		
		public void suppAbo(){
			
			this.tableAbo();
			
			System.out.println("Quel type de Abonnement (avec id_client puis id_revue) souhaitez-vous supprimer ?");
			
			Scanner sc = new Scanner(System.in);
			
			this.setIdCl(sc.nextInt());
			this.setIdRev(sc.nextInt());
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_client=? and id_revue=?");
					
				req.setInt(1, getIdCl()); // 1 correspond au 1er para du where
				req.setInt(2, getIdRev());

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
		    	this.suppAbo();
		}
		
		public void modifAbo() throws Exception {
			
			this.tableAbo();
			
			System.out.println("Quelle donn�e souhaitez-vous modifier parmi (recopier exactement le terme) : \ndate_debut \ndate_fin");
			Scanner sc = new Scanner(System.in);
			String col = sc.nextLine();
			
			System.out.println("Entrez l'id du client et celui de la revue da la ligne � modifier:");
			this.setIdCl(sc.nextInt());
			this.setIdRev(sc.nextInt());
			
			System.out.println("Par quel date ? : ");
			Date date1 = this.lireDate();
			java.sql.Date sDate = convertUtilToSql(date1);
			System.out.println(sDate);
			
			Connexion connection = new Connexion();
			Connection laConnexion = connection.creeConnexion();
			
			try {
				PreparedStatement req = laConnexion.prepareStatement("update Abonnement set " + col + "=? where id_client=? and id_revue=?");
					
				req.setDate(1, sDate);
				req.setInt(2, getIdCl());
				req.setInt(3, getIdRev());
	
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
		    	this.modifAbo();

		}
		
}
