package application.controller;

import application.view.WindowButtonHBox;
import application.view.studentscreen.StudentScreenGridPane;
import javafx.scene.Node;

public class StudentScreenController extends Controller
{

	@Override
	public Node getCenterElement()
	{
		StudentScreenGridPane studentScreenGridPane = new StudentScreenGridPane();

		studentScreenGridPane.getButtonHBox().getAdd().setOnAction(e ->
		{
			System.out.println("Add Exam");
		});

		return studentScreenGridPane;
	}

	@Override
	public Node getBottonElement()
	{
		WindowButtonHBox windowButtonHBox = new WindowButtonHBox();

		return windowButtonHBox;
	}

}
