package dao;

import java.util.Scanner;

import metier.Periodicite;

public class ChoixDAO {
	
	public void choixPeriodeDAO() {

		PeriodiciteDAO pd1 = new PeriodiciteDAO();
		Periodicite p1 = new Periodicite(0, "");
		
		System.out.println("Que souhaitez-vous faire sur la table Periodicit�: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.S�lectionner \n");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		case "1":System.out.println("Quelle Périodicité voulez-vous  ?");
		Scanner sc1 = new Scanner(System.in);
		String lib = sc1.nextLine();
		p1.setLibelle(lib);
			pd1.create(p1);
			
			break;
		case "2": 
			
			System.out.println("Quel id de ligne de periodicité souhaitez-vous modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idlib = sc2.nextInt();
			p1.setId_periode(idlib);
			Scanner sc21 = new Scanner(System.in);
			
			System.out.println("Avec quel mot souhaiter vous remplacer la p�riodicite ?");
			String nom_ap = sc.nextLine();
			p1.setLibelle(nom_ap);
			System.out.println("salut");
		
			pd1.update(p1);
			break;
		case "3": System.out.println("Quelle Périodicité voulez-vous supprimer ?");
		Scanner sc3 = new Scanner(System.in);
		String lib2 = sc3.nextLine();
		p1.setLibelle(lib2);
			pd1.delete(p1);
			sc3.close();
			break;
		case "4": 
		System.out.println("Quel est le numéro de votre periodicite souhaitez-vous choisir ?");
		Scanner sc4 = new Scanner(System.in);
		int id = sc4.nextInt();
		pd1.getById(id);
			break;
		default: System.out.println("Entr�e inconnue");
		
		}	
	sc.close();
	}
	
	
	
	
	
	
}
