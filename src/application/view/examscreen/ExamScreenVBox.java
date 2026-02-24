package application.view.examscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class ExamScreenVBox extends VBox
{
	private UpperGridPane upperGridPane;
	private LowerGridPane lowerGridPane;
	
	public ExamScreenVBox() 
	{
		upperGridPane = new UpperGridPane();
		lowerGridPane = new LowerGridPane();
		
		getChildren().addAll(upperGridPane, new Separator() ,lowerGridPane);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(0, 20, 0, 20));
		setSpacing(5);
	}

	public UpperGridPane getUpperGridPane()
	{
		return upperGridPane;
	}

	public LowerGridPane getLowerGridPane()
	{
		return lowerGridPane;
	}
}
