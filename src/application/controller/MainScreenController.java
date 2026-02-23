package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainScreenController extends Windows<StudentScreenController> implements Initializable
{
	public static String MAIN_SCREEN_FXML_PATH = "/MainScreenView.fxml";

	@FXML
	private TableColumn<Student, String> columnFirstName;

	@FXML
	private TableColumn<Student, String> columnLastName;

	@FXML
	private TableColumn<Student, Integer> columnMatriculationNumber;

	@FXML
	private TableColumn<Student, Double> columnGradePointAvrage;

	@FXML
	private TableView<Student> overviewTable;

	@FXML
	private Button addStudentButton;

	@FXML
	private Button editStudentButton;

	@FXML
	private Button deleteStudentButton;

	private ObservableList<Student> initialStudent = FXCollections.observableArrayList();
	private ArrayList<Student> students = new ArrayList<Student>();

	@FXML
	private void addStudent()
	{
		openWindow(StudentScreenController.STUDENT_SCREEN_FXML_PATH, "Add new Student", 900, 600);
		Student student = getController().getStudent();

		if (student != null)
		{
			initialStudent.add(student);
			students.add(student);
		}
	}

	@FXML
	void deleteStudent()
	{
		int selectedID = overviewTable.getSelectionModel().getSelectedIndex();
		overviewTable.getItems().remove(selectedID);
	}

	@FXML
	void editStudent()
	{

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		columnFirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		columnMatriculationNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("matriculationNumber"));
		columnGradePointAvrage.setCellValueFactory(new PropertyValueFactory<Student, Double>("gradePointAvrage"));

		overviewTable.setItems(initialStudent);

		addStudentButton.setTooltip(createStyledTooltip("adds a new student"));
		editStudentButton.setTooltip(createStyledTooltip("edits the selected student"));
		deleteStudentButton.setTooltip(createStyledTooltip("deletes the selected student"));
	}
}
