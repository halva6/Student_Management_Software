package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class WindowButtonHBox extends HBox
{
	private Button apply;
	private Button cancel;
	private Text errorText;

	public WindowButtonHBox()
	{
		apply = new Button("Apply");
		cancel = new Button("Cancel");
		errorText = new Text();

		apply.setTooltip(createTooltip("Apply changes and close"));
		cancel.setTooltip(createTooltip("abort all changes and close"));

		errorText.setFill(Color.RED);;

		getChildren().addAll(errorText, apply, cancel);
		setSpacing(50);
		setPadding(new Insets(20, 20, 20, 0));
		setAlignment(Pos.CENTER_RIGHT);
	}

	private Tooltip createTooltip(String tooltipText)
	{
		Tooltip tooltip = new Tooltip(tooltipText);
		tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
		tooltip.setShowDelay(Duration.millis(300));
		return tooltip;
	}

	public Button getApply()
	{
		return apply;
	}

	public Button getCancel()
	{
		return cancel;
	}

	public Text getErrorText()
	{
		return errorText;
	}
}
