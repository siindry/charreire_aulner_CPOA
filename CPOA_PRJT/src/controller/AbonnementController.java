package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Client;
import metier.Revue;


public class AbonnementController extends Stage implements IAddModController{
	
	@FXML
	private Label lbl_titre;
	
	@FXML
	private TextField txt_idC;
	
	@FXML
	private TextField txt_idR;
	
	@FXML
	private Button btn_quitter;
	
	@FXML
	private Button btn_confirmer;
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private DatePicker dtp_deb;
	
	@FXML
	private DatePicker dtp_fin;
	
	@FXML
	private ComboBox<String> combo_client;
	
	@FXML
	private ComboBox<String> combo_revue;
	
	private int idC = TableAbonnementController.idC;
	private int idR = TableAbonnementController.idR;
	private LocalDate dtDeb = TableAbonnementController.dtDeb;
	private LocalDate dtFin = TableAbonnementController.dtFin;
	
	private boolean ajout = TableAbonnementController.ajout;
	
	private DAOFactory dao = AccueilController.dao;
	
	
	
	@FXML
	public void initialize() throws SQLException {
		
		if(ajout) {
			
			lbl_titre.setText("Ajout dans la table Abonnement");
			
			ArrayList<Client> c1 = dao.getClientDAO().findAllNomPrenom();
			ArrayList<String> listeNomPre = new ArrayList<String>();
			for (int i=0; i<c1.size(); i++) {
				Client c2 = c1.get(i);
				listeNomPre.add(c2.getNom() + " " + c2.getPrenom());
			}
			this.combo_client.setItems(FXCollections.observableArrayList(listeNomPre));
			
			
			
			ArrayList<Revue> r1 = dao.getRevueDAO().findAllTitreDesc();
			ArrayList<String> listeTitreDesc = new ArrayList<String>();
			for (int i=0; i<r1.size(); i++) {
				Revue r2 = r1.get(i);
				listeTitreDesc.add(r2.getTitre() + "," + r2.getDescription());
			}
			
			this.combo_revue.setItems(FXCollections.observableArrayList(listeTitreDesc));
			
		}else {
			lbl_titre.setText("Modification de la table Abonnement");
			
			txt_idC.setText((String.valueOf(idC)));
			txt_idR.setText((String.valueOf(idR)));
			
			dtp_deb.setValue(dtDeb);
			dtp_fin.setValue(dtFin);
			
			ArrayList<String> c1 = dao.getAbonnementDAO().getClientInClient(idC);
			ArrayList<String> r1 = dao.getAbonnementDAO().getRevueInRevue(idR);
			
		    this.combo_client.setItems(FXCollections.observableArrayList(c1));
		    this.combo_revue.setItems(FXCollections.observableArrayList(r1));
			

		}

	}
	
	@FXML
	public void affIdC() {
		
		String client = combo_client.getSelectionModel().getSelectedItem();

		String[] limite = client.split("\\ "); // String array, each element is text between dots

		String nom = limite[0];
		String prenom = limite[1];
		
		int id = dao.getClientDAO().getIdbyNom(nom, prenom);
		txt_idC.setText(Integer.toString(id));
	}
	
	@FXML
	public void affIdR() {
		
		String revue = combo_revue.getSelectionModel().getSelectedItem();
		
		String[] limite = revue.split("\\,"); // String array, each element is text between dots

		String titre = limite[0];
		String description = limite[1];
		
		
		int id = dao.getRevueDAO().getIdByTitre(titre, description);
		txt_idR.setText(Integer.toString(id));
		
	}
	
	public void sendToDB() throws SQLException, IOException {
		
		boolean reussi;
		Abonnement abo1;
		LocalDate dateAjd = LocalDate.now();
		
		boolean rempli = true;
		String erreur = "";
		
		if(txt_idC.getText().isEmpty()) {
			erreur = erreur + "Vous devez sélectionner un client !\n";
			rempli = false;
		}
		
		if(txt_idR.getText().isEmpty()) {
			erreur = erreur + "Vous devez sélectionner une revue !\n";
			rempli = false;
		}
		
		if(dtp_deb.getValue() == null) {
			erreur = erreur + "Le champ date début est vide !\n";
			rempli = false;
		}else {
			if(dateAjd.isBefore(dtp_deb.getValue())) {
				erreur = erreur + "Vous ne pouvez mettre une date de début supérieure à aujourd'hui !\n";
				rempli = false;
			}
		}
		
		if(dtp_fin.getValue() == null) {
			erreur = erreur + "Le champ date fin est vide !\n";
			rempli = false;
		}else {
			if(dtp_fin.getValue().isBefore(dtp_deb.getValue())) {
				erreur = erreur + "La date de fin est supérieure à celle du début de l'abonnement !\n";
				rempli = false;
			}
		}
		
		
		
		if(rempli) {
			System.out.println("entrées cohérentes");
			if(ajout) {
				abo1 = new Abonnement(Integer.parseInt(txt_idC.getText()),Integer.parseInt(txt_idR.getText()),dtp_deb.getValue(),dtp_fin.getValue());
				reussi= dao.getAbonnementDAO().create(abo1);
			}else {
				abo1 = new Abonnement(Integer.parseInt(txt_idC.getText()),Integer.parseInt(txt_idR.getText()),dtp_deb.getValue(),dtp_fin.getValue());
				reussi= dao.getAbonnementDAO().update(abo1);
			}
			
			if(reussi) {
				
				final URL fxmlURL = getClass().getResource("../application/VueTableAbonnement.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				TableAbonnementController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
				this.setScene(scene);
				this.setTitle("Table Abonnement");
				this.show();
				
				Stage stage = (Stage) btn_confirmer.getScene().getWindow();
				stage.close();
			}
			else
				System.out.println("Il y a une erreur.");
		}else {
			
			Stage stage = (Stage) btn_confirmer.getScene().getWindow();
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.initOwner(stage);
			alert.setTitle("Erreur lors de la saisie");
			alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
			alert.setContentText(erreur);
			alert.showAndWait();
			
		}
	}

		
	
	public void quitter() throws IOException {
		
		final URL fxmlURL = getClass().getResource("../application/VueTableAbonnement.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		final VBox node = (VBox)fxmlLoader.load();
		Scene scene = new Scene(node);
		this.initModality(Modality.APPLICATION_MODAL);
		
		TableAbonnementController controleur = fxmlLoader.getController();
		fxmlLoader.setController(controleur);
		
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		this.setScene(scene);
		this.setTitle("Table Abonnement");
		this.show();
		
		Stage stage = (Stage) btn_quitter.getScene().getWindow();
		stage.close();
	}
}
