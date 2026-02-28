package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * This class extends {@link javafx.scene.layout.HBox}, allows you to apply or
 * cancel your input or changes and return to the previous screen. If an error
 * occurs, a text message will be displayed.
 * 
 */
public class WindowButtonHBox extends HBox
{
	private Button apply;
	private Button cancel;

	// shows a small error text if an input is invalid
	private Text errorText;

	/**
	 * Creates a WindowButtonHBox with buttons and an error display.
	 */
	public WindowButtonHBox()
	{
		apply = new Button("Apply");
		cancel = new Button("Cancel");
		errorText = new Text();

		apply.setTooltip(createTooltip("Apply changes and close"));
		cancel.setTooltip(createTooltip("abort all changes and close"));

		errorText.setFill(Color.RED);

		getChildren().addAll(errorText, apply, cancel);
		setSpacing(50);
		setPadding(new Insets(20, 20, 20, 0));
		setAlignment(Pos.CENTER_RIGHT);
	}

	/**
	 * Creates a styled {@link javafx.scene.control.Tooltip}.
	 *
	 * @param tooltipText the text displayed in the tooltip
	 * @return a configured Tooltip instance
	 */
	private Tooltip createTooltip(String tooltipText)
	{
		Tooltip tooltip = new Tooltip(tooltipText);
		tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
		tooltip.setShowDelay(Duration.millis(300));
		return tooltip;
	}

	/**
	 * Returns the Apply button.
	 *
	 * @return the Apply Button
	 */
	public Button getApply()
	{
		return apply;
	}

	/**
	 * Returns the Cancel button
	 *
	 * @return the Cancel Button
	 */
	public Button getCancel()
	{
		return cancel;
	}

	/**
	 * Returns the error text display.
	 *
	 * @return the error Text
	 */
	public Text getErrorText()
	{
		return errorText;
	}
}
