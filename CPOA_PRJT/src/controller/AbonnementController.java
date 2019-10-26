package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Abonnement;


public class AbonnementController extends Stage{
	
	Stage window = new Stage();
	
	@FXML
	private TextField txt_idC;
	
	@FXML
	private TextField txt_idR;
	
	@FXML
	private Button btn_quitter;
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private DatePicker dtp_deb;
	
	@FXML
	private DatePicker dtp_fin;
	
	int idC = TableAbonnementController.idC;
	int idR = TableAbonnementController.idR;
	LocalDate dtDeb = TableAbonnementController.dtDeb;
	LocalDate dtFin = TableAbonnementController.dtFin;
	boolean ajout = TableAbonnementController.ajout;
	DAOFactory dao = AccueilController.dao;
	
	
	@FXML
	public void initialize() {
		
		if(ajout) {
			
		}else {
			txt_idC.setText((String.valueOf(idC)));
			txt_idR.setText((String.valueOf(idR)));
			
			dtp_deb.setValue(dtDeb);
			dtp_fin.setValue(dtFin);
			
	
		}

	}
	
	public void sendToDB() throws SQLException, IOException {
		
		if(ajout) {
			
		}else {
			Abonnement abo1 = new Abonnement(Integer.parseInt(txt_idC.getText()),Integer.parseInt(txt_idR.getText()),dtp_deb.getValue(),dtp_fin.getValue());
			boolean reussi= dao.getAbonnementDAO().update(abo1);
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
				window.setScene(scene);
				window.setTitle("Table Abonnement");
				window.show();
			}
			else
				System.out.println("Il y a une erreur.");
			
		}

		
	}
	
	public void quitter() {
		Stage stage = (Stage) btn_quitter.getScene().getWindow();
		stage.close();
	}
}
