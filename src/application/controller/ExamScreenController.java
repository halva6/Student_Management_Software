package application.controller;

import application.view.WindowButtonHBox;
import application.view.examscreen.ExamScreenVBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class ExamScreenController extends Controller implements ExitScreen
{
	private ExamScreenVBox examScreenVBox;
	private WindowButtonHBox windowButtonHBox;

	public ExamScreenController()
	{
		examScreenVBox = new ExamScreenVBox();
		windowButtonHBox = new WindowButtonHBox();
	}

	@Override
	public Node getCenterElement()
	{
		return examScreenVBox;
	}

	@Override
	public Node getBottonElement()
	{
		return windowButtonHBox;
	}

	@Override
	public void cancelScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getCancel().setOnAction(action);
	}
}
