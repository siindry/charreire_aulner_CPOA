package dao;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class ChoixDAO {
	
	boolean reussi = false;
	DAOFactory doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	
	
	public void choixTable() throws Exception {
		
		System.out.println("Choisissez une table é éditer : \n 1.Periodicité \n 2.Revue \n "
				+ "3.Client \n 4.Abonnement \n 5.Quitter");
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();

		
		switch(choix) {

			case 1: this.choixPeriodeDAO();	
				break;
			case 2: this.choixRevueDAO();
				break;
			case 3: this.choixClientDAO();
				break;
			case 4: this.choixAboDAO();
				break;
			case 5 : 
				System.out.println("Au revoir");
				System.exit(1);			
				break;
			default: System.out.println("Entrée inconnue");
		
		}
		
	}
	
	public void choixPeriodeDAO(){

		

		
		
		
		Periodicite p1 = new Periodicite(0, "");
		
		System.out.println("Que souhaitez-vous faire sur la table Periodicité: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner \n 5.Choisir un mode de base de donnée \n 6.Changer de table \n 7.Récuperer les données dans une liste et les afficher");
		Scanner sc25 = new Scanner(System.in);
		String choix = sc25.nextLine();
		
		
		switch(choix) {
		
		
		case "1":
			System.out.println("Quelle PÃ©riodicité souhaitez-vous ajouter ?");
			Scanner sc1 = new Scanner(System.in);
			String lib = sc1.nextLine();
			p1.setLibelle(lib);
			reussi = doas.getPeriodiciteDAO().create(p1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixPeriodeDAO();
			break;
			
			
		case "2": 
			System.out.println("Quel id de ligne de periodicitÃ© souhaitez-vous modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idlib = sc2.nextInt();
			p1.setId_periode(idlib);
			Scanner sc21 = new Scanner(System.in);
			
			System.out.println("Avec quel mot souhaiter vous remplacer la périodicite ?");
			String nom_ap = sc21.nextLine();
			p1.setLibelle(nom_ap);
		
			reussi= doas.getPeriodiciteDAO().update(p1);
			if(reussi==true)
				System.out.println("Modifié avec succès");
			else
				System.out.println("Aucune modification");
			this.choixPeriodeDAO();
			break;
			
			
		case "3": 
			System.out.println("Quelle PÃ©riodicitÃ© voulez-vous supprimer en mettant son id?");
			Scanner sc3 = new Scanner(System.in);
			int id = sc3.nextInt();
			p1.setId_periode(id);
			reussi= doas.getPeriodiciteDAO().delete(p1);
			if(reussi==true)
				System.out.println("Supprimé avec succès");
			else
				System.out.println("Aucune suppression");;
				this.choixPeriodeDAO();
			break;
			
			
		case "4": 
			System.out.println("Quel est le numÃ©ro de votre periodicite souhaitez-vous choisir ?");
			Scanner sc4 = new Scanner(System.in);
			int id1 = sc4.nextInt();
			p1= doas.getPeriodiciteDAO().getById(id1);
			this.choixPeriodeDAO();
			break;
			
			
		case "5":
			System.out.println("En quel type de BdD voulez-vous éditer :\n 1.MYSQL \n 2.ListeMemoire");
			Scanner sc20 = new Scanner(System.in);
			String choixType = sc20.nextLine();
			
			switch(choixType) {
				case "1" : doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
				this.choixPeriodeDAO();
					break;
				case "2" : doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
				this.choixPeriodeDAO();
					break;
				default: System.out.println("Entrée inconnue");
				break;
		
				
			
		
		}	
		case "6":
			try {
				this.choixTable();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "7":
			ArrayList<Periodicite> l1 = null;
			l1 = doas.getPeriodiciteDAO().findAll();
			this.choixPeriodeDAO();
			break;
			
		default: System.out.println("Entrée inconnue");
			break;
		
		
		
		}	
	}
	
	
	public void choixClientDAO() {

		
		Client c1 = new Client(null, null, 0, "", null, null, null, null);

		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner \n 5.Choisir un mode de base de donnée \n 6.Changer de table \n 7.Récuperer les données dans une liste et les afficher");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":
			System.out.println("Quelle Client souhaitez-vous ajouter en emttant ces informations dans l'ordre : nom, prenom, no_rue, voie, code_postal, ville,  pays");
			c1.setNom(sc.nextLine());
			c1.setPrenom(sc.nextLine());
			c1.setNo_rue(sc.nextLine());
			c1.setVoie(sc.nextLine());
			c1.setCode_p(sc.nextLine());
			c1.setVille(sc.nextLine());
			c1.setPays(sc.nextLine());
			
			reussi = doas.getClientDAO().create(c1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixClientDAO();
			break;
			
			
		case "2": 
			System.out.println("Quel id de ligne de Client souhaitez-vous modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idcl = sc2.nextInt();
			
			System.out.println("Voici les données du client que vous avez séléctionnés");
			c1 = doas.getClientDAO().getById(idcl);
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
			
			reussi = doas.getClientDAO().update(c1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixClientDAO();
			break;
			
			
		case "3": 
			System.out.println("Quelle Client voulez-vous supprimer en mettant son id?");
			Scanner sc3 = new Scanner(System.in);
			c1.setId_client(sc3.nextInt());
			reussi = doas.getClientDAO().delete(c1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixClientDAO();
			break;
			
			
		case "4": 
			System.out.println("Mettez le numéro pour le client que vous voulez choisir ?");
			Scanner sc4 = new Scanner(System.in);
			int idc = sc4.nextInt();
			c1= doas.getClientDAO().getById(idc);
			this.choixClientDAO();
			break;
			
		case "5":
			System.out.println("En quel type de BdD voulez-vous éditer :\n 1.MYSQL \n 2.ListeMemoire");
			Scanner sc20 = new Scanner(System.in);
			String choixType = sc20.nextLine();
			
			switch(choixType) {
				case "1" : 
					doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
					this.choixClientDAO();
					break;
				case "2" :
					doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
					System.out.println("ListeMemoire");
					this.choixClientDAO();
					break;
				default: System.out.println("Entrée inconnue");
					break;
			}
		
		case "6":
			try {
				this.choixTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "7":
			ArrayList<Client> l1 = null;
			l1 = doas.getClientDAO().findAll();
			this.choixClientDAO();
			break;
		
		default: System.out.println("Entrée inconnue");
		
		}	
	}
	
	
	
	
	
	public void choixRevueDAO() {


		Revue r1 = new Revue(0, null, null, 0, null, 0);
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner \n 5.Choisir un mode de base de donnée \n 6.Changer de table \n 7.Récuperer les données dans une liste et les afficher");
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
			
			Scanner tarif = new Scanner(System.in);
			String tar = tarif.nextLine();
			double tar1 = Double.valueOf(tar);
			r1.setTarif(tar1);
			
			reussi = doas.getRevueDAO().create(r1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixRevueDAO();
			break;
			
			
		case "2": 
			System.out.println("Entrez l'id de revue de la ligne que vous souhaiter modifier ?");
			Scanner sc2 = new Scanner(System.in);
			int idr = sc2.nextInt();
			
			System.out.println("Voici les données de la revue séléctionnée");
			r1= doas.getRevueDAO().getById(idr);
			r1.setId_revue(idr);
			
			Scanner sc21 = new Scanner(System.in);
			System.out.println("Entrez les nouvelles données dans l'ordre : titre, description, tarif_numero, visuel, id_periodicite");
			
			r1.setTitre(sc21.nextLine());
			r1.setDescription(sc21.nextLine());
			Scanner tarif1 = new Scanner(System.in);
			String tar11 = tarif1.nextLine();
			double tar12 = Double.valueOf(tar11);
			r1.setTarif(tar12);
			r1.setVisuel(sc21.nextLine());
			r1.setId_periode(sc21.nextInt());
			
			reussi = doas.getRevueDAO().update(r1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixRevueDAO();
			break;
			
			
		case "3": 
			System.out.println("Quelle est l'id de la revue que vous souhaitez supprimer ?");
			Scanner sc3 = new Scanner(System.in);
			r1.setId_revue(sc3.nextInt());
			reussi = doas.getRevueDAO().delete(r1);
			if(reussi==true)
				System.out.println("Ajouté avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixRevueDAO();
			break;
			
			
		case "4": 
			System.out.println("Mettez le numéro pour le titre que vous voulez choisir ?");
			Scanner sc4 = new Scanner(System.in);
			int idc = sc4.nextInt();
			r1= doas.getRevueDAO().getById(idc);
			this.choixRevueDAO();
			break;
			
		
		case "5":
			System.out.println("En quel type de BdD voulez-vous éditer :\n 1.MYSQL \n 2.ListeMemoire");
			Scanner sc20 = new Scanner(System.in);
			String choixType = sc20.nextLine();
			
			switch(choixType) {
				case "1" : doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
				this.choixRevueDAO();
					break;
				case "2" : doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
				this.choixRevueDAO();
					break;
				default: System.out.println("Entrée inconnue");
					break;
			}	
		
		case "6":
			try {
				this.choixTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "7":
			ArrayList<Revue> l1 = null;
			l1 = doas.getRevueDAO().findAll();
			this.choixRevueDAO();
			break;
		
		default: System.out.println("Entrée inconnue");
		
		}	
	}
	
	
	public void choixAboDAO() {

		Abonnement a1 = new Abonnement(0, 0, null, null);
		
		System.out.println("Que souhaitez-vous faire sur la table Client: \n 1.Ajouter \n 2.Modifier "
				+ "\n 3.Supprimer \n 4.Sélectionner \n 5.Choisir un mode de base de donnée \n 6.Changer de table \n 7.Récuperer les données dans une liste et les afficher");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		
		switch(choix) {
		
		
		case "1":
			System.out.println("Entrez les informations suivantes pour l'ajout d'un abonnement : id_client, id_revue, date_debut, date_fin (les dates sont aux format yyyy/MM/dd) :");
			Scanner sc1 = new Scanner(System.in);
			
			a1.setIdCl(sc1.nextInt());
			a1.setIdRev(sc1.nextInt());
			
			Scanner sc12 = new Scanner(System.in);
			String date1 = sc12.nextLine();
			String date2 = sc12.nextLine();
	
		    
		    LocalDate dateDebut = LocalDate.parse(date1);
		    LocalDate dateFin = LocalDate.parse(date2);
		    
		    a1.setDateDeb(dateDebut);
		    a1.setDateFin(dateFin);
	
			
		    reussi = doas.getAbonnementDAO().create(a1);
			if(reussi==true)
				System.out.println("Ajouter avec succès");
			else
				System.out.println("Aucun ajout");
			this.choixAboDAO();
			break;
			
			
		case "2": 
			System.out.println("Entrez l'id du client pour l'abonnment que vous souhaiter modifier :");
			Scanner sc2 = new Scanner(System.in);
			int idcl = sc2.nextInt();
			
			System.out.println("\nEntrez l'id de revue :");
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


			
		    reussi = doas.getAbonnementDAO().update(a1);
			if(reussi==true)
				System.out.println("Modifié avec succès");
			else
				System.out.println("Aucune modification");
			this.choixAboDAO();
			break;
			
			
		case "3": 
			System.out.println("Supprimer un abonnement en y indiquant le numero du client et celui de la revue correspondante ?");
			Scanner sc3 = new Scanner(System.in);
			a1.setIdCl(sc3.nextInt());
			a1.setIdRev(sc3.nextInt());
			reussi = doas.getAbonnementDAO().delete(a1);
			if(reussi==true)
				System.out.println("Supprimé avec succès");
			else
				System.out.println("Aucune suppression");
			this.choixAboDAO();
			break;
			
			
		case "4": 
			System.out.println("Mettez le numéro du client et de la revue correspondante pour l'abonnement que vous voulez choisir :");
			Scanner sc4 = new Scanner(System.in);
			int idcli = sc4.nextInt();
			int idrv = sc4.nextInt();
			a1 = doas.getAbonnementDAO().getBy2Id(idcli, idrv);
			this.choixAboDAO();
			break;
			
			
		case "5":
			System.out.println("En quel type de BdD voulez-vous éditer :\n 1.MYSQL \n 2.ListeMemoire");
			Scanner sc20 = new Scanner(System.in);
			String choixType = sc20.nextLine();
			
			switch(choixType) {
				case "1" : doas = DAOFactory.getDAOFactory(EPersistance.MYSQL);
				this.choixAboDAO();
					break;
				case "2" : doas = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
				this.choixAboDAO();
					break;
				default: System.out.println("Entrée inconnue");
					break;
			}
			
		case "6":
			try {
				this.choixTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "7":
			ArrayList<Abonnement> l1 = null;
			l1 = doas.getAbonnementDAO().findAll();
			this.choixAboDAO();
			break;
			
		default: System.out.println("Entrée inconnue");
		
		}	

	}
		


}
