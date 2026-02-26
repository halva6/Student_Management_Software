package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Exitable;
import application.controller.interfaces.Startable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScreenController extends Application
{
	private BorderPane root;

	private ArrayList<Controller> controllerHierarchy = new ArrayList<>();
	private int index = 0;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		controllerHierarchy.add(new StartScreenController());
		controllerHierarchy.add(new MainScreenController());
		controllerHierarchy.add(new StudentScreenController());
		controllerHierarchy.add(new ExamScreenController());

		try
		{
			root = new BorderPane();
			Scene scene = new Scene(root, 900, 600);
			setNewView(controllerHierarchy.get(index));

			setActionEvents();

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

	private void setActionEvents()
	{
		for (Controller controller : controllerHierarchy)
		{
			if (controller instanceof Startable)
			{
				((Startable) controller).addNewScreenEvent(e -> goToNewView());
			}
			if (controller instanceof Exitable)
			{
				((Exitable) controller).cancelScreenEvent(e -> goToOldView());
			}

			if (controller instanceof Applicable<?>)
			{
				((Applicable<?>) controller).applyScreenEvent(e -> applyAndGotoOldView(controller));
			}
		}
	}

	private void goToNewView()
	{
		index++;
		Controller controller = controllerHierarchy.get(index);
		if (controller instanceof StudentScreenController)
		{
			controllerHierarchy.set(index, new StudentScreenController());
			setActionEvents();
		} else if (controller instanceof ExamScreenController)
		{
			controllerHierarchy.set(index, new ExamScreenController());
			setActionEvents();
		}
		setNewView(controllerHierarchy.get(index));
	}

	private void goToOldView()
	{
		index--;
		setNewView(controllerHierarchy.get(index));
	}

	private void applyAndGotoOldView(Controller controller)
	{
		((Applicable<?>) controller).createModel();

		if (index == 2)
		{
			((MainScreenController) controllerHierarchy.get(1)).addStudent(((StudentScreenController) controller).getModel());
		}
		if(index == 3) 
		{
			((StudentScreenController) controllerHierarchy.get(2)).addExam(((ExamScreenController) controller).getModel());
		}

		goToOldView();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
