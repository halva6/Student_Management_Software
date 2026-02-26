package application.controller;

import application.view.startscreen.StartScreen;
import javafx.scene.Node;

public class StartScreenController extends Controller
{

	@Override
	public Node getCenterElement()
	{
		StartScreen startScreen = new StartScreen();
		startScreen.setOnAction(e ->
		{
			System.out.println("Start");
		});
		return startScreen;
	}

	@Override
	public Node getBottonElement()
	{
		return null;
	}

}
