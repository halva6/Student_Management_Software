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

public class MenuBarController
{
	private UniversalMenuBar universalMenuBar;

	public MenuBarController()
	{
		universalMenuBar = new UniversalMenuBar();
	}

	public ArrayList<Student> loadFile(Stage stage)
	{
		FileChooser fileChooser = new FileChooser();
		File loadedFile = fileChooser.showOpenDialog(stage);

		ArrayList<Student> students = new ArrayList<>();

		if (loadedFile != null)
		{

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

	public void saveFile(Stage stage, ArrayList<Student> students)
	{
		FileChooser fileChooser = new FileChooser();
		File saveFile = fileChooser.showSaveDialog(stage);

		if (saveFile != null)
		{
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

	public UniversalMenuBar getUniversalMenuBar()
	{
		return universalMenuBar;
	}
}
