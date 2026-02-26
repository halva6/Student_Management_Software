package application.controller;

import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenTableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MainScreenController extends Controller implements StartNewScreen
{

	private TableButtonHBox mainScreenHBox;
	private MainScreenTableView mainScreenTableView;

	public MainScreenController()
	{
		mainScreenTableView = new MainScreenTableView();
		mainScreenHBox = new TableButtonHBox("Student");
	}

	@Override
	public Node getCenterElement()
	{
		return mainScreenTableView;
	}

	@Override
	public Node getBottonElement()
	{

		mainScreenHBox.getEdit().setOnAction(e ->
		{
			System.out.println("Edit Student");
		});

		mainScreenHBox.getDelete().setOnAction(e -> System.out.println("delete Student"));

		return mainScreenHBox;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		mainScreenHBox.getAdd().setOnAction(action);
	}

}
