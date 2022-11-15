package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage; 
	private Scene scene; 
	private Parent root; 
	
	public void goToHomePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/homepage.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToIdlePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/idle-page.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToUndergradPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/undergraduate-program.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile)); 
		scene = new Scene(root); 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow(); 
		stage.setScene(scene);
		stage.show();
	}
	public void goToGraduatePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/graduate-program.fxml";
		root = FXMLLoader.load(getClass().getResource(pathOfNewFile));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}


	public void test(ActionEvent e) throws IOException{
		System.out.println("I work");	
	}
}
