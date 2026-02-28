package application.controller;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * Base class for almost all controllers
 *
 * <p>
 * This class combines almost all controllers and, through the following
 * functions, makes the graphical elements of the individual screens available
 * so that they can be easily displayed in a {@link BorderPane} and also
 * exchanged.
 * </p>
 */
// source [1]
public abstract class Controller
{
	/**
	 * Returns the center element of the BorderPane.
	 *
	 * @return the center {@link Node}
	 */
	public abstract Node getCenterElement();

	/**
	 * Returns the bottom element of the BorderPane.
	 *
	 * @return the bottom {@link Node}
	 */
	public abstract Node getBottonElement();
}
