package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import dao.IAbonnementDAO;
import dao.connexion.Connexion;
import metier.Abonnement;
import metier.Client;

public class MySQLAbonnementDAO implements IAbonnementDAO {
	
	private  static MySQLAbonnementDAO dao = null;
	
	public MySQLAbonnementDAO() {
		
	}
	
	public static IAbonnementDAO getInstance() {
		if(dao==null)
			dao = new MySQLAbonnementDAO();
		
		return dao;
	}
	
	
	public Abonnement getBy2Id(int id1, int id2) {
		
		Abonnement a1 = new Abonnement(id1, id2, null, null);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_client=? and id_revue=?");
					requete.setInt(1 ,id1);
					requete.setInt(2 ,id2);
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	a1.setIdCl(res.getInt("id_client"));
			    System.out.println("\nid client : " + a1.getIdCl() );
			    
			    a1.setIdRev(res.getInt("id_revue"));
			    System.out.println("id revue : " + a1.getIdRev() );
			    
			    LocalDate dateD = res.getDate("date_debut").toLocalDate();
			    a1.setDateDeb(dateD);
			    System.out.println("date début : " + a1.getDateDeb() );
			    
			    LocalDate dateF = res.getDate("date_debut").toLocalDate();
			    a1.setDateFin(dateF);
			    System.out.println("date fin : " + a1.getDateFin() + "\n");

		    }
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion réussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
		}
		
		return a1;
	}


	public boolean create(Abonnement a1) {
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		LocalDate date1 = a1.getDateDeb();
		LocalDate date2 = a1.getDateFin();
		
		java.sql.Date dateS = java.sql.Date.valueOf(date1);
		java.sql.Date dateU = java.sql.Date.valueOf(date2);
		


		
	    try {
	    	
				PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (id_client,id_revue,date_debut,date_fin) value(?,?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setInt(1, a1.getIdCl());
				req.setInt(2, a1.getIdRev());
				req.setDate(3, dateS);
				req.setDate(4, dateU);
				
				int i = req.executeUpdate();
				System.out.println("ligne touchï¿½ : " + i);
				
				if (laConnexion != null) {
					System.out.println("Fermeture rï¿½ussie! ");
					laConnexion.close();
				}	
				
			} catch (SQLException sqle) {
				System.out.println("Erreur : " + sqle.getMessage());
				return false;
		}
		return true;
	}


	public boolean update(Abonnement a1) {
		
		int i = 0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		
		LocalDate date1 = a1.getDateDeb();
		LocalDate date2 = a1.getDateFin();
		
		java.sql.Date dateDeb = java.sql.Date.valueOf(date1);
		java.sql.Date dateFin = java.sql.Date.valueOf(date2);
		
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Abonnement set date_debut=?,date_fin=? where id_client=? and id_revue=?");
			req.setDate(1, dateDeb);
			req.setDate(2, dateFin);
			req.setInt(3, a1.getIdCl());
			req.setInt(4, a1.getIdRev());

			
			

			i = req.executeUpdate();
			System.out.println("ligne touchï¿½ : " + i);
			
		if (laConnexion != null) {
			System.out.println("Fermeture rï¿½ussie! ");
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


	public boolean delete(Abonnement a1) {
		
		int i =0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_client=? and id_revue=?");
				
			req.setInt(1, a1.getIdCl()); // 1 correspond au 1er para du where
			req.setInt(2, a1.getIdRev());

			i = req.executeUpdate();
			System.out.println("ligne touchï¿½ : " + i);
			
			if (laConnexion != null) {
				System.out.println("Fermeture rï¿½ussie! ");
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


	@Override
	public ArrayList<Abonnement> findAll() {
		
		ArrayList<Abonnement> listea = new ArrayList<Abonnement>();
		Abonnement a1 = new Abonnement(0, 0, null, null);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement");
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	a1.setIdCl(res.getInt("id_client"));
			    System.out.println("\nid client : " + a1.getIdCl() );
			    
			    a1.setIdRev(res.getInt("id_revue"));
			    System.out.println("id revue : " + a1.getIdRev() );
			    
			    LocalDate dateD = res.getDate("date_debut").toLocalDate();
			    a1.setDateDeb(dateD);
			    System.out.println("date début : " + a1.getDateDeb() );
			    
			    LocalDate dateF = res.getDate("date_debut").toLocalDate();
			    a1.setDateFin(dateF);
			    System.out.println("date fin : " + a1.getDateFin() + "\n");
			    
			    listea.add(a1);

		    }
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion réussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Erreur : " + sqle.getMessage());
		}
		return listea;
	}


	@Override
	public Abonnement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> createGetKey(Abonnement a1) {
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		LocalDate date1 = a1.getDateDeb();
		LocalDate date2 = a1.getDateFin();
		
		java.sql.Date dateS = java.sql.Date.valueOf(date1);
		java.sql.Date dateU = java.sql.Date.valueOf(date2);
		


		
	    try {
	    	
				PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (id_client,id_revue,date_debut,date_fin) value(?,?,?,?)",
						 Statement.RETURN_GENERATED_KEYS);
				
				req.setInt(1, a1.getIdCl());
				req.setInt(2, a1.getIdRev());
				req.setDate(3, dateS);
				req.setDate(4, dateU);
				
				req.executeUpdate();
				ResultSet rs = req.getGeneratedKeys();

				while (rs.next()) {
					 int cle1 = rs.getInt(1);
					 keys.add(cle1);
					 int cle2 = rs.getInt(2);
					 keys.add(cle2);
				}
				
				if (laConnexion != null) {
					System.out.println("Fermeture rï¿½ussie! ");
					laConnexion.close();
				}	
				
			} catch (SQLException sqle) {
				System.out.println("Erreur : " + sqle.getMessage());
		}
		return keys;
	}

}
