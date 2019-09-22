package metier;
import dao.*;

import java.util.Scanner;

public class gestionM {

	public static void main(String[] args) throws Exception {
		
		boolean faireMain = true;
		
		while(faireMain==true) {
			
			System.out.println("Choisissez une table � �diter : \n 1.Periodicit� \n 2.Revue \n "
					+ "3.Client \n 4.Abonnement");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			
			switch(choix) {
				case "1": ChoixDAO c1 = new ChoixDAO();
							c1.choixPeriodeDAO();				
					break;
				case "2": Revue r1 = null;
									r1.choixRevue();
					break;
				case "3": Client cd1 = null;
									//c1.choixClient();
					break;
				case "4": Abonnement a1 = null;
									a1.choixAbo();
									
					break;
				default: System.out.println("Entr�e inconnue");
			
			}
			
			System.out.println("Voulez-vous �diter encore une fois ? {\n1 : oui \n2 : non");
			int refaireMain = sc.nextInt();
			if(refaireMain==2)
				faireMain=false;
			else if(refaireMain>2) {
				System.out.println("Entr�e inconnue, sortie du programme");
				faireMain=false;
			}
				
			
			
		}
		System.out.println("Au revoir !");
	}

}
