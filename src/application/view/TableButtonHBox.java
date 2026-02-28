package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * This class extends {@link javafx.scene.layout.HBox}, provides the
 * {@link javafx.scene.control.Button} for adding, editing, or modifying table
 * values.
 */
public class TableButtonHBox extends HBox
{
	private Button add;
	private Button edit;
	private Button delete;

	/**
	 * Creates a TableButtonHBox with buttons with the given text.
	 *
	 * <p>
	 * Each button is labeled with an icon and the provided text.
	 * </p>
	 *
	 * @param text the label text for the buttons
	 */
	public TableButtonHBox(String text)
	{
		add = new Button("+ " + text);
		edit = new Button("✎ " + text);
		delete = new Button("🗑 " + text);

		add.setTooltip(createTooltip("Add " + text));
		edit.setTooltip(createTooltip("Edit " + text));
		delete.setTooltip(createTooltip("Delete " + text));

		getChildren().addAll(add, edit, delete);
		setSpacing(40);
		// source [18]
		setPadding(new Insets(20, 0, 20, 0));
		setAlignment(Pos.CENTER);
	}

	/**
	 * Creates a styled {@link javafx.scene.control.Tooltip}.
	 *
	 * @param tooltipText the text displayed in the tooltip
	 * @return a configured Tooltip instance
	 */
	// source [13]
	private Tooltip createTooltip(String tooltipText)
	{
		Tooltip tooltip = new Tooltip(tooltipText);
		tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
		tooltip.setShowDelay(Duration.millis(300));
		return tooltip;
	}

	/**
	 * Returns the Add button.
	 *
	 * @return the Add Button
	 */
	public Button getAdd()
	{
		return add;
	}

	/**
	 * Returns the Edit button.
	 *
	 * @return the Edit Button
	 */
	public Button getEdit()
	{
		return edit;
	}

	/**
	 * Returns the Delete button.
	 *
	 * @return the Delete Button
	 */
	public Button getDelete()
	{
		return delete;
	}
}