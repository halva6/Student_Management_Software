package application.controller.interfaces;

import application.model.ExaminationPerformance;
import application.model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Represents a component that supports applying changes and providing a model.
 *
 * <p>
 * Implementations of this interface allow registration of an event handler for
 * apply actions, creation of a model, and access to the created model.
 * </p>
 *
 * @param <M> the type of the model. It can be a {@link Student} or an
 *            {@link ExaminationPerformance}
 */
//source [1]
public interface Applicable<M>
{
	/**
	 * Registers an event handler for apply actions.
	 *
	 * @param action the event handler that is triggered when the apply event occurs
	 */
	public void applyScreenEvent(EventHandler<ActionEvent> action);

	/**
	 * Creates the model instance.
	 */
	public void createModel();

	/**
	 * Returns the created model.
	 *
	 * @return the model of type {@code M}
	 */
	public M getModel();
}
