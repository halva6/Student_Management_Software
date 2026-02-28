package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.model.Student;
import application.view.UniversalMenuBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller for the universal menu bar.
 */
public class MenuBarController
{
	private UniversalMenuBar universalMenuBar;

	/**
	 * Creates a new MenuBarController and initializes the menu bar.
	 */
	public MenuBarController()
	{
		universalMenuBar = new UniversalMenuBar();
	}

	/**
	 * Loads student data from a selected file.
	 *
	 * <p>
	 * The method uses object deserialization to read {@link Student} objects from
	 * the file and returns them as a list.
	 * </p>
	 *
	 * @param stage the stage used to display the file chooser
	 * @return a list of loaded students
	 */
	public ArrayList<Student> loadFile(Stage stage)
	{
		// source [24]
		FileChooser fileChooser = new FileChooser();
		File loadedFile = fileChooser.showOpenDialog(stage);

		ArrayList<Student> students = new ArrayList<>();
		
		// source [24]
		if (loadedFile != null)
		{
			// source [25]
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadedFile)))
			{
				Object obj;
				// Read objects until end of file (EOFException is thrown)
				while ((obj = ois.readObject()) != null)
				{
					if (obj instanceof Student)
					{
						Student student = (Student) obj;
						System.out.println("Read: " + student.toString());
						students.add(student);
					}
				}
			} catch (IOException e)
			{
				if (e instanceof java.io.EOFException)
				{
					System.out.println("\nReached end of file.");
				} else
				{
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace(); // Thrown if User class is not found during deserialization
			}
		}

		return students;
	}

	/**
	 * Saves student data to a selected file.
	 *
	 * <p>
	 * The method serializes all {@link Student} objects and writes them to the
	 * chosen file.
	 * </p>
	 *
	 * @param stage    the stage used to display the file chooser
	 * @param students the list of students to save
	 */
	public void saveFile(Stage stage, ArrayList<Student> students)
	{
		// source [24]
		FileChooser fileChooser = new FileChooser();
		File saveFile = fileChooser.showSaveDialog(stage);

		// source [24]
		if (saveFile != null)
		{
			// source [25]
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile)))
			{
				// Write each object in the list
				for (Student student : students)
				{
					oos.writeObject(student);
					System.out.println("Wrote: " + student);
				}
				System.out.println("All objects written to " + saveFile);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	/**
	 * Returns the universal menu bar.
	 *
	 * @return the UniversalMenuBar instance
	 */
	public UniversalMenuBar getUniversalMenuBar()
	{
		return universalMenuBar;
	}
}
