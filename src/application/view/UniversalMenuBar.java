package application.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * This class extends {@linkjavafx.scene.control.MenuBar }, represents the menu
 * bar in the upper left corner of the screen. It provides functions such as
 * loading and saving student data from files.
 */
//source [23]
public class UniversalMenuBar extends MenuBar
{
	private MenuItem load;
	private MenuItem save;

	private MenuItem git;

	/**
	 * Creates a UniversalMenuBar.
	 *
	 * <p>
	 * The menu bar contains:
	 * <ul>
	 * <li>File menu with load and save options</li>
	 * <li>Help menu with a GitHub link</li>
	 * </ul>
	 * </p>
	 */
	public UniversalMenuBar()
	{
		Menu file = new Menu("File");
		load = new MenuItem("load...");
		save = new MenuItem("save");

		file.getItems().addAll(load, save);

		Menu help = new Menu("Help");
		git = new MenuItem("see on GitHub");
		help.getItems().add(git);

		getMenus().addAll(file, help);
	}

	/**
	 * Returns the load menu item.
	 *
	 * @return the load MenuItem
	 */
	public MenuItem getLoad()
	{
		return load;
	}

	/**
	 * Returns the save menu item.
	 *
	 * @return the save MenuItem
	 */
	public MenuItem getSave()
	{
		return save;
	}

	/**
	 * Returns the GitHub menu item.
	 *
	 * @return the GitHub MenuItem
	 */
	public MenuItem getGit()
	{
		return git;
	}
}
