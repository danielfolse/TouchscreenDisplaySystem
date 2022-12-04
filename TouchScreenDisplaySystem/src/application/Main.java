package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import org.apache.commons.lang.time.StopWatch;


public class Main extends Application {
	final int SCREEN_WIDTH = 1920;
	final int SCREEN_HEIGHT = 1080;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			StopWatch watch = new StopWatch();
			String rootPath = "/pages/idle-page.fxml";
			Parent root = FXMLLoader.load(getClass().getResource(rootPath));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
