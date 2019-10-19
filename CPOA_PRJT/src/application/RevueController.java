package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

public class RevueController implements Initializable{
	
	private Stage stage = null;
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private Label lbl_type;
	
	@FXML
	private TextField txt_titre;
	
	@FXML
	private TextField txt_desc;
	
	@FXML
	private TextField txt_tarif;

	@FXML
	private ChoiceBox<String> combo_periodicite;
	
	DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	String daoT = null;
	

	@FXML
    private void button() throws SQLException { 
		
		String titre = txt_titre.getText();
		String desc = txt_desc.getText();
		String tarif = txt_tarif.getText();
		String periodicite = combo_periodicite.getSelectionModel().getSelectedItem().toString();
		Double tarifDoub = Double.parseDouble(tarif);
		
		Periodicite p1 = dao.getPeriodiciteDAO().getByLib(periodicite);
		int noPeriod = p1.getId_periode();
		
        String str = titre + " " + desc + " (" + tarif + " euros)";
       
        Revue r1 = new Revue(0, titre, desc, tarifDoub, "aucun", noPeriod);
        lbl_res.setText(r1.toString());
        dao.getRevueDAO().create(r1);
        
	}

	public void Changement() {
		
		ArrayList<String> rPer = dao.getPeriodiciteDAO().findAllStr();	
		
	    this.combo_periodicite.setItems(FXCollections.observableArrayList(rPer));
	    lbl_type.setText("Vous etes actuellement en Liste Memoire : ");
		
	}
	
	@FXML 
    private void affiche() { 
		dao.getRevueDAO().findAll();
			
	}
	
	@FXML 
    private void goSQL() { 
		dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		this.combo_periodicite.setItems(FXCollections.observableArrayList());
		Changement();
		lbl_type.setText("Vous etes actuellement en SQL : ");
		daoT = "sql";
	}
	
	@FXML 
    private void goMemoire() { 
		dao = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
		this.combo_periodicite.setItems(FXCollections.observableArrayList());
		Changement();
		lbl_type.setText("Vous etes actuellement en Liste Memoire : ");
			daoT = "liste";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}
	
	public void setStage(Stage stage) {
	    this.stage = stage;
	}


}
