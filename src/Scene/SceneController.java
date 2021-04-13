package scene;

import com.sun.glass.events.MouseEvent;

import gui.GameButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	protected static final int Height = 674;
	protected static final int Width = 1200;
	protected Scene mainScene;
	protected Stage mainStage;
	protected VBox buttonPane;
	protected AnchorPane mainPane;

	public SceneController() {
		mainStage = new Stage();
		mainStage.setTitle("PlantWar");
		setUpMainStage();

		
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);

	}

	public Stage getMainstage() {
		return mainStage;
	}
public void setUpMainStage() {
	createButtonPane();
	createMenuButtons();
	createBackgroundPane();
	createLogo();
	mainScene = new Scene(mainPane, Width, Height);
}
	public void setMainstage(Stage mainstage) {
		this.mainStage = mainstage;
	}

	public void createStartButton() {
		GameButton StartButton = new GameButton("Start Game");
		buttonPane.getChildren().add(StartButton);
		StartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setUpChooseMapScene();
				mainStage.setScene(mainScene);
				System.out.println(0);// To change scene

			}
		});
	}

	public void createExitButton() {
		GameButton ExitButton = new GameButton("Exit Game");
		buttonPane.getChildren().add(ExitButton);
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainStage.close();
			}

		});
	}

	public void createMenuButtons() {
		createStartButton();
		createExitButton();
	}

	public void createButtonPane() {
		buttonPane = new VBox();
		buttonPane.setSpacing(20);
		buttonPane.setLayoutX(223);
		buttonPane.setLayoutY(340);
	}

	public void createLogo() {
		ImageView Logo = new ImageView("Logo.png");
		Logo.setLayoutX(125);
		Logo.setLayoutY(105);
		mainPane.getChildren().add(Logo);
	}

	public void createBackgroundPane() {
		mainPane = new AnchorPane();
		mainPane.getChildren().addAll(new ImageView("Background.jpg"), buttonPane);

	}

	public void setUpChooseMapScene() {
		setUpChooseMapPane();
		createChooseMapButtons();
		createMapTopic();
		createMapPicture();
		mainScene = new Scene(mainPane, Width, Height);

	}

	public void setUpChooseMapPane() {
		mainPane = new AnchorPane();
		mainPane.getChildren().add(new ImageView("blue green.jpg"));
		

	}
public void createBackButton() {
	GameButton back =new GameButton("");
	back.setUpButtonStyle3();
	mainPane.getChildren().add(back);
	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setUpMainStage();
			mainStage.setScene(mainScene);
		}
	});
	back.setLayoutX(38);
	back.setLayoutY(36);
}
	public void createChooseMapButton1() {
		GameButton map1 = new GameButton("ENTER");
		map1.setUpButtonStyle2();
		mainPane.getChildren().add(map1);
		map1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		map1.setLayoutX(166.5);
		map1.setLayoutY(510);
	}

	public void createChooseMapButton2() {
		GameButton map2 = new GameButton("ENTER");
		map2.setUpButtonStyle2();
		mainPane.getChildren().add(map2);
		map2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(2);
			}
		});
		map2.setLayoutX(474.5);
		map2.setLayoutY(510);
	}

	public void createChooseMapButton3() {
		GameButton map3 = new GameButton("ENTER");
		map3.setUpButtonStyle2();
		mainPane.getChildren().add(map3);
		map3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(3);
			}
		});
		map3.setLayoutX(782.5);
		map3.setLayoutY(510);
	}

	public void createChooseMapButtons() {
		createChooseMapButton1();
		createChooseMapButton2();
		createChooseMapButton3();
		createBackButton();
	}
	public void createMapTopic() {
		ImageView maps=new ImageView("Maps.png");
		maps.setLayoutX(444);
		maps.setLayoutY(58);
		mainPane.getChildren().add(maps);
		
	}
	public void createMapPicture() {
		ImageView mapPic1= new ImageView("black.jpg");
		ImageView mapPic2= new ImageView("black.jpg");
		ImageView mapPic3= new ImageView("black.jpg");
		
		mapPic1.setLayoutX(180);
		mapPic1.setLayoutY(216);
		mapPic2.setLayoutX(489);
		mapPic2.setLayoutY(216);
		mapPic3.setLayoutX(797);
		mapPic3.setLayoutY(216);
		
		mainPane.getChildren().addAll(mapPic1,mapPic2,mapPic3);
		
		
		ImageView mapLock2 = new ImageView("lock.png");
		ImageView mapLock3 = new ImageView("lock.png");
		
		mapLock2.setLayoutX(548);
		mapLock2.setLayoutY(269);
		mapLock3.setLayoutX(857);
		mapLock3.setLayoutY(269);
		
		mainPane.getChildren().addAll(mapLock2,mapLock3);
		
	}

}
