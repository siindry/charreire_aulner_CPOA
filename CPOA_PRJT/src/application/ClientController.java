package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import metier.Client;

public class ClientController implements Initializable{
	
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private TextField txt_nom;
	
	@FXML
	private TextField txt_prenom;
	
	@FXML
	private TextField txt_no_rue;
	
	@FXML
	private TextField txt_voie;
	
	@FXML
	private TextField txt_code_postal;
	
	@FXML
	private TextField txt_ville;
	
	@FXML
	private TextField txt_pays;

	DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	String daoT = null;
	

	@FXML
    private void button() throws SQLException { 
		
		String nom = txt_nom.getText();
		String prenom = txt_prenom.getText();
		String no_rue = txt_no_rue.getText();
		String voie = txt_voie.getText();
		String code_postal = txt_code_postal.getText();
		String ville = txt_ville.getText();
		String pays = txt_pays.getText();
		
		
		
        String str = nom + " " + prenom + ", habitant à " + no_rue + " " + voie + " à " + code_postal + " "+ ville + " " + pays;
       
        Client c1 = new Client(0, nom, prenom, no_rue, voie, code_postal, ville, pays);
        lbl_res.setText(str);
        dao.getClientDAO().create(c1);
        
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		
	}

}
