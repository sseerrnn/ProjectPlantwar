package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		ViewManager manager = new ViewManager();
		primaryStage = manager.getMainStage();
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}
