package dao.memoire;
import java.util.ArrayList;

import dao.IClientDAO;
import metier.Client;
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
			
			this.donnees.add(new Client("Jean", "Philipe", 1, "98", "Place de la liberté", "64814", "Rombas", "France"));
			this.donnees.add(new Client("Marc", "DeHue", 2, "157", "Rue du marché", "75000", "Paris", "France"));
		}



		public boolean update(Client c1) {
			
			
			int compt = 0;
			int id = c1.getId_client();
			boolean exist = false;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_client() == id) {
					c1 = this.donnees.set(compt, c1);
					exist=true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				exist = false;
				throw new IllegalArgumentException("Votre objet n'existe pas, votre requete a donc échoué");
			}
			return exist;
			
		}
		
		
		public boolean create(Client c1) {
			

			c1.setId_client(this.donnees.size()+1);
			boolean fait = this.donnees.add(c1);
			return fait;
		}
		
		
		
		public boolean delete(Client c1) {
			
			int compt = 0;
			int id = c1.getId_client();
			boolean exist = false;
				
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_client() == id) {
					
					c1 = this.donnees.remove(compt);
					exist=true;
				}
				else
					compt++;
			}
			
			if(compt == this.donnees.size()) {
				exist = false;
				System.out.println("-- ! -- Votre élement est en fin de liste veuillez d'abord ajouter un autre élement après celui-ci");
			}
			
			if(compt > this.donnees.size()) {
				exist = false;
				throw new IllegalArgumentException("Votre objet n'existe pas, votre requete a donc échoué");
			}
			return exist;
		}
		
		public Client getById(int id) {
			
			Client c1 = new Client(null, null, 0, null, null, null, null, null);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_client() == id) {
					c1 = this.donnees.get(compt);
					System.out.println("\n" + "Id" + c1.getId_client() + "\n"  + "Nom" + c1.getNom() + "\n" + "Prenom"  + c1.getPrenom() + "\n" + "No de rue" + c1.getNo_rue() + "\n" + c1.getVoie() 
							+ "\n" + c1.getVille() + "\n" + c1.getPays() + "\n");
					exist = true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Aucune ligne trouvé avec cet id.");
			}
			
			return c1;
			
		}

		@Override
		public int createGetKey(Client objet) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public ArrayList<Client> findAll() {
			
			Client c1 = new Client(null, null, 1, null, null, null, null, null);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				c1 = this.donnees.get(compt);
				System.out.println("\n" + "Id" + c1.getId_client() + "\n"  + "Nom" + c1.getNom() + "\n" + "Prenom"  + c1.getPrenom() + "\n" + "No de rue" + c1.getNo_rue() + "\n" + c1.getVoie() 
						+ "\n" + c1.getVille() + "\n" + c1.getPays() + "\n");
				compt++;

			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Fin de la ligne.");
			}
			
			return (ArrayList<Client>) this.donnees;
		}
	}

	

