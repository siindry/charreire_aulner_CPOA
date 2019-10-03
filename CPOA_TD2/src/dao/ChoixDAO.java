package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import dao.factory.DAOFactory;
import dao.memoire.ListeMemoirePeriodiciteDAO;
import dao.mysql.MySQLPeriodiciteDAO;
import enumeration.EPersistance;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class ChoixDAO {
	
	public void choixPeriodeDAO() {

		DAOFactory doas = null;
		System.out.println("En quel type de BdD voulez-vous éditer : 1.MYSQL 2.ListeMemoire");
		Scanner sc = new Scanner(System.in);
		String choixType = sc.nextLine();
		
		switch(choixType) {
		case "MYSQL" : doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
						MySQLPeriodiciteDAO pds1 = MySQLPeriodiciteDAO.getInstance();
			break;
		case "ListeMemoire" : doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
								ListeMemoirePeriodiciteDAO pds11 = ListeMemoirePeriodiciteDAO.getInstance();
		}
		
		
		
		Periodicite p1 = new Periodicite(0, "");
		
		System.out.println("Que souhaitez-vous faire sur la table Periodicitï¿½: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sï¿½lectionner \n");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":System.out.println("Quelle PÃ©riodicitÃ© voulez-vous  ?");
		Scanner sc1 = new Scanner(System.in);
		String lib = sc1.nextLine();
		p1.setLibelle(lib);
			pd1.create(p1);
			break;
			
			
		case "2": 
			System.out.println("Quel id de ligne de periodicitÃ© souhaitez-vous modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idlib = sc2.nextInt();
			p1.setId_periode(idlib);
			Scanner sc21 = new Scanner(System.in);
			
			System.out.println("Avec quel mot souhaiter vous remplacer la pï¿½riodicite ?");
			String nom_ap = sc.nextLine();
			p1.setLibelle(nom_ap);
			System.out.println("salut");
		
			pd1.update(p1);
			break;
			
			
		case "3": System.out.println("Quelle PÃ©riodicitÃ© voulez-vous supprimer ?");
		Scanner sc3 = new Scanner(System.in);
		String lib2 = sc3.nextLine();
		p1.setLibelle(lib2);
			pd1.delete(p1);
			sc3.close();
			break;
			
			
		case "4": 
		System.out.println("Quel est le numÃ©ro de votre periodicite souhaitez-vous choisir ?");
		Scanner sc4 = new Scanner(System.in);
		int id = sc4.nextInt();
		pd1.getById(id);
			break;
		default: System.out.println("Entrï¿½e inconnue");
		
		}	
	sc.close();
	}
	
	
	public void choixClientDAO() {

		ClientDAO cd1 = new ClientDAO();
		Client c1 = new Client(null, null, 0, "", null, null, null, null);
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sï¿½lectionner \n");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":System.out.println("Quelle Client souhaitez-vous ajouter en emttant ces informations dans l'ordre : nom, prenom, no_rue, voie, code_postal, ville,  pays");
		c1.setNom(sc.nextLine());
		c1.setPrenom(sc.nextLine());
		c1.setNo_rue(sc.nextLine());
		c1.setVoie(sc.nextLine());
		c1.setCode_p(sc.nextLine());
		c1.setVille(sc.nextLine());
		c1.setPays(sc.nextLine());
			cd1.create(c1);
			break;
			
			
		case "2": 
			System.out.println("Quel id de ligne de Client souhaitez-vous modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idcl = sc2.nextInt();
			
			System.out.println("Voici les données du client que vous avez séléctionnés");
			cd1.getById(idcl);
			c1.setId_client(idcl);
			
			Scanner sc21 = new Scanner(System.in);
			System.out.println("Entrez les nouvelles données dans l'ordre : nom, prenom, no_rue, voie, code_postal, ville,  pays");
			c1.setNom(sc.nextLine());
			c1.setPrenom(sc.nextLine());
			c1.setNo_rue(sc.nextLine());
			c1.setVoie(sc.nextLine());
			c1.setCode_p(sc.nextLine());
			c1.setVille(sc.nextLine());
			c1.setPays(sc.nextLine());
			
			cd1.update(c1);
			break;
			
			
		case "3": System.out.println("Quelle client voulez-vous supprimer ?");
			Scanner sc3 = new Scanner(System.in);
			c1.setId_client(sc3.nextInt());
			cd1.delete(c1);
			sc3.close();
			break;
			
			
		case "4": 
		System.out.println("Mettez le numéro pour le client que vous voulez choisir ?");
		Scanner sc4 = new Scanner(System.in);
		int idc = sc4.nextInt();
		cd1.getById(idc);
			break;
		default: System.out.println("Entrï¿½e inconnue");
		
		}	
	sc.close();
	}
	
	
	
	
	
	public void choixRevueDAO() {

		RevueDAO rd1 = new RevueDAO();
		Revue r1 = new Revue(0, null, null, 0, null, 0);
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sï¿½lectionner \n");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":
		System.out.println("Entrez une information par ligne ces informations suivantes : titre, description, visuel, son type periodicite, tarif du nemoro :");
		Scanner sc1 = new Scanner(System.in);
		
		r1.setTitre(sc1.nextLine());
		r1.setDescription(sc1.nextLine());
		r1.setVisuel(sc1.nextLine());
		r1.setId_periode(sc1.nextInt());
		r1.setTarif(sc1.nextInt());
		
			rd1.create(r1);
			break;
			
			
		case "2": 
			System.out.println("Entrez l'id de revue de la ligne que vous souhaiter modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idcl = sc2.nextInt();
			
			System.out.println("Voici les données de la revue séléctionné");
			rd1.getById(idcl);
			r1.setId_revue(idcl);
			
			Scanner sc21 = new Scanner(System.in);
			System.out.println("Entrez les nouvelles données dans l'ordre : titre, description, tarif_numero, visuel, id_periodicite");
			r1.setTitre(sc2.nextLine());
			r1.setDescription(sc2.nextLine());
			r1.setVisuel(sc2.nextLine());
			r1.setId_periode(sc2.nextInt());
			
			rd1.update(r1);
			break;
			
			
		case "3": System.out.println("Quelle est l'id de la revue que vous souhaitez supprimer ?");
			Scanner sc3 = new Scanner(System.in);
			r1.setId_revue(sc3.nextInt());
			rd1.delete(r1);
			sc3.close();
			break;
			
			
		case "4": 
		System.out.println("Mettez le numï¿½ro pour le titre que vous voulez choisir ?");
		Scanner sc4 = new Scanner(System.in);
		int idc = sc4.nextInt();
		rd1.getById(idc);
			break;
		default: System.out.println("Entrï¿½e inconnue");
		
		}	
	sc.close();
	}
	
	
	public void choixAboDAO() {

		AbonnementDAO ad1 = new AbonnementDAO();
		Abonnement a1 = new Abonnement(0, 0, null, null);
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sï¿½lectionner \n");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":
		System.out.println("Entrez ces informations suivantes pour l'ajout d'un abonnement : id_client, id_revue, date_debut, date_fin (les dates sont aux format dd/MM/yyyy) :");
		Scanner sc1 = new Scanner(System.in);
		
		a1.setIdCl(sc1.nextInt());
		a1.setIdRev(sc1.nextInt());
		
		Scanner sc12 = new Scanner(System.in);
		String date1 = sc12.nextLine();
		String date2 = sc12.nextLine();
		
	
	    //Date date = formatter.parse(scanner.nextLine());
	    //System.out.println(date);
		
		
		/*String dateFormat = "dd-MM-yyyy";
	   
	    Date date_deb = new SimpleDateFormat(dateFormat).parse(scanner.nextLine());
	    System.out.println(date_deb);
	    a1.setDateDeb(date_deb);
	    
	    Date date_fin = new SimpleDateFormat(dateFormat).parse(scanner.nextLine());
	    a1.setDateDeb(date_fin);*/
	    
	    LocalDate dateDebut = LocalDate.parse(date1);
	    LocalDate dateFin = LocalDate.parse(date2);
	    
	    a1.setDateDeb(dateDebut);
	    a1.setDateFin(dateFin);

		
			ad1.create(a1);
			break;
			
			
		case "2": 
			System.out.println("Entrez l'id du client de la ligne que vous souhaiter modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idcl = sc2.nextInt();
			
			System.out.println("\nEntrez l'id de revue de la ligne que vous souhaiter modifier ?");
			int idr1 = sc2.nextInt();

			System.out.println("Entrez les nouvelles données dans l'ordre : date_debut, date_fin (les dates sont aux format yyyy-MM-jj) :");
			Scanner sc21 = new Scanner(System.in);
			String date11 = sc21.nextLine();
			String date21 = sc21.nextLine();
			
			a1.setIdCl(idcl);
			a1.setIdRev(idr1);
			
		    LocalDate dateDebut1 = LocalDate.parse(date11);
		    a1.setDateDeb(dateDebut1);
		    
		    LocalDate dateFin1 = LocalDate.parse(date21);
		    a1.setDateFin(dateFin1);


			
			ad1.update(a1);
			break;
			
			
		case "3": System.out.println("Supprimer un abonnement en y indiquant le numero du client et celui de la revue correspondante ?");
			Scanner sc3 = new Scanner(System.in);
			a1.setIdCl(sc3.nextInt());
			a1.setIdRev(sc3.nextInt());
			ad1.delete(a1);
			sc3.close();
			break;
			
			
		case "4": 
		System.out.println("Mettez le numï¿½ro du client pour l'abonnement que vous voulez choisir :");
		Scanner sc4 = new Scanner(System.in);
		int idc = sc4.nextInt();
		ad1.getById(idc);
			break;
		default: System.out.println("Entrï¿½e inconnue");
		
		}	
	sc.close();
	}
		
	

}
