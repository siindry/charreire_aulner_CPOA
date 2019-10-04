package dao.memoire;

import java.util.ArrayList;
import dao.IRevueDAO;
import metier.Revue;

public class ListeMemoireRevueDAO implements IRevueDAO{
	
	private static ListeMemoireRevueDAO instance;

	private ArrayList<Revue> donnees;
	

		public static ListeMemoireRevueDAO getInstance() {

			if (instance == null) {
				
				instance = new ListeMemoireRevueDAO();
			}

			return instance;
		}

		private ListeMemoireRevueDAO() {

			this.donnees = new ArrayList<Revue>();
			
			this.donnees.add(new Revue(1, "Le Monde", "Journal", 2 , "lemonde.jpg", 2));
			this.donnees.add(new Revue(2, "Charlie Hebdo", "journal satirique", 2.2, "ch.jpg", 3));
		}



		public boolean create(Revue objet) {

			objet.setId_revue(3);
			// Ne fonctionne que si l'objet métier est bien fait...
			while (this.donnees.contains(objet)) {

				objet.setId_periode(objet.getId_periode() + 1);
			}
			boolean ok = this.donnees.add(objet);
			
			return ok;
		}


		public boolean update(Revue objet) {
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				
				this.donnees.set(idx, objet);
			}
			
			return true;
		}


		public boolean delete(Revue objet) {

			Revue supprime;
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				supprime = this.donnees.remove(idx);
			}
			
			return objet.equals(supprime);
		}


		public Revue getById(int id) {
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(new Revue(id, "test", "test2", 0, "test.jpg", 0));
			if (idx == -1) {
				throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
			} else {
				return this.donnees.get(idx);
			}
		}


		public ArrayList<Revue> findAll() {
			return (ArrayList<Revue>) this.donnees;
		}
	 
	
}
