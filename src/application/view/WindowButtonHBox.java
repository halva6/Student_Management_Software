package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class WindowButtonHBox extends HBox
{
	private Button apply;
	private Button cancel;

	public WindowButtonHBox()
	{
		apply = new Button("Apply");
		cancel = new Button("Cancel");

		getChildren().addAll(apply, cancel);
		setSpacing(50);
		setPadding(new Insets(20, 20, 20, 0));
		setAlignment(Pos.CENTER_RIGHT);
	}

	public Button getApply()
	{
		return apply;
	}

	public Button getCancel()
	{
		return cancel;
	}
}
