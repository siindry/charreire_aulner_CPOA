package application;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccueilController extends Stage{
	
	int iTable;
	private Stage secondStage = new Stage();
	

	
	@FXML
	public void affPeriodicite(){
		
		try {
			
			
			final URL fxmlURL = getClass().getResource("VueTablePeriodicite.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			RevueController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Ajout Periodicite");
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}



		
	}
	
	@FXML
	public void affRevue(){
		
		iTable = 2;
		
	}
	
	@FXML
	public void affClient(){
		
		iTable = 3;
		
	}
	
	@FXML
	public void affAbo(){
		
		iTable = 4;
		
	}
	
	@FXML
	public void openAjout(){
		
		switch(iTable){
			
		case 1:
			try {
			
				
				final URL fxmlURL = getClass().getResource("VueTablePeriodicite.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				RevueController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(scene);
				secondStage.setTitle("Ajout Periodicite");
				secondStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		
		
		case 2:
			try {
			
				final URL fxmlURL=getClass().getResource("Revue2.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				RevueController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(scene);
				secondStage.setTitle("Ajout Revue");
				secondStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			try {
			
				final URL fxmlURL=getClass().getResource("Client.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				RevueController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(scene);
				secondStage.setTitle("Ajout Client");
				secondStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		
		case 4:
			try {
			
				final URL fxmlURL=getClass().getResource("Abonnement.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final VBox node = (VBox)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.initModality(Modality.APPLICATION_MODAL);
				
				RevueController controleur = fxmlLoader.getController();
				fxmlLoader.setController(controleur);
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondStage.setScene(scene);
				secondStage.setTitle("Ajout Abonnement");
				secondStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			break;
		
		}

		
	}
	
	public void openModif(){
		
		
		
	}
	
	public void goSQL(){
		
	}
	
	public void goListeMemoire(){
		
	}
	
	public void openSupp(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
