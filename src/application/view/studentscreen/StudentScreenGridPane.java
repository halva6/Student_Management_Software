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

/**
 * GridPane layout for displaying and editing student information. This class
 * extends {@link javafx.scene.layout.GridPane}. It offers the input options for
 * the student's data.
 */
public class StudentScreenGridPane extends GridPane
{

	private TextField firstName;
	private TextField lastName;
	private TextField matriculationNumber;
	private TextField studyProgram;
	private TextField eMail;

	private VBox examVBox;
	private TableButtonHBox buttonHBox;
	private StudentScreenTableView screenTableView;

	/**
	 * Creates an empty StudentScreenGridPane.
	 */
	public StudentScreenGridPane()
	{
		// text fields
		firstName = new TextField();
		firstName.setPromptText("First Name");

		lastName = new TextField();
		lastName.setPromptText("Last Name");

		matriculationNumber = new TextField();
		matriculationNumber.setPromptText("Matriculation Number");

		studyProgram = new TextField();
		studyProgram.setPromptText("Study Program");

		eMail = new TextField();
		eMail.setPromptText("E-Mail");

		// add, edit, delete buttons
		buttonHBox = new TableButtonHBox("Exam");

		// TableView
		screenTableView = new StudentScreenTableView();

		createExamVBox();

		createGrid();

	}

	/**
	 * Creates a StudentScreenGridPane with predefined student data.
	 *
	 * <p>
	 * The given values are added to the corresponding input fields.
	 * </p>
	 *
	 * @param firstName           the student's first name
	 * @param lastName            the student's last name
	 * @param matriculationNumber the student's matriculation number
	 * @param studyProgram        the student's study program
	 * @param eMail               the student's email address
	 */
	public StudentScreenGridPane(String firstName, String lastName, String matriculationNumber, String studyProgram, String eMail)
	{
		// text fields
		this.firstName = new TextField(firstName);
		this.firstName.setPromptText("First Name");

		this.lastName = new TextField(lastName);
		this.lastName.setPromptText("Last Name");

		this.matriculationNumber = new TextField(matriculationNumber);
		this.matriculationNumber.setPromptText("Matriculation Number");

		this.studyProgram = new TextField(studyProgram);
		this.studyProgram.setPromptText("Study Program");

		this.eMail = new TextField(eMail);
		this.eMail.setPromptText("E-Mail");

		// add, edit, delete buttons
		buttonHBox = new TableButtonHBox("Exam");

		// TableView
		screenTableView = new StudentScreenTableView();

		createExamVBox();

		createGrid();

	}

	/**
	 * Creates and configures a {@link javafx.scene.layout.VBox} for a better
	 * arrangement of the table for the exam results.
	 */
	private void createExamVBox()
	{
		examVBox = new VBox();
		examVBox.setAlignment(Pos.CENTER);
		examVBox.setSpacing(5);
		examVBox.setFillWidth(true);
		examVBox.setPrefWidth(100);
		examVBox.setPrefHeight(200);
		examVBox.getChildren().add(screenTableView);
		examVBox.getChildren().add(buttonHBox);
	}

	
	/**
	 * It creates, sets the style, and adds the elements to the GridPane.
	 */
	private void createGrid()
	{
		// add all to the GridPane
		add(new Text("First Name"), 0, 0);
		add(firstName, 1, 0);

		add(new Text("Last Name"), 0, 1);
		add(lastName, 1, 1);

		add(new Text("Matriculation Number"), 0, 2);
		add(matriculationNumber, 1, 2);

		add(new Text("Study Program"), 0, 3);
		add(studyProgram, 1, 3);

		add(new Text("E-Mail"), 0, 4);
		add(eMail, 1, 4);

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

		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
	}

	/**
	 * Returns the first name text field.
	 *
	 * @return the first name TextField
	 */
	public TextField getFirstName()
	{
		return firstName;
	}

	/**
	 * Returns the first name text field.
	 *
	 * @return the first name TextField
	 */
	public TextField getLastName()
	{
		return lastName;
	}

	/**
	 * Returns the matriculation number text field.
	 *
	 * @return the matriculation number TextField
	 */
	public TextField getMatriculationNumber()
	{
		return matriculationNumber;
	}

	/**
	 * Returns the study program text field.
	 *
	 * @return the study program TextField
	 */
	public TextField getStudyProgram()
	{
		return studyProgram;
	}

	/**
	 * Returns the email text field.
	 *
	 * @return the email TextField
	 */
	public TextField getEMail()
	{
		return eMail;
	}

	/**
	 * Returns a completed HBox with buttons to control the
	 * {@link StudentScreenTableView}
	 *
	 * @return the TableButtonHBox containing buttons
	 */
	public TableButtonHBox getButtonHBox()
	{
		return buttonHBox;
	}

	/**
	 * Returns the table view displaying examination performances.
	 *
	 * @return the StudentScreenTableView
	 */
	public StudentScreenTableView getScreenTableView()
	{
		return screenTableView;
	}
}
