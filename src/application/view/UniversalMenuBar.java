package application.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class UniversalMenuBar extends MenuBar
{
	private MenuItem load;
	private MenuItem save;
	
	private MenuItem git;
		
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
	
	public MenuItem getLoad()
	{
		return load;
	}

	public MenuItem getSave()
	{
		return save;
	}

	public MenuItem getGit()
	{
		return git;
	}
}
