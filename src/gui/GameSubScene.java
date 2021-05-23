package gui;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class GameSubScene extends SubScene {

	protected static final String BACKGROUND_PATH = "board.png";
	protected static final int WIDTH = 983;
	protected static final int HEIGHT = 520;
	protected static final String[] PLANTBUTTON_OFF_PATH = { "peashooterbuttonoff.png", "sunflowerbuttonoff.png",
			"wallnutbuttonoff.png", "potatobombbuttonoff.png", "cabbagepultbuttonoff.png", "snowpeabuttonoff.png",
			"twinsunflowerbuttonoff.png", "cornpultbuttonoff.png", "doublepeashooterbuttonoff.png",
			"tallnutbuttonoff.png" };
	

	private GameButton resumeButton;
	private GameButton restartButton;
	private GameButton levelButton;
	private GameButton exitButton;



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

		resumeButton = new GameButton("RESUME");
		restartButton = new GameButton("RESTART");
		levelButton = new GameButton("MAPS");
		exitButton = new GameButton("EXIT");

		resumeButton.setUpPauseMenuButton1();
		restartButton.setUpPauseMenuButton2();
		levelButton.setUpPauseMenuButton3();
		exitButton.setUpPauseMenuButton4();

		getPane().getChildren().addAll(pauseLogo, resumeButton, restartButton, levelButton, exitButton);
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

	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

	public GameButton getResumeButton() {
		return resumeButton;
	}

	public void setResumeButton(GameButton resumeButton) {
		this.resumeButton = resumeButton;
	}

	public GameButton getRestartButton() {
		return restartButton;
	}

	public void setRestartButton(GameButton restartButton) {
		this.restartButton = restartButton;
	}

	public GameButton getLevelButton() {
		return levelButton;
	}

	public void setLevelButton(GameButton levelButton) {
		this.levelButton = levelButton;
	}

	public GameButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(GameButton exitButton) {
		this.exitButton = exitButton;
	}

}
