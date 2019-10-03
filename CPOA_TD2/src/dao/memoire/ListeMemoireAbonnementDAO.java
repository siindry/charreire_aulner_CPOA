package dao.memoire;

import java.time.LocalDate;
import java.util.ArrayList;

import metier.Abonnement;

public class ListeMemoireAbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;
	
	private ArrayList<Abonnement> donnees;
	
	
	public static ListeMemoireAbonnementDAO getInstance() {
		
		if (instance == null) {
		
		instance = new ListeMemoireAbonnementDAO();
		}
		
		return instance;
	}
	
	private ListeMemoireAbonnementDAO() {
	
		this.donnees = new ArrayList<Abonnement>();
		
		String date1 = "2018-09-03";
		String date2 = "2018-10-23";
		LocalDate dateDebut = LocalDate.parse(date1);
		   LocalDate dateFin = LocalDate.parse(date2);
		
		this.donnees.add(new Abonnement(1, 2, dateDebut, dateFin));
		this.donnees.add(new Abonnement(2, 3, dateDebut, dateFin));
	}
	
	
	
	public boolean create(Abonnement objet) {
		
		objet.setIdCl(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {
		
		objet.setIdCl(objet.getIdCl() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}
	
	
	public boolean update(Abonnement objet) {
	
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
		throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
		
		this.donnees.set(idx, objet);
		}
		
		return true;
	}
	
	
	public boolean delete(Abonnement objet) {
	
		Abonnement supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
		throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
		supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}
	
	
	public Abonnement getById2(int idCl, int idRev) {
		// Ne fonctionne que si l'objet métier est bien fait...
		
		String date1 = "2018-09-03";
		String date2 = "2018-10-23";
		LocalDate dateDebut = LocalDate.parse(date1);
		   LocalDate dateFin = LocalDate.parse(date2);
		
		
		int idx = this.donnees.indexOf(new Abonnement(idCl, idRev, dateDebut, dateFin));
		if (idx == -1) {
		throw new IllegalArgumentException("Aucun objet ne possède ces identifiants");
		} else {
		return this.donnees.get(idx);
		}
	}
	
	
	public ArrayList<Abonnement> findAll() {
		return (ArrayList<Abonnement>) this.donnees;
	}


}