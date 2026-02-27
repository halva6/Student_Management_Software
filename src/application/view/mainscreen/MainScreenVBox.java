package application.view.mainscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainScreenVBox extends VBox
{
	private TextField seach;
	private MainScreenTableView mainScreenTableView;

	public MainScreenVBox() 
	{
		seach = new TextField();
		seach.setPromptText("Search...");
		
		mainScreenTableView = new MainScreenTableView();
		
		getChildren().addAll(seach, mainScreenTableView);
		setSpacing(10);
		setPadding(new Insets(20, 20, 20, 20));
		setAlignment(Pos.CENTER);
	}
	
	public TextField getSearch() 
	{
		return seach;
	}
	
	public MainScreenTableView getMainScreenTableView() 
	{
		return mainScreenTableView;
	}
}
