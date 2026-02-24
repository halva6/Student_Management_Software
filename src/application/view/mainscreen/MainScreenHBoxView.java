package application.view.mainscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MainScreenHBoxView extends HBox
{
	private Button addStudent;
	private Button editStudent;
	private Button deleteStudent;

	public MainScreenHBoxView()
	{
		addStudent = new Button("+ Student");
		editStudent = new Button("✎ Student");
		deleteStudent = new Button("🗑 Student");

		setSpacing(40);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(20, 0, 20, 0));
		getChildren().addAll(addStudent, editStudent, deleteStudent);
	}

	public Button getAddStudent()
	{
		return addStudent;
	}

	public Button getEditStudent()
	{
		return editStudent;
	}

	public Button getDeleteStudent()
	{
		return deleteStudent;
	}
}
