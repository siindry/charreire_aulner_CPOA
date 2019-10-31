package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Abonnement;


public class TableAbonnementController extends Stage{
	
	@FXML
	private Button btn_supp;
	
	@FXML
	private Button btn_ajout;
	
	@FXML
	private Button btn_modif;
	
	@FXML
	private Button btn_retour;
	
	@FXML
	private TableView<Abonnement> tbl_abonnement = new TableView<Abonnement>();
	
	public static int idC; 
	public static int idR; 
	public static LocalDate dtDeb;
	public static LocalDate dtFin;
	public static boolean ajout; //booleen pour savoir quelle fenetre on va ouvrir entre ajout (true) ou modif (false)
	
	DAOFactory dao = AccueilController.dao;
	private Stage window = new Stage();
	
	@FXML
	public void initialize() {
		
		TableColumn<Abonnement, String> colNumC = new TableColumn<>("Numéro Client");
		TableColumn<Abonnement, String> ColNumR = new TableColumn<>("Numéro Revue");
		TableColumn<Abonnement, String> oolDtDeb = new TableColumn<>("Date de début");
		TableColumn<Abonnement, String> colDtFin = new TableColumn<>("Date de fin");
		
		colNumC.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("id_client"));
		ColNumR.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("id_revue"));
		oolDtDeb.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("date_debut"));
		colDtFin.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("date_fin"));

		
		this.tbl_abonnement.getColumns().setAll(colNumC, ColNumR, oolDtDeb, colDtFin);
		
		this.tbl_abonnement.getItems().addAll(dao.getAbonnementDAO().findAll());
		
		tbl_abonnement.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        btn_supp.setDisable(false);
		        btn_modif.setDisable(false);
		    }else {
		        btn_supp.setDisable(true);
		        btn_modif.setDisable(true);
		    }
		});
		

	}
	
	public void affModAbo(){
		
	        int index = tbl_abonnement.getSelectionModel().getSelectedIndex();
	        Abonnement abo = tbl_abonnement.getItems().get(index);
			idC = abo.getId_client();
			idR = abo.getId_revue();
			dtDeb = abo.getDate_debut();
			dtFin = abo.getDate_fin();
	        ajout=false;
	        
			try {
				
				
				final URL fxmlURL = getClass().getResource("../application/VueAddModAbo.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				AbonnementController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("../application./application.css").toExternalForm());
				window.setScene(scene);
				window.setTitle("Modification Revue");
				window.show();
				
				Stage stage = (Stage) btn_modif.getScene().getWindow();
				stage.close();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    

	
	}
	
	public void affAddAbo(){

        ajout=true;
        
		try {
			
			
			final URL fxmlURL = getClass().getResource("../application/VueAddModAbo.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			AbonnementController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			window.setScene(scene);
			window.setTitle("Abonnement");
			window.show();
			
			Stage stage = (Stage) btn_ajout.getScene().getWindow();
			stage.close();
			
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void quitter() throws IOException {
		
		final URL fxmlURL = getClass().getResource("../application/Accueil.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		final VBox node = (VBox)fxmlLoader.load();
		Scene scene = new Scene(node);
		this.initModality(Modality.APPLICATION_MODAL);
		
		AccueilController controleur = fxmlLoader.getController();
		fxmlLoader.setController(controleur);
		
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		this.setScene(scene);
		this.setTitle("Accueil");
		this.show();
		
		Stage stage = (Stage) btn_retour.getScene().getWindow();
		stage.close();
		
	}
	
	public void supprimer() throws IOException {
		
		int index = tbl_abonnement.getSelectionModel().getSelectedIndex();
        Abonnement abo = tbl_abonnement.getItems().get(index);
        dao.getAbonnementDAO().delete(abo);
        
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
		
		Stage stage = (Stage) btn_supp.getScene().getWindow();
		stage.close();
		
	}
	
	
	
	
	
	
	
}
