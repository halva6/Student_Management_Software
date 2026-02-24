package application.view.examscreen;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class LowerGridPane extends GridPane
{
	private TextField firstResult;
	private TextField secondResult;
	private TextField thirdResult;

	private DatePicker firstDate;
	private DatePicker secondDate;
	private DatePicker thirdDate;
	
	private TextField[] results = new TextField[3];
	private DatePicker[] dates = new DatePicker[3];

	public LowerGridPane()
	{
		// initialize nodes
		firstResult = new TextField();
		firstResult.setPromptText("1. Result");

		secondResult = new TextField();
		secondResult.setPromptText("2. Result");

		thirdResult = new TextField();
		thirdResult.setPromptText("3. Result");

		firstDate = new DatePicker();
		secondDate = new DatePicker();
		thirdDate = new DatePicker();

		// add nodes to the grid
		add(new Text("1. Attempt"), 0, 1);
		add(new Text("2. Attempt"), 0, 2);
		add(new Text("3. Attempt"), 0, 3);

		add(new Text("Result"), 1, 0);
		add(firstResult, 1, 1);
		add(secondResult, 1, 2);
		add(thirdResult, 1, 3);

		add(new Text("Date"), 2, 0);
		add(firstDate, 2, 1);
		add(secondDate, 2, 2);
		add(thirdDate, 2, 3);

		// constrains
		ColumnConstraints leftConstraint = new ColumnConstraints();
		leftConstraint.setPercentWidth(20);
		getColumnConstraints().add(leftConstraint);

		ColumnConstraints middleConstraint = new ColumnConstraints();
		middleConstraint.setPercentWidth(40);
		getColumnConstraints().add(middleConstraint);

		ColumnConstraints rightConstraint = new ColumnConstraints();
		rightConstraint.setPercentWidth(40);
		getColumnConstraints().add(rightConstraint);

		// gird layout properties
		setVgap(10);
		setHgap(20);
		setWidth(USE_COMPUTED_SIZE);
		setHeight(USE_COMPUTED_SIZE);
		setPadding(new Insets(20));

		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
		
		results[0] = firstResult;
		results[1] = secondResult;
		results[2] = thirdResult;
		
		dates[0] = firstDate;
		dates[1] = secondDate;
		dates[2] = thirdDate;
	}

	public TextField[] getResults()
	{
		return results;
	}

	public DatePicker[] getDates()
	{
		return dates;
	}
}
