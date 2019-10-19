package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import metier.Periodicite;


public class PeriodiciteController implements Initializable{
	
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private Label txt_titre;
	
DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	String daoT = null;
	
	@FXML
    private void button() throws SQLException { 
		
		String titre = txt_titre.getText();
       
        Periodicite p1 = new Periodicite(0, titre);
        lbl_res.setText(p1.toString());
        dao.getPeriodiciteDAO().create(p1);
        
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}