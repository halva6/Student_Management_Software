package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Applicable;
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

public class StudentScreenController extends Controller implements Startable, Exitable, Applicable<Student>
{
	private StudentScreenGridPane studentScreenGridPane;
	private WindowButtonHBox windowButtonHBox;

	private Student student;

	private ObservableList<ExaminationPerformance> observableExaminationPerformances = FXCollections.observableArrayList();
	private ArrayList<ExaminationPerformance> examinationPerformances = new ArrayList<>();

	public StudentScreenController()
	{
		studentScreenGridPane = new StudentScreenGridPane();
		windowButtonHBox = new WindowButtonHBox();
		
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
		String firstName = studentScreenGridPane.getFirstNameInput().getText();
		String lastName = studentScreenGridPane.getLastNameInput().getText();
		int matriculationNumber = -1;

		try
		{
			matriculationNumber = Integer.valueOf(studentScreenGridPane.getMatriculationNumberInput().getText());
		} catch (NumberFormatException exception)
		{
			exception.printStackTrace();
			System.out.println("Matriculation number is in the wrong format!");
		}

		String studyProgram = studentScreenGridPane.getStudyProgramInput().getText();
		String eMail = studentScreenGridPane.geteMailInput().getText();

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
	
	private void deleteExam() 
	{
		int selectedID = studentScreenGridPane.getScreenTableView().getSelectionModel().getSelectedIndex();
		observableExaminationPerformances.remove(selectedID);
		examinationPerformances.remove(selectedID);
	}
}
