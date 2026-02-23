package application.controller;

import java.io.IOException;
import java.util.function.Consumer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Windows<C>
{
	private Stage stage = new Stage();

	public C openWindow(String fxmlPath, String title, double width, double height)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
			Parent root = loader.load();

			Scene scene = new Scene(root, width, height);
			stage.setTitle(title);
			stage.setScene(scene);

			stage.showAndWait();

			return loader.getController();

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error, because of loading the fxml-file");
		}
		return null;
	}

	public C openWindow(String fxmlPath, String title, double width, double height, Consumer<C> controllerInitializer)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
			Parent root = loader.load();

			C controller = loader.getController();

			if (controllerInitializer != null)
			{
				controllerInitializer.accept(controller);
			}

			Scene scene = new Scene(root, width, height);
			stage.setTitle(title);
			stage.setScene(scene);

			stage.showAndWait();

			return controller;

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error, because of loading the fxml-file");
		}

		return null;
	}

	public void showStage()
	{
		stage.showAndWait();
	}

	protected Tooltip createStyledTooltip(String text)
	{
		Tooltip tooltip = new Tooltip(text);
		tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
		tooltip.setShowDelay(Duration.millis(300));
		return tooltip;
	}

}
