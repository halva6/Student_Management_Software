package application.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

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
		
		add.setTooltip(createTooltip("Add " + text));
		edit.setTooltip(createTooltip("Edit " + text));
		delete.setTooltip(createTooltip("Delete " + text));

		getChildren().addAll(add, edit, delete);
		setSpacing(40);
		setPadding(new Insets(20, 0, 20, 0));
		setAlignment(Pos.CENTER);
	}
	
	private Tooltip createTooltip(String tooltipText) 
	{
		Tooltip tooltip = new Tooltip(tooltipText);
		tooltip.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #333; -fx-padding: 5 10 5 10;");
		tooltip.setShowDelay(Duration.millis(300));
		return tooltip;
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