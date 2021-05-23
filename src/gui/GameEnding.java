package gui;

import element.Audio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import scene.SceneController;

public class GameEnding extends AnchorPane {

	private ImageView background;
	private ImageView statusImage;
	private boolean isWin;
	private Button replayButton;
	private Button nextButton;
	private Button homeButton;
	private AnchorPane endingPane;

	public GameEnding(boolean isWin) {
		super();
		this.isWin = isWin;
		endingPane = new AnchorPane();

		createBackground();
		createStatusImage();
	}

	public void createBackground() {
		background = new ImageView("result_background.jpg");
		endingPane.getChildren().add(background);
	}

	public void createStatusImage() {
		if (isWin) {
			statusImage = new ImageView("win.png");
			statusImage.setLayoutX(175);
			statusImage.setLayoutY(89);
			statusImage.setFitHeight(114);
			statusImage.setFitWidth(864);
			createReplayButton(208, 328);
			createNextButton(495, 328);
			createHomeButton(782, 328);
		} else {
			statusImage = new ImageView("lose.png");
			statusImage.setLayoutX(118);
			statusImage.setLayoutY(89);
			statusImage.setFitHeight(114);
			statusImage.setFitWidth(978);
			createReplayButton(352, 328);
			createHomeButton(639, 328);
		}
		endingPane.getChildren().add(statusImage);
	}

	public void createReplayButton(int initX, int initY) {
		replayButton = new Button();
		replayButton.setGraphic(new ImageView("replaybutton.png"));
		replayButton
				.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		replayButton.setLayoutX(initX);
		replayButton.setLayoutY(initY);
		endingPane.getChildren().add(replayButton);

		replayButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneController.getInstance().setUpGameScene();

				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				int level = SceneController.getInstance().getGameController().getLevel();
				SceneController.getInstance().resetGame();
				SceneController.getInstance().getGameController().selectLevel(level);

				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				SceneController.getInstance().createChooseCharSubScene();
				SceneController.getInstance().getChooseChar().moveSubSceneIn();

				Audio.createMouseClickedSound();
				Audio.createGameSound();
			}
		});
	}

	public void createNextButton(int initX, int initY) {
		nextButton = new Button();
		nextButton.setGraphic(new ImageView("nextbutton.png"));
		nextButton
				.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		nextButton.setLayoutX(initX);
		nextButton.setLayoutY(initY);
		endingPane.getChildren().add(nextButton);
		nextButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				SceneController.getInstance().setUpGameScene();
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				int level = SceneController.getInstance().getGameController().getLevel();
				if (level < 3) {
					level += 1;
				}
				SceneController.getInstance().resetGame();
				SceneController.getInstance().getGameController().selectLevel(level);

				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				SceneController.getInstance().createChooseCharSubScene();
				SceneController.getInstance().getChooseChar().moveSubSceneIn();

				Audio.createMouseClickedSound();
				Audio.createGameSound();
			}
		});
	}

	public void createHomeButton(int initX, int initY) {
		homeButton = new Button();
		homeButton.setGraphic(new ImageView("homebutton.png"));
		homeButton
				.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		homeButton.setLayoutX(initX);
		homeButton.setLayoutY(initY);
		endingPane.getChildren().add(homeButton);

		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SceneController.getInstance().resetGameStatus();
				SceneController.getInstance().setUpChooseMapScene();
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				SceneController.getInstance().getGameController().setGameStart(false);

				Audio.createMouseClickedSound();
				Audio.createChooseMapMusic();
			}
		});
	}

	public AnchorPane getEndingPane() {
		return endingPane;
	}

	public void setEndingPane(AnchorPane endingPane) {
		this.endingPane = endingPane;
	}

}
