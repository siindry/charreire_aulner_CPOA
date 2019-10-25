package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.AccueilController;
import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.Client;
import metier.Periodicite;

public class TableClientController {
	
	@FXML
	private TableView<Client> tbl_client = new TableView<Client>();
	
	DAOFactory dao = AccueilController.dao;
	
	@FXML
	public void initialize() {
		

		TableColumn<Client, String> colNumC = new TableColumn<>("Numéro client");
		TableColumn<Client, String> ColNom = new TableColumn<>("Nom");
		TableColumn<Client, String> oolPrenom = new TableColumn<>("Prenom");
		TableColumn<Client, String> colRue = new TableColumn<>("Numéro de rue");
		TableColumn<Client, String> colVoie = new TableColumn<>("Voie");
		TableColumn<Client, String> colIdP = new TableColumn<>("Code postal");
		TableColumn<Client, String> colVille = new TableColumn<>("Ville");
		TableColumn<Client, String> colPays = new TableColumn<>("Pays");
		
		colNumC.setCellValueFactory(new PropertyValueFactory<Client, String>("id_client"));
		ColNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
		oolPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
		colRue.setCellValueFactory(new PropertyValueFactory<Client, String>("no_rue"));
		colVoie.setCellValueFactory(new PropertyValueFactory<Client, String>("voie"));
		colIdP.setCellValueFactory(new PropertyValueFactory<Client, String>("id_periodicite"));
		colVille.setCellValueFactory(new PropertyValueFactory<Client, String>("ville"));
		colPays.setCellValueFactory(new PropertyValueFactory<Client, String>("pays"));
		
		this.tbl_client.getColumns().setAll(colNumC, ColNom, oolPrenom, colRue, colVoie, colIdP, colVille, colPays);
		
		this.tbl_client.getItems().addAll(dao.getClientDAO().findAll());

	}
	
	
}
