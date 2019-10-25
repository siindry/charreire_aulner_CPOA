package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.GroupLayout.Group;

import application.AccueilController;
import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metier.Periodicite;

public class TablePeriodiciteController {
	
	@FXML
	private TableView<Periodicite> tbl_periodicite = new TableView<Periodicite>();
	
	DAOFactory dao = AccueilController.dao;
	
	@FXML
	public void initialize() {
		

		TableColumn<Periodicite, String> colLibelle = new TableColumn<>("Libellé");
		TableColumn<Periodicite, String> colIdPer = new TableColumn<>("Numéro périodicite");
		
		colLibelle.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("libelle"));
		colIdPer.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("id_periodicite"));
		
		this.tbl_periodicite.getColumns().setAll(colIdPer, colLibelle);
		
		this.tbl_periodicite.getItems().addAll(dao.getPeriodiciteDAO().findAll());

	}



	
}
