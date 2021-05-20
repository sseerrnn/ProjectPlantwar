package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class GameEnding extends AnchorPane {

	private ImageView background;
	private ImageView statusImage;
	private boolean isWin;
	private Button replayButton;
	private Button nextButton;
	private Button homeButton;

	public GameEnding(boolean isWin) {
		super();
		this.isWin = isWin;

		createBackground();
		createStatusImage();
	}

	public void createBackground() {
		background = new ImageView("result_background.jpg");
		this.getChildren().add(background);
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
		this.getChildren().add(statusImage);
	}

	public void createReplayButton(int initX, int initY) {
		replayButton = new Button();
		replayButton.setGraphic(new ImageView("replaybutton.png"));
		replayButton.setLayoutX(initX);
		replayButton.setLayoutY(initY);
		this.getChildren().add(replayButton);
	}

	public void createNextButton(int initX, int initY) {
		nextButton = new Button();
		nextButton.setGraphic(new ImageView("nextbutton.png"));
		nextButton.setLayoutX(initX);
		nextButton.setLayoutY(initY);
		this.getChildren().add(nextButton);
	}

	public void createHomeButton(int initX, int initY) {
		homeButton = new Button();
		homeButton.setGraphic(new ImageView("homebutton.png"));
		homeButton.setLayoutX(initX);
		homeButton.setLayoutY(initY);
		this.getChildren().add(homeButton);
	}

}
