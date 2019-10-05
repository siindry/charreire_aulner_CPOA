package dao.memoire;
import java.util.ArrayList;

import dao.IPeriodiciteDAO;
import metier.Periodicite;


public class ListeMemoirePeriodiciteDAO implements IPeriodiciteDAO{



		private static ListeMemoirePeriodiciteDAO instance;

		private ArrayList<Periodicite> donnees;


		public static ListeMemoirePeriodiciteDAO getInstance() {

			if (instance == null) {
				
				instance = new ListeMemoirePeriodiciteDAO();
			}

			return instance;
		}

		private ListeMemoirePeriodiciteDAO() {

			this.donnees = new ArrayList<Periodicite>();
			
			this.donnees.add(new Periodicite(1, "Mensuel"));
			this.donnees.add(new Periodicite(2, "Quotidien"));
			
		}



		public boolean create(Periodicite objet) {

			// Ne fonctionne que si l'objet métier est bien fait...
			while (this.donnees.contains(objet)) {

				objet.setId_periode(objet.getId_periode() + 1);
			}
			boolean ok = this.donnees.add(objet);
			
			return ok;
		}


		public boolean update(Periodicite objet) {
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				
				this.donnees.set(idx, objet);
			}
			
			return true;
		}


		public boolean delete(Periodicite objet) {

			Periodicite supprime;
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				supprime = this.donnees.remove(idx);
			}
			
			return objet.equals(supprime);
		}


		public Periodicite getById(int id) {
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(new Periodicite(id, "test"));
			if (idx == -1) {
				throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
			} else {
				return this.donnees.get(idx);
			}
		}


		public ArrayList<Periodicite> findAll() {
			return (ArrayList<Periodicite>) this.donnees;
		}
	}

	

