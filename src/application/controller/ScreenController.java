package application.controller;

import application.view.TableButtonHBox;
import application.view.WindowButtonHBox;
import application.view.examscreen.ExamScreenVBox;
import application.view.mainscreen.MainScreenTableView;
import application.view.startscreen.StartScreen;
import application.view.studentscreen.StudentScreenGridPane;
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

			root.setCenter(setStartScreen());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Student Management Software");
			primaryStage.show();
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	// start screen
	private StartScreen setStartScreen()
	{
		StartScreen startScreen = new StartScreen();
		startScreen.setOnAction(e ->
		{
			root.setBottom(setMainScreenHBox());
			root.setCenter(setMainScreenTableView());
		});
		return startScreen;
	}

	// main screen
	private TableButtonHBox setMainScreenHBox()
	{
		TableButtonHBox mainScreenHBox = new TableButtonHBox("Student");
		mainScreenHBox.getAdd().setOnAction(e ->
		{
			root.setCenter(setStudentScreenGridPane());
			root.setBottom(setStudentWindowButtonHBox());
		});

		mainScreenHBox.getEdit().setOnAction(e ->
		{
			System.out.println("edit Student");
			root.setCenter(setStudentScreenGridPane());
			root.setBottom(setStudentWindowButtonHBox());
		});

		mainScreenHBox.getDelete().setOnAction(e -> System.out.println("delete Student"));

		return mainScreenHBox;
	}

	private MainScreenTableView setMainScreenTableView()
	{
		MainScreenTableView mainScreenTableView = new MainScreenTableView();

		return mainScreenTableView;
	}

	// student screen
	private StudentScreenGridPane setStudentScreenGridPane()
	{
		StudentScreenGridPane studentScreenGridPane = new StudentScreenGridPane();

		studentScreenGridPane.getButtonHBox().getAdd().setOnAction(e ->
		{
			root.setCenter(setExamScreenVBox());
			root.setBottom(setExamWindowButtonHBox());
		});

		return studentScreenGridPane;
	}

	private WindowButtonHBox setStudentWindowButtonHBox()
	{
		WindowButtonHBox windowButtonHBox = new WindowButtonHBox();

		return windowButtonHBox;
	}

	// exam screen
	
	private ExamScreenVBox setExamScreenVBox() 
	{
		ExamScreenVBox examScreenVBox = new ExamScreenVBox();
		return examScreenVBox;
	}
	
	private WindowButtonHBox setExamWindowButtonHBox()
	{
		WindowButtonHBox windowButtonHBox = new WindowButtonHBox();

		return windowButtonHBox;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
