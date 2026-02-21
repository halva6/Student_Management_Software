package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StartScreenController
{

	public static String START_SCREEN_FXML_PATH = "/StartScreenView.fxml";

	@FXML
	private Button startButton;

	private Scene scene;

	@FXML
	private void startMainScreen()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(MainScreenController.MAIN_SCREEN_FXML_PATH));
			Parent mainRoot = loader.load();
			scene.setRoot(mainRoot);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void setScene(Scene scene)
	{
		this.scene = scene;
	}
}
