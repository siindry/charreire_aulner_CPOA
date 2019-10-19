package metier;


import java.sql.*;
import java.util.Scanner;

import dao.connexion.Connexion;

public class Periodicite {
	
	private int id_periode;
	private String libelle;

	
	public Periodicite(int id_periode, String libelle) {
		super();
		this.id_periode = id_periode;
		this.libelle = libelle;
	}
	
	public Periodicite(String libelle) {
		super();
		this.libelle = libelle;
	}
	

	public int getId_periode() {
		return id_periode;
	}


	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
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
