package application.controller.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Startable
{
	public void addNewScreenEvent(EventHandler<ActionEvent> action);
}
