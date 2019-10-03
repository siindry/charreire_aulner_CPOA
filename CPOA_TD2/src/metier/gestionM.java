package metier;
import dao.*;

import java.util.Scanner;

public class gestionM {

	public static void main(String[] args) throws Exception {
		
		boolean faireMain = true;
		
		//while(faireMain==true) {
			
			System.out.println("Choisissez une table � �diter : \n 1.Periodicit� \n 2.Revue \n "
					+ "3.Client \n 4.Abonnement");
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			ChoixDAO c1 = new ChoixDAO();
			
			switch(choix) {
				case 1: c1.choixPeriodeDAO();				
					break;
				case 2: c1.choixRevueDAO();
					break;
				case 3: c1.choixClientDAO();
					break;
				case 4: c1.choixAboDAO();
									
					break;
				default: System.out.println("Entr�e inconnue");
			
			}
			
			/*System.out.println("Voulez-vous �diter encore une fois ? {\n1 : oui \n2 : non");
			Scanner sc1 = new Scanner(System.in);
			int refaireMain = sc1.nextInt();
			if(refaireMain==2)
				faireMain=false;
			else if(refaireMain>2) {
				System.out.println("Entr�e inconnue, sortie du programme");
				faireMain=false;
			}else {
				faireMain=true;
			}*/
			sc.close();
				
			
			System.out.println("Au revoir !");
		//}
		
	}

}
