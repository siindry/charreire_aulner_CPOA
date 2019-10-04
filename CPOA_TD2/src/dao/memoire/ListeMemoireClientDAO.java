package dao.memoire;
import java.util.ArrayList;

import dao.IClientDAO;
import metier.Client;


public class ListeMemoireClientDAO implements IClientDAO {



		private static ListeMemoireClientDAO instance;

		private ArrayList<Client> donnees;


		public static ListeMemoireClientDAO getInstance() {

			if (instance == null) {
				
				instance = new ListeMemoireClientDAO();
			}

			return instance;
		}

		private ListeMemoireClientDAO() {

			this.donnees = new ArrayList<Client>();
			
			this.donnees.add(new Client("test", "test", 3, "test", "test", "test", "test", "test"));
			this.donnees.add(new Client("test", "test", 3, "test", "test", "test", "test", "test"));
		}



		public boolean create(Client objet) {

			objet.setId_client(3);
			// Ne fonctionne que si l'objet métier est bien fait...
			while (this.donnees.contains(objet)) {

				objet.setId_client(objet.getId_client() + 1);
			}
			boolean ok = this.donnees.add(objet);
			
			return ok;
		}


		public boolean update (Client objet) {
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				
				this.donnees.set(idx, objet);
			}
			
			return true;
		}


		public boolean delete(Client objet) {

			Client supprime;
			
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(objet);
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				supprime = this.donnees.remove(idx);
			}
			
			return objet.equals(supprime);
		}


		public Client getById(int id) {
			// Ne fonctionne que si l'objet métier est bien fait...
			int idx = this.donnees.indexOf(new Client("test", "test", 3, "test", "test", "test", "test", "test"));
			if (idx == -1) {
				throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
			} else {
				return this.donnees.get(idx);
			}
		}


		public ArrayList<Client> findAll() {
			return (ArrayList<Client>) this.donnees;
		}
	}

	

