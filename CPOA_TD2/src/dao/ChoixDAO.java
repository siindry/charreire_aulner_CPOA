package dao;

import java.util.Scanner;

import metier.Periodicite;

public class ChoixDAO {
	
	public void choixPeriodeDAO() {

		PeriodiciteDAO pd1 = new PeriodiciteDAO();
		Periodicite p1 = new Periodicite(0, null);
		
		System.out.println("Que souhaitez-vous faire sur la table Periodicit�: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.S�lectionner \n 5.Afficher la table");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		switch(choix) {
		case "1":pd1.create(p1);
			break;
		case "2": pd1.update(p1);
			break;
		case "3": pd1.delete(p1);
			break;
		case "4": 
		System.out.println("Quel est le numéro de votre periodicite souhaitez-vous choisir ?");
		Scanner sc1 = new Scanner(System.in);
		int id = sc1.nextInt();
		pd1.getById(id);
			break;
		default: System.out.println("Entr�e inconnue");
		
		}	
	
	}
	
	
	
	
	
	
}
