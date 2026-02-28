package application.view.studentscreen;

import application.model.ExaminationPerformance;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

// source [3] [4]
/**
 * TableView for displaying a student's examination performances. This class
 * extends {@link javafx.scene.control.TableView} for
 * {@link application.model.ExaminationPerformance}.
 */
public class StudentScreenTableView extends TableView<ExaminationPerformance>
{
	private TableColumn<ExaminationPerformance, Integer> semesterColumn;
	private TableColumn<ExaminationPerformance, String> examColumn;
	private TableColumn<ExaminationPerformance, Double> gradeColumn;
	private TableColumn<ExaminationPerformance, Boolean> passedColumn;
	private TableColumn<ExaminationPerformance, Integer> attemptColumn;

	/**
	 * Creates a new StudentScreenTableView with predefined columns. This table is
	 * linked to {@link application.model.ExaminationPerformance}
	 */
	public StudentScreenTableView()
	{
		semesterColumn = new TableColumn<>("Semester");
		semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
		// source [28]
		semesterColumn.setSortable(true);
		getColumns().add(semesterColumn);

		examColumn = new TableColumn<>("Exam");
		examColumn.setCellValueFactory(new PropertyValueFactory<>("examName"));
		examColumn.setSortable(true);
		getColumns().add(examColumn);

		gradeColumn = new TableColumn<>("Grade");
		gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
		gradeColumn.setSortable(true);
		getColumns().add(gradeColumn);

		passedColumn = new TableColumn<>("Passed");
		passedColumn.setCellValueFactory(new PropertyValueFactory<>("passed"));
		passedColumn.setSortable(true);
		getColumns().add(passedColumn);

		attemptColumn = new TableColumn<>("Attempts");
		attemptColumn.setCellValueFactory(new PropertyValueFactory<>("attempts"));
		attemptColumn.setSortable(true);
		getColumns().add(attemptColumn);

		setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
	}
}
