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



	public String toString() {
		return  nom + ", " + prenom + ", " + no_rue + ", " + voie + ", "
				+ code_p + ", " + ville + ", " + pays;
	}

	
	
	
}