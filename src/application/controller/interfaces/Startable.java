package application.controller.interfaces;

import application.controller.ScreenController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Represents a component that can start or trigger a new screen event.
 *
 * <p>
 * Implementations of this interface provide functionality to register an event
 * that is executed when a new screen should be opened.
 * </p>
 * 
 * <p>
 * This allows you to generalize the code for opening a new screen and avoid
 * redefining it in every class. This is done by iterating through all classes
 * that implement this interface and adding a general code snippet since each of
 * these classes has this functionality. This is done within the
 * {@link ScreenController}
 * </p>
 */
//source [1]
public interface Startable
{
	/**
	 * Registers an event handler for starting a new screen.
	 *
	 * @param action the event handler that is triggered when the event occurs
	 */
	public void addNewScreenEvent(EventHandler<ActionEvent> action);
}
