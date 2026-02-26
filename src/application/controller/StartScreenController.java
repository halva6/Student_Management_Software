package application.controller;

import application.view.startscreen.StartScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class StartScreenController extends Controller implements StartNewScreen
{
	private StartScreen startScreen;

	public StartScreenController()
	{
		startScreen = new StartScreen();
	}

	@Override
	public Node getCenterElement()
	{
		return startScreen;
	}

	@Override
	public Node getBottonElement()
	{
		return null;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		startScreen.setOnAction(action);
	}

}
