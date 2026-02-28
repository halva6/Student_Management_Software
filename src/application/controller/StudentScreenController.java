package application.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Editable;
import application.controller.interfaces.Exitable;
import application.controller.interfaces.Startable;
import application.model.ExaminationPerformance;
import application.model.Student;
import application.view.DeleteAlert;
import application.view.WindowButtonHBox;
import application.view.studentscreen.StudentScreenGridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;

/**
 * Controller for the student screen.
 *
 * <p>
 * This controller manages the student screen view, handles user interactions,
 * and creates or edits {@link Student} models. It also supports adding,
 * editing, and deleting examination performances.
 * </p>
 * 
 * <p>
 * Extends {@link Controller} and implements:
 * <ul>
 * <li>{@link Startable}</li>
 * <li>{@link Exitable}</li>
 * <li>{@link Applicable}</li>
 * <li>{@link Editable}</li>
 * </ul>
 * </p>
 */
public class StudentScreenController extends Controller implements Startable, Exitable, Applicable<Student>, Editable<ExaminationPerformance>
{
	private StudentScreenGridPane studentScreenGridPane;
	private WindowButtonHBox windowButtonHBox;

	private Student student;

	// source [2] [3]
	private ObservableList<ExaminationPerformance> observableExaminationPerformances = FXCollections.observableArrayList();
	// source [11]
	private ArrayList<ExaminationPerformance> examinationPerformances = new ArrayList<>();

	private boolean edit;

	/**
	 * Creates a new StudentScreenController. That means a new student will be
	 * created.
	 */
	public StudentScreenController()
	{
		edit = false;
		studentScreenGridPane = new StudentScreenGridPane();
		windowButtonHBox = new WindowButtonHBox();

		// source [3]
		studentScreenGridPane.getScreenTableView().setItems(observableExaminationPerformances);

		studentScreenGridPane.getButtonHBox().getDelete().setOnAction(e -> deleteExam());
	}

	/**
	 * Creates a StudentScreenController for editing an existing student.
	 *
	 * <p>
	 * The views are initialized with the student's existing data and examination
	 * performances.
	 * </p>
	 *
	 * @param student the student to edit
	 */
	public StudentScreenController(Student student)
	{
		edit = true;
		studentScreenGridPane = new StudentScreenGridPane(student.getFirstName(), student.getLastName(), String.valueOf(student.getMatriculationNumber()), student.getStudyProgram(),
				student.getEMail());
		windowButtonHBox = new WindowButtonHBox();

		for (ExaminationPerformance examinationPerformance : student.getExaminationPerformances())
		{
			observableExaminationPerformances.add(examinationPerformance);
			examinationPerformances.add(examinationPerformance);
		}

		// source [3]
		studentScreenGridPane.getScreenTableView().setItems(observableExaminationPerformances);
		studentScreenGridPane.getButtonHBox().getDelete().setOnAction(e -> deleteExam());
	}

	@Override
	public Node getCenterElement()
	{
		return studentScreenGridPane;
	}

	@Override
	public Node getBottonElement()
	{

		return windowButtonHBox;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		studentScreenGridPane.getButtonHBox().getAdd().setOnAction(action);
	}

	@Override
	public void cancelScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getCancel().setOnAction(action);
	}

	@Override
	public void applyScreenEvent(EventHandler<ActionEvent> action)
	{
		windowButtonHBox.getApply().setOnAction(action);

	}

	@Override
	public void createModel()
	{
		String firstName = studentScreenGridPane.getFirstName().getText();
		String lastName = studentScreenGridPane.getLastName().getText();
		int matriculationNumber = -1;

		try
		{
			matriculationNumber = Integer.valueOf(studentScreenGridPane.getMatriculationNumber().getText());

			// source [6]
		} catch (NumberFormatException exception)
		{
			windowButtonHBox.getErrorText().setText("Matriculation number is in the wrong format!");
		}

		String studyProgram = studentScreenGridPane.getStudyProgram().getText();
		String eMail = studentScreenGridPane.getEMail().getText();

		if (firstName.isBlank() || lastName.isBlank() || studyProgram.isBlank() || eMail.isBlank())
		{
			windowButtonHBox.getErrorText().setText("There are empty fields!");
			return;
		}
		
		if (!validEMail(eMail))
		{
			windowButtonHBox.getErrorText().setText("The email input does not correspond to the correct email formatting!");
			return;
		}

		student = new Student(firstName, lastName, matriculationNumber, studyProgram, eMail, examinationPerformances);
	}

	/**
	 * Validates an email address using a regular expression.
	 *
	 * @param eMail the email address to validate
	 * @return {@code true} if the email is valid, otherwise {@code false}
	 */
	// source [20]
	public boolean validEMail(String eMail)
	{
		String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMail);

		return matcher.matches();
	}

	@Override
	public Student getModel()
	{
		return student;
	}

	/**
	 * Adds an examination performance to the model.
	 *
	 * @param examinationPerformance the performance to add
	 */
	public void addExam(ExaminationPerformance examinationPerformance)
	{
		observableExaminationPerformances.add(examinationPerformance);
		examinationPerformances.add(examinationPerformance);
	}

	/**
	 * Replaces the selected examination performance.
	 *
	 * @param examinationPerformance the new performance
	 */
	public void replaceExam(ExaminationPerformance examinationPerformance)
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		observableExaminationPerformances.set(selectedID, examinationPerformance);
		examinationPerformances.set(selectedID, examinationPerformance);

	}

	/**
	 * Deletes the selected examination performance from the table.
	 */
	private void deleteExam()
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		if (selectedID >= 0)
		{
			// source [26]
			DeleteAlert deleteAlert = new DeleteAlert("Do you want to delete this exam?");
			Optional<ButtonType> option = deleteAlert.showAndWait();
			if (option.get() == ButtonType.OK)
			{
				observableExaminationPerformances.remove(selectedID);
				examinationPerformances.remove(selectedID);
			}
		}
	}

	@Override
	public void editScreenEvent(EventHandler<ActionEvent> action)
	{
		studentScreenGridPane.getButtonHBox().getEdit().setOnAction(action);
	}

	@Override
	public ExaminationPerformance getSelectedEntry()
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		// source [10]
		return (selectedID >= 0) ? examinationPerformances.get(selectedID) : null;
	}

	/**
	 * Indicates if the student was created or only edited
	 * 
	 * @return {@code true} if in edit mode, otherwise {@code false}
	 */
	public boolean wasEdit()
	{
		return edit;
	}
}
