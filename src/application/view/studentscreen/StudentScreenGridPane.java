package application.view.studentscreen;

import application.view.TableButtonHBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StudentScreenGridPane extends GridPane
{

	private TextField firstNameInput;
	private TextField lastNameInput;
	private TextField matriculationNumberInput;
	private TextField studyProgramInput;
	private TextField eMailInput;

	private VBox examVBox;
	private TableButtonHBox buttonHBox;
	private StudentScreenTableView screenTableView;

	public StudentScreenGridPane()
	{
		// text fields
		firstNameInput = new TextField();
		firstNameInput.setPromptText("First Name");

		lastNameInput = new TextField();
		lastNameInput.setPromptText("Last Name");

		matriculationNumberInput = new TextField();
		matriculationNumberInput.setPromptText("Matriculation Number");

		studyProgramInput = new TextField();
		studyProgramInput.setPromptText("Study Program");

		eMailInput = new TextField();
		eMailInput.setPromptText("E-Mail");

		// add, edit, delete buttons
		buttonHBox = new TableButtonHBox("Exam");

		// TableView
		screenTableView = new StudentScreenTableView();

		// VBox
		examVBox = new VBox();
		examVBox.setAlignment(Pos.CENTER);
		examVBox.setSpacing(5);
		examVBox.setFillWidth(true);
		examVBox.setPrefWidth(100);
		examVBox.setPrefHeight(200);
		examVBox.getChildren().add(screenTableView);
		examVBox.getChildren().add(buttonHBox);

		// add all to the GridPane
		add(new Text("First Name"), 0, 0);
		add(firstNameInput, 1, 0);

		add(new Text("Last Name"), 0, 1);
		add(lastNameInput, 1, 1);

		add(new Text("Matriculation Number"), 0, 2);
		add(matriculationNumberInput, 1, 2);

		add(new Text("Study Program"), 0, 3);
		add(studyProgramInput, 1, 3);

		add(new Text("E-Mail"), 0, 4);
		add(eMailInput, 1, 4);

		add(new Separator(), 0, 5);
		add(new Separator(), 1, 5);

		add(new Text("Examination Performance"), 0, 6);
		add(examVBox, 1, 6);

		// constrains
        ColumnConstraints leftConstraint = new ColumnConstraints();
        leftConstraint.setPercentWidth(30);
        getColumnConstraints().add(leftConstraint);
		
        ColumnConstraints rightConstraint = new ColumnConstraints();
        rightConstraint.setPercentWidth(70);
        getColumnConstraints().add(rightConstraint);
     		
		// properties
		setVgap(20);
		setPadding(new Insets(20, 20, 0, 20));
		setAlignment(Pos.CENTER);
		setWidth(USE_COMPUTED_SIZE);
		setHeight(USE_COMPUTED_SIZE);
		
		GridPane.setHgrow(this,Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);

	}

	public TextField getFirstNameInput()
	{
		return firstNameInput;
	}

	public TextField getLastNameInput()
	{
		return lastNameInput;
	}

	public TextField getMatriculationNumberInput()
	{
		return matriculationNumberInput;
	}

	public TextField getStudyProgramInput()
	{
		return studyProgramInput;
	}

	public TextField geteMailInput()
	{
		return eMailInput;
	}

	public TableButtonHBox getButtonHBox()
	{
		return buttonHBox;
	}

	public StudentScreenTableView getScreenTableView()
	{
		return screenTableView;
	}
}
