package application.view.mainscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * VBox layout for the main screen of the application. This class extends
 * {@link javafx.scene.layout.VBox} and contains a search field and a
 * {@link MainScreenTableView}.
 */
public class MainScreenVBox extends VBox
{
	private TextField seach;
	private MainScreenTableView mainScreenTableView;

	/**
	 * Creates a new MainScreenVBox. Initializes the search text and the table with
	 * the students.
	 */
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

	/**
	 * Returns the search text field.
	 *
	 * @return the search TextField
	 */
	public TextField getSearch()
	{
		return seach;
	}

	/**
	 * Returns the student table view.
	 *
	 * @return the MainScreenTableView
	 */
	public MainScreenTableView getMainScreenTableView()
	{
		return mainScreenTableView;
	}
}
