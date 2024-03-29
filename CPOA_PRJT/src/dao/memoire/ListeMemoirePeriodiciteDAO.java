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


		
		
		public boolean update(Periodicite p1) {
			
			
			int compt = 0;
			int id = p1.getId_periodicite();
			boolean exist = false;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_periodicite() == id) {
					p1 = this.donnees.set(compt, p1);
					exist=true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				exist = false;
				throw new IllegalArgumentException("Votre objet n'existe pas, votre requete a donc �chou�");
			}
			return exist;
			
		}
		
		
		public boolean create(Periodicite p1) {
			

			p1.setId_periodicite(this.donnees.size()+1);
			boolean fait = this.donnees.add(p1);
			return fait;
		}
		
		
		
		public boolean delete(Periodicite p1) {
			
			int compt = 0;
			int id = p1.getId_periodicite();
			boolean exist = false;
				
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_periodicite() == id) {
					
					p1 = this.donnees.remove(compt);
					exist=true;
				}
				else
					compt++;
			}
			
			if(compt == this.donnees.size()) {
				exist = false;
				System.out.println("-- ! -- Votre �lement est en fin de liste veuillez d'abord ajouter un autre �lement apr�s celui-ci");
			}
			
			if(compt > this.donnees.size()) {
				exist = false;
				throw new IllegalArgumentException("Votre objet n'existe pas, votre requete a donc �chou�");
			}
			return exist;
		}
		
		public Periodicite getById(int id) {
			
			Periodicite p1 = new Periodicite(null);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_periodicite() == id) {
					p1 = this.donnees.get(compt);
					System.out.println("ligne numero " + compt + "\n" + "Id" + p1.getId_periodicite() + "\n" + p1.getLibelle() + "\n");
					exist = true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Aucune ligne trouv� avec cet id.");
			}
			
			return p1;
			
		}
		

		@Override
		public int createGetKey(Periodicite p1) {
			p1.setId_periodicite(this.donnees.size()+1);
			this.donnees.add(p1);
			int id = p1.getId_periodicite();
			return id;
		}
		
		
		
		public ArrayList<Periodicite> findAll() {
			
			Periodicite p1 = new Periodicite(1, null);
			int compt = 0;
			
			while(compt < this.donnees.size()) {
				p1 = this.donnees.get(compt);
				System.out.println("\n" + "Id : " + p1.getId_periodicite() + "\n Libelle : " + p1.getLibelle() + "\n");
				compt++;

			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Fin de la ligne.");
			}
			
			return (ArrayList<Periodicite>) this.donnees;
		}

		@Override
		public Periodicite getByLib(String lib) {
			Periodicite p1 = new Periodicite(null);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getLibelle() == lib) {
					p1 = this.donnees.get(compt);
					System.out.println("ligne numero " + compt + "\n" + "Id" + p1.getId_periodicite() + "\n" + p1.getLibelle() + "\n");
					exist = true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Aucune ligne trouv� avec cet id.");
			}
			
			return p1;
		}

		@Override
		public ArrayList<String> findAllStr() {
			
			ArrayList<String> arrP = new ArrayList<String>();
			Periodicite p1 = new Periodicite(1, null);
			int compt = 0;
			
			while(compt < this.donnees.size()) {
				p1 = this.donnees.get(compt);
				System.out.println("\n" + "Id : " + p1.getId_periodicite() + "\n Libelle : " + p1.getLibelle() + "\n");
				compt++;
				arrP.add(p1.getLibelle());

			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Fin de la ligne.");
			}
			
			return arrP;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

	

