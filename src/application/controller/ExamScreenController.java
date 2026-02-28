package application.controller;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Exitable;
import application.model.ExaminationPerformance;
import application.view.WindowButtonHBox;
import application.view.examscreen.ExamScreenVBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

/**
 * Controller for the exam screen.
 *
 * <p>
 * This controller manages the exam screen view and handles user interactions
 * for creating or editing {@link ExaminationPerformance} models. It supports
 * apply and cancel actions as well as model creation.
 * </p>
 * <p>
 * Extends {@link Controller} and implements:
 * <ul>
 * <li>{@link Exitable}</li>
 * <li>{@link Applicable}</li>
 * </ul>
 * </p>
 */
public class ExamScreenController extends Controller implements Exitable, Applicable<ExaminationPerformance>
{
	private ExamScreenVBox examScreenVBox;
	private WindowButtonHBox windowButtonHBox;

	private ExaminationPerformance examinationPerformance;
	private boolean edit;

	/**
	 * Creates a new ExamScreenController. That means a new exam will be created.
	 */
	public ExamScreenController()
	{
		edit = false;
		examScreenVBox = new ExamScreenVBox();
		windowButtonHBox = new WindowButtonHBox();
	}

	/**
	 * Creates a ExamScreenController for editing an existing student.
	 *
	 * @param examinationPerformance the exam to edit
	 */
	public ExamScreenController(ExaminationPerformance examinationPerformance)
	{
		edit = true;
		String examName = examinationPerformance.getExamName();
		String examDescription = examinationPerformance.getExamDescription();
		String examType = examinationPerformance.getExamType();
		int semester = examinationPerformance.getSemester();
		double[] results = examinationPerformance.getResults();
		String[] dates = examinationPerformance.getDates();
		int attempts = examinationPerformance.getAttempts();

		examScreenVBox = new ExamScreenVBox(examName, examDescription, examType, semester, results, dates, attempts);
		windowButtonHBox = new WindowButtonHBox();
	}

	@Override
	public Node getCenterElement()
	{
		return examScreenVBox;
	}

	@Override
	public Node getBottonElement()
	{
		return windowButtonHBox;
	}

	@Override
	public void cancelScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getCancel().setOnAction(action);
	}

	@Override
	public void applyScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getApply().setOnAction(action);
	}

	@Override
	public void createModel()
	{
		String examName = examScreenVBox.getUpperGridPane().getExamName().getText();
		String examDescription = examScreenVBox.getUpperGridPane().getExamDescription().getText();
		// source [8]
		String examType = examScreenVBox.getUpperGridPane().getExamType().getValue();
		// source [9]
		int semester = examScreenVBox.getUpperGridPane().getSemester().getValue();

		if (examName.isBlank() || examDescription.isBlank())
		{
			windowButtonHBox.getErrorText().setText("There are empty fields!");
			return;
		}

		double[] attemptResults = new double[3];
		String[] attemptDates = new String[3];

		int attemps = 0;

		for (int i = 0; i < examScreenVBox.getLowerGridPane().getResults().length; i++)
		{
			// checks if there are any empty fields
			// source [5]
			if (!examScreenVBox.getLowerGridPane().getResults()[i].getText().isBlank() && examScreenVBox.getLowerGridPane().getDates()[i].getValue() != null)
			{
				// Extracting the fields of the exam results with the corresponding dates and
				// converting them into a usable format
				try
				{
					// converts the grade as a string to a double
					double result = Double.valueOf(examScreenVBox.getLowerGridPane().getResults()[i].getText());

					// on my university there are only grades from 1.0 to 5.0
					if (result > 5)
					{
						windowButtonHBox.getErrorText().setText("Only grades from 1.0 to 5.0 are allowed!");
						return;
					}
					attemptResults[i] = result;

					// source [6]
				} catch (NumberFormatException e)
				{
					windowButtonHBox.getErrorText().setText("Incorrect parameter type in one of the result input fields.");
					return;
				}

				// source [5]
				attemptDates[i] = examScreenVBox.getLowerGridPane().getDates()[i].getValue().toString();
			} else
			{
				// Checks whether an exam result was entered at all
				if (i == 0)
				{
					windowButtonHBox.getErrorText().setText("You need at least one exam result.");
					return;
				}
				attemps = i;
				break;
			}
		}

		examinationPerformance = new ExaminationPerformance(examName, examDescription, examType, semester, attemps, attemptResults, attemptDates);
	}

	@Override
	public ExaminationPerformance getModel()
	{
		return examinationPerformance;
	}

	/**
	 * Indicates if the exam was created or only edited
	 * 
	 * @return {@code true} if in edit mode, otherwise {@code false}
	 */
	public boolean wasEdit()
	{
		return edit;
	}
}
