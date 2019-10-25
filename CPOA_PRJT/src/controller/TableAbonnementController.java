package controller;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import metier.Abonnement;

public class TableAbonnementController {
	
	@FXML
	private Button btn_supp;
	
	@FXML
	private Button btn_ajout;
	
	@FXML
	private Button btn_modif;
	
	@FXML
	private TableView<Abonnement> tbl_abonnement = new TableView<Abonnement>();
	
	DAOFactory dao = AccueilController.dao;
	
	@FXML
	public void initialize() {
		
		TableColumn<Abonnement, String> colNumC = new TableColumn<>("Numéro Client");
		TableColumn<Abonnement, String> ColNom = new TableColumn<>("Numéro Revue");
		TableColumn<Abonnement, String> oolPrenom = new TableColumn<>("Date de début");
		TableColumn<Abonnement, String> colRue = new TableColumn<>("Date de fin");
		
		colNumC.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("id_client"));
		ColNom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("id_revue"));
		oolPrenom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("date_debut"));
		colRue.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("date_fin"));

		
		this.tbl_abonnement.getColumns().setAll(colNumC, ColNom, oolPrenom, colRue);
		
		this.tbl_abonnement.getItems().addAll(dao.getAbonnementDAO().findAll());
		
		tbl_abonnement.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        btn_supp.setDisable(false);
		        btn_ajout.setDisable(false);
		        btn_modif.setDisable(false);
		    }else {
		        btn_supp.setDisable(true);
		        btn_ajout.setDisable(true);
		        btn_modif.setDisable(true);
		    }
		});
		

	}
	
	public void affAddModAbo(){
		
	        int index = tbl_abonnement.getSelectionModel().getSelectedIndex();
	        Abonnement abo = tbl_abonnement.getItems().get(index);
	        System.out.println(abo.getId_client());
	    

	
	}
}
