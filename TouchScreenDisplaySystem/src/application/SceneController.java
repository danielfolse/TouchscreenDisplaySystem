package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class SceneController implements Initializable{
	private final int IDLE_TIME_SEC = 900; //eventually change to 900 for 15 min
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String pathOfNewFile;
	private PauseTransition pause;

	public long interactionCounter;
	public long clickCounter = 0;

	@FXML
	GridPane sideBar;
	@FXML
	GridPane homeSideBar;
	@FXML
	Text newsTicker;
	@FXML
	Button invisIdlePageBtn;
 	@FXML


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition translate = new TranslateTransition();
		TranslateTransition translateNews = new TranslateTransition();
		translateGrid(-763, translate, sideBar);
		translateGrid(763, translate, homeSideBar);
		String[] newsItems = new String[0];
		try {
			newsItems = readTextFromFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		translateText(translateNews, newsTicker, newsItems);
		if (invisIdlePageBtn != null) {
			pause = new PauseTransition(Duration.seconds(IDLE_TIME_SEC));
			invisIdlePageBtn.setOpacity(0);
			invisIdlePageBtn.setDisable(true);
			pause.setOnFinished(e -> translateBtn(translate, invisIdlePageBtn));
			pause.play();
		}
	}

	public void goToHomePage(ActionEvent e) throws IOException {
		if(homeSideBar == null && sideBar == null){
			long initialTime = System.currentTimeMillis();
		}
		pathOfNewFile = "/pages/homepage.fxml";
		addLink(e, pathOfNewFile);
	}

	public void goToIdlePage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/idle-page.fxml";
		addLink(e, pathOfNewFile);
	}

	@FXML
	public void goToUndergradPage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/undergraduate-program.fxml";
		transitionBetween(e, pathOfNewFile);
	}

	public void goToGraduatePage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/graduate-program.fxml";
		transitionBetween(e, pathOfNewFile);
	}

	public void goToAcademicsPage(ActionEvent e) throws IOException {
		if(homeSideBar == null) {
			pathOfNewFile = "/pages/academics.fxml";
			transitionBetween(e, pathOfNewFile);
		}
		else {
			pathOfNewFile = "/pages/academics.fxml";
			addLink(e, pathOfNewFile);
		}
	}

	public void goToEngagementPage(ActionEvent e) throws IOException {
		if(homeSideBar == null) {
			pathOfNewFile = "/pages/engagement.fxml";
			transitionBetween(e, pathOfNewFile);
		}
		else {
			pathOfNewFile = "/pages/engagement.fxml";
			addLink(e, pathOfNewFile);
		}
	}

	public void goToResourcesPage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/resources.fxml";
		transitionBetween(e, pathOfNewFile);
	}

	public void goToInternshipsPage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/internships.fxml";
		transitionBetween(e, pathOfNewFile);
	}

	public void goToClubsPage(ActionEvent e) throws IOException {
		pathOfNewFile = "/pages/clubs.fxml";
		transitionBetween(e, pathOfNewFile);
	}


	private void addLink(ActionEvent e, String path) throws IOException {
		root = FXMLLoader.load(getClass().getResource(path));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.getScene().setRoot(root);
	}

	public void test(ActionEvent e) throws IOException {
		System.out.println("I work");
	}

	public void transitionBetween (ActionEvent e, String pathOfNewFile){
		TranslateTransition translate = new TranslateTransition();
		translateGrid(763, translate, sideBar);
		translate.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					addLink(e, pathOfNewFile);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
	}
	private void translateGrid(int distance, TranslateTransition translate, GridPane gp) {
		translate.setNode(gp);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(1);
		translate.setByX(distance);
		translate.play();
	}

	private void translateBtn(TranslateTransition translate, Button btn) {
		invisIdlePageBtn.setText("Program has been inactive for " + IDLE_TIME_SEC / 60
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

	@FXML
	private void translateText(TranslateTransition translate, Text newsTicker, String[] newsItems) {
		int distance = 0;
		int time = 0;
		for (int i = 0; i < newsItems.length; i++) {
			newsTicker.setText(newsTicker.getText() + "                                                  " + newsItems[i]);
			distance = distance - 10 * (newsItems[i].length() + 50);
			time = time + 100 * newsItems[i].length();
		}
		translate.setNode(newsTicker);
		translate.setDuration(Duration.millis(time));
		translate.setCycleCount(10);
		translate.setByX(distance);
		translate.play();

	}
	private String[] readTextFromFile() throws IOException {
		List<String> arr = new ArrayList();
		BufferedReader bfrdr = new BufferedReader(new FileReader("C:\\TouchScreenDisplaySystem\\announcements.txt"));

		String newsItem = bfrdr.readLine();

		while(newsItem != null){
			arr.add(newsItem);
			newsItem = bfrdr.readLine();
		}
		bfrdr.close();

		String[] announcementArray = arr.toArray(new String[0]);
		return announcementArray;
	}
}

