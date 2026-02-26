package application.controller.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Applicable<M>
{
	public void applyScreenEvent(EventHandler<ActionEvent> action);
	
	public void createModel();
	
	public M getModel();
}
