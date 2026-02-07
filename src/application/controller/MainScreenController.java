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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
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

	private ObservableList<Student> initialStudent = FXCollections.observableArrayList();

	@FXML
	private void addStudent()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource(StudentScreenController.NEW_STUDENT_SCREEN_FXML_PATH));
			Parent root = loader.load();

			StudentScreenController studentScreenController = loader.getController();

			Scene scene = new Scene(root, 900, 600);
			Stage stage = new Stage();
			stage.setTitle("Add a new student");
			stage.setScene(scene);

			studentScreenController.setStage(stage);

			stage.showAndWait();
			
			overviewTable.getItems().add(studentScreenController.getStudent());

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error because of loading the fxml-file");
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
