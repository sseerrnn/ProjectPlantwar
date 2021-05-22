package gui;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import logic.GameController;
import scene.SceneController;

public class GameSubScene extends SubScene {

	protected static final String BACKGROUND_PATH = "board.png";
	protected static final int WIDTH = 983;
	protected static final int HEIGHT = 520;
	protected static final String[] PLANTBUTTON_OFF_PATH = { "peashooterbuttonoff.png", "sunflowerbuttonoff.png",
			"wallnutbuttonoff.png", "potatobombbuttonoff.png", "cabbagepultbuttonoff.png", "snowpeabuttonoff.png",
			"twinsunflowerbuttonoff.png", "cornpultbuttonoff.png", "doublepeashooterbuttonoff.png",
			"tallnutbuttonoff.png" };

	public GameSubScene() {
		super(new AnchorPane(), WIDTH, HEIGHT);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_PATH), null, null, null, null);
		AnchorPane root = (AnchorPane) this.getRoot();
		root.setBackground(new Background(image));
		this.setLayoutX(200);
		this.setLayoutY(-94);
		this.setVisible(false);
	}

	public void setUpPlantButtonOff() {
		for (int i = 0; i < 10; i++) {
			ImageView pic = new ImageView(PLANTBUTTON_OFF_PATH[i]);

			if (i < 5) {
				pic.setLayoutX(55 + 177 * (i));
				pic.setLayoutY(146);
				getPane().getChildren().add(pic);
			} else {
				pic.setLayoutX(55 + 177 * (i - 5));
				pic.setLayoutY(272);
				getPane().getChildren().add(pic);
			}
		}
	}

	public void setUpGamePaused() {
		ImageView pauseLogo = new ImageView("gamepaused.png");
		pauseLogo.setLayoutX(210);
		pauseLogo.setLayoutY(70);

		GameButton resumeButton = new GameButton("RESUME");
		GameButton restartButton = new GameButton("RESTART");
		GameButton levelButton = new GameButton("MAPS");
		GameButton exitButton = new GameButton("EXIT");

		resumeButton.setUpPauseMenuButton1();
		restartButton.setUpPauseMenuButton2();
		levelButton.setUpPauseMenuButton3();
		exitButton.setUpPauseMenuButton4();

		resumeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				moveSubSceneOut();
			}
		});

		restartButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				GameController plantButton = new GameController();

				for (PlantButton pt : plantButton.getSelectedPlantButtons()) {
					SceneController.getInstance().getMainPane().getChildren().remove(pt.getImage());
					// plantButton.getSelectedPlantButtons().removeAll(plantButton.getSelectedPlantButtons());
				}

				SceneController.getInstance().getChooseChar().moveSubSceneOut();
				SceneController.getInstance().createChooseCharSubScene();
				SceneController.getInstance().getChooseChar().moveSubSceneIn();
				moveSubSceneOut();
				plantButton.setGameStart(false);
				plantButton.setGameStart(true);
			}
		});

		levelButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				GameController exitGame = new GameController();

				SceneController.getInstance().setUpChooseMapScene();
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
			}
		});

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneController.getInstance().getMainstage().close();
			}
		});

		getPane().getChildren().addAll(pauseLogo, resumeButton, restartButton, levelButton, exitButton);
	}

	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

	public void moveSubSceneIn() {
		TranslateTransition move = new TranslateTransition();
		move.setNode(this);
		this.setVisible(true);
		move.setToY(94 * 2);
		move.play();
	}

	public void moveSubSceneOut() {
		TranslateTransition move = new TranslateTransition();
		move.setNode(this);
		move.setToY(-94 * 2 - 520);
		move.play();
	}

}
