package application.view.mainscreen;

import application.model.Student;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

// source [3] [4]
/**
 * A TableView that displays the students with selected data. This class extends
 * {@link TableView} for {@link Student}.
 */
public class MainScreenTableView extends TableView<Student>
{
	private TableColumn<Student, String> firstNameColumn;
	private TableColumn<Student, String> lastNameColumn;
	private TableColumn<Student, Integer> matriculationNumberColumn;
	private TableColumn<Student, Double> gradePointAvrageColumn;

	/**
	 * Creates a new MainScreenTableView with predefined columns. This table is
	 * linked to {@link application.model.Student}.
	 */
	public MainScreenTableView()
	{
		firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		// source [28]
		firstNameColumn.setSortable(true);
		getColumns().add(firstNameColumn);

		lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastNameColumn.setSortable(true);
		getColumns().add(lastNameColumn);

		lastNameColumn = new TableColumn<>("Study Program");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("studyProgram"));
		lastNameColumn.setSortable(true);
		getColumns().add(lastNameColumn);

		matriculationNumberColumn = new TableColumn<>("Matriculation Number");
		matriculationNumberColumn.setCellValueFactory(new PropertyValueFactory<>("matriculationNumber"));
		matriculationNumberColumn.setSortable(true);
		getColumns().add(matriculationNumberColumn);

		gradePointAvrageColumn = new TableColumn<>("Grade Point Avrage");
		gradePointAvrageColumn.setCellValueFactory(new PropertyValueFactory<>("gradePointAvrage"));
		gradePointAvrageColumn.setSortable(true);
		getColumns().add(gradePointAvrageColumn);

		setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
	}
}
