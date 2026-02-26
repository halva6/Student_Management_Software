package application.view.examscreen;

import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class UpperGridPane extends GridPane
{
	private TextField examName;
	private TextField examDescription;
	private ChoiceBox<String> examType;
	private Spinner<Integer> semester;

	public UpperGridPane()
	{
		// initialize nodes
		examName = new TextField();
		examName.setPromptText("Name of the exam");
		examDescription = new TextField();
		examDescription.setPromptText("Description of the exam");

		examType = new ChoiceBox<>();
		examType.getItems().addAll("Examination", "Academic paper");
		examType.setValue("Examination");

		semester = new Spinner<>();
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		semester.setValueFactory(valueFactory);

		createGrid();
	}

	public UpperGridPane(String examName, String examDescription, String examType, int semester)
	{
		// initialize nodes
		this.examName = new TextField(examName);
		this.examName.setPromptText("Name of the exam");
		this.examDescription = new TextField(examDescription);
		this.examDescription.setPromptText("Description of the exam");

		this.examType = new ChoiceBox<>();
		this.examType.getItems().addAll("Examination", "Academic paper");
		this.examType.setValue(examType);

		this.semester = new Spinner<>();
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, semester);
		this.semester.setValueFactory(valueFactory);

		createGrid();
	}

	private void createGrid()
	{
		// add nodes
		add(new Text("Name"), 0, 0);
		add(new Text("Description"), 0, 1);
		add(new Text("Exam Type"), 0, 2);
		add(new Text("Semester"), 0, 3);

		add(examName, 1, 0);
		add(examDescription, 1, 1);
		add(examType, 1, 2);
		add(semester, 1, 3);

		// constrains
		ColumnConstraints leftConstraint = new ColumnConstraints();
		leftConstraint.setPercentWidth(50);
		getColumnConstraints().add(leftConstraint);

		ColumnConstraints rightConstraint = new ColumnConstraints();
		rightConstraint.setPercentWidth(50);
		getColumnConstraints().add(rightConstraint);

		// gird layout properties
		setVgap(20);
		setWidth(USE_COMPUTED_SIZE);
		setHeight(USE_COMPUTED_SIZE);
		setPadding(new Insets(20));

		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
	}

	public TextField getExamName()
	{
		return examName;
	}

	public TextField getExamDescription()
	{
		return examDescription;
	}

	public ChoiceBox<String> getExamType()
	{
		return examType;
	}

	public Spinner<Integer> getSemester()
	{
		return semester;
	}
}
