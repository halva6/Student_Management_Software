package application.controller;

import application.view.WindowButtonHBox;
import application.view.examscreen.ExamScreenVBox;
import javafx.scene.Node;

public class ExamScreenController extends Controller
{

	@Override
	public Node getCenterElement()
	{
		ExamScreenVBox examScreenVBox = new ExamScreenVBox();
		return examScreenVBox;
	}

	@Override
	public Node getBottonElement()
	{
		WindowButtonHBox windowButtonHBox = new WindowButtonHBox();

		return windowButtonHBox;
	}

}
