package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Editable;
import application.controller.interfaces.Exitable;
import application.controller.interfaces.Startable;
import application.model.ExaminationPerformance;
import application.model.Student;
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
			if (controller instanceof Editable<?>)
			{
				((Editable<?>) controller).editScreenEvent(e -> editAndGotoNewView(controller));
			}
		}
	}

	private void goToNewView()
	{
		index++;
		if (index == 2)
		{
			controllerHierarchy.set(index, new StudentScreenController());
			setActionEvents();
		} else if (index == 3)
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
			StudentScreenController studentScreenController = (StudentScreenController) controller;

			if (studentScreenController.wasEdit())
			{
				((MainScreenController) controllerHierarchy.get(1)).replaceStudent(studentScreenController.getModel());
			} else
			{
				((MainScreenController) controllerHierarchy.get(1)).addStudent(studentScreenController.getModel());
			}
		}
		if (index == 3)
		{
			ExamScreenController examScreenController = (ExamScreenController) controller;

			if (examScreenController.wasEdit())
			{
				((StudentScreenController) controllerHierarchy.get(2)).replaceExam(examScreenController.getModel());

			} else
			{
				((StudentScreenController) controllerHierarchy.get(2)).addExam(examScreenController.getModel());
			}
		}

		goToOldView();
	}

	private void editAndGotoNewView(Controller controller)
	{
		index++;
		if (index == 2)
		{
			Student student = ((MainScreenController) controller).getSelectedEntry();
			System.out.println(student.toString());
			controllerHierarchy.set(index, new StudentScreenController(student));

			setActionEvents();
		} else if (index == 3)
		{
			ExaminationPerformance examinationPerformance = ((StudentScreenController) controller).getSelectedEntry();
			System.out.println(examinationPerformance.toString());
			controllerHierarchy.set(index, new ExamScreenController(examinationPerformance));

			setActionEvents();
		}
		setNewView(controllerHierarchy.get(index));
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
