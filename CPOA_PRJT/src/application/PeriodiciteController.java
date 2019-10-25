package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import metier.Periodicite;

public class PeriodiciteController implements Initializable {

	
	@FXML
	private Label lbl_res;
	
	@FXML 
	private Label lbl_addmod_periodicite;
	
	@FXML
	private Button btn_confirmer;
	
	@FXML 
	private Button btn_annuler;
	
	@FXML
	private TextField txt_periodicite ;


	DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	String daoT = null;
	
	@FXML
	private void button() throws SQLException{
		
		String periodicite = txt_periodicite.getText();
		
		String str = "Périodicité : " + periodicite;
		
		Periodicite p1 = new Periodicite(periodicite);
		lbl_res.setText(str);
		dao.getPeriodiciteDAO().create(p1); 
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle resources) {
		dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		
	}
}
