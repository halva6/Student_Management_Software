package application.controller;

import application.view.WindowButtonHBox;
import application.view.studentscreen.StudentScreenGridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class StudentScreenController extends Controller implements StartNewScreen, ExitScreen
{
	private StudentScreenGridPane studentScreenGridPane;
	private WindowButtonHBox windowButtonHBox;

	public StudentScreenController()
	{
		studentScreenGridPane = new StudentScreenGridPane();
		windowButtonHBox = new WindowButtonHBox();
	}

	@Override
	public Node getCenterElement()
	{
		return studentScreenGridPane;
	}

	@Override
	public Node getBottonElement()
	{

		return windowButtonHBox;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		studentScreenGridPane.getButtonHBox().getAdd().setOnAction(action);
	}

	@Override
	public void cancelScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getCancel().setOnAction(action);
	}

}
