package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.ExaminationPerformance;
import application.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentScreenController extends Windows<GradeScreenController> implements Initializable
{
	public static String STUDENT_SCREEN_FXML_PATH = "/StudentScreenView.fxml";

	@FXML
	private TextField firstNameInput;

	@FXML
	private TextField lastNameInput;

	@FXML
	private TextField matriculationNumberInput;

	@FXML
	private TextField studyProgramInput;

	@FXML
	private TextField eMailInput;

	@FXML
	private Button applyButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button addExamButton;

	@FXML
	private Text errorText;

	@FXML
	private TableView<ExaminationPerformance> examTable;

	@FXML
	private TableColumn<ExaminationPerformance, Integer> semesterColumn;

	@FXML
	private TableColumn<ExaminationPerformance, String> examColumn;

	@FXML
	private TableColumn<ExaminationPerformance, Double> gradeColumn;

	@FXML
	private TableColumn<ExaminationPerformance, Boolean> passedColumn;

	@FXML
	private TableColumn<ExaminationPerformance, Integer> attemptColumn;

	private ObservableList<ExaminationPerformance> examList = FXCollections.observableArrayList();
	private ArrayList<ExaminationPerformance> examinationPerformances = new ArrayList<ExaminationPerformance>();

	private Student student;

	@FXML
	private void applyParameters(ActionEvent event)
	{
		if (firstNameInput.getText().isBlank() || lastNameInput.getText().isBlank() || studyProgramInput.getText().isBlank() || eMailInput.getText().isBlank()
				|| matriculationNumberInput.getText().isBlank())
		{
			errorText.setText("There are empty fields.");
			return;
		}

		int matriculationNumber = -1;
		try
		{
			matriculationNumber = Integer.valueOf(matriculationNumberInput.getText());

		} catch (NumberFormatException e)
		{
			e.printStackTrace();
			errorText.setText("Incorrect parameter type in the input field. It must be an integer number.");
			return;
		}

		student = new Student(firstNameInput.getText(), lastNameInput.getText(), matriculationNumber, studyProgramInput.getText(), eMailInput.getText(), examinationPerformances);
		exitView(event);

	}

	public Student getStudent()
	{
		return student;
	}

	@FXML
	private void exitView(ActionEvent event)
	{
		Node eventNode = (Node) event.getSource();
		Stage currentStage = (Stage) eventNode.getScene().getWindow();
		currentStage.close();
	}

	@FXML
	private void addExam(ActionEvent event)
	{
		openWindow(GradeScreenController.GRADE_SCREEN_FXML_PATH, "Add an exam", 600, 400);
		ExaminationPerformance examinationPerformance = getController().getExaminationPerformance();

		if (examinationPerformance != null)
		{
			examList.add(examinationPerformance);
			examinationPerformances.add(examinationPerformance);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		semesterColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Integer>("semesterNumber"));
		examColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, String>("examName"));
		gradeColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Double>("grade"));
		passedColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Boolean>("passed"));
		attemptColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Integer>("attempts"));

		examTable.setItems(examList);
	}
}
