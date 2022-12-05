package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileWriter;

public class SceneController implements Initializable{
	private final int IDLE_TIME_SEC = 5; //eventually change to 900 for 15 min 
	private Stage stage; 
	private Scene scene; 
	private Parent root;
	private PauseTransition pause; 

	@FXML
	GridPane sideBar;
	@FXML
	GridPane homeSideBar;
	@FXML
	Text newsTicker;
	@FXML
	Button invisIdlePageBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition translate = new TranslateTransition();
		translateGrid(-763, translate, sideBar);
		translateGrid(763, translate, homeSideBar);
		translateText(1920, translate, newsTicker);
		
        if(invisIdlePageBtn != null) {
    		pause = new PauseTransition(Duration.seconds(IDLE_TIME_SEC));
            invisIdlePageBtn.setOpacity(0);
            invisIdlePageBtn.setDisable(true);
            pause.setOnFinished(e -> translateBtn(translate, invisIdlePageBtn));
            pause.play();
        }
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
//	public void WriteStatsToFile(StopWatch watch){
//		try {
//			FileWriter myWriter = new FileWriter("TimeStats.txt");
//			myWriter.write("Total Time not on Idle: " + watch.getTime());
//			myWriter.close();
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
//	}
	private void translateGrid(int distance, TranslateTransition translate, GridPane gp) {
		translate.setNode(gp);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(1);
		translate.setByX(distance);
		translate.play();
	}
	
	private void translateBtn(TranslateTransition translate, Button btn) {
		invisIdlePageBtn.setText("Program has been inactive for " + IDLE_TIME_SEC/60 
				+ " minutes.\n Click here to go to the home page.");
		invisIdlePageBtn.setPrefSize(800, 800);
        invisIdlePageBtn.setDisable(false);
        invisIdlePageBtn.setOpacity(1);
        translate.setNode(btn);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(1);
        translate.setByX(650);
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
