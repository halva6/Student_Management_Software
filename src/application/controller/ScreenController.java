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
	private MenuBarController menuBar;

	private ArrayList<Controller> controllerHierarchy = new ArrayList<>();
	private int index = 0;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		controllerHierarchy.add(new MainScreenController());
		controllerHierarchy.add(new StudentScreenController());
		controllerHierarchy.add(new ExamScreenController());

		menuBar = new MenuBarController();
		try
		{
			root = new BorderPane();
			Scene scene = new Scene(root, 900, 600);
			setNewView(controllerHierarchy.get(index));

			root.setTop(menuBar.getUniversalMenuBar());
			setMenuBarActionEvents(primaryStage);

			setActionEvents();

			primaryStage.setScene(scene);
			primaryStage.setTitle("Student Management Software");
			primaryStage.show();
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	private void setMenuBarActionEvents(Stage stage)
	{
		menuBar.getUniversalMenuBar().getLoad().setOnAction(e ->
		{
			controllerHierarchy.set(0, new MainScreenController(menuBar.loadFile(stage)));
			setNewView(controllerHierarchy.get(0));
			setActionEvents();
		});

		menuBar.getUniversalMenuBar().getSave().setOnAction(e ->
		{
			menuBar.saveFile(stage, ((MainScreenController) controllerHierarchy.get(0)).getStudents());
		});

		menuBar.getUniversalMenuBar().getGit().setOnAction(e -> getHostServices().showDocument("https://github.com/halva6/Student_Management_Software"));
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
		if (index == 1)
		{
			controllerHierarchy.set(index, new StudentScreenController());
			setActionEvents();
		} else if (index == 2)
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

		if (index == 1)
		{
			StudentScreenController studentScreenController = (StudentScreenController) controller;
			Student student = studentScreenController.getModel();
			if (student == null || student.getMatriculationNumber() == -1)
			{
				return;
			}

			if (studentScreenController.wasEdit())
			{
				((MainScreenController) controllerHierarchy.get(0)).replaceStudent(student);
			} else
			{
				((MainScreenController) controllerHierarchy.get(0)).addStudent(student);
			}
		}
		if (index == 2)
		{
			ExamScreenController examScreenController = (ExamScreenController) controller;
			ExaminationPerformance examinationPerformance = examScreenController.getModel();

			if (examinationPerformance == null)
			{
				return;
			}

			if (examScreenController.wasEdit())
			{
				((StudentScreenController) controllerHierarchy.get(1)).replaceExam(examinationPerformance);

			} else
			{
				((StudentScreenController) controllerHierarchy.get(1)).addExam(examinationPerformance);
			}
		}

		goToOldView();
	}

	private void editAndGotoNewView(Controller controller)
	{
		index++;
		if (index == 1)
		{
			Student student = ((MainScreenController) controller).getSelectedEntry();
			controllerHierarchy.set(index, new StudentScreenController(student));

			setActionEvents();
		} else if (index == 2)
		{
			ExaminationPerformance examinationPerformance = ((StudentScreenController) controller).getSelectedEntry();
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
