package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.SceneController;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		try {
			primarystage = SceneController.getInstance().getMainstage();
			primarystage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
