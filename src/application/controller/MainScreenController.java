package application.controller;

import java.util.ArrayList;

import application.controller.interfaces.Startable;
import application.model.Student;
import application.view.TableButtonHBox;
import application.view.mainscreen.MainScreenTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MainScreenController extends Controller implements Startable
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
	}

	@Override
	public Node getCenterElement()
	{
		return mainScreenTableView;
	}

	@Override
	public Node getBottonElement()
	{

		mainScreenHBox.getEdit().setOnAction(e ->
		{
			System.out.println("Edit Student");
		});

		mainScreenHBox.getDelete().setOnAction(e -> System.out.println("delete Student"));

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

}
