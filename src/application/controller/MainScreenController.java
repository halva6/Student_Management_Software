package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Editable;
import application.controller.interfaces.Startable;
import application.model.Student;
import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MainScreenController extends Controller implements Startable, Editable<Student>
{

	private TableButtonHBox mainScreenHBox;
	private MainScreenTableView mainScreenTableView;

	private ObservableList<Student> observableStudents = FXCollections.observableArrayList();
	private ArrayList<Student> students = new ArrayList<>();

	public MainScreenController()
	{
		mainScreenTableView = new MainScreenTableView();
		mainScreenHBox = new TableButtonHBox("Student");

		mainScreenTableView.setItems(observableStudents);

		mainScreenHBox.getDelete().setOnAction(e -> deleteStudent());
	}

	@Override
	public Node getCenterElement()
	{
		return mainScreenTableView;
	}

	@Override
	public Node getBottonElement()
	{
		return mainScreenHBox;
	}

	@Override
	public void addNewScreenEvent(EventHandler<ActionEvent> action)
	{
		mainScreenHBox.getAdd().setOnAction(action);
	}

	public void addStudent(Student student)
	{
		observableStudents.add(student);
		students.add(student);
	}

	public void replaceStudent(Student student)
	{
		int selectedID = mainScreenTableView.getSelectionModel().getSelectedIndex();
		observableStudents.set(selectedID, student);
		students.set(selectedID, student);
	}

	private void deleteStudent()
	{
		int selectedID = mainScreenTableView.getSelectionModel().getSelectedIndex();
		if (selectedID >= 0)
		{
			observableStudents.remove(selectedID);
			students.remove(selectedID);
		}
	}

	@Override
	public void editScreenEvent(EventHandler<ActionEvent> action)
	{
		mainScreenHBox.getEdit().setOnAction(action);
	}

	@Override
	public Student getSelectedEntry()
	{
		int selectedID = mainScreenTableView.getSelectionModel().getSelectedIndex();

		return (selectedID >= 0) ? students.get(selectedID) : null;
	}
}