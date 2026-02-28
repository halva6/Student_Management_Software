package application.view.examscreen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 * The GridPane represents the lower part of the exam screen. The results and
 * dates of the exams are entered here. This class extends
 * {@link javafx.scene.layout.GridPane}.
 */
public class LowerGridPane extends GridPane
{
	private TextField firstResult;
	private TextField secondResult;
	private TextField thirdResult;

	// source [5]
	private DatePicker firstDate;
	private DatePicker secondDate;
	private DatePicker thirdDate;

	private TextField[] results = new TextField[3];
	private DatePicker[] dates = new DatePicker[3];

	/**
	 * Creates an empty LowerGridPane
	 */
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

		createGrid();
	}

	/**
	 * Creates a LowerGridPane with predefined attempt data.
	 *
	 * <p>
	 * The given results and date strings are inserted into the corresponding fields
	 * based on the number of attempts.
	 * </p>
	 *
	 * @param results  an array containing the result values
	 * @param dates    an array containing the date strings
	 * @param attempts the number of valid attempts
	 */
	public LowerGridPane(double[] results, String[] dates, int attempts)
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

		createGrid();

		for (int i = 0; i < attempts; i++)
		{
			this.results[i].setText(String.valueOf(results[i]));
			
			// source [14] [15]
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dateTime = LocalDate.parse(dates[i], dateTimeFormatter);
			this.dates[i].setValue(dateTime);
		}
	}

	/**
	 * It creates, sets the style, and adds the elements to the GridPane.
	 */
	private void createGrid()
	{
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
		// source [20]
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

		// source [19]
		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);

		// adds the TextFields and the DatePickers to an array, for a better handling
		results[0] = firstResult;
		results[1] = secondResult;
		results[2] = thirdResult;

		dates[0] = firstDate;
		dates[1] = secondDate;
		dates[2] = thirdDate;
	}

	/**
	 * Returns the array of result text fields.
	 *
	 * @return an array containing the result TextFields
	 */
	public TextField[] getResults()
	{
		return results;
	}

	/**
	 * Returns the array of date pickers.
	 *
	 * @return an array containing the DatePickers
	 */
	public DatePicker[] getDates()
	{
		return dates;
	}
}
