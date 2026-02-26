package application.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScreenController extends Application
{
	private BorderPane root;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try
		{
			root = new BorderPane();
			Scene scene = new Scene(root, 900, 600);
			setNewView(new StartScreenController());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Student Management Software");
			primaryStage.show();
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	private void setNewView(Controller controller) 
	{
		root.setCenter(controller.getCenterElement());
		root.setBottom(controller.getBottonElement());
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
