package application;

import java.net.URL;
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
import metier.Periodicite;
import metier.Revue;

public class RevueController implements Initializable{
	
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

	
	DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
	
	String daoT = null;
	

	@FXML
    private void button() { 
		
		
		String titre = txt_titre.getText();
		String desc = txt_desc.getText();
		String tarif = txt_tarif.getText();
		String periodicite = combo_periodicite.getSelectionModel().getSelectedItem().toString();
		Double tarifDoub = Double.parseDouble(tarif);
		
		Periodicite p1 = dao.getPeriodiciteDAO().getByLib(periodicite);
		int noPeriod = p1.getId_periode();
		
        String str = titre + " " + desc + " (" + tarif + " euros)";
        lbl_res.setText(str);
        Revue r1 = new Revue(0, titre, desc, tarifDoub, "aucun", noPeriod);
        dao.getRevueDAO().create(r1);
        
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<String> rPer = new ArrayList<String>();
		ArrayList<Periodicite> arrP1 = dao.getPeriodiciteDAO().findAll();
		
		Periodicite p1 = null;
		String period = null;
		

		for(int i=0; i<arrP1.size(); i++) {
			p1 = arrP1.get(i);
			period = p1.getLibelle();
				
			rPer.add(period);
		}

		
		
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
		lbl_type.setText("Vous etes actuellement en SQL : ");
		daoT = "sql";
	}
	
	@FXML 
    private void goMemoire() { 
		dao = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
		lbl_type.setText("Vous etes actuellement en Liste Memoire : ");
			daoT = "liste";
	}


}
