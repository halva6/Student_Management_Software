package application.controller.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Exitable
{
	public void cancelScreenEvent(EventHandler<ActionEvent> action);
}
