package application.view;

import javafx.scene.control.Alert;

/**
 * This class extends {@link Alert}, represents a small dialog intended to
 * prompt the user to confirm whether they really want to delete a specific
 * entry from a table.
 */
//source [26]
public class DeleteAlert extends Alert
{
	/**
	 * Create the dialog
	 * 
	 * @param text small information text about the deleting object.
	 */
	public DeleteAlert(String text)
	{
		super(AlertType.CONFIRMATION, text);
		setTitle("You are about to delete");
	}
}
