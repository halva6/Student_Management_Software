package application.controller.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Editable<M>
{
	public void editScreenEvent(EventHandler<ActionEvent> action);

	public M getSelectedEntry();
}
