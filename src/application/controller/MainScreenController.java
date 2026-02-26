package application.controller;

import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenTableView;
import javafx.scene.Node;

public class MainScreenController extends Controller
{

	@Override
	public Node getCenterElement()
	{
		MainScreenTableView mainScreenTableView = new MainScreenTableView();

		return mainScreenTableView;
	}

	@Override
	public Node getBottonElement()
	{
		TableButtonHBox mainScreenHBox = new TableButtonHBox("Student");
		mainScreenHBox.getAdd().setOnAction(e ->
		{
			System.out.println("Add Student");
		});

		mainScreenHBox.getEdit().setOnAction(e ->
		{
			System.out.println("Edit Student");
		});

		mainScreenHBox.getDelete().setOnAction(e -> System.out.println("delete Student"));

		return mainScreenHBox;
	}

}
