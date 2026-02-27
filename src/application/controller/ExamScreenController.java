package application.controller;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Exitable;
import application.model.ExaminationPerformance;
import application.view.WindowButtonHBox;
import application.view.examscreen.ExamScreenVBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class ExamScreenController extends Controller implements Exitable, Applicable<ExaminationPerformance>
{
	private ExamScreenVBox examScreenVBox;
	private WindowButtonHBox windowButtonHBox;

	private ExaminationPerformance examinationPerformance;
	private boolean edit;

	public ExamScreenController()
	{
		edit = false;
		examScreenVBox = new ExamScreenVBox();
		windowButtonHBox = new WindowButtonHBox();
	}

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
		String examType = examScreenVBox.getUpperGridPane().getExamType().getValue();
		int semester = examScreenVBox.getUpperGridPane().getSemester().getValue();
		
		if(examName.isBlank() || examDescription.isBlank()) 
		{
			windowButtonHBox.getErrorText().setText("There are empty fields!");
			return;
		}

		double[] attemptResults = new double[3];
		String[] attemptDates = new String[3];

		int attemps = 0;

		for (int i = 0; i < examScreenVBox.getLowerGridPane().getResults().length; i++)
		{
			if (!examScreenVBox.getLowerGridPane().getResults()[i].getText().isBlank() && examScreenVBox.getLowerGridPane().getDates()[i].getValue() != null)
			{
				try
				{
					double result = Double.valueOf(examScreenVBox.getLowerGridPane().getResults()[i].getText());
					
					if(result > 5) 
					{
						windowButtonHBox.getErrorText().setText("Only grades from 1.0 to 5.0 are allowed!");
						return;
					}
					attemptResults[i] = result;
				} catch (NumberFormatException e)
				{
					windowButtonHBox.getErrorText().setText("Incorrect parameter type in one of the result input fields.");
					return;
				}

				attemptDates[i] = examScreenVBox.getLowerGridPane().getDates()[i].getValue().toString();
			} else
			{
				// Überprüft ob überhaupt ein Prüfungsergebnis eingetragen wurde
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

	public boolean wasEdit()
	{
		return edit;
	}
}
