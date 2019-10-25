package application;

import java.net.URL;

import controller.RevueController;
import controller.TableAbonnementController;
import controller.TableClientController;
import controller.TablePeriodiciteController;
import controller.TableRevueController;
import dao.factory.DAOFactory;
import enumeration.EPersistance;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccueilController extends Stage{
	
	int iTable;
	private Stage secondStage = new Stage();
	public static DAOFactory dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
	
	@FXML
	private Label lbl_type;

	
	@FXML
	public void affPeriodicite(){
		
		try {
			
			
			final URL fxmlURL = getClass().getResource("VueTablePeriodicite.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			TablePeriodiciteController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Table Periodicite");
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}



		
	}
	
	@FXML
	public void affRevue(){
		
		try {
			
			
			final URL fxmlURL = getClass().getResource("VueTableRevue.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			TableRevueController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Table Revue");
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void affClient(){
		
		try {
			
			
			final URL fxmlURL = getClass().getResource("VueTableClient.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			TableClientController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Table Client");
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void affAbo(){
		
		try {
			
			
			final URL fxmlURL = getClass().getResource("VueTableAbonnement.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			this.initModality(Modality.APPLICATION_MODAL);
			
			TableAbonnementController controleur = fxmlLoader.getController();
			fxmlLoader.setController(controleur);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Table Abonnement");
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
				
				TablePeriodiciteController controleur = fxmlLoader.getController();
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
				
				TableRevueController controleur = fxmlLoader.getController();
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
				
				TableClientController controleur = fxmlLoader.getController();
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
				
				TableAbonnementController controleur = fxmlLoader.getController();
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
		AccueilController.dao = DAOFactory.getDAOFactory(EPersistance.MYSQL);
		lbl_type.setText("Vous actuellement en SQL");
	}
	
	public void goListeMemoire(){
		AccueilController.dao = DAOFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
		lbl_type.setText("Vous actuellement en Liste Mémoire");
	}
	
	public void openSupp(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
