package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainScreenController extends Controller implements Initializable
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
	private Button newStudent;

	private ObservableList<Student> initialStudent = FXCollections.observableArrayList(
			new Student("Heinz", "Maier", 123, 2.2), new Student("Wolgang", "Schmidt", 161, 4.5),
			new Student("Pein", "Lich", 1312, 1.23));
	
	@FXML
	private void addStudent()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(NewStudentScreenController.NEW_STUDENT_SCREEN_FXML_PATH));
			
			Scene scene = new Scene(loader.load(), 900, 600);
			Stage stage = new Stage();
			stage.setTitle("Add a new student");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
			}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		columnFirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		columnMatriculationNumber
				.setCellValueFactory(new PropertyValueFactory<Student, Integer>("matriculationNumber"));
		columnGradePointAvrage.setCellValueFactory(new PropertyValueFactory<Student, Double>("gradePointAvrage"));

		overviewTable.setItems(initialStudent);

	}
}
