package dao.memoire;

import java.util.ArrayList;
import dao.IRevueDAO;
import metier.Revue;
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




		public boolean update(Revue r1) {
			
			
			int compt = 0;
			int id = r1.getId_revue();
			boolean exist = false;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_revue() == id) {
					r1 = this.donnees.set(compt, r1);
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
		
		
		public boolean create(Revue r1) {
			

			r1.setId_revue(this.donnees.size()+1);
			boolean fait = this.donnees.add(r1);
			return fait;
		}
		
		
		
		public boolean delete(Revue r1) {
			
			int compt = 0;
			int id = r1.getId_revue();
			boolean exist = false;
				
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_revue() == id) {
					
					r1 = this.donnees.remove(compt);
					exist=true;
				}
				else
					compt++;
			}
			

			
			if(compt > this.donnees.size()) {
				exist = false;
				throw new IllegalArgumentException("Votre objet n'existe pas, votre requete a donc échoué");
			}
			return exist;
		}
		
		public Revue getById(int id) {
			
			Revue r1 = new Revue(0, null, null, 0, null, 0);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				if(this.donnees.get(compt).getId_revue() == id) {
					r1 = this.donnees.get(compt);
					System.out.println("\n" + "Id" + r1.getId_revue() + "\n"  + "Titre" + r1.getTitre() + "\n" + "Descritpion"  + r1.getDescription() +
							"\n" + "Tarif" + r1.getTarif() + "\n" + "Visuel" + r1.getVisuel() + "\n" + "Id periodicite" + r1.getId_periode() + "\n");
					exist = true;
				}
				else
					compt++;
			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Aucune ligne trouvé avec cet id.");
			}
			
			return r1;
			
		}

		
		public ArrayList<Revue> findAll() {
			
			Revue r1 = new Revue(0, null, null, 0, null, 0);
			boolean exist= false;
			int compt = 0;
			
			while(exist==false && compt < this.donnees.size()) {
				r1 = this.donnees.get(compt);
				System.out.println("\n" + "Id" + r1.getId_revue() + "\n"  + "Titre" + r1.getTitre() + "\n" + "Descritpion"  + r1.getDescription() +
						"\n" + "Tarif" + r1.getTarif() + "\n" + "Visuel" + r1.getVisuel() + "\n" + "Id periodicite" + r1.getId_periode() + "\n");
				compt++;

			}
			
			if(compt >= this.donnees.size()) {
				System.out.println("Fin de la ligne.");
			}
			
			return (ArrayList<Revue>) this.donnees;
		}
	 
	
}
