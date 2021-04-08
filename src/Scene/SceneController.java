package scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneController {
	protected static int Height=674;
	protected static int Width=1200;
	protected Scene mainscene;
	protected Stage mainstage;
	protected VBox mainPane;
	protected StackPane backgroundPane; 
	

	public SceneController() {
		mainstage = new Stage();
		mainstage.setTitle("PlantWar");
		mainPane = new VBox();
	
		mainPane.setAlignment(Pos.CENTER);
		gui.Button StartButton = new gui.Button("Start Game");
		gui.Button ExitButton = new gui.Button("Exit Game");
		mainPane.getChildren().addAll(StartButton,ExitButton);
		mainPane.setSpacing(20);
		backgroundPane=new StackPane();
		backgroundPane.getChildren().addAll(new ImageView("Background.jpg"),mainPane);
		
		mainscene = new Scene(backgroundPane,Width,Height);

		mainstage.setScene(mainscene);

	}

	public Stage getMainstage() {
		return mainstage;
	}

	public void setMainstage(Stage mainstage) {
		this.mainstage = mainstage;
	}

}
