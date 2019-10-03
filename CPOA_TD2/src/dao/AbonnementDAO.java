package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import metier.Abonnement;
import metier.Connexion;


public class AbonnementDAO implements DAO<Abonnement> {

	@Override
	public Abonnement getById(int id) {
		
		Abonnement a1 = new Abonnement(id, id, null, null);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where and id_client=?");
					requete.setInt(1 ,id);
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	a1.setIdCl(res.getInt("id_client"));
			    System.out.println("id client : " + a1.getIdCl() );
			    
			    a1.setIdRev(res.getInt("id_revue"));
			    System.out.println("id revue : " + a1.getIdRev() );
			    
			    Date dateD = res.getDate("date_debut");
			    LocalDate dateD1 = dateD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			    a1.setDateDeb(dateD1);
			    System.out.println("date début : " + a1.getDateDeb() );
			    
			    Date dateF = res.getDate("date_debut");
			    LocalDate dateF1 = dateF.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			    a1.setDateFin(dateF1);
			    System.out.println("date fin : " + a1.getDateFin() );

		    }
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion rï¿½ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connectï¿½" + sqle.getMessage());
		}
		
		return a1;
	}

	@Override
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
				System.out.println("Pas connectï¿½" + sqle.getMessage());
		}
		return false;
	}

	@Override
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
			System.out.println("Pas connectï¿½" + sqle.getMessage());
		}
		
		if(i==0)
	    	return false;
	    else {
	    	return true;
	    }
	}

	@Override
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
			System.out.println("Pas connectï¿½" + sqle.getMessage());
		}
		
		if(i==0)
	    	return false;
	    else {
	    	return true;
	    }
	}

}
