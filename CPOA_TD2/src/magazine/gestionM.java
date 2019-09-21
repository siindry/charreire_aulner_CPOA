package magazine;

import java.util.Scanner;

public class gestionM {

	public static void main(String[] args) throws Exception {
		
		boolean faireMain = true;
		
		while(faireMain==true) {
			
			System.out.println("Choisissez une table à éditer : \n 1.Periodicité \n 2.Revue \n "
					+ "3.Client \n 4.Abonnement \n");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			
			switch(choix) {
				case "1": Periodicite p1 = new Periodicite();
										p1.choixPeriode();
											
					break;
				case "2": Revue r1 = new Revue();
									r1.choixRevue();
					break;
				case "3": Client c1 = new Client();
									c1.choixClient();
					break;
				case "4": Abonnement a1 = new Abonnement();
									a1.choixAbo();		
					break;
				default: System.out.println("Entrée inconnue");
			
			}
			
			System.out.println("Voulez-vous éditer encore une fois ? {\n1 : oui \n2 : non");
			int refaireMain = sc.nextInt();
			if(refaireMain==2)
				faireMain=false;
			else if(refaireMain>2) {
				System.out.println("Entrée inconnue, sortie du programme");
				faireMain=false;
			}
				
			
			
		}
		System.out.println("Au revoir !");
	}

}
