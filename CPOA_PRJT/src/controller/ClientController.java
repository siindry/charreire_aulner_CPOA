package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.AccueilController;
import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Client;


public class ClientController extends Stage{
	
	@FXML
	private Label lbl_titre;
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private TextField txt_nom;
	
	@FXML
	private TextField txt_prenom;
	
	@FXML
	private TextField txt_no_rue;
	
	@FXML
	private TextField txt_voie;
	
	@FXML
	private TextField txt_code_postal;
	
	@FXML
	private TextField txt_ville;
	
	@FXML
	private TextField txt_pays;
	
	@FXML
	private Button btn_confirmer;
	
	@FXML
	private Button btn_quitter;
	

	int idC = TableClientController.idC; //8champs
	String nom = TableClientController.nom;
	String prenom = TableClientController.prenom;
	String no_rue = TableClientController.no_rue;
	String voie = TableClientController.voie;
	String cP = TableClientController.cP;
	String ville = TableClientController.ville;
	String pays = TableClientController.pays;
	
	boolean ajout = TableClientController.ajout; //récupère le ajout=1 ou modif=0
	
	DAOFactory dao = AccueilController.dao;
	
	Stage erreurStage = new Stage();
	

	/*@FXML
    private void button() throws SQLException { 
		
		String nom = txt_nom.getText();
		String prenom = txt_prenom.getText();
		String no_rue = txt_no_rue.getText();
		String voie = txt_voie.getText();
		String code_postal = txt_code_postal.getText();
		String ville = txt_ville.getText();
		String pays = txt_pays.getText();
		
		
		
        String str = nom + " " + prenom + ", habitant à " + no_rue + " " + voie + " à " + code_postal + " "+ ville + " " + pays;
       
        Client c1 = new Client(0, nom, prenom, no_rue, voie, code_postal, ville, pays);
        lbl_res.setText(str);
        dao.getClientDAO().create(c1);
        
	}*/
	
	

	@FXML
	public void initialize() throws SQLException{
		if(ajout) {
					
					lbl_titre.setText("Ajout dans la table Client");
					//tout est vide
					}
					
		else 
				{
					lbl_titre.setText("Modification de la table Client");
					
					//txt_idC.setText((String.valueOf(idC))); pas utile
					txt_nom.setText((String.valueOf(nom)));
					txt_prenom.setText((String.valueOf(prenom)));
					txt_no_rue.setText((String.valueOf(no_rue)));
					txt_voie.setText((String.valueOf(voie)));
					txt_code_postal.setText((String.valueOf(cP)));
					txt_ville.setText((String.valueOf(ville)));
					txt_pays.setText((String.valueOf(pays)));
					
		
				}
		
			}
	
	public void sendToDB() throws SQLException, IOException {
			
			boolean reussi;
			Client c1;
			
			boolean rempli = true;
			String erreur = "";
			
			System.out.println("appui");
			
			if(txt_nom.getText().isEmpty()) {
				erreur = erreur + "Vous devez sélectionner un Nom !\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_prenom.getText().isEmpty()) {
				erreur = erreur + "Vous devez sélectionner une Prenom !\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_no_rue.getText() == null) {
				erreur = erreur + "Vous devez sélectionner un numéro de rue !\\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_voie.getText() == null) {
				erreur = erreur + "Vous devez sélectionner une rue !\\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_code_postal.getText() == null) {
				erreur = erreur + "Vous devez sélectionner un code postal !\\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_ville.getText() == null) {
				erreur = erreur + "Vous devez sélectionner une ville !\\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			if(txt_pays.getText() == null) {
				erreur = erreur + "Vous devez sélectionner un pays !\\n";
				System.out.println("FAUX");
				rempli = false;
			}
			
			///ici
			
			if(rempli) {
				System.out.println("test rempli");
				if(ajout) {
					c1 = new Client(idC,txt_nom.getText(),txt_prenom.getText(),txt_no_rue.getText(),txt_voie.getText(),txt_code_postal.getText(),txt_ville.getText(),txt_pays.getText());
					reussi= dao.getClientDAO().create(c1);
				}else {
					c1 = new Client(idC,txt_nom.getText(),txt_prenom.getText(),txt_no_rue.getText(),txt_voie.getText(),txt_code_postal.getText(),txt_ville.getText(),txt_pays.getText());
					reussi= dao.getClientDAO().update(c1);
				}
				
				if(reussi) {//!!!
					lbl_res.setText("yo res");
					final URL fxmlURL = getClass().getResource("../application/VueTableClient.fxml");
					final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
					final VBox node = (VBox)fxmlLoader.load();
					Scene scene = new Scene(node);
					this.initModality(Modality.APPLICATION_MODAL);
					
					TableClientController controleur = fxmlLoader.getController();
					fxmlLoader.setController(controleur);
					
					scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
					this.setScene(scene);
					this.setTitle("Table Client");
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
		
		final URL fxmlURL = getClass().getResource("../application/VueTableClient.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		final VBox node = (VBox)fxmlLoader.load();
		Scene scene = new Scene(node);
		this.initModality(Modality.APPLICATION_MODAL);
		
		TableClientController controleur = fxmlLoader.getController();
		fxmlLoader.setController(controleur);
		
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		this.setScene(scene);
		this.setTitle("Table Client");
		this.show();
		
		Stage stage = (Stage) btn_quitter.getScene().getWindow();
		stage.close();
	}

		
		

			
	}


