package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RevueController {
	
	@FXML
	private Label lbl_res;
	
	@FXML
	private TextField txt_titre;
	
	@FXML
	private TextField txt_desc;
	
	@FXML
	private TextField txt_tarif;

	
	@FXML 
    private void button() { 
		
        String str = txt_titre.getText() + " " +   txt_desc.getText() + " (" + txt_tarif.getText() + " euros)";
        lbl_res.setText(str);
	}
}
