package application.controller;

import java.util.ArrayList;

import application.model.ExaminationPerformance;
import application.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentScreenController extends Windows<GradeScreenController>
{
	public static String STUDENT_SCREEN_FXML_PATH = "/StudentScreenView.fxml";
	
	//TODO beim Tab-Drücken soll die Reihenfolge von oben nach unten sein (z.Z. ein wenig durcheinander)
	
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
		int matriculationNumber = Integer.valueOf(matriculationNumberInput.getText()); //TODO Fehlerbehandlung bei falscher eingabe
				
		student = new Student(firstNameInput.getText(), lastNameInput.getText(), matriculationNumber,
				studyProgramInput.getText(), eMailInput.getText(), examinationPerformances);
		
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
		examList.add(examinationPerformance);
		examinationPerformances.add(examinationPerformance);

		semesterColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Integer>("semesterNumber"));
		examColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, String>("examName"));
		gradeColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Double>("grade"));
		passedColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Boolean>("passed"));
		attemptColumn.setCellValueFactory(new PropertyValueFactory<ExaminationPerformance, Integer>("attempts"));

		examTable.setItems(examList);
	}
}
