package scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneController {
	protected static int Height;
	protected static int Width;
	protected Scene mainscene;
	protected Stage mainstage;
	protected StackPane mainPane;

	public SceneController() {
		mainstage = new Stage();
		mainstage.setTitle("PlantWar");
		mainPane = new StackPane();
		mainscene = new Scene(mainPane, Width, Height);
		gui.Button button1 = new gui.Button("Start Game");
		mainPane.getChildren().add(button1);
//		button1.initializeButtonListeners();
		mainstage.setScene(mainscene);

	}

	public Stage getMainstage() {
		return mainstage;
	}

	public void setMainstage(Stage mainstage) {
		this.mainstage = mainstage;
	}

}
