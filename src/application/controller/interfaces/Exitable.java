package application.controller.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Represents a component that supports cancel actions.
 *
 * <p>
 * Implementations of this interface allow registration of an event handler that
 * is triggered when a screen or operation should be canceled.
 * </p>
 */
public interface Exitable
{
	/**
	 * Registers an event handler for canceling the screen.
	 *
	 * @param action the event handler that is triggered on cancel
	 */
	public void cancelScreenEvent(EventHandler<ActionEvent> action);
}
