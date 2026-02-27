package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Editable;
import application.controller.interfaces.Startable;
import application.model.Student;
import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenVBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MainScreenController extends Controller implements Startable, Editable<Student>
{

	private TableButtonHBox tableButtonHBox;
	private MainScreenVBox mainScreenVBox;

	private ObservableList<Student> observableStudents = FXCollections.observableArrayList();
	private ArrayList<Student> students = new ArrayList<>();
	FilteredList<Student> filteredData = new FilteredList<>(observableStudents, p -> true);

	public MainScreenController()
	{
		init();
	}

	public MainScreenController(ArrayList<Student> students)
	{
		for(Student student : students) 
		{
			observableStudents.add(student);
		}
		this.students = students;
		init();
	}

	private void init()
	{
		mainScreenVBox = new MainScreenVBox();
		tableButtonHBox = new TableButtonHBox("Student");

		tableButtonHBox.getDelete().setOnAction(e -> deleteStudent());

		mainScreenVBox.getSearch().textProperty().addListener((observable, oldValue, newValue) ->
		{
			filteredData.setPredicate(student ->
			{
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty())
				{
					return true;
				}
				// Compare first name and last name of every person with the filter text
				String lowerCaseFilter = newValue.toLowerCase();

				if (student.getFirstName().toLowerCase().contains(lowerCaseFilter))
				{
					return true; // Filter matches first name
				} else if (student.getLastName().toLowerCase().contains(lowerCaseFilter))
				{
					return true; // Filter matches last name
				} else if (String.valueOf(student.getMatriculationNumber()).contains(lowerCaseFilter))
				{
					return true; // Filter matches matriculation number
				} else if (student.getStudyProgram().toLowerCase().contains(lowerCaseFilter))
				{
					return true; // Filter matches last name
				}
				return false; // Does not match.
			});
		});

		mainScreenVBox.getMainScreenTableView().setItems(filteredData);
	}

	@Override
	public Node getCenterElement()
	{
		return mainScreenVBox;
	}

	@Override
	public Node getBottonElement()
	{
		return tableButtonHBox;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		tableButtonHBox.getAdd().setOnAction(action);
	}

	public void addStudent(Student student)
	{
		System.out.println(student.toString());
		observableStudents.add(student);
		students.add(student);
	}

	public void replaceStudent(Student student)
	{
		int selectedID = mainScreenVBox.getMainScreenTableView().getSelectionModel().getSelectedIndex();
		observableStudents.set(selectedID, student);
		students.set(selectedID, student);
	}

	private void deleteStudent()
	{
		int selectedID = mainScreenVBox.getMainScreenTableView().getSelectionModel().getSelectedIndex();
		if (selectedID >= 0)
		{
			observableStudents.remove(selectedID);
			students.remove(selectedID);
		}
	}

	public ArrayList<Student> getStudents()
	{
		return students;
	}

	@Override
	public void editScreenEvent(EventHandler<ActionEvent> action)
	{
		tableButtonHBox.getEdit().setOnAction(action);
	}

	@Override
	public Student getSelectedEntry()
	{
		int selectedID = mainScreenVBox.getMainScreenTableView().getSelectionModel().getSelectedIndex();

		return (selectedID >= 0) ? students.get(selectedID) : null;
	}
}