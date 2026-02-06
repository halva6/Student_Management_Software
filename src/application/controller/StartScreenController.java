package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class StartScreenController extends Controller{
	
	public static String START_SCREEN_FXML_PATH = "/StartScreenView.fxml";
	
	@FXML
	private Button startButton;

	@FXML
	private void startMainScreen() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(MainScreenController.MAIN_SCREEN_FXML_PATH));
			Parent mainRoot = loader.load();
			
			MainScreenController mainScreenController = loader.getController();
			mainScreenController.setScene(scene);
			
			scene.setRoot(mainRoot);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
