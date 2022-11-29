package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneController implements Initializable{
	private Stage stage; 
	private Scene scene; 
	private Parent root; 
	
	@FXML
	GridPane academicSideBar; 
	GridPane engagementSideBar; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  TranslateTransition translate = new TranslateTransition();
		  translateGrid(translate, academicSideBar); 
		  // Not sure why but movement doesn't work for engagement page 
		  translateGrid(translate, engagementSideBar); 
	}
	
	public void goToHomePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/homepage.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setResizable(true);
		stage.show();
	}
	
	public void goToIdlePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/idle-page.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setResizable(true);
		stage.show();
	}
	
	public void goToUndergradPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/undergraduate-program.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToGraduatePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/graduate-program.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToAcademicsPage(ActionEvent e) throws IOException{
		
		
		String pathOfNewFile = "/pages/academics.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToEngagementPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/engagement.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToResourcesPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/resources.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToInternshipsPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/internships.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	public void goToClubsPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/clubs.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}

	// TODO: use this to simplify code later
	private void addPath(ActionEvent e, String path) throws IOException{
		root = FXMLLoader.load(getClass().getResource(path));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}

	private void translateGrid(TranslateTransition translate, GridPane gp) {
		  translate.setNode(gp);
		  translate.setDuration(Duration.millis(1000));
		  translate.setCycleCount(1);
		  translate.setByX(-1000);
		  translate.play();
	}
}
