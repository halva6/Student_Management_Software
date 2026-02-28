package application.view.examscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * This class combines the {@link UpperGridPane} and the {@link LowerGridPane}
 * to create the general exam screen in a vertical layout. It extends
 * {@link javafx.scene.layout.VBox}
 */
public class ExamScreenVBox extends VBox
{
	private UpperGridPane upperGridPane;
	private LowerGridPane lowerGridPane;

	/**
	 * Creates an empty ExamScreenVBox.
	 */
	public ExamScreenVBox()
	{
		upperGridPane = new UpperGridPane();
		lowerGridPane = new LowerGridPane();

		createVBox();
	}

	/**
	 * Creates an ExamScreenVBox with predefined exam data.
	 *
	 * @param examName        the name of the exam
	 * @param examDescription the description of the exam
	 * @param examType        the type of the exam
	 * @param semester        the semester number
	 * @param results         an array containing attempt results
	 * @param dates           an array containing attempt dates (yyyy-MM-dd)
	 * @param attempts        the number of valid attempts
	 */
	public ExamScreenVBox(String examName, String examDescription, String examType, int semester, double[] results, String[] dates, int attempts)
	{
		upperGridPane = new UpperGridPane(examName, examDescription, examType, semester);
		lowerGridPane = new LowerGridPane(results, dates, attempts);
		createVBox();

	}

	/**
	 * Builds and configures the VBox layout.
	 */
	private void createVBox()
	{
		getChildren().addAll(upperGridPane, new Separator(), lowerGridPane);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(0, 20, 0, 20));
		setSpacing(5);
	}

	/**
	 * Returns the upper grid pane containing exam information.
	 *
	 * @return the UpperGridPane
	 */
	public UpperGridPane getUpperGridPane()
	{
		return upperGridPane;
	}

	/**
	 * Returns the lower grid pane containing attempt results.
	 *
	 * @return the LowerGridPane
	 */
	public LowerGridPane getLowerGridPane()
	{
		return lowerGridPane;
	}
}
