package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IClientDAO;
import dao.connexion.Connexion;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class MySQLClientDAO implements IClientDAO{
	
	
	private static IClientDAO dao = null;
	
	public MySQLClientDAO() {
		
	}
	
	public static IClientDAO getInstance() {
		if(dao==null)
			dao = new MySQLClientDAO();
		
		return dao;
	}
	
	public Client getById(int id) {
		
		Client c1 = new Client(null, null, id, null, null, null, null, null);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client=?");
					requete.setInt(1 ,id);
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	c1.setId_client(res.getInt("id_client"));
			    System.out.println("id : " + c1.getId_client() );
			    
			    c1.setNom(res.getString("nom"));
			    System.out.println("nom : " + c1.getNom() );
			    
			    c1.setPrenom(res.getString("prenom"));
			    System.out.println("prenom : " + c1.getPrenom() );
			    
			    c1.setNo_rue(res.getString("no_rue"));
			    System.out.println("no_rue : " + c1.getNo_rue() );
			    
			    c1.setVoie(res.getString("voie"));
			    System.out.println("voie : " + c1.getVoie() );
			    
			    c1.setCode_p(res.getString("code_postal"));
			    System.out.println("code_postal : " + c1.getCode_p() );
			    
			    c1.setVille(res.getString("ville"));
			    System.out.println("ville : " + c1.getVille() );
			    
			    c1.setPays(res.getString("pays"));
			    System.out.println("pays : " + c1.getPays() + "\n");
		    }
			
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		return c1;
		

	}


	public boolean create(Client c1) {
		int i = 0;
		
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
	
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom,prenom,no_rue,voie,code_postal,ville,pays) value(?,?,?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, c1.getNom());
			req.setString(2, c1.getPrenom());
			req.setString(3, c1.getNo_rue());
			req.setString(4, c1.getVoie());
			req.setString(5, c1.getCode_p());
			req.setString(6, c1.getVille());
			req.setString(7, c1.getPays());
				
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


	public boolean update(Client c1) {
		int i = 0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("update Client set nom=?, prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=? where id_client=?");
			req.setString(1, c1.getNom());
			req.setString(2, c1.getPrenom());
			req.setString(3, c1.getNo_rue());
			req.setString(4, c1.getVoie());
			req.setString(5, c1.getCode_p());
			req.setString(6, c1.getVille());
			req.setString(7, c1.getPays());
			
			req.setInt(8, c1.getId_client());

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


	public boolean delete(Client c1) {
		int i = 0;
		
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_Client=?");
			req.setInt(1, c1.getId_client()); // 1 correspond au 1er para du where

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
	
	
	public int createGetKey(Client c1) {

		int key = 0;
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
	
		
		try {
			PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom,prenom,no_rue,voie,code_postal,ville,pays) value(?,?,?,?,?,?,?)",
					 Statement.RETURN_GENERATED_KEYS);
			
			req.setString(1, c1.getNom());
			req.setString(2, c1.getPrenom());
			req.setString(3, c1.getNo_rue());
			req.setString(4, c1.getVoie());
			req.setString(5, c1.getCode_p());
			req.setString(6, c1.getVille());
			req.setString(7, c1.getPays());
			

			req.executeUpdate();
			ResultSet rs = req.getGeneratedKeys();

			while (rs.next()) {
				 key = rs.getInt(1); 
			}
			if (laConnexion != null) {
				System.out.println("Fermeture r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		System.out.println("key : " + key);
	    return key;

		
	}

	public boolean equals(Client obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public ArrayList<Client> findAll() {
		
		ArrayList<Client> listec = new ArrayList<Client>();
		Client c1 = new Client(null, null, 0, null, null, null, null, null);
		listec.add(c1);
		Connexion connection = new Connexion();
		Connection laConnexion = connection.creeConnexion();
		
		try {
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client");
					ResultSet res = requete.executeQuery();
	
		    while(res.next()) {
		    	
		    	c1.setId_client(res.getInt("id_client"));
			    System.out.println("id : " + c1.getId_client() );
			    
			    c1.setNom(res.getString("nom"));
			    System.out.println("nom : " + c1.getNom() );
			    
			    c1.setPrenom(res.getString("prenom"));
			    System.out.println("prenom : " + c1.getPrenom() );
			    
			    c1.setNo_rue(res.getString("no_rue"));
			    System.out.println("no_rue : " + c1.getNo_rue() );
			    
			    c1.setVoie(res.getString("voie"));
			    System.out.println("voie : " + c1.getVoie() );
			    
			    c1.setCode_p(res.getString("code_postal"));
			    System.out.println("code_postal : " + c1.getCode_p() );
			    
			    c1.setVille(res.getString("ville"));
			    System.out.println("ville : " + c1.getVille() );
			    
			    c1.setPays(res.getString("pays"));
			    System.out.println("pays : " + c1.getPays() + "\n");
			    
			    listec.add(c1);
		    }
			
			if (laConnexion != null) {
				System.out.println("Fermeture de la connexion r�ussie! ");
				laConnexion.close();
			}	
		} catch (SQLException sqle) {
			System.out.println("Pas connect�" + sqle.getMessage());
		}
		
		return listec;
	}
}
