package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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


public class AbonnementController extends Stage{
	
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
	
	int idC = TableAbonnementController.idC;
	int idR = TableAbonnementController.idR;
	LocalDate dtDeb = TableAbonnementController.dtDeb;
	LocalDate dtFin = TableAbonnementController.dtFin;
	
	boolean ajout = TableAbonnementController.ajout;
	
	DAOFactory dao = AccueilController.dao;
	
	
	@FXML
	public void initialize() throws SQLException {
		
		if(ajout) {
			
			lbl_titre.setText("Ajout dans la table Abonnement");
			
			ArrayList<Client> c1 = dao.getClientDAO().findAllNomPrenom();
			ArrayList<String> listeNomPre = new ArrayList<String>();
			for (int i=0; i<c1.size()-1; i++) {
				Client c2 = c1.get(i);
				listeNomPre.add(c2.getNom() + " " + c2.getPrenom());
			}
			this.combo_client.setItems(FXCollections.observableArrayList(listeNomPre));
			
			
			
			ArrayList<Revue> r1 = dao.getRevueDAO().findAllTitreDesc();
			ArrayList<String> listeTitreDesc = new ArrayList<String>();
			for (int i=0; i<c1.size(); i++) {
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
			
			ArrayList<String> c1 = dao.getAbonnementDAO().getClient(idC);
			ArrayList<String> r1 = dao.getAbonnementDAO().getRevue(idR);
			
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
		
		if(ajout) {
			abo1 = new Abonnement(Integer.parseInt(txt_idC.getText()),Integer.parseInt(txt_idR.getText()),dtp_deb.getValue(),dtp_fin.getValue());
			reussi= dao.getAbonnementDAO().create(abo1);
		}else {
			abo1 = new Abonnement(Integer.parseInt(txt_idC.getText()),Integer.parseInt(txt_idR.getText()),dtp_deb.getValue(),dtp_fin.getValue());
			reussi= dao.getAbonnementDAO().update(abo1);
		}
		if(reussi) {
				lbl_res.setText(abo1.toString());
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
