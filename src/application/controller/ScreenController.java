package application.controller;

import application.view.mainscreen.MainScreenHBoxView;
import application.view.mainscreen.MainScreenTableView;
import application.view.startscreen.StartScreenView;
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

			root.setCenter(setStartScreenView());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	private StartScreenView setStartScreenView()
	{
		StartScreenView startScreenView = new StartScreenView();
		startScreenView.setOnAction(e ->
		{
			root.setBottom(setMainScreenHBoView());
			root.setCenter(setMainScreenTableView());
		});
		return startScreenView;
	}

	private MainScreenHBoxView setMainScreenHBoView()
	{
		MainScreenHBoxView mainScreenHBoxView = new MainScreenHBoxView();
		mainScreenHBoxView.getAddStudent().setOnAction(e -> System.out.println("add Student"));
		mainScreenHBoxView.getEditStudent().setOnAction(e -> System.out.println("edit Student"));
		mainScreenHBoxView.getDeleteStudent().setOnAction(e -> System.out.println("delete Student"));

		return mainScreenHBoxView;
	}

	private MainScreenTableView setMainScreenTableView()
	{
		MainScreenTableView mainScreenTableView = new MainScreenTableView();

		return mainScreenTableView;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
