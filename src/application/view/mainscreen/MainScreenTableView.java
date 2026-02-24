package application.view.mainscreen;

import application.model.Student;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainScreenTableView extends TableView<Student>
{
	private TableColumn<Student, String> firstNameColumn;
	private TableColumn<Student, String> lastNameColumn;
	private TableColumn<Student, Integer> matriculationNumberColumn;
	private TableColumn<Student, Double> gradePointAvrageColumn;

	public MainScreenTableView()
	{
		firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		getColumns().add(firstNameColumn);

		lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		getColumns().add(lastNameColumn);

		matriculationNumberColumn = new TableColumn<>("Matriculation Number");
		matriculationNumberColumn.setCellValueFactory(new PropertyValueFactory<>("matriculationNumber"));
		getColumns().add(matriculationNumberColumn);

		gradePointAvrageColumn = new TableColumn<>("Grade Point Avrage");
		gradePointAvrageColumn.setCellValueFactory(new PropertyValueFactory<>("gradePointAvrage"));
		getColumns().add(gradePointAvrageColumn);
		
		setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
	}
}
