package application;

<<<<<<< Updated upstream
public class Main {
||||||| ancestor
import javafx.application.Application;
import javafx.stage.Stage;
import scene.SceneController;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		
		SceneController manager = new SceneController();
		primarystage.setScene(null);
		primarystage = manager.getMainstage();
		primarystage.show();

	}
=======
import javafx.application.Application;
import javafx.stage.Stage;
import scene.SceneController;

public class Main extends Application {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		
		SceneController manager = new SceneController();
		primarystage.setScene(null);
		primarystage = manager.getMainstage();
		primarystage.show();

	}
>>>>>>> Stashed changes

