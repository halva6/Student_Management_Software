package application.controller;

import java.util.ArrayList;
import java.util.Optional;

import application.controller.interfaces.Editable;
import application.controller.interfaces.Exitable;
import application.controller.interfaces.Startable;
import application.model.Student;
import application.view.DeleteAlert;
import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenVBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;

/**
 * Controller for the main screen
 *
 * <p>
 * This controller manages the main view, including student data display, search
 * functionality, and actions for adding, editing, and deleting students. It
 * supports filtering of students based on search input.
 * </p>
 * <p>
 * Extends {@link Controller} and implements:
 * <ul>
 * <li>{@link Startable}</li>
 * <li>{@link Exitable}</li>
 * 
 * </ul>
 * </p>
 */
public class MainScreenController extends Controller implements Startable, Editable<Student>
{

	private TableButtonHBox tableButtonHBox;
	private MainScreenVBox mainScreenVBox;

	// source [2] [3]
	private ObservableList<Student> observableStudents = FXCollections.observableArrayList();
	// source [11]
	private ArrayList<Student> students = new ArrayList<>();
	// source [21]
	FilteredList<Student> filteredData = new FilteredList<>(observableStudents, p -> true);

	/**
	 * Creates a MainScreenController with no initial students.
	 */
	public MainScreenController()
	{
		init();
	}

	/**
	 * Creates a MainScreenController with an initial list of students.
	 *
	 * @param students the list of students to display
	 */
	public MainScreenController(ArrayList<Student> students)
	{
		for (Student student : students)
		{
			observableStudents.add(student);
		}
		this.students = students;
		init();
	}

	/**
	 * The actual initialization of the class with the corresponding view elements.
	 * Additionally, the search function is added via the appropriate ActionEvent.
	 */
	private void init()
	{
		mainScreenVBox = new MainScreenVBox();
		tableButtonHBox = new TableButtonHBox("Student");

		tableButtonHBox.getDelete().setOnAction(e -> deleteStudent());

		// source [21]
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
					return true; // Filter matches study program
				}
				return false; // Does not match.
			});
		});
		
		// source [27]
	    SortedList<Student> sortedData = new SortedList<>(filteredData);
	    sortedData.comparatorProperty().bind(
	            mainScreenVBox.getMainScreenTableView().comparatorProperty()
	    );

	    mainScreenVBox.getMainScreenTableView().setItems(sortedData);
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

	/**
	 * Adds a student to the model.
	 *
	 * @param student the student to add
	 */
	public void addStudent(Student student)
	{
		System.out.println(student.toString());
		observableStudents.add(student);
		students.add(student);
	}

	/**
	 * Replaces the selected student with a new entry.
	 *
	 * @param student the new student data
	 */
	public void replaceStudent(Student student)
	{
		int selectedID = mainScreenVBox.getMainScreenTableView().getSelectionModel().getSelectedIndex();
		observableStudents.set(selectedID, student);
		students.set(selectedID, student);
	}

	/**
	 * Deletes the selected student from the table.
	 */
	private void deleteStudent()
	{
		int selectedID = mainScreenVBox.getMainScreenTableView().getSelectionModel().getSelectedIndex();
		if (selectedID >= 0)
		{
			// source [26]
			DeleteAlert deleteAlert = new DeleteAlert("Do you want to delete this student?");
			Optional<ButtonType> option = deleteAlert.showAndWait();
			if (option.get() == ButtonType.OK)
			{
				observableStudents.remove(selectedID);
				students.remove(selectedID);
			}
		}
	}

	/**
	 * Returns the list of all students.
	 *
	 * @return the student list
	 */
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

		// source [10]
		return (selectedID >= 0) ? students.get(selectedID) : null;
	}
}