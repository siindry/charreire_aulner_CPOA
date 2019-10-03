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

		
		
}