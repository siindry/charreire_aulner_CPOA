package metier;


import java.sql.*;
import java.util.Scanner;

import dao.connexion.Connexion;

public class Periodicite {
	
	private int id_periodicite;
	private String libelle;

	
	public Periodicite(int id_periode, String libelle) {
		super();
		this.id_periodicite = id_periode;
		this.libelle = libelle;
	}
	
	public Periodicite(String libelle) {
		super();
		this.libelle = libelle;
	}
	

	public int getId_periodicite() {
		return id_periodicite;
	}


	public void setId_periodicite(int id_periode) {
		this.id_periodicite = id_periode;
	}



	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}
	
	
	
}
