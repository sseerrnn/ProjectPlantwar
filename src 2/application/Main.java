package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.SceneController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage = SceneController.getInstance().getMainstage();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
