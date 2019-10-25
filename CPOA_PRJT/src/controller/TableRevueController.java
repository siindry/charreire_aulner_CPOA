package controller;

import application.AccueilController;
import dao.factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.Revue;

public class TableRevueController {
	
	@FXML
	private TableView<Revue> tbl_revue = new TableView<Revue>();
	
	DAOFactory dao = AccueilController.dao;
	
	@FXML
	public void initialize() {
		

		TableColumn<Revue, String> colNumR = new TableColumn<>("Numéro Revue");
		TableColumn<Revue, String> colTitre = new TableColumn<>("Titre");
		TableColumn<Revue, String> colDesc = new TableColumn<>("Description");
		TableColumn<Revue, String> colTarif = new TableColumn<>("Tarif");
		TableColumn<Revue, String> colVisuel = new TableColumn<>("Visuel");
		TableColumn<Revue, String> colIdP = new TableColumn<>("Periodicite");

		
		colNumR.setCellValueFactory(new PropertyValueFactory<Revue, String>("id_revue"));
		colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));
		colDesc.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));
		colTarif.setCellValueFactory(new PropertyValueFactory<Revue, String>("tarif"));
		colVisuel.setCellValueFactory(new PropertyValueFactory<Revue, String>("visuel"));
		colIdP.setCellValueFactory(new PropertyValueFactory<Revue, String>("id_periodicite"));
		
		this.tbl_revue.getColumns().setAll(colNumR, colTitre, colDesc, colTarif, colVisuel, colIdP);
		
		this.tbl_revue.getItems().addAll(dao.getRevueDAO().findAll());

	}
	
}
