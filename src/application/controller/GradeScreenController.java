package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ExaminationPerformance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GradeScreenController implements Initializable
{
	public static String GRADE_SCREEN_FXML_PATH = "/GradeScreenView.fxml";
	@FXML
	private TextField nameInput;

	@FXML
	private TextField descriptionInput;

	@FXML
	private ChoiceBox<String> examTypeChoiceBox;

	@FXML
	private Spinner<Integer> semesterSpinner;

	@FXML
	private TextField firstResultInput;

	@FXML
	private TextField secondResultInput;

	@FXML
	private TextField thirdResultInput;

	@FXML
	private DatePicker firstAttemptDate;

	@FXML
	private DatePicker secondAnttemptDate;

	@FXML
	private DatePicker thirdAttemptDate;

	@FXML
	private Button applyAndCloseButton;

	@FXML
	private Button cancelButton;
	
	private ExaminationPerformance ep;

	@FXML
	private void applyAndClose(ActionEvent event)
	{
		double[] attemptResults = new double[3];
		String[] attemptDates = new String[3];

		TextField[] resultInputs = { firstResultInput, secondResultInput, thirdResultInput };
		DatePicker[] attemptDatePickers = { firstAttemptDate, secondAnttemptDate, thirdAttemptDate };

		int attemps = 0;

		for (int i = 0; i < resultInputs.length; i++)
		{
			if (resultInputs[i].getText() != "" && attemptDatePickers[i].getValue() != null)
			{
				attemptResults[i] = Double.valueOf(resultInputs[i].getText()); // TODO Fehlermeldung wenn der Input
																				// falsch ist
				attemptDates[i] = attemptDatePickers[i].getValue().toString();
			} else
			{
				// TODO Fehlermeldung wenn schon das erste Eingabefeld leer ist
				attemps = i;
				break;
			}
		}

		 ep = new ExaminationPerformance(nameInput.getText(), descriptionInput.getText(),
				examTypeChoiceBox.getValue(), semesterSpinner.getValue(), attemps, attemptResults, attemptDates);
		 
		 cancel(event);
	}
	
	public ExaminationPerformance getExaminationPerformance() 
	{
		return ep;
	}

	@FXML
	private void cancel(ActionEvent event)
	{
		Node eventNode = (Node) event.getSource();
		Stage currentStage = (Stage) eventNode.getScene().getWindow();
		currentStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		examTypeChoiceBox.getItems().addAll("examination", "academic paper");
		examTypeChoiceBox.setValue("examination");

		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		semesterSpinner.setValueFactory(valueFactory);
	}
}
