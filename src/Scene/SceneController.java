package scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneController {
	protected static int Height;
	protected static int Width;
	protected Scene mainscene;
	protected Stage mainstage;
	protected VBox mainPane;

	public SceneController() {
		mainstage = new Stage();
		mainstage.setTitle("PlantWar");
		mainPane = new VBox();
		mainscene = new Scene(mainPane, Width, Height);
		mainPane.setAlignment(Pos.CENTER);
		gui.Button StartButton = new gui.Button("Start Game");
		gui.Button ExitButton = new gui.Button("Exit Game");
		mainPane.getChildren().addAll(StartButton,ExitButton);
		mainPane.setSpacing(20);
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
