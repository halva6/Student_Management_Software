package application.controller.interfaces;

import application.model.ExaminationPerformance;
import application.model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Represents an editable component that supports editing actions.
 *
 * <p>
 * Implementations of this interface allow registration of an event handler for
 * edit events and provide access to the currently selected entry.
 * </p>
 *
 * @param <M> the type of the selected entry. It can be a {@link Student} or an
 *            {@link ExaminationPerformance}
 */
public interface Editable<M>
{
	/**
	 * Registers an event handler for edit actions.
	 *
	 * @param action the event handler that is triggered when an edit event occurs
	 */
	public void editScreenEvent(EventHandler<ActionEvent> action);

	/**
	 * Returns the currently selected entry.
	 *
	 * @return the selected entry of type M
	 */
	public M getSelectedEntry();
}
