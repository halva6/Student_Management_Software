package application.controller;

import application.model.ExaminationPerformance;
import application.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentScreenController
{
	public static String NEW_STUDENT_SCREEN_FXML_PATH = "/StudentScreenView.fxml";

	@FXML
	private Button applyButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField eMailInput;

	@FXML
	private DatePicker firstAttemptDate;

	@FXML
	private TextField firstNameInput;

	@FXML
	private TextField firstResultInput;

	@FXML
	private TextField lastNameInput;

	@FXML
	private TextField matriculationNumberInput;

	@FXML
	private DatePicker secondAnttemptDate;

	@FXML
	private TextField secondResultInput;

	@FXML
	private TextField studyProgramInput;

	@FXML
	private DatePicker thirdAttemptDate;

	@FXML
	private TextField thirdResultInput;

	@FXML
	private Text errorText;
	
	private Stage stage;
	
	private Student student;

	@FXML
	private void applyParameters(ActionEvent event)
	{
		ExaminationPerformance examinationPerformance = new ExaminationPerformance();

		int errorCode = setExaminationPerformance(examinationPerformance);

		int matriculationNumber = -1;
		try
		{
			matriculationNumber = Integer.valueOf(matriculationNumberInput.getText());
		} catch (NumberFormatException e)
		{
			errorText.setText("Wrong input in the matriculation number field");
			errorCode = 1;
		}

		student = new Student(firstNameInput.getText(), lastNameInput.getText(), matriculationNumber,
				studyProgramInput.getText(), eMailInput.getText(), examinationPerformance);

		if (errorCode == 0)
		{
			exitView(event);
		}
	}

	@FXML
	private void exitView(ActionEvent event)
	{

		stage.close();
	}

	private int setExaminationPerformance(ExaminationPerformance examinationPerformance)
	{
		String firstResult = firstResultInput.getText();
		String firstDate = firstAttemptDate.getEditor().getText();

		int errorCode = 0;
		if (!firstResult.isEmpty() && !firstDate.isEmpty())
		{
			errorCode = addExam(firstResult, firstDate, 0, examinationPerformance);

			String secondresult = secondResultInput.getText();
			String secondDate = secondAnttemptDate.getEditor().getText();
			if (!secondDate.isEmpty() && !secondresult.isEmpty() && errorCode != 1)
			{
				errorCode = addExam(secondresult, secondDate, 1, examinationPerformance);

				String thirdResult = thirdResultInput.getText();
				String thirdDate = thirdAttemptDate.getEditor().getText();

				if (!thirdDate.isEmpty() && thirdResult.isEmpty() && errorCode != 1)
				{
					errorCode = addExam(thirdResult, thirdDate, 2, examinationPerformance);
				}
			}
		}
		return errorCode;
	}

	private int addExam(String resultString, String date, int attempt, ExaminationPerformance examinationPerformance)
	{
		try
		{
			double result = Double.valueOf(resultString);
			examinationPerformance.addExam(result, date, attempt);
		} catch (NumberFormatException e)
		{
			errorText.setText("Wrong input in the " + (attempt + 1) + ". result field");
			return 1;
		}

		return 0;
	}
	
	public void setStage(Stage stage) 
	{
		this.stage = stage;
	}
	
	public Student getStudent() 
	{
		return student;
	}

}
