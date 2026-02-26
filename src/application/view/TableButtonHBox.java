package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TableButtonHBox extends HBox
{
	private Button add;
	private Button edit;
	private Button delete;

	public TableButtonHBox(String text)
	{
		add = new Button("+ " + text);
		edit = new Button("✎ " + text);
		delete = new Button("🗑 " + text);

		getChildren().addAll(add, edit, delete);
		setSpacing(40);
		setPadding(new Insets(20, 0, 20, 0));
		setAlignment(Pos.CENTER);
	}

	public Button getAdd()
	{
		return add;
	}

	public Button getEdit()
	{
		return edit;
	}

	public Button getDelete()
	{
		return delete;
	}
}