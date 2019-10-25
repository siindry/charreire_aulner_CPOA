package dao.memoire;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.IAbonnementDAO;
import metier.Abonnement;


public class ListeMemoireAbonnementDAO implements IAbonnementDAO{

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
		LocalDate dateDebut1 = LocalDate.parse(date1);
		LocalDate dateFin2 = LocalDate.parse(date2);
		
		String date3 = "2017-01-25";
		String date4 = "2019-03-25";
		LocalDate dateDebut3 = LocalDate.parse(date3);
		LocalDate dateFin4 = LocalDate.parse(date4);
		
		this.donnees.add(new Abonnement(1, 2, dateDebut1, dateFin2));
		this.donnees.add(new Abonnement(2, 3, dateDebut3, dateFin4));
	}
	
	
	
	public boolean update(Abonnement a1) {
		
		
		int compt = 0;
		int idab = a1.getId_client();
		int idrv = a1.getId_revue();
		boolean exist = false;
		
		while(exist==false && compt < this.donnees.size()) {
			if(this.donnees.get(compt).getId_client() == idab && this.donnees.get(compt).getId_revue() == idrv) {
				a1 = this.donnees.set(compt, a1);
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
	
	
	public boolean create(Abonnement a1) {
		
		boolean fait = this.donnees.add(a1);
		return fait;
	}
	
	
	
	public boolean delete(Abonnement a1) {
		
		int compt = 0;
		int idab = a1.getId_client();
		int idrv = a1.getId_revue();
		boolean exist = false;
			
		while(exist==false && compt < this.donnees.size()) {
			if(this.donnees.get(compt).getId_client() == idab && this.donnees.get(compt).getId_revue() == idrv) {
				a1 = this.donnees.remove(compt);
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
	
	public Abonnement getBy2Id(int id1, int id2) {
		
		Abonnement a1 = new Abonnement(0, 0, null, null);
		boolean exist= false;
		int compt = 0;
		
		while(exist==false && compt < this.donnees.size()) {
			if(this.donnees.get(compt).getId_client() == id1 && this.donnees.get(compt).getId_revue() == id2) {
				a1 = this.donnees.get(compt);
				System.out.println("\n" + "Numero du client : " + a1.getId_client() + "\n"  + "Numero de revue : " + a1.getId_revue() + "\n" + "Date début : "  + a1.getDate_debut() +
						"\n" + "Date fin : " + a1.getDate_fin() + "\n");
				exist = true;
			}
			else
				compt++;
		}
		
		if(compt >= this.donnees.size()) {
			System.out.println("Aucune ligne trouvé avec cet id.");
		}
		
		return a1;
		
	}

	
	public ArrayList<Abonnement> findAll() {
		
		Abonnement a1 = new Abonnement(0, 0, null, null);
		boolean exist= false;
		int compt = 0;
		
		while(exist==false && compt < this.donnees.size()) {
			a1 = this.donnees.get(compt);
			System.out.println("\n" + "Numero du client : " + a1.getId_client() + "\n"  + "Numero de revue : " + a1.getId_revue() + "\n" + "Date début : "  + a1.getDate_debut() +
					"\n" + "Date fin : " + a1.getDate_fin() + "\n");
			compt++;

		}
		
		if(compt >= this.donnees.size()) {
			System.out.println("Fin de la table.");
		}
		
		return (ArrayList<Abonnement>) this.donnees;
	}

	@Override
	public Abonnement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> createGetKey(Abonnement atest1) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	}


