package scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SceneController {
	protected static int Height;
	protected static int Width;
	protected Scene mainscene;
	protected Stage mainstage;
	protected javafx.scene.layout.AnchorPane mainPane;
	
	

	public SceneController() {
		// TODO Auto-generated constructor stub
		mainstage = new Stage();
		mainstage.setTitle("PlantWar");
		mainPane = new javafx.scene.layout.AnchorPane();
		mainscene = new Scene(mainPane, Width, Height);
		gui.Button button1=new gui.Button("Hello");
		mainPane.getChildren().add(button1);
		
		mainstage.setScene(mainscene);
		
		
	}

	public Stage getMainstage() {
		return mainstage;
	}

	public void setMainstage(Stage mainstage) {
		this.mainstage = mainstage;
	}

}
