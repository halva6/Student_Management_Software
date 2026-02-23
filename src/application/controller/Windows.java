package application.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Windows<T>
{
	private Stage stage = new Stage();
	private T controller;
	
	public void openWindow(String fxmlPath, String title, double width, double height)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
			Parent root = loader.load();

			Scene scene = new Scene(root, width, height);
			stage.setTitle(title);
			stage.setScene(scene);

			stage.showAndWait();
			
			controller = loader.getController();

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error because of loading the fxml-file");
		}
	}
	
	protected Tooltip createStyledTooltip(String text) {
	    Tooltip tooltip = new Tooltip(text);
	    tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
	    tooltip.setShowDelay(Duration.millis(300));
	    return tooltip;
	}
	
	public T getController() 
	{
		return controller;
	}
}
