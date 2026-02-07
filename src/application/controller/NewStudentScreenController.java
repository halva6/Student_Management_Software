package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewStudentScreenController
{

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
	void applyParameters(ActionEvent event)
	{

	}

	@FXML
	void exitView(ActionEvent event)
	{

	}

	public static String NEW_STUDENT_SCREEN_FXML_PATH = "/NewStudentScreenView.fxml";

	public String getName()
	{
		return "nice";
	}
}
