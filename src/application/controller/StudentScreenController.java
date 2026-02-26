package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Applicable;
import application.controller.interfaces.Editable;
import application.controller.interfaces.Exitable;
import application.controller.interfaces.Startable;
import application.model.ExaminationPerformance;
import application.model.Student;
import application.view.WindowButtonHBox;
import application.view.studentscreen.StudentScreenGridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class StudentScreenController extends Controller implements Startable, Exitable, Applicable<Student>, Editable<ExaminationPerformance>
{
	private StudentScreenGridPane studentScreenGridPane;
	private WindowButtonHBox windowButtonHBox;

	private Student student;

	private ObservableList<ExaminationPerformance> observableExaminationPerformances = FXCollections.observableArrayList();
	private ArrayList<ExaminationPerformance> examinationPerformances = new ArrayList<>();

	private boolean edit;

	public StudentScreenController()
	{
		edit = false;
		studentScreenGridPane = new StudentScreenGridPane();
		windowButtonHBox = new WindowButtonHBox();

		studentScreenGridPane.getScreenTableView().setItems(observableExaminationPerformances);
		studentScreenGridPane.getButtonHBox().getDelete().setOnAction(e -> deleteExam());
	}

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
		} catch (NumberFormatException exception)
		{
			exception.printStackTrace();
			System.out.println("Matriculation number is in the wrong format!");
		}

		String studyProgram = studentScreenGridPane.getStudyProgram().getText();
		String eMail = studentScreenGridPane.getEMail().getText();

		System.out.println(eMail);

		if (firstName.isBlank() || lastName.isBlank() || studyProgram.isBlank() || eMail.isBlank())
		{
			System.out.println("There are empty fields!");
			return;
		}

		student = new Student(firstName, lastName, matriculationNumber, studyProgram, eMail, examinationPerformances);
	}

	@Override
	public Student getModel()
	{
		return student;
	}

	public void addExam(ExaminationPerformance examinationPerformance)
	{
		observableExaminationPerformances.add(examinationPerformance);
		examinationPerformances.add(examinationPerformance);
	}

	public void replaceExam(ExaminationPerformance examinationPerformance)
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		observableExaminationPerformances.set(selectedID, examinationPerformance);
		examinationPerformances.set(selectedID, examinationPerformance);

	}

	private void deleteExam()
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		if (selectedID >= 0)
		{
			observableExaminationPerformances.remove(selectedID);
			examinationPerformances.remove(selectedID);
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
		return (selectedID >= 0) ? examinationPerformances.get(selectedID) : null;
	}

	public boolean wasEdit()
	{
		return edit;
	}
}
