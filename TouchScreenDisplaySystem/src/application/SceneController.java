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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.lang.time.StopWatch;
import java.io.FileWriter;

public class SceneController implements Initializable{
	private Stage stage; 
	private Scene scene; 
	private Parent root;
	StopWatch watch;
	@FXML
	GridPane sideBar;
	@FXML
	GridPane homeSideBar;
	@FXML
	Text newsTicker;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition translate = new TranslateTransition();
		translateGrid(-763, translate, sideBar);
		translateGrid(763, translate, homeSideBar);
		translateText(1920, translate, newsTicker);
	}
	
	public void goToHomePage(ActionEvent e) throws IOException{
		//watch.start();
		String pathOfNewFile = "/pages/homepage.fxml";
		addLink(e, pathOfNewFile);
	}
	
	public void goToIdlePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/idle-page.fxml";
		addLink(e, pathOfNewFile);
		//watch.stop();
		//WriteStatsToFile(watch);
	}
	
	public void goToUndergradPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/undergraduate-program.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToGraduatePage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/graduate-program.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToAcademicsPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/academics.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToEngagementPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/engagement.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToResourcesPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/resources.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToInternshipsPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/internships.fxml";
		addLink(e, pathOfNewFile);
	}
	public void goToClubsPage(ActionEvent e) throws IOException{
		String pathOfNewFile = "/pages/clubs.fxml";
		addLink(e, pathOfNewFile);
	}


	private void addLink(ActionEvent e, String path) throws IOException{
		root = FXMLLoader.load(getClass().getResource(path));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.getScene().setRoot(root);

	}

	public void test(ActionEvent e) throws IOException {
		System.out.println("I work");
	}
	public void WriteStatsToFile(StopWatch watch){
		try {
			FileWriter myWriter = new FileWriter("TimeStats.txt");
			myWriter.write("Total Time not on Idle: " + watch.getTime());
			myWriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	private void translateGrid(int distance, TranslateTransition translate, GridPane gp) {
		translate.setNode(gp);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(1);
		translate.setByX(distance);
		translate.play();
	}

	private void translateText(int distance, TranslateTransition translate, Text newsTicker) {
		translate.setNode(newsTicker);
		translate.setDuration(Duration.millis(2000));
		translate.setCycleCount(1);
		translate.setByX(distance);
		for(int i = 0; i < 100; i++) {
			translate.play();
		}

	}

}
