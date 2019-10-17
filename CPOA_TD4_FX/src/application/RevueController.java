package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RevueController {
	
	@FXML
	private Label lbl_tarif;
	
	
	@FXML 
    private void button() { 
		
        System.out.println(lbl_tarif.getText()); 
    } 
	
}
